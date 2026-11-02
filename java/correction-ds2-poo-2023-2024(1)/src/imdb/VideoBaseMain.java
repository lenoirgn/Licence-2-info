package imdb;

import java.util.List;

import imdb.tools.VideoCategory;

public class VideoBaseMain {
   public static void main(String[] args) {
      VideoBase base = new VideoBase();
      /* adds some videos to base */
      String id ="video007"];
      try {
         base.rateVideo(id, 3);
         System.out.println("new rating : "+base.getVideo(id).ratingsAverage());
      } catch (UnknownVideoException e) {
	  System.out.println("vidéo inconnue");
      }

      List<Video> allMovies = base.videosForCategory(VideoCategory.MOVIE);
      
   }
}
