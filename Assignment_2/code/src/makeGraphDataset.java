import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class makeGraphDataset 
{   //static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<String> Edges;
    static ArrayList<String> nodes;
    //static ArrayList<String> dest = new ArrayList<String>();
    static int[] noOfNodes = {10,20,30,40,50} ;
    static int[] noOfEdges = {20,40,60,80,100} ;
    static Random val1 ;
    static Random val2;

    public makeGraphDataset(){
        Edges = new ArrayList<String>();
        nodes = new ArrayList<String>();
        val1 = new Random();
        val2 = new Random();

    }
    public void makedataset() throws IOException
    {
        for (int i: noOfNodes)
        {
            for (int j : noOfEdges)
            { 
                createNodes(i);
                createEdges(j);
               // System.out.println("No of nodes: "+nodes.size()+"\n"+nodes);
                //System.out.println("No of edges: "+Edges.size()+"\n"+Edges);
                writeToFile(i, j);
                nodes.clear();
                Edges.clear();
            }
        }
       
   
    }
    public void writeToFile(int V, int E) throws IOException 
    {
        File file = new File("data\\graph"+V+"."+E+".txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String i : Edges)
            {
                fileWriter.write(i+"\n");
                
                //System.out.println(i);
            }
        }
        
    }
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
                
            count++;}

        }
    }
    public void createNodes(int seed)
    {

        for (int i = 0; i < seed; i++)
        {
            String node = "node"+i;
            nodes.add(node);
            //System.out.println(node);
        }
    }
  
}
