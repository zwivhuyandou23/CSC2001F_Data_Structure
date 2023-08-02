

import java.sql.Time;
import java.util.*;
public class Converter
{

    String[] Hour = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve"};
    String[] Minutes = {"five","ten", "quarter","twenty", "twenty five","half"};
    public static void main(String[] args )
    {

        Scanner scan = new Scanner(System.in);
        String time =scan.nextLine();

        while (!time.equals("done"))
        {
            time = properTime(time);

            if (time.indexOf(":") == 1) //single hour
                {
                    Timer d;
                    d.
                }

            time =scan.nextLine();



        }
    }
    static String properTime(String time)
    {
        String digit = time.substring( time.indexOf(":")+1 );
        int intDigit = Integer.parseInt(digit);
        //System.out.println(digit);
        if (Integer.parseInt(digit) %5 != 0)
        
        { 
           String digitLast = digit.substring(1);
           System.out.println(digitLast);
            if (Integer.parseInt(digitLast)>2 &&  Integer.parseInt(digitLast)<8)

            {
                System.out.println(time);
                time = time.substring(0,time.indexOf(":")+2) + "5" ;
               System.out.println(time);
            }
            else if (Integer.parseInt(digitLast)<3)
            {
                System.out.println(time);
                time = time.substring(0,time.indexOf(":")+2) + "0" ;
             //   System.out.println(time);
            }
            else 
                {
        //        System.out.println(digit);

                digit = digit.substring(0,1);
      //  System.out.println(digit);
                int cDigit = Integer.parseInt(digit)+1;
                
                String finalDig = Integer.toString(cDigit) ; 

                time = time.substring(0,time.indexOf(":")+1) + finalDig+"0" ;
               // System.out.println(time);
                }
                
           // int dig =  Math.round(Integer.parseInt(digit));
            //System.out.println(dig);
        }

        if(Integer.parseInt(time.substring(time.indexOf(":")+1)) >59){

        int sortHour = Integer.parseInt(time.substring(0,2));
    
        sortHour++;
            time = Integer.toString(sortHour)+":00";

            //System.out.println(time.substring(time.indexOf(":")+1));
        }

        if(Integer.parseInt(time.substring(0,2)) >12)
            { 
              //  System.out.println(Integer.parseInt(time.substring(time.indexOf(":")+1)));
                time = "1"+time.substring(2);
            }


            System.out.println(time);
            return time;
      
    }

}