import java.util.ArrayList;

public class Account implements Comparable<Account>
{

    private String accountName, description;
    private ArrayList<Posts> accountPosts = new ArrayList<Posts>(); //different way of storing accountPosts?
    private ArrayList<Account> followers = new ArrayList<Account>();
    private ArrayList<Account> following = new ArrayList<Account>();
    
    public Account(String a, String d)
    {
        accountName = a;
        description = d; 
    }
    public Account(Account d){
        this.accountName = d.accountName;
        this.description = d.description;
    }
    /**
     * 
     * @return 
     * returns copy of accountName
    */
    public String getAccountName() 
    { return new String(accountName);}
    /**
     * 
     * @return 
     * returns copy of account description
    */
    public String getAccountDescription(){

        return new String(description);
    }
    /**
     * 
     * @return 
     * returns copy of accountPost array
    */
    public ArrayList<Posts> getAccountPosts() 
    {
        return accountPosts;
    }

    public ArrayList<Account> getAccountFollowers()
    {
        return followers;
    }

    public ArrayList<Account> getAccountFollowing()
    {
        return following;
    }
    
    /**
     * 
     * @return 
     * returns number of posts in an account
    */
    public int getNumberOfPosts()
    {
        return accountPosts.size();
    }
    public int getNumberOfFollowers()
    {
        return followers.size();
    }
    public int getNumberOfFollowing()
    {
        return following.size();
    }


    void addNewFollower(Account a)
    {   
        if (!followers.contains(a))
                followers.add(a);
        else 
            System.out.println("Follower Already Exists\n");
         
    }
    void addNewFollowing(Account a)
    {   
        if (!following.contains(a))
                following.add(a);
   
        
    }

    public void fullDescription() 
    {   
    
         System.out.println("The profile description is: "+toString());
            System.out.println("Followers: "+ getNumberOfFollowers());
            for (Account i: followers)
            {   
                if (i!=null)
                    System.out.println(i.getAccountName());
            }
            System.out.println("\nFollowing: "+ getNumberOfFollowing());
            for (Account i: following)
            {   
                if (i!=null)
                    System.out.println(i.getAccountName());
            }     
        
    }

    /**
     * 
     * @param p
     */
    public void addAccountPost(Posts p)
    {
            if (!accountPosts.contains(p))
                accountPosts.add(p);
            else 
                System.out.println("Post Already Exists\n"+p);
    }

    /**
     * recursicely prints a list of an account posts
     * @param start
     * @param stop
     */

     

    public void listAccountPosts()
    {
       
        if (accountPosts != null )
        {   
           for (Posts i: accountPosts)
           {    
                System.out.println(i);
            
           }
        }
        else 
            System.out.println("No posts for "+getAccountName());
        
    }

    
    /**
     * checks if an account post already exists of the same title
     * @param p
     * @return
     */
    @Override
    public int compareTo(Account other) 
    {
        return (this.accountName).compareTo(other.accountName);
        
    }
    public String toString()
    {

        return getAccountName()+" "+getAccountDescription();
    }
}
