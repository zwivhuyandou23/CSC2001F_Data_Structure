
import java.util.*;
import java.io.*;  
public class Profile {

    BinarySearchTree tree;
    Scanner input;
    String choice;

    public Profile()
    {
    tree = new BinarySearchTree();
    input = new Scanner(System.in);
     // throw exception if it's a string

    }

    /* The function starts the whole user interface when it is called from the main class
    */
    public void startTikTok () throws IOException
    {
        while (true) {
            System.out.println("Choose an action from the menu:\n1. Find the profile description for a given account\n2. List all accounts\n3. Create an account\n4. Delete an account\n5. Display all posts for a single account\n6. Add a new post for an account\n7. Load a file of actions from disk and process this\n8. List of Followers and Following for an an Account\n9. Add new Follower\n10. Add new Following\n11. Quit");
            choice =  input.nextLine();       
            if (choice.equals("1")) 
            {
                option1();   
                System.out.println();   
            }
            else if (choice.equals("2"))
                option2();
            else if (choice.equals("3"))
                createNewAccount();
            else if (choice.equals("4"))
                option4();
            else if (choice.equals("5"))
                option5();
            else if (choice.equals("6") )
                option6();
            else if (choice.equals("7"))
                option7();           
            else if (choice.equals("8")) 
                option8();
            else if (choice.equals("9"))
            {
                System.out.println("Done, Goodbye");
                break;
            }
            else
                System.out.println("\nInvalid option!! Try Again.\n");   
        }
    } 
    /*Create a new account */
    private void createNewAccount()
    {
        System.out.println("");
        System.out.println("Enter the account name:");
        String aName = input.nextLine();

        System.out.println("Enter the description:");
        String adescription = input.nextLine();
        Account newAccount = new Account(aName,adescription);
        tree.insert(newAccount);

        System.out.println("\nNew Account has been added:\n"+newAccount.toString());       
    }
    /**   
    *@throws IOException
    *Loads in the dataset file and populate the data into the Binary Search Tree
    */
    private  void populate() throws IOException
    {

        FileReader file = new FileReader("/home/zwivhuya/School/CSC2001F/Assignments/DS/CSC2001F_Data_Structure/Assignment_1/Code/src/dataset.txt");

        BufferedReader br = new BufferedReader(file);
        
        String line = br.readLine();

        while (line !=null)
        {
            System.out.println(line); // shows what line is being processed
            if (line.substring(0, 6).equals("Create"))
            {
                String accountDetails, description;
                accountDetails = line.substring(7);
                int index = accountDetails.indexOf(" ");

                String aName = accountDetails.substring(0, index);
                   
                description = accountDetails.substring(index + 1);
                tree.insert(new Account(aName, description));
                line = br.readLine();
            }
            else if (line.substring(0, 3).equals("Add")) 
            {   
                newPost(line);
                line = br.readLine();
            }
                        
        }
        System.out.println("\nDataset populated!!!");
        br.close();
    }

    /**
     
    *@param line
    * Create a new post from the given dataset
    */
    private void newPost(String line)
     {
        String accountDetails, video,title,likes;

                accountDetails = line.substring(4);
                
                int index1 = accountDetails.indexOf(" ");
                String aName = accountDetails.substring(0, index1);
                
                accountDetails = accountDetails.substring(index1);
                video = accountDetails.substring(1,14);
                accountDetails = accountDetails.substring(15);
                likes =  accountDetails.substring(0, accountDetails.indexOf(" "));             
                accountDetails = accountDetails.substring(accountDetails.indexOf(" ")+1);
                title = accountDetails;             
                
                Account accountOfNewPost = new Account(aName,null);
                BinaryTreeNode<Account> node =  tree.find(accountOfNewPost);
                if ( node != null)
                {
                    Posts newAccPost = new Posts(title, video, likes);          
                        node.data.addAccountPost(newAccPost); 
                    }
                else
                    {
                        System.out.println("Account Name: "+aName+" does not exist!!!\n");
                        System.out.println("Would you like to create a new Account for "+aName+"?[y/n]");
                        String newAccountQuery = input.nextLine();

                        if (newAccountQuery.equals("y"))
                            createNewAccount();
                    }   
        }

