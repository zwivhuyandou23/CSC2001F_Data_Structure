import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Random;

public class makeGraphDataset 
{

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
                for (int i = 0; i<multi+10;i++)
                {   int randomNode1 = a.nextInt(10+multi);
                    int randomNode2 = a.nextInt(10+multi);

                    int weight = a.nextInt(10);
                    weight++;

                    if(randomNode1 != randomNode2 && weight!=0)
                    {
                        if (randomNode2 < 10 && randomNode1 <10  )
                        {

                            System.out.println("Node"+randomNode1+"  "+"Node"+randomNode2+"  "+weight );
                            fileWrite.write("Node"+randomNode1+"  "+"Node"+randomNode2+"  "+weight+"\n");

                        }
                        else if (randomNode1 < 10)
                            
                        {
                            System.out.println("Node"+randomNode1+"  "+"Node"+randomNode2+" "+weight);
                            fileWrite.write("Node"+randomNode1+"  "+"Node"+randomNode2+" "+weight+"\n");
                        }
                        else if (randomNode2 < 10)
                            
                        {
                            System.out.println("Node"+randomNode1+" "+"Node"+randomNode2+"  "+weight);
                            fileWrite.write("Node"+randomNode1+" "+"Node"+randomNode2+"  "+weight+"\n");
                        }
                        else 
                            
                        {
                            System.out.println("Node"+randomNode1+" "+"Node"+randomNode2+" "+weight);
                            fileWrite.write("Node"+randomNode1+" "+"Node"+randomNode2+" "+weight+"\n");
                        }
                    }
                    

                }
            }
        }

        

    }
}