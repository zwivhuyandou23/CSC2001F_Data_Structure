import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {

        TikTok tiktok = new TikTok();
        try {
            tiktok.startTikTok();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
}
