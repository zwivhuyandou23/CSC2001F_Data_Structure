import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FunctionTest

{
    
    ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    ArrayList<Vertex> startvertices = new ArrayList<Vertex>();
    ArrayList<Vertex> destvertices = new ArrayList<Vertex>();
    static int[] noOfNodes = {10,20,30,40,50} ;
    static int[] noOfEdges = {20,40,60,80,100} ;
    Graph graph;
    int edgesAdded;

    public FunctionTest()
    {
     graph = new Graph();
     edgesAdded = 0;
    }
    public void startTest() throws FileNotFoundException
    {   

        addFileEdgesToQueue();
        
    }
    public void addFileEdgesToQueue() throws FileNotFoundException {

        for (int i : noOfNodes)
        {   
            for (int j : noOfEdges)
            {
                FileReader file = new FileReader("graph"+i+"."+j +".txt");
                System.out.println("graph"+i+"."+j +".txt");
                try (BufferedReader br = new BufferedReader(file)) 
                {   String line = br.readLine();
                    
                    while (line!=null){

                        
                        String sourceName, destName;
                        double cost;
                        sourceName = line.substring(0,6);
                        destName = line.substring(7,13);
                        String costy = line.substring(14);
                        cost = Double.valueOf(costy);

                        //System.out.println(line);
                        //System.out.println(sourceName+"\n"+destName);
                        line = br.readLine();

                        graph.addEdge(sourceName, destName, cost);
                        edgesAdded++;

                        if (!vertices.contains(graph.getVertex(sourceName))){
                            
                            vertices.add(graph.getVertex(sourceName));}

                        if (!startvertices.contains(graph.getVertex(sourceName))){
                            
                            startvertices.add(graph.getVertex(sourceName));}
                        else{
                            
                            destvertices.add(graph.getVertex(sourceName));}
                    }
                    //System.out.println("Total Number of Vertices: "+graph.vertexMap.size());
                    
                makeRequests();
                graph.clearAll();
                edgesAdded = 0;
                } 
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
                
        }
        
    }
    public static void write() {
        
    }
    public void makeRequests()
    {
        int c = 0;
        Random a = new Random();
        

        //System.out.println("Total Number of Edges: "+edgesAdded);
        while(startvertices.size()>1 && destvertices.size()>1)
        {
            int i = a.nextInt(startvertices.size()-1);
            int j = a.nextInt(destvertices.size()-1);

            if (i != j)
            {
                Vertex start = startvertices.get(i);
            Vertex dest = destvertices.get(j);
            System.out.println("Start "+start.name+"\nDestination "+dest.name);
            graph.dijkstra(start.name);
            
            
            graph.printPath(dest.name);
        
            System.out.println();
            startvertices.remove(i);
            destvertices.remove(j);

            
            c++;
            }
        }
        
    }
}
