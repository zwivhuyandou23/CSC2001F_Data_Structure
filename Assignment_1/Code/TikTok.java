
import java.util.*;
import java.io.*;  
public class TikTok {

    BinarySearchTree tree = new BinarySearchTree();

    public void startTikTok () throws IOException
    {

        String choice;
        Scanner input = new Scanner(System.in);
        

        do {
            System.out.println("Choose an action from the menu:\n1. Find the profile description for a given account\n2. List all accounts\n3. Create an account\n4. Delete an account\n5. Display all posts for a single account\n6. Add a new post for an account\n7. Load a file of actions from disk and process this\n8. Quit");
            choice =  input.nextLine(); // throw exception if it's a string
            
            
            if (choice.equals("1")) {

                System.out.println("Enter the account name:");

                String aName = input.nextLine();
                descriptionFinder(aName);
            }
            else if (choice.equals("2"))
            {   
                
                tree.getListOfAccounts();


            }
            else if (choice.equals("3"))
            {
                System.out.println("Enter the account name:");
                String aName = input.nextLine();

                System.out.println("Enter the description:");
                String adescription = input.nextLine();
                Account newAccount = new Account(aName,adescription);
                tree.insert(newAccount);
                System.out.println("New Account has been added:\n"+newAccount.toString());

            } else if (choice.equals("4"))
            {
                System.out.println("Enter the account name:");
                String aName = input.nextLine();

                
                Account oldAccount = new Account(aName,"");
                tree.delete(oldAccount);
                System.out.println("Account: "+oldAccount.toString()+ " has been removed.");

            } 
            else if (choice.equals("5"))
            {
                System.out.println("Enter the account name:");
                String aName = input.nextLine();

                
                Account account = new Account(aName,"");
                tree.delete(account);
                System.out.println("Posts by: "+account.getAccountName());
                // to be continued


            } else if (choice.equals("6") )
            {
                System.out.println("Enter the account name:");
                String aName = input.nextLine();

                
                Account account = new Account(aName,"");

                System.out.println("");

            }
            else if (choice.equals("7"))
            {
                System.out.println("");
                populate();


            }
            else if ((Integer.getInteger(choice)< 1) || (Integer.getInteger(choice)> 8))
            {
                System.out.println("\nInvalid option!! Try Again.\n");
            }


            
        } while (!choice.equals("8"));
        input.close();
    }
    public TikTok(){} // constructor

    public  void populate() throws IOException
    {

        FileReader file = new FileReader("C:\\Users\\Zwivh\\OneDrive - University of Cape Town\\3rd Year\\CSC2001F\\dataset.txt");

        BufferedReader br = new BufferedReader(file);
        
        String line = br.readLine();

        while (line != null)
        {
            System.out.println(line); // shows what line is being processed
            if (line.substring(0, 6).equals("Create"))
            {
                String accountDetails, description;
                accountDetails = line.substring(7);

                char[] chars = accountDetails.toCharArray();  //storing the account details into a char array
                String indexStr = indexFinder(chars);         // the indexFinder return a string/char of the last char on the account name.
                int index = accountDetails.indexOf(indexStr);

                String aName = accountDetails.substring(0, index + 1);        
                description = accountDetails.substring(index + 2); 
                tree.insert(new Account(aName, description));
                line = br.readLine();
            }
            else if (line.substring(0, 3).equals("Add")) {
                
                String accountDetails, video,title;
                int likes;

                accountDetails = line.substring(3);

                char[] chars = accountDetails.toCharArray();  //storing the account details into a char array
                String indexStr = indexFinder(chars);         // the indexFinder return a string/char of the last char on the account name.
                int index1 = accountDetails.indexOf(indexStr);

                String aName = accountDetails.substring(0, index1 + 1);
                System.out.println(aName);
                accountDetails = accountDetails.substring(index1 + 2);
                

                title = accountDetails.substring(0,14);
                System.out.println(title);
                
                line = br.readLine();
            }

        }
        System.out.println("\nDataset populated!!!");
        br.close();
    }

    public String indexFinder( char[] arrayOfAccount) {
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

    public  void descriptionFinder(String accName)
    {   Account account = new Account(accName,"");
        
        BinaryTreeNode<Account> foundAccount = tree.find(account);
        //System.out.println(foundAccount.data.description);
        if(foundAccount == null)
        {
            System.out.println("No account exists with account name: "+ accName);
        }
        else
        {
            System.out.println(foundAccount.data.toString());
        }

    }

}


