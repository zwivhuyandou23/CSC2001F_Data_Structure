public class Posts
{
    private String title, videoName, numberOfLikes;
    
    public Posts(String t, String v, String n)
    {

        title = t;
        videoName = v;
        numberOfLikes = n;

    }
    public String getTitle(){

        return new String(title);
    }
    public String getVideo()
    {

        return new String(videoName);
    }
    public String getLikes()
    {
        return new String(numberOfLikes);
    }
    public String toString()
    {

        return "Title: "+getTitle()+"\n"+"Video: "+getVideo()+"\n"+"Number of likes: "+getLikes()+"\n";
    }
}

