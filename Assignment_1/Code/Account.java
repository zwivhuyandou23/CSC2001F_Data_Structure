import java.util.ArrayList;

public class Account implements Comparable<Account>
{

    public String accountName, description;
    private int count = 1; //keeps count of no. of Posts objects in the accountPosts array
    private ArrayList<Posts> accountPosts = new ArrayList<Posts>() ;// create this type
    
    public Account(String a, String d){
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
    
    public int getNumberOfPosts()
    {
        return count;
    }
    public void listAccountPosts()
    {
        for (Posts i : accountPosts)
        {
            System.out.println(i);
        }
    }
    public void addAccountName(String name){
        accountName = name;

    }
    public void addAccountPost(Posts p){
        
        if (p != null)
        {
            accountPosts.add(p);
            count++;
            
        }


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

