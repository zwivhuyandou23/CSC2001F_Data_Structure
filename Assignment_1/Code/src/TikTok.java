import java.io.IOException;

public class TikTok {

    public static void main(String[] args)
    {

        Profile tiktok = new Profile();
        try {
            tiktok.startTikTok();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
}
