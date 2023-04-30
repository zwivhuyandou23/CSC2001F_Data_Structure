import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
    int edgesAdded;
    int operations = 0;
    static ArrayList<String> data = new ArrayList<String>();

    
    static FileWriter dataToFile;
    

    

    public FunctionTest()
    {
        try {
            dataToFile =  new FileWriter(new File("data\\data.csv"));
        } catch (Exception e) 
        {
            // TODO: handle exception
        }
     edgesAdded = 0;
    }
    public void startTest() throws IOException
    {   new makeGraphDataset().makedataset(); 
        addFileEdgesToQueue();
        writeToFile();
    }
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

                        //System.out.println(line);
                        //System.out.println(sourceName+"\n"+destName);
                        line = br.readLine();
                        

                        graph.addEdge(sourceName, destName, cost);
                        edgesAdded++;
                        vertices.add(graph.getVertex(sourceName));
                        vertices.add(graph.getVertex(destName));
                    }
                    //System.out.println("Total Number of Vertices: "+graph.vertexMap.size());
                } 
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               // System.out.println(startvertices);
              
            makeRequests(2,i,j);
            
            }
                
        }
        
        
        
        //System.out.println(ops.size());

        graph.clearAll();
        edgesAdded = 0;
        
        //graph.pqCount = 0;
        
    }
   
    public void makeRequests(int seed ,int V, int E) throws IOException
    {
        
        
        Random a = new Random();
        Random b = new Random();
        

        
        while(seed > 1 )
        {
            int i = a.nextInt(V-1);
            int j = b.nextInt(V-1);
            //System.out.println(j+" Total Number of Edges: "+i);
            //System.out.println(seed);
            Vertex start = vertices.get(i); //start node
            Vertex dest = vertices.get(j); // destination

            if (!start.name.equals(dest.name) && start != null && dest != null)
            {
            
            
            //System.out.println("Start "+(start.name));
            operations  = graph.dijkstra(start.name);
           //System.out.println(operations);
            graph.printPath(dest.name);
            
            
           // System.out.println(V+", "+E+", "+operations);
            if (operations<1)
                makeRequests(seed, V, E);
            else
                data.add(V+", "+E+", "+operations+", "+(E*Math.log(V)));
            
            
            
            vertices.remove(i);
            vertices.remove(j);
            }
            seed--;}
            //System.out.println(data);
        
    }
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
