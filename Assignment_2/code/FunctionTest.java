import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FunctionTest

{
    Graph graph;
    ArrayList<Vertex> vertices = new ArrayList<Vertex>();

    public FunctionTest()
    {
        graph = new Graph();
    }
    public void startTest() throws FileNotFoundException
    {
        addFileEdgesToQueue();
        makeRequests();
    }
    public void addFileEdgesToQueue() throws FileNotFoundException {

        for (int i = 1; i<6;i++)
        {   
            
            FileReader file = new FileReader("C:\\Users\\Zwivh\\OneDrive\\Desktop\\Repositories\\CSC2001F_Data_Structure\\Assignment_2\\code\\graph"+i +".txt");
            System.out.println("graph"+i +".txt");
            try (BufferedReader br = new BufferedReader(file)) 
            {   String line = br.readLine();
                while (line!=null){

                    
                    String sourceName, destName;
                    double cost;
                    sourceName = line.substring(0,6);
                    destName = line.substring(7,13);
                    String costy = line.substring(14);
                    cost = Double.valueOf(costy);

                    System.out.println(line);
                    //System.out.println(sourceName+"\n"+destName+"\n"+cost+"\n");
                    line = br.readLine();

                    graph.addEdge(sourceName, destName, cost);
                    vertices.add(graph.getVertex(sourceName));
                    vertices.add(graph.getVertex(destName));

                    


            }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    public void makeRequests()
    {
        int c = 0;
        while(c<10)
        {
            Random a = new Random();
            int index = a.nextInt(vertices.size()-1);

            Vertex startName = vertices.get(index);
            System.out.println("Vertex "+startName.name);
            
            graph.unweighted(startName.name);

            System.out.println("Vertex "+startName.name);
            graph.dijkstra(startName.name);

            System.out.println("Vertex "+startName.name);
            graph.negative(startName.name);

            System.out.println("Vertex "+startName.name);
            graph.acyclic(startName.name);

            c++;
        }
        
    }
}