
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        String choice;
        Scanner input = new Scanner(System.in);
        
        do 
        {
            System.out.println("Choose an action from the menu:\n1. Find the profile description for a given account\n2. List all accounts\n3. Create an account\n4. Delete an account\n5. Display all posts for a single account\n6. Add a new post for an account\n7. Load a file of actions from disk and process this\n8. Quit");
            choice =  input.nextLine();
            switch (choice)
            {

                case '1':

                break;
              
                case '2':
                    
                break;
                
                case '3':
                    
                break;
                
                case '4':
                    
                break;
                
                case '5':
                    
                break;
                
                case '6':
                    
                break;

                case '7':
                    
                break ;
                
                default:

                break
               
            }
        }
        while (!choice.equals('8'));


    }
    
}
