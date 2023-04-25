import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class makeGraphDataset 
{
    static ArrayList<String> Edges = new ArrayList<String>();
    public static void main(String[] args) throws IOException
    {
        Random a = new Random();

        //int randomNo = a.nextInt(100);

        int count = 0;
        while (count<5)
        {               
            
           int multi = 10*count;
            count++;
            String fName = "graph"+count+".txt"; 
            File filename = new File(fName);

            try (FileWriter fileWrite = new FileWriter(filename)) {
                System.out.println(fName);
                for (int i = 0; i<(multi/2)+10;i++)
                {   int randomNode1 = a.nextInt(10+i);
                    int randomNode2 = a.nextInt(10+i);

                    int weight = a.nextInt(10);
                    weight++;

                    if(randomNode1 != randomNode2 && weight!=0 )
                    {
                        if (randomNode2 < 10 && randomNode1 <10  )
                        {   String edge = "Node"+randomNode1+"  "+"Node"+randomNode2+"  "+weight;
                            //System.out.println("Node"+randomNode1+"  "+"Node"+randomNode2+" "+weight);
                            if (!Edges.contains(edge))
                                Edges.add(edge);

                        }
                        else if (randomNode1 < 10)
                            
                        {
                            String edge = "Node"+randomNode1+"  "+"Node"+randomNode2+" "+weight;
                            //System.out.println("Node"+randomNode1+"  "+"Node"+randomNode2+" "+weight);
                            if (!Edges.contains(edge))
                                Edges.add(edge);
                        }
                        else if (randomNode2 < 10)
                            
                        {   String edge = "Node"+randomNode1+" "+"Node"+randomNode2+"  "+weight;
                            
                            //System.out.println("Node"+randomNode1+" "+"Node"+randomNode2+"  "+weight);
                            if (!Edges.contains(edge))
                                Edges.add(edge);
                        }
                        else 
                            
                        {   
                            String edge ="Node"+randomNode1+" "+"Node"+randomNode2+" "+weight;

                            //System.out.println("Node"+randomNode1+" "+"Node"+randomNode2+" "+weight);
                            if (!Edges.contains(edge))
                                Edges.add(edge);
                        }
                    }
                    

                }
                for (String i : Edges)
                {
                    System.out.println(i);
                    fileWrite.write(i+"\n");
            
                }
            }
        }
        

        

    }
}