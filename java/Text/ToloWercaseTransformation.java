import java.util.Scanner;

public class ToloWercaseTransformation implements Transformation {
    
    public String transform(String input){
       
        return input. toLowerCase();
    }

     public String getDescription() {
        return "Remplace les caractères majuscules par des minuscules.";
    }

    /**public static void main(String[] args) {
        Scanner saisie =new Scanner(System.in);
        System.out.println("Entrez un mot :");
        String mot =saisie.next();
        ToloWercaseTransformation trans= new ToloWercaseTransformation();
        System.out.println("le mot transformer est : "+trans.transform(mot));
        
    }
    */

}