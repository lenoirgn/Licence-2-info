package imdb;

import java.util.*;

import imdb.tools.VideoCategory;

public class VideoBase {
   
   private Map<String, Video> videos;

   public VideoBase() {
      this.videos = new HashMap<>();
   }

   public void addVideo(Video video) {
      this.videos.put(video.getId(), video);
   }

   public void removeVideo(String id) {
      this.videos.remove(id);
   }

   public Video getVideo(String id) {
      return this.videos.get(id);
   }

   public void viewVideo(String id) throws UnknownVideoException {
      if (! this.videos.containsKey(id)) {
         throw new UnknownVideoException(id);
      }
      this.getVideo(id).incrementViews();
   }
   /**
    * add a new rating to video with given Id, 
    * @param id the id of the rated video
    * @param rating the rating
    * @exception UnknownVideoException if there is no known video with given id
    */
   public void rateVideo(String id, int rating) throws UnknownVideoException {
      if (! this.videos.containsKey(id)) {
         throw new UnknownVideoException(id);
      }
      this.getVideo(id).newRating(rating);
   }

   public Video bestRatedVideo() {
      float topRating = 0;
      Video topVideo = null;
      for(Video video : this.videos.values()) {
         float rating = video.ratingsAverage();
         if (video.ratingsAverage() > topRating) {
            topRating = rating;
            topVideo = video;
         }
      }
      return topVideo;
   }

   public void displayBase() {
      for(String id : this.videos.keySet()) {   // ou avec values()
         Video video = this.getVideo(id);
         System.out.println(video.getInfo().shortDescription()+" : "+video.ratingsAverage()+"/"+video.nbRatings());
      }
   }

   public List<Video> videosForCategory(VideoCategory category) {
      List<Video> result = new ArrayList<>();
      for (Video video : this.videos.values()) {
         if (video.getInfo().category() == category) {
            result.add(video);
         }
      }
      return result;
   }

   public Map<VideoCategory, List<Video>> videosByCategory() {
      Map<VideoCategory, List<Video>> result = new HashMap<>();
      for (VideoCategory category : VideoCategory.values()) {
         result.put(category, this.videosForCategory(category));
      }
      return result;
   }


}
