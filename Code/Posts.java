public class Posts
{
    private String title, videoName;
    private int numberOfLikes;
    
    public Posts(String t, String v, int n)
    {

        title = t;
        videoName = v;
        numberOfLikes = n;

    }
    public String getTitle(){

        return title;
    }
    public String getVideo()
    {

        return videoName;
    }
    public int getLikes()
    {
        return numberOfLikes;
    }
    public String tostring()
    {

        return "Title: "+getTitle()+"\n"+"Video: "+getVideo()+"\n"+"Number of likes: "+getLikes();
    }
}

