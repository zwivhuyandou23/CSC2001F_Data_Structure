/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;


// Graph class: evaluate shortest paths.
//
// CONSTRUCTION: with no parameters.
//
// ******************PUBLIC OPERATIONS**********************
// void addEdge( String v, String w, double cvw )
//                              --> Add additional edge
// void printPath( String w )   --> Print path after alg is run
// void unweighted( String s )  --> Single-source unweighted
// void dijkstra( String s )    --> Single-source weighted
// void negative( String s )    --> Single-source negative weighted
// void acyclic( String s )     --> Single-source acyclic
// ******************ERRORS*********************************
// Some error checking is performed to make sure graph is ok,
// and to make sure graph satisfies properties needed by each
// algorithm.  Exceptions are thrown if errors are detected.

public class Graph
{
    public static final double INFINITY = Double.MAX_VALUE;
    private Map<String,Vertex> vertexMap = new HashMap<String,Vertex>( );
    
    public ArrayList<Integer> operations;
    /**
     * Add a new edge to the graph.
     */
    public void addEdge( String sourceName, String destName, double cost )
    {
        Vertex v = getVertex( sourceName );
        Vertex w = getVertex( destName );
        v.adj.add( new Edge( w, cost ) );
    }

    /**
     * Driver routine to handle unreachables and print total cost.
     * It calls recursive routine to print shortest path to
     * destNode after a shortest path algorithm has run.
     */
    public void printPath( String destName )
    {
        Vertex w = vertexMap.get( destName );
        if( w == null )
            return;//throw new NoSuchElementException( "Destination vertex not found" );
        else if( w.dist == INFINITY )
          // System.out.println( destName + " is unreachable" );
           ;
        else
        {
           // System.out.print( "(Cost is: " + w.dist + ") " );
            printPath( w );
           // System.out.println( );
        }
    }

    /**
     * If vertexName is not present, add it to vertexMap.
     * In either case, return the Vertex.
     */
    public Vertex getVertex( String vertexName )
    {
        Vertex v = vertexMap.get( vertexName );
        if( v == null )
        {
            v = new Vertex( vertexName );
            vertexMap.put( vertexName, v );
        }
        return v;
    }

    /**
     * Recursive routine to print shortest path to dest
     * after running shortest path algorithm. The path
     * is known to exist.
     */
    private void printPath( Vertex dest )
    {
        if( dest.prev != null )
        {
            printPath( dest.prev );
            //System.out.print( " to " );
        }
        //System.out.print( dest.name );
    }
    
    /**
     * Initializes the vertex output info prior to running
     * any shortest path algorithm.
     */
    public void clearAll( )
    {
        for( Vertex v : vertexMap.values( ) )
            v.reset( );
    }

    /**
     * Single-source unweighted shortest-path algorithm.
     */
    public void unweighted( String startName )
    {
        clearAll( ); 

        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        Queue<Vertex> q = new LinkedList<Vertex>( );
        q.add( start ); start.dist = 0;

        while( !q.isEmpty( ) )
        {
            Vertex v = q.remove( );

            for( Edge e : v.adj )
            {
                Vertex w = e.dest;
                if( w.dist == INFINITY )
                {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add( w );
                }
            }
        }
    }

    /**
     * Single-source weighted shortest-path algorithm. (Dijkstra) 
     * using priority queues based on the binary heap
     */
    public int dijkstra( String startName )
    {   operations = new ArrayList<Integer>(); 
        PriorityQueue<Path> pq = new PriorityQueue<Path>( );
        
        Vertex start = vertexMap.get( startName );
        if( start == null )
            return 0;
            //throw new NoSuchElementException( "Start vertex not found" );

        clearAll( );
        pq.add( new Path( start, 0 ) ); start.dist = 0;
        int pqCount = 0;
        int nodesSeen = 0;
        while( !pq.isEmpty( ) && nodesSeen < vertexMap.size( ) )
        {    
            pqCount +=(int)(Math.log(pq.size())/Math.log(2));
            //System.out.println(pqCount);
            Path vrec = pq.remove( );
            Vertex v = vrec.dest;
            if( v.scratch != 0 )  // already processed v
                continue;
                
            v.scratch = 1;
            nodesSeen++;

            for( Edge e : v.adj )
            {
                Vertex w = e.dest;
                double cvw = e.cost;
                
                if( cvw < 0 )
                    throw new GraphException( "Graph has negative edges" );
                    
                if( w.dist > v.dist + cvw )
                {
                    w.dist = v.dist +cvw;
                    w.prev = v;
                    pq.add( new Path( w, w.dist ) );
                    pqCount +=(int)(Math.log(pq.size())/Math.log(2));
                }
            }
        }
        //System.out.println("No of ops: "+ pqCount);
        return pqCount;
       

    }

