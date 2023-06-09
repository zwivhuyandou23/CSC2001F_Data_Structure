
import java.util.*;
import java.io.*;  
public class Profile {

    BinarySearchTree tree;
    Scanner input;
    String choice;
    /**
     * Initializes the BST and the user input Scanner 
     */
    public Profile()
    {
    tree = new BinarySearchTree();
    input = new Scanner(System.in);
     

    }

    /**
     * The function starts the whole user interface when it is called from the main function from the main class.
     */
    public void startTikTok () throws IOException
    {
        while (true) {
            System.out.println();
            System.out.println("Choose an action from the menu:\n1. Find the profile description for a given account\n2. List all accounts\n3. Create an account\n4. Delete an account\n5. Display all posts for a single account\n6. Add a new post for an account\n7. Load a file of actions from disk and process this\n8. Add new Follower\n9. Remove Account Follower \n10. Automatic test (Delete <Account Name>, Display <Account Name>, Find <Account Name>, List <Account Name> Posts) from File\n11. Quit");
            choice =  input.nextLine();       
            if (choice.equals("1")) 
                option1();   
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
            else if (choice.equals("8")) {
            System.out.println("Enter Account Name that has a new Follower: ");
            String aName = input.nextLine();
            
            System.out.println("Enter Account Name that has started following: "+aName);
            String fName = input.nextLine();
                option8(aName,fName);
            }
            else if(choice.equals("9"))
                option9();
            else if (choice.equals("10")) 
                option10();
            else if (choice.equals("11"))
            {
                System.out.println("Bye!!!");
                break;
            }
            else
                System.out.println("\nInvalid option!! Try Again.\n");   
        System.out.println();
        }
    } 
    
    

    /*
     * Executes option 1 instructions from user TikTok interface
     */
    private void option1()
    {   
        System.out.println("");
        System.out.println("Enter the account name:");

        String aName = input.nextLine();

        System.out.println();
        //descriptionFinder(aName);
        //System.out.println();
        
        Account account = new Account(aName,null); 
        BinaryTreeNode<Account> b =  tree.find(account);
        

        if (b!=null)
        {
        
        b.getNodeData().fullDescription();;

        
        }
        else
            {
            System.out.println("Account "+aName+" Does not Exist"+"\nWould you like to create an account?[y/n]");
            String newAccountQuery = input.nextLine();
                if(newAccountQuery.equals("y"))
                    createNewAccount();
            }
    }
    /*
     * Executes option 2 instructions from user TikTok interface
     */
    private void option2() 
    {
        
        tree.getListOfAccounts();
        
    }
    /*
     * Executes option 4 instructions from user TikTok interface
     */
    private void option4() 
    {
        System.out.println("");
        System.out.println("Enter the account name:");
        String aName = input.nextLine();

        
        Account oldAccount = new Account(aName,null);
        BinaryTreeNode<Account> node = tree.find(oldAccount);
        if (node!= null)
        {
            tree.delete(oldAccount);

        System.out.println("Account: "+node.getNodeData()+ " has been removed.");
        }
        else
        
            System.out.println("Account "+aName+" Does Not Exists");
    }
    /**
     * Executre option 5 instructions from user TikTok interface
     */
    private void option5() 
    {
        System.out.println("");
        System.out.println("Enter the account name:");
        String aName = input.nextLine();
        Account account = new Account(aName,null); 
        BinaryTreeNode<Account> b =  tree.find(account);
        System.out.println("Post by: "+account.getAccountName());
        if (b!=null)
            b.data.listAccountPosts();
        else
            {
                System.out.println("Account "+aName+" Does not Exist"+"\nWould you like to create an account?[y/n]");
                String newAccountQuery = input.nextLine();

                if(newAccountQuery.equals("y"))
                    createNewAccount();
            }
    }
    /**
     * Executre option 6 instructions from user TikTok interface
     */
    private void option6() 
    {
        System.out.println("");
        String aName, title, video, likes;
        System.out.println("Enter the account name:");
        aName = input.nextLine();
        if (tree.find(new Account(aName, null) ) == null)
        {   
            System.out.println("Account "+aName+" Does not Exist"+"\nWould you like to create an account?[y/n]");
            String newAccountQuery = input.nextLine();

            if(newAccountQuery.equals("y"))
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
        Post newPost = new Post(title, video, likes);
        node.data.addAccountPost(newPost);
        System.out.println("New Post added by Account Name: "+account.getAccountName()+"\n"+ newPost); 
        }
    }
    /**
     * 
     * Executre option 7 instructions from user TikTok interface
     *
     * @throws IOException
     */
    private void option7() throws IOException 
    {
        System.out.println("");
        populate();
        System.out.println("");
    }
    
