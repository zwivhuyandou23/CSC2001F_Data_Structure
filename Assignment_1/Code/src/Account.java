import java.util.ArrayList;

public class Account implements Comparable<Account>
{

    private String accountName, description;
    private ArrayList<Post> accountPosts = new ArrayList<Post>(); //different way of storing accountPosts?
    private ArrayList<Account> followers = new ArrayList<Account>();
    private ArrayList<Account> following = new ArrayList<Account>();
    
    /**
     * Initializes the accountName and descriptions instances
     * @param a
     * @param d
     * Takes in String instance a and d.
     */
    public Account(String a, String d)
    {
        accountName = a;
        description = d; 
    }
    /**
     * Copies other Account instance data and initialises them into this account instances
     * @param other
     * Takes in other Account instance
     */
    public Account(Account other){
        this.accountName = other.accountName;
        this.description = other.description;
    }
    /**
     * A get method for account name
     * @return 
     * Copy of accountName
    */
    public String getAccountName() 
    { return new String(accountName);}
    /**
     * A get method for account description
     * @return 
     * Copy of account description
    */
    public String getAccountDescription(){

        return new String(description);
    }
    /**
     * A get method for accountPosts lis
     * @return 
     * A shallow copy of this account list of Post 
    */
    public ArrayList<Post> getAccountPosts() 
    {
        return accountPosts;
    }
    /**
     * A get method for followers list
     * @return
     * A list of other accounts that follow this account
     */
    public ArrayList<Account> getAccountFollowers()
    {
        return followers;
    }
    /**
     * A get method for following list
     * @return
     * A list of other accounts that this account follows
     */
    public ArrayList<Account> getAccountFollowing()
    {
        return following;
    }
    
    /**
     * A get method for accountPosts size
     * @return 
     * Number of posts in this account
    */
    public int getNumberOfPosts()
    {
        return accountPosts.size();
    }
    /**
     * A get method for followers size
     * @return 
     * Number of this account followers 
     */
    public int getNumberOfFollowers()
    {
        return followers.size();
    }
    /**
     * A get method for following size
     * @return 
     * Number of other accounts following this account
     */
    public int getNumberOfFollowing()
    {
        return following.size();
    }
    /**
     * Adds the other account that has started to follow by this account
     * @param a
     * Takes in an Account object
     */

    void addNewFollower(Account a)
    {   
        if (!followers.contains(a))
                followers.add(a);
        else 
            System.out.println("Follower Already Exists\n");
         
    }
    /**
     * Adds the other account that has started following this account
     * @param a
     * Takes in an Account object;
     */
    void addNewFollowing(Account a)
    {   
        if (!following.contains(a))
                following.add(a);
   
        
    }
    /**
     * Prints the full description of an account including its followers and other account it follows
     */

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
     * Add a Post object into the accountPosts list if it doesn't already exist.
     * @param p
     * Takes in Post p object
     */
    public void addAccountPost(Post p)
    {
            if (!accountPosts.contains(p))
                accountPosts.add(p);
            else 
                System.out.println("Post Already Exists\n"+p);
    }

    /**
     * Recursicely prints a list of an account posts
     * 
     */
    public void listAccountPosts()
    {
       
        if (accountPosts != null )
        {   
           for (Post i: accountPosts)
           {    
                System.out.println(i);
            
           }
        }
        else 
            System.out.println("No posts for "+getAccountName());
        
    }

    
    /**
     * Checks if this account name equals the other account name in alphanumerical order
     * @param other
     * Take in an other Account instance variable
     * 
     * @return
     * The value 0 if this Account equals other Account in alphanumerical order
     * A value less than 0 if this Account is less than other Account in alphanumerical order
     * A value greater than 0 if this Account is less than other Account in alphanumerical order
     * 
     */
    @Override
    public int compareTo(Account other) 
    {
        return (this.accountName).compareTo(other.accountName);
        
    }
    /**
     * Return string representation of the Account object
     */
    @Override
    public String toString()
    {

        return getAccountName()+" "+getAccountDescription();
    }
}
