package imdb.tools;

public class IdGenerator {
   private static final String ID_LABEL="ID#";
   private static int cpt = 0;
   public static String generateUniqueId() {
      return ID_LABEL+(IdGenerator.cpt++);
   }
}
