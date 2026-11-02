package imdb.tools;

/** a class to store informations about a video : title, author, duration, etc. */
public class VideoInformation {
   public VideoInformation(VideoCategory cat/* probably some other args */) { /* do something */ }

   public String shortDescription() { return "relevant description"; };
   public VideoCategory category() { return null; }
   /* other stuff */

   public boolean equals(Object o) { return this == o; //faut de mieux ici}
}
