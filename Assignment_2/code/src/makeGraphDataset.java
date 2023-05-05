import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class makeGraphDataset 
{   
    static ArrayList<String> Edges;
    static ArrayList<String> nodes;

    static int[] noOfNodes = {10,20,30,40,50} ;
    static int[] noOfEdges = {20,40,60,80,100} ;
    static Random val1 ;
    static Random val2;
    /**
     * Initializes the instance variables Edges, nodes, val1, val2;
     */
    public makeGraphDataset(){
        Edges = new ArrayList<String>();
        nodes = new ArrayList<String>();
        val1 = new Random();
        val2 = new Random();
    }
    /**
     * Calls the createNodes(int), createEdges(int) writeToFile(int, int) to create nodes, edges and, a file to stores the results of the Dikstra's algorithm
     * @throws IOException
     */
    public void makedataset() throws IOException
    {
        for (int i: noOfNodes)
        {
            for (int j : noOfEdges)
            { 
                createNodes(i);
                createEdges(j);
                writeToFile(i, j);
                nodes.clear();
                Edges.clear();
            }
        }
    }
    /**
     * Creates 
     * @param V
     * Takes in an int value
     * @param E
     * Takes in an int value
     * @throws IOException
     */
    public void writeToFile(int V, int E) throws IOException 
    {
        File file = new File("data\\graph"+V+"."+E+".txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String i : Edges)
            {
                fileWriter.write(i+"\n");

            }
        }
        
    }
    /**
     * Randomly chooses a two nodes and a random weight to create a weighted edge the add it into an Edges list
     * @param seed
     * Takes in an int value
     */
    public void createEdges(int seed) 
    {
        int count =0;
        while (seed !=count)
        {
            int index1 = val1.nextInt(nodes.size()-1);
            int index2 = val2.nextInt(nodes.size()-1);
            int weight = val2.nextInt(10);

            String node1 = nodes.get(index1);
            String node2 = nodes.get(index2);

            String edge = "";
            

            if (weight != 0 && index1 != index2)
            {
                if (!Edges.contains(edge) && node1.length() == 5 && node2.length() == 5){edge = node1+"  "+node2+"  "+weight; Edges.add(edge); }

                else if (!Edges.contains(edge) && node1.length() == 5 && node2.length() == 6){edge = node1+"  "+node2+" "+weight; Edges.add(edge); }

                else if (!Edges.contains(edge) && node1.length() == 6 && node2.length() == 5){edge = node1+" "+node2+"  "+weight; Edges.add(edge); }

                else if (!Edges.contains(edge) && node1.length() == 6 && node2.length() == 6){edge = node1+" "+node2+" "+weight;Edges.add(edge); }
                
            count++;
        }

        }
    }
    /**
     * Creates a list of distinct nodes
     * @param seed
     * Takes in an int value
     */
    public void createNodes(int seed)
    {
        for (int i = 0; i < seed; i++)
        {
            String node = "node"+i;
            nodes.add(node);
        }
    }
  
}
