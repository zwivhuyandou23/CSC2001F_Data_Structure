import java.util.ArrayList;

public class Account implements Comparable<Account>
{

    public String accountName, description;
    private int count = 1; //keeps count of no. of Posts objects in the accountPosts array
    private Posts[] accountPosts = new Posts[100]; //different way of storing accountPosts?
    
    
    public Account(String a, String d)
    {
        accountName = a;
        description = d;
        
    }
    public Account(Account d){
        this.accountName = d.accountName;
        this.description = d.description;

    }
    public String getAccountName() // for choice 2
    {

        return accountName;
    }
    public String getAccountDescription(){

        return description;
    }
    public Posts[] getAccountPosts() 
    {
        return accountPosts;
    }
    
    public int getNumberOfPosts()
    {
        return count-1;
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
    public void addAccountName(String name){
        accountName = name;

    }
    public void addAccountPost(Posts p)
    {
        
       addAccountPost(p,0);

    }
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
            else if (p.getTitle().compareTo(accountPosts[index].getTitle()) == 0)
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
    
    // this function return 1 if the calling object is greater than the argument object
    // this function return 0 if the calling object is less or equal the argument object
    // uses the getNumberOfPosts functions to see how many posts an account has and

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

