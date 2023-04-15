

public class Account implements Comparable<Account>
{

    private String accountName, description;
    private int postCount = 1; //keeps postCount of no. of Posts objects in the accountPosts array
    private int followerCount = 1;
    private int followingCount = 1;
    private Posts[] accountPosts = new Posts[100]; //different way of storing accountPosts?
    private Account[] followers = new Account[1_000];
    private Account[] following = new Account[1_000];
    
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
    {

        return new String(accountName);
    }
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
    public Posts[] getAccountPosts() 
    {
        return accountPosts.clone();
    }
    /**
     * 
     * @return 
     * returns number of posts in an account
    */
    public int getNumberOfPosts()
    {
        return postCount-1;
    }
    public int getNumberOfFollowers()
    {
        return followerCount-1;
    }
    void addNewFollower(Account a)
    {   
        addNewFollower(a,0);
    }
    void addNewFollower(Account a,int index)
    {
        followers[followerCount-1] = a;
        followerCount++; 
 
    }
    void addNewFollowing(Account a)
    {   
        addNewFollowing(a,0);
    }
    void addNewFollowing(Account a,int index)
    {
        
        following[followingCount-1] = a;
        followingCount++;
   
    }
    public void fullDescription() 
    {   
        
        System.out.println("The profile description is: "+toString()+"\nFollowers: "+ getNumberOfFollowers());
        fullDescription(0, followers.length-1);

    }
    public void fullDescription(int start, int stop)   
    {   
        
        if (followers != null)
        {
            while (followers[start] !=null)
            { 
                System.out.println(followers[start]);
                start++;
            }
        }
    }
    /**
     * recursicely prints out list of account posts
     * @param start
     * @param stop
     */
    public void listAccountPosts()
    {
        listAccountPosts(0, followerCount-1);
    }
    public void listAccountPosts(int start, int stop)
    {   
        if (accountPosts != null)
        {
            
            if (accountPosts[start] == null)  
                {
                System.out.println("Total Number of posts: "+ getNumberOfPosts()+"\n");
                return; 
                }                 
            else
            {
                System.out.println (accountPosts[start]);
                listAccountPosts (start+1, stop);
            }


        }
        else 
        {
            System.out.println("No posts for "+getAccountName());
        }
    }

    /**
     * 
     * @param p
     */
    public void addAccountPost(Posts p)
    {
        
       addAccountPost(p,0);

    }
    /**
     * insert account post into accountPosts array
     * @param p
     * @param index
     */
    public void addAccountPost(Posts p, int index)
    {
        
        if (postExists(p))
            System.out.println("Post: \n"+ p+"exists!!!");
        else
        {
            if (accountPosts == null)
            {
                accountPosts[index] = p;
                postCount++;
            }
            else if(accountPosts[index] == null)
            {
                accountPosts[index] = p;
                postCount++;
            }
            else
            {
                index++;
                addAccountPost(p, index);
            }
        }
        

    }

    /**
     * checks if an account post already exists of the same title
     * @param p
     * @return
     */
    public boolean postExists(Posts p)
    {
        return postExists(p, 0);
    }
    private boolean postExists(Posts p, int index)
    {
        boolean a = false;
        if ((getNumberOfPosts()>1)  )
        {   
            if (accountPosts[index] == null)
                return false;    
            else if (p.getTitle().equals(accountPosts[index].getTitle()))
            {
                a  = true;
                return a;
            }
            
            else
            {   index++;
                postExists(p, index);
            }
        }
        else
            a = false;
        
        return a;
    }

    
    

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