    /*  The function looks for a description matching an account
    *   if such an account does not exist it asks user if they want to create an account or not
    */
    private  void descriptionFinder(String accName) 
    {   
        Account account = new Account(accName,"");   
        BinaryTreeNode<Account> foundAccount = tree.find(account);   
        if(foundAccount == null)
        {
            System.out.println("Account "+account.getAccountName()+" Does not Exist"+"\nWould you like to create an account?[y/n]");
            String newAccountQuery = input.nextLine();

            if(newAccountQuery.equals("y"))
                createNewAccount();


        }
        else
        {
            System.out.println(foundAccount.data.toString());
        }

    }
    /*
     * Executes option 1 instructions
     */
    private void option1()
    {
        System.out.println("");
        System.out.println("Enter the account name:");

        String aName = input.nextLine();
        System.out.println();
        descriptionFinder(aName);
    }
    /*
     * Executes option 2 instructions
     */
    private void option2() 
    {
        System.out.println();
        tree.getListOfAccounts();
        System.out.println();
    }
    /*
     * Executes option 4 instructions
     */
    private void option4() 
    {
        System.out.println("");
        System.out.println("Enter the account name:");
        String aName = input.nextLine();

        
        Account oldAccount = new Account(aName,null);
        tree.delete(oldAccount);
        
        System.out.println("Account: "+aName+ " has been removed.");  
    }
    /*
     * Executes option 5 instructions
     */
    private void option5() 
    {
        System.out.println("");
        System.out.println("Enter the account name:");
        String aName = input.nextLine();
        Account account = new Account(aName,null); 
        BinaryTreeNode<Account> b =  tree.find(account);
        System.out.println("Posts by: "+account.getAccountName());
        if (b!=null)
            b.data.listAccountPosts(0,b.data.getAccountPosts().length-1);
        else
            {
                System.out.println("Account "+aName+"Does not Exist"+"\nWould you like to create an account?[y/n]");
                String newAccountQuery = input.nextLine();

                if(newAccountQuery.equals("y"))
                    createNewAccount();
            }
    }
    /*
     * Executes option 6 instructions
     */
    private void option6() 
    {
        System.out.println("");
        String aName, title, video, likes;
        System.out.println("Enter the account name:");
        aName = input.nextLine();
        if (tree.find(new Account(aName, null) ) == null)
        {   System.out.println(aName+"'s Account does not exist!!!");
            createNewAccount();
        }

        System.out.println("Video Title:");
        title = input.nextLine();

        System.out.println("Name of Video:");
        video = input.nextLine();

        System.out.println("Number of Likes:");
        likes = input.nextLine();

        Account account = new Account(aName,null);

        BinaryTreeNode<Account> node =  tree.find(account);
        if (node != null)
        {
        Posts newPost = new Posts(title, video, likes);
        node.data.addAccountPost(newPost);
        System.out.println("New Post added by Account Name: "+account.getAccountName()+"\n"+ newPost); 
        }
    }
    /**
     * Executes option 7 instructions
     * @throws IOException
     */
    private void option7() throws IOException 
    {
        System.out.println("");
        populate();
        System.out.println("");
    }
    private void option8()
    {
        System.out.println("Enter Account Name: ");
        String aName = input.nextLine();

        Account newAccount = new Account(aName,null);
        BinaryTreeNode<Account> node = tree.find(newAccount);

        if (node !=null)
        
            node.getNodeData().addNewFollower(newAccount);
        else 
        {
            System.out.println("Account "+aName+"Does not Exist"+"\nWould you like to create an account?[y/n]");
            String newAccountQuery = input.nextLine();

            if(newAccountQuery.equals("y"))
                createNewAccount();
        }

    }
    
}