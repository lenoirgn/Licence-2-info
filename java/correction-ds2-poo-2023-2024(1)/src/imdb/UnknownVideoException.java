package imdb;

public class UnknownVideoException extends Exception {
   public UnknownVideoException(String id) {
      super("unknown video Id "+id);
   }
}
