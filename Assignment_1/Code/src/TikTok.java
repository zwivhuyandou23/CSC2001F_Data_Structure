import java.io.IOException;

public class TikTok {

    /**
     * The main Function initiates the TikTok interface
     * @param args
     */
    public static void main(String[] args)
    {

        Profile tiktok = new Profile();
        try {
            tiktok.startTikTok();

        } catch (IOException e) {
        
            e.printStackTrace();
        }
        
        
    }
    
}
