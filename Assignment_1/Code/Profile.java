
import java.util.*;

import javax.lang.model.util.ElementScanner6;

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
    public void startTikTok () throws IOException
    {
        
        
        while (true) {
            System.out.println("Choose an action from the menu:\n1. Find the profile description for a given account\n2. List all accounts\n3. Create an account\n4. Delete an account\n5. Display all posts for a single account\n6. Add a new post for an account\n7. Load a file of actions from disk and process this\n8. Quit");
            choice =  input.nextLine(); 
            
            
            if (choice.equals("1")) 
            {
                System.out.println("");
                System.out.println("Enter the account name:");

                String aName = input.nextLine();
                System.out.println();
                   
                descriptionFinder(aName);


                
                
            System.out.println();   
            }
            else if (choice.equals("2"))
            {   
                System.out.println();
                tree.getListOfAccounts();
                System.out.println();
            }
            else if (choice.equals("3"))
            {
                createNewAccount();

            } else if (choice.equals("4"))
            {
                System.out.println("");
                System.out.println("Enter the account name:");
                String aName = input.nextLine();

                
                Account oldAccount = new Account(aName,null);
                tree.delete(oldAccount);
                
                System.out.println("Account: "+aName+ " has been removed.");

            } 
            else if (choice.equals("5"))
            {
                System.out.println("");
                System.out.println("Enter the account name:");
                String aName = input.nextLine();

                
                Account account = new Account(aName,null);
                
                BinaryTreeNode<Account> b =  tree.find(account);
                
                System.out.println("Posts by: "+account.getAccountName());
                if (b!=null)
                    b.data.listAccountPosts(0,b.data.getAccountPosts().size()-1);
                else
                    {
                        System.out.println("Account "+aName+"Does not Exist"+"\nWould you like to create an account?[y/n]");
                        String newAccountQuery = input.nextLine();

                        if(newAccountQuery.equals("y"))
                            createNewAccount();


                    }

            } 
            else if (choice.equals("6") )
            {
                System.out.println("");
                String aName, title, video, likes;
                System.out.println("Enter the account name:");
                aName = input.nextLine();

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
                System.out.println("New Post added by Account Name: "+account.getAccountName()+"\n"+ newPost); //selection statement for null
                }
                else 
                    createNewAccount();

                

            }
            
            else if (choice.equals("7"))
            {
                System.out.println("");
                populate();
                System.out.println("");
            }            
            else if (choice.equals("8"))
            {
            System.out.println("Done, Goodbye");
                break;
            }
            else
                System.out.println("\nInvalid option!! Try Again.\n");   
        }
        
    
    } 

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

    private  void populate() throws IOException
    {

        FileReader file = new FileReader("dataset.txt");

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
                
                int index = accountDetails.indexOf(" ");

                String aName = accountDetails.substring(0, index);  
                //System.out.println(aName);      
                description = accountDetails.substring(index + 1); 
                //System.out.println(description);
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

    private void newPost(String line)
     {
        String accountDetails, video,title,likes;

                accountDetails = line.substring(4);

                char[] chars = accountDetails.toCharArray();  //storing the account details into a char array
                
                int index1 = accountDetails.indexOf(" ");

                String aName = accountDetails.substring(0, index1);
                //System.out.println(aName);
                accountDetails = accountDetails.substring(index1);
                

                video = accountDetails.substring(1,14);
                //System.out.println(video);
                accountDetails = accountDetails.substring(15);
                likes =  accountDetails.substring(0, accountDetails.indexOf(" "));
                //System.out.println(likes);
                accountDetails = accountDetails.substring(accountDetails.indexOf(" ")+1);
                title = accountDetails;
                //System.out.println(title);
                Account accountOfNewPost = new Account(aName,null);
                BinaryTreeNode<Account> node =  tree.find(accountOfNewPost);
                if ( node != null)
                {
                    Posts newAccPost = new Posts(title, video, likes);
                       if (!node.data.getAccountPosts().contains(newAccPost))
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
                   
                   // System.out.println(newPost+" Exists");
        }

    
    private  void descriptionFinder(String accName)
    {   Account account = new Account(accName,"");
        
        BinaryTreeNode<Account> foundAccount = tree.find(account);
        //System.out.println(foundAccount.data.description);
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

}