    /**
     * Single-source negative-weighted shortest-path algorithm.
     * Bellman-Ford Algorithm
     */
    public void negative( String startName )
    {
        clearAll( ); 

        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        Queue<Vertex> q = new LinkedList<Vertex>( );
        q.add( start ); start.dist = 0; start.scratch++;

        while( !q.isEmpty( ) )
        {
            Vertex v = q.remove( );
            if( v.scratch++ > 2 * vertexMap.size( ) )
                throw new GraphException( "Negative cycle detected" );

            for( Edge e : v.adj )
            {
                Vertex w = e.dest;
                double cvw = e.cost;
                
                if( w.dist > v.dist + cvw )
                {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                      // Enqueue only if not already on the queue
                    if( w.scratch++ % 2 == 0 )
                        q.add( w );
                    else
                        w.scratch--;  // undo the enqueue increment    
                }
            }
        }
    }

    /**
     * Single-source negative-weighted acyclic-graph shortest-path algorithm.
     */
    public void acyclic( String startName )
    {
        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        clearAll( ); 
        Queue<Vertex> q = new LinkedList<Vertex>( );
        start.dist = 0;
        
          // Compute the indegrees
		Collection<Vertex> vertexSet = vertexMap.values( );
        for( Vertex v : vertexSet )
            for( Edge e : v.adj )
                e.dest.scratch++;
            
          // Enqueue vertices of indegree zero
        for( Vertex v : vertexSet )
            if( v.scratch == 0 )
                q.add( v );
       
        int iterations;
        for( iterations = 0; !q.isEmpty( ); iterations++ )
        {
            Vertex v = q.remove( );

            for( Edge e : v.adj )
            {
                Vertex w = e.dest;
                double cvw = e.cost;
                
                if( --w.scratch == 0 )
                    q.add( w );
                
                if( v.dist == INFINITY )
                    continue;    
                
                if( w.dist > v.dist + cvw )
                {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                }
            }
        }
        
        if( iterations != vertexMap.size( ) )
            throw new GraphException( "Graph has a cycle!" );
    }

    /**
     * Process a request; return false if end of file.
     */
    public static boolean processRequest( Scanner in, Graph g )
    {
        try
        {
            System.out.print( "Enter start node:" );
            String startName = in.nextLine( );

            System.out.print( "Enter destination node:" );
            String destName = in.nextLine( );

            System.out.print( "Enter algorithm (u, d, n, a ): " );
            String alg = in.nextLine( );
            
            if( alg.equals( "u" ) )
                g.unweighted( startName );
            else if( alg.equals( "d" ) )    
            {
                g.dijkstra( startName );
                g.printPath( destName );
            }
            else if( alg.equals( "n" ) )
                g.negative( startName );
            else if( alg.equals( "a" ) )
                g.acyclic( startName );
                    
            g.printPath( destName );
        }
        catch( NoSuchElementException e )
          { return false; }
        catch( GraphException e )
          { System.err.println( e ); }
        return true;
    }

    /**
     * A main routine that:
     * 1. Reads a file containing edges (supplied as a command-line parameter);
     * 2. Forms the graph;
     * 3. Repeatedly prompts for two vertices and
     *    runs the shortest path algorithm.
     * The data file is a sequence of lines of the format
     *    source destination cost
     */
    public static void main( String [ ] args )
    {
        Graph g = new Graph( );
        try
        {   	
            FileReader fin = new FileReader("graph10.20");
            Scanner graphFile = new Scanner( fin );

            // Read the edges and insert
            String line;
            while( graphFile.hasNextLine( ) )
            {
                line = graphFile.nextLine( );
                StringTokenizer st = new StringTokenizer( line );

                try
                {
                    if( st.countTokens( ) != 3 )
                    {
                        System.err.println( "Skipping ill-formatted line " + line );
                        continue;
                    }
                    String source  = st.nextToken( );
                    String dest    = st.nextToken( );
                    int    cost    = Integer.parseInt( st.nextToken( ) );
                    g.addEdge( source, dest, cost );
                    
                }
                catch( NumberFormatException e )
                  { System.err.println( "Skipping ill-formatted line " + line ); }
             }
         }
         catch( IOException e )
           { System.err.println( e ); }

         System.out.println( "File read..." );
         System.out.println( g.vertexMap.size( ) + " vertices" );

         Scanner in = new Scanner( System.in );
         while( processRequest( in, g ) )
             ;
    }
}
