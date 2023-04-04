import java.sql.SQLOutput;
import java.util.*;
import java.io.*;  
public class TikTok {

    public static void main(String[] args) throws IOException
    {

        String choice;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Choose an action from the menu:\n1. Find the profile description for a given account\n2. List all accounts\n3. Create an account\n4. Delete an account\n5. Display all posts for a single account\n6. Add a new post for an account\n7. Load a file of actions from disk and process this\n8. Quit");
            //choice =  input.nextLine();
            choice = "7";
            if (choice.equals("1")) {
                System.out.println("Hellow");

            } else if (choice.equals("2")) {
            } else if (choice.equals("3")) {
            } else if (choice.equals("4")) {
            } else if (choice.equals("5")) {
            } else if (choice.equals("6")) {
            } else if (choice.equals("7")) {
                populate();


            }


            input.close();
        } while (choice.equals("8"));
    }

    public static void populate() throws IOException
    {

        FileReader file = new FileReader("C:\\Users\\Zwivh\\OneDrive - University of Cape Town\\3rd Year\\CSC2001F\\dataset.txt");

        BufferedReader br = new BufferedReader(file);

        String line = br.readLine();
        while (line != null)
        {
            System.out.println(line); // shows what line is been processed
            if (line.substring(0, 6).equals("Create"))
            {
                    String accountDetails, name, description;
                    accountDetails = line.substring(7);

                    char[] chars = accountDetails.toCharArray();  //storing the account details into a char array
                    String indexStr = indexFinder(chars);         // the indexFinder return a string/char of the last char on the account name.
                    int index = accountDetails.indexOf(indexStr);

                    String aName = accountDetails.substring(0, index + 1);
                    //System.out.println(aName);

                    description = accountDetails.substring(index + 2);
                    //System.out.println(description);


                    BinarySearchTree b = new BinarySearchTree();
                    b.insert(new Account(aName, description));

                    String accountName = b.root.data.description;
                   // System.out.println(accountName);
                //System.out.println(newAccount.accountName);
                    line = br.readLine();

            }



            else if (line.substring(0, 3).equals("Add")) {
                //System.out.println("TO be populated");

                line = br.readLine();
            }

        }
        System.out.println("\nDataset populated!!!");
    }
        public static String indexFinder( char[] arrayOfAccount) {
            String name = "";
            for (char c : arrayOfAccount)
            {
                if (Character.isDigit(c))
                {
                    name = String.valueOf(c);

                }

            }
            //System.out.println(name.toString());
            return name.toString();
        }

}


