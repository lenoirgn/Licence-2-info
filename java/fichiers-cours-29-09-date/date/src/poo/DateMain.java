package poo;

import poo.tools.Month;

/** main to experiment Date class */
public class DateMain {

   /** default value for nbDaysAfter arg */
   private static int DEFAULT_VALUE = 100;

    public static void main(String[] args) throws Exception {

      Date d = new Date(31, Month.march, 2015);
      Date dd = new Date(31, Month.december, 2015);

      System.out.println("---------tomorrow-------------");

      System.out.println("tomorrow for " + d + " -> " + d.tomorrow());
      System.out.println("tomorrow for " + dd + " -> " + dd.tomorrow());
      Date d1 = new Date(30 , Month.september, 2024);
      System.out.println("tomorrow de " + d1 + " -> " + d1.tomorrow());

      System.out.println("---------nbDaysAfter-------------");

      int nbDays = DateMain.handleNbDaysValueFromArgs(args);

      try {
         Date dateAfter = d1.nbDaysAfter(nbDays);
         System.out.println("date "+nbDays+" days after "+ d1+" = "+dateAfter);
      }
      catch (IllegalArgumentException e) {
         System.out.println("/!\\ argument cannot be negative");
      }
   }

   private static void usage() {
      System.out.println(" ** NB : You can give a positive int as argument.");
      System.out.println(" ** e.g. : java -classpath classes date.DateMain 5");
      System.out.println(" ** If no value is provided then " + DateMain.DEFAULT_VALUE + " is used");
   }

   /**
    * @param args the command line args
    * @return the value that must be used for nbDaysAfter, default value if no arg provided or arg is not an int
    */
   private static int handleNbDaysValueFromArgs(String[] args) {
      int value = DEFAULT_VALUE;
      if (args.length < 1) {
         DateMain.usage();
      } else {
         try {
            value = Integer.parseInt(args[0]);
         } catch (Exception e) {
            DateMain.usage();
         }
      }
      return value;
   }

}
