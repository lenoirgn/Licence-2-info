package imdb;

import java.util.*;
import imdb.tools.IdGenerator;
import imdb.tools.VideoInformation;

/**
 * a class to model videos and their ratings. Videos have a unique id.
 */
public class Video {

   private String id;
   private VideoInformation info;
   private int views;
   private List<Integer> ratings;

   public Video(VideoInformation information) {
      this.info = information;
      this.id = IdGenerator.generateUniqueId();
      this.views = 0;
      this.ratings = new ArrayList<>();
   }
   
   public void incrementViews() {
      this.views = this.views + 1;
   }
   public void newRating(int rating) {
      this.ratings.add(rating);
   }

   public float ratingsAverage()  {
      if (this.ratings.isEmpty()) {
         return 0;
      }
      int sum = 0;
      for(int rating : this.ratings) {
         sum = sum + rating;
      }
      return sum / this.nbRatings();
   }
   
   /* ou pour ne pas itérer à chaque accès à la moyenne : 
   ajouter un attribut average et utiliser nbRatings pour une mise à jour à chaque newRating(rating) en ayant :
   public void newRating(int rating) {
      float global = this.average * this.nbRatings();
      this.ratings.add(rating);
      this.average = (global + rating) / this.nbRatings();
   }
   */ 

   public int nbRatings() {
      return this.ratings.size();
   }

   public String getId() {
      return this.id;
   }
  
   public int getViews() {
      return views;
   }

   public List<Integer> getRatings() {
      return ratings;
   }

   public VideoInformation getInfo() {
      return this.info;
   }

   public boolean equals(Object o) { 
      if (! (o instanceof Video))
         return false;
      Video other = (Video) o;
      return this.id.equals(other.id);
   }
}