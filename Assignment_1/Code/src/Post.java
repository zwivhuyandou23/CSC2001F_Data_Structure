public class Post
{
    private String title, videoName, numberOfLikes;
    /**
     * Initializes the title , videoName, numberOfLikes instance variables
     * @param t
     * Takes in a String instance
     * @param v
     * Takes in a String instance
     * @param n
     * Takes in a String instance
     */
    public Post(String t, String v, String n)
    {

        title = t;
        videoName = v;
        numberOfLikes = n;

    }
    /**
     *  get method for title
     * @return
     * String value of title
     */
    public String getTitle(){

        return new String(title);
    }
    /**
     * get method for videoName
     * @return
     * String value of videoName
     */
    public String getVideo()
    {   


        return new String(videoName);
    }
    
    /**
     * get method for number of likes
     * @return
     * String value of numberOfLikes
     */
    public String getLikes()
    {
        return new String(numberOfLikes);
    }
    /**
     * Return string representation of the Post object
     */
    @Override
    public String toString()
    {

        return "Title: "+getTitle()+"\n"+"Video: "+getVideo()+"\n"+"Number of likes: "+getLikes()+"\n";
    }
}

