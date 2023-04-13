

public class Account implements Comparable<Account>
{

    private String accountName, description;
    private int count = 1; //keeps count of no. of Posts objects in the accountPosts array
    private Posts[] accountPosts = new Posts[1000]; //different way of storing accountPosts?
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
        return count-1;
    }
    /**
     * recursicely prints out list of account posts
     * @param start
     * @param stop
     */
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
                count++;
            }
            else if(accountPosts[index] == null)
            {
                accountPosts[index] = p;
                count++;
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

    void addNewFollower(Account a)
    {   
        addNewFollower(a,0);
    }
    void addNewFollower(Account a,int index)
    {

        if (followers == null)
        {
            followers[index] = a;
            count++;
        }
        else if(followers[index] == null)
        {
            followers[index] = a;
            count++;
        }
        else
        {
            index++;
            addNewFollower(a, index);
        }
    

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

