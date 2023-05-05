import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    static ArrayList<Integer> ops = new ArrayList<Integer>();
    Graph graph;
    
    int operations = 0;
    static ArrayList<String> data = new ArrayList<String>();

    static FileWriter dataToFile;
    /**
     * Initialises the csv file object that stores the number of operations the Dikjtra's algorithm takes to find shortest path to a vertex
     */
    public FunctionTest()
    {
        try {
            dataToFile =  new FileWriter(new File("data\\data.csv"));
        } catch (Exception e) 
        {
            // TODO: handle exception
        }

    }
    /**
     * Starts the program
     * @throws IOException
     */
    public void startTest() throws IOException
    {   new makeGraphDataset().makedataset(); 
        addFileEdgesToQueue();
        writeToFile();
    }
    /**
     * Processes text files with graph edges and initializes the graph instance and adds the egdes into the graph
     * Stores vertices from the file into an ArrayList for use in the makeRequests() method
     * Calls the makeRequests() method to test the Dijkstra's method 
     * @throws IOException
     */
    public void addFileEdgesToQueue() throws IOException {

        for (int i : noOfNodes)
        {   
            for (int j : noOfEdges)
            {
                
                FileReader file = new FileReader("data\\graph"+i+"."+j +".txt");
                System.out.println("graph"+i+"."+j +".txt\nFile read...\n");

                try (BufferedReader br = new BufferedReader(file)) 
                {   String line = br.readLine();
                    graph = new Graph();
                    while (line!=null)
                    {     
                        String sourceName, destName;
                        double cost;
                        sourceName = line.substring(0,6);
                        destName = line.substring(7,13);
                        String costy = line.substring(14);
                        cost = Double.valueOf(costy);
                        line = br.readLine();
                        graph.addEdge(sourceName, destName, cost);
                        
                        vertices.add(graph.getVertex(sourceName));
                        vertices.add(graph.getVertex(destName));
                    }
            
                } 
                catch (IOException e) {
                    
                    e.printStackTrace();
                } 
            makeRequests(1,i,j);
            
            }       
        }
        graph.clearAll();
            
    } 
   /**
    * Randomly chooses start and destination vertices from the vertices list and make the Dikjstra's method take the start name as an argument
    * The Dikstra's method has been modified to return operations done to find shortest path to a node.
    * The operations are then stored in a list together with Vertices, Edges and Theoretical operations.
    * @param seed
    * Takes in an int value
    * @param V
    * Takes in an int value
    * @param E
    * Takes in an int value
    * @throws IOException
    */
    public void makeRequests(int seed ,int V, int E) throws IOException
    {
        
        
        Random a = new Random();
        Random b = new Random();
        while(seed !=0 ) 
        {
            int i = a.nextInt(V-1);
            int j = b.nextInt(V-1);
            
            Vertex start = null;
            Vertex dest = null;

            
            if(i< vertices.size() && j <vertices.size()  ){

            start = vertices.get(i); //start node
            dest = vertices.get(j); // destination
            }
        

            if (!start.name.equals(dest.name) )
            {
            operations  = graph.dijkstra(start.name);
           
            graph.printPath(dest.name);
            
            
            System.out.println(V+", "+E+", "+operations);
            if (operations == 0)
            System.out.println("");    
            
                
            else{
                data.add(V+", "+E+", "+operations+", "+(E*Math.log(V)));seed--;}
            vertices.remove(i);
            vertices.remove(j);
            
            }
            
        }
            
        
    }
    /**
     * Writes the contents from the data list and writes them into a csv file object.
     * @throws IOException
     */
    public static void writeToFile() throws IOException 
    {   
        dataToFile.write("Vertices"+","+"Edges"+","+"Operations"+","+"Theoretical"+"\n");
        dataToFile.write(0+", "+0+", "+0+", "+0+"\n");
        for (String i : data)
        {
            System.out.println(i);
            dataToFile.write(i+"\n");
            dataToFile.flush();
        }
        
    }
}