    /**
     * Executre option 8 instructions from user TikTok interface
     */
    private void option8(String aName, String fName)
    {
        Account newAccount = new Account(aName,null);
        BinaryTreeNode<Account> node = tree.find(newAccount);

        Account newfollowerAccount = new Account(fName,null);
        BinaryTreeNode<Account> node1 = tree.find(newfollowerAccount);

        if (node == null)
        {
            System.out.println("Account "+aName+" Does not Exist"+"\nWould you like to create an account?[y/n]");
            String newAccountQuery = input.nextLine();

            if(newAccountQuery.equals("y"))
                createNewAccount();
            return;
        }
        if (node1 == null)
        {   System.out.println("Account "+fName+" Does not Exist"+"\nWould you like to create an account?[y/n]");
            String newAccountQuery = input.nextLine();

            if(newAccountQuery.equals("y"))
                createNewAccount();
            return;
        }
            
        
        else 
        {
            node.getNodeData().addNewFollower(node1.getNodeData());
            node1.getNodeData().addNewFollowing(node.getNodeData());
        }
        
    }
    /**
     * Executre option 9 instructions from user TikTok interface
     */
    private void option9() 
    {
        String unfollowedAcc, unfollowingAcc;
        System.out.println("Enter the account name that has been unfollowed:");
        unfollowedAcc = input.nextLine();

        System.out.println("Enter the account name that unfollowed "+unfollowedAcc+": ");
        unfollowingAcc = input.nextLine();

        Account feAccount = new Account(unfollowedAcc,"");
        Account unAccount = new Account(unfollowingAcc,"");
        
        BinaryTreeNode<Account> node = tree.find(feAccount);
        BinaryTreeNode<Account> node1 = tree.find(unAccount);

        
        if (node == null ){

            

            System.out.println("Account "+feAccount+" Does not Exist"+"\nWould you like to create an account?[y/n]");
            String newAccountQuery = input.nextLine();

            if(newAccountQuery.equals("y"))
                createNewAccount();
        } 
        if (node1 == null ){

            
            System.out.println("Account "+unAccount+" Does not Exist"+"\nWould you like to create an account?[y/n]");
            String newAccountQuery = input.nextLine();

            if(newAccountQuery.equals("y"))
                createNewAccount();
        } 
        else if(node !=null && node1 != null )
        {
            node.getNodeData().getAccountFollowers().remove(node1.getNodeData());
            node1.getNodeData().getAccountFollowing().remove(node.getNodeData());
            System.out.println(unfollowingAcc +" Has unfollowed "+ feAccount);
        }
    }
    /**
     * Executre option 10 instructions from user TikTok interface
     */
    private void option10() throws IOException 
    {
        FileReader file = new FileReader("commandsList.txt");

        BufferedReader br = new BufferedReader(file);
        
        String line = br.readLine();
        
        while (line !=null)

        
        {
            System.out.println("@"+line);
            if (line.substring(0, 4).equalsIgnoreCase("Find") )
            {
                //System.out.println();
                String aName = line.substring(5,line.indexOf("description")-1);
                Account oldAccount = new Account(aName,null);
                BinaryTreeNode<Account> node = tree.find(oldAccount);
                if(node != null)
                {
                  node.getNodeData().fullDescription();  
                }
                else
                    System.out.println(aName+" does not exist\n");
            
            }
            else if(line.substring(0, 6).equalsIgnoreCase("Delete") )
            {   
                String aName = line.substring(7);
                //System.out.println(aName);
                Account oldAccount = new Account(aName,null);
                BinaryTreeNode<Account> node = tree.find(oldAccount);
                if (node != null)
                {
                    tree.delete(node.data);
        
                    System.out.println("Account: "+aName+ " has been removed.\n");
                }
                else
                
                    {System.out.println("Account"+aName+" Does Not Exists\n");}
            }
            else if (line.substring(0, 7).equalsIgnoreCase("Display"))
            {
                String aName = line.substring(8, line.indexOf("Post")-1);
                //System.out.println(aName);
                Account oldAccount = new Account(aName,null);
                BinaryTreeNode<Account> node = tree.find(oldAccount);
                //System.out.println(node.data);
                if (node != null)
                {
                    node.getNodeData().listAccountPosts();
                }
                else
                
                    {System.out.println("Account "+aName+" Does Not Exists");}

            }
        line = br.readLine(); 
        
        }
        
    
    br.close();
    }
    /**
     * Creates a new account 
     * */
    private void createNewAccount()
    {
        System.out.println("");
        System.out.println("Enter the account name:");
        String aName = input.nextLine();

        System.out.println("Enter the description:");
        String adescription = input.nextLine();
        Account newAccount = new Account(aName,adescription);
        tree.insert(newAccount);
      
    }
    /**   
    * @throws IOException
    * Loads in the dataset file and populate the data into the Binary Search Tree
    */

    private  void populate() throws IOException
    {
        String textFile = "dataset.txt";
        if (textFile.contains(".txt"))
        {
            FileReader file = new FileReader("dataset.txt");
        

            BufferedReader br = new BufferedReader(file);
        
            String line = br.readLine();

            while (line !=null)
            {
                System.out.println(line); // shows what line is being processed
                if (line.substring(0, 6).equalsIgnoreCase("Create"))
                {
                    String accountDetails, description;
                    accountDetails = line.substring(7);
                    int index = accountDetails.indexOf(" ");

                    String aName = accountDetails.substring(0, index);
                    System.out.print(aName);
                
                    description = accountDetails.substring(index + 1);
                    tree.insert(new Account(aName, description));
                
                }
                else if (line.substring(0, 3).equalsIgnoreCase("Add")) 
                {   
                    newPost(line);
                
                }
                else
                {
                addFileFollower(line);
            
                }
                line = br.readLine();
            }
            
            System.out.println("\nDataset populated!!!");
            br.close();
        }
        else
            {System.out.println("Unsupported file format");}        

        
        
    }
    /**
     * Processes the String line and looks for account names
     * A followers account name and an account following this account
     * Add the follower and  account following another account in their respective lists
     * Given that they exist
     * @param line
     * akes in a String line
     */
    void addFileFollower(String line)
    {
        String newFollower, newFollowing;

        newFollowing = line.substring(0, line.indexOf(" "));

        line = line.substring(line.indexOf(" "));

        
        newFollower = line.substring(9);
        //System.out.println(newFollowing+"\n"+newFollower);
        option8(newFollower, newFollowing);

    }

    /**
     * Processes the String line and looks for an account name
     * Adds a post into the account
     * The details are also extracted from the line String 
     * @param line
     * Takes in a String line
     * 
     * 
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
                    Post newAccPost = new Post(title, video, likes);          
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
}