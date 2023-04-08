import java.util.ArrayList;

public class Account implements Comparable<Account>
{

    public String accountName, description;
    private int count = 1; //keeps count of no. of Posts objects in the accountPosts array
    private ArrayList<Posts> accountPosts = new ArrayList<Posts>() ;// create this type
    private ArrayList<String> listOfTitles = new ArrayList<String>();
    
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
    public ArrayList<Posts> getAccountPosts() 
    {
        return accountPosts;
    }
    
    public int getNumberOfPosts()
    {
        return count;
    }
    public void listAccountPosts()
    {   
        if (accountPosts != null)
        {
            for (Posts i : accountPosts)
            {
                System.out.println(i);
            }

        }
        else 
        {
            System.out.println("Does Not Exist!!!");
        }
    }
    public void addAccountName(String name){
        accountName = name;

    }
    public void addAccountPost(Posts p){
        
        if ((!accountPosts.contains(p)) && (!listOfTitles.contains(p.getTitle()) ))
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

