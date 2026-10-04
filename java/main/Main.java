public class Main {

    public static void main(String[] args) {
        String name;
        int age;
        char grade;

        name = "John Doe";
        age = 20;
        grade = 'A';

        System.out.println("Name: " + name);
        System.out.println("Age: " + (age + 1));
        System.out.println("Grade: " + grade);

        // 1
        {
            int x = 10;
            int y = 20;
            x = y + 5;
            y = y / 2;
        }

        // 2
        {
            String s1 = "ville";
            String s2 = "il";
            boolean contient;

            if (s1.contains(s2)) {
                contient = true;
            } else {
                contient = false;
            }
        }

        // 3-1
        {
            int x = 10;
            int y = 20;
            int max;

            if (x > y) {
                max = x;
            } else {
                max = y;
            }
        }

        // 3-2
        {
            int x = 10;
            int y = 20;
            int z = 15;
            int max;

            if (x > y && x > z) {
                max = x;
            } else if (y > z) {
                max = y;
            } else {
                max = z;
            }
        }

        
        boolean n = estPremier(16);
        System.out.println("est premier " + n);
        int comp=nb_occurence("mamadou", 'm');
        System.out.println("le nombre occurence est " + comp);
        int[] tab = {1, 4, 5, 0};
        int min = min(tab);
        System.out.println("Le min est : " + min);
        int index=index(new char[]{'a', 'b', 'c', 'd','c'}, 'c');
        System.out.println("L'index est : " + index);
        int entete=entete(new int[]{1, 2, 3,10, 5});
        System.out.println("L'entete est : " + entete);
        int sequence=sequencePos(new int[]{1, -2, 3,-10, 5, -1, 2, 3});
        System.out.println("La sequence est : " + sequence);
        int produit=produit(new int[][]{{1, 2}, {3, 4}});
        System.out.println("Le produit est : " + produit);
        /** int[] tab = tableau(10);
        System.out.println("Le tableau est :");
        for (int i = 0; i < tab.length; i++) {
        System.out.println(tab[i]);
        } */
    }
    // 5
    public static boolean estPremier(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    // 7
    public static int[] tableau(int n) {
        int [] tab= new int [n];
        for (int i=0; i<n;i++ ){
            tab[i]=i+1;
        }
        return tab;
    } 
    // 6
     public static int nb_occurence(String s, char c){
        int comp=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==c){
                comp++;
            }
        }
        return comp;

     } 
     // 8
    public static int min (int[] tab){
       int  min=tab[0];
       for (int i=1;i<tab.length;i++){
        if (tab[i]<min){
            min=tab[i];
        }

       }
       return min;

    }
    // 9
    public static int index(char [] tab, char c){
        int index=-1;
        for (int i=0;i<tab.length;i++){
            if (tab[i]==c){
                index=i;
                break;
            }
        }
        return index;
    }
    // 11
    public static int entete(int[] tab){
        int entete=0;
        for (int i=0;i<tab.length;i++){
            if (tab[i]>0){
                entete++;
        }else{
            break;
        }
        }
        return entete;
        
    }
    //12
    public static int sequencePos(int[] tab){
        int count=0;
        int max=0;
        for (int i=0;i<tab.length;i++){
            if (tab[i]>0){
                count++;
            }else{
                if (count>max){
                    max=count;
                }
                count=0;
               
            }
        }
        if (count>max){
            max=count;
        }
        return max;
    }
    // 13
    public static int produit(int [][] tab){
        int result=1;
        for (int i=0;i<tab.length;i++){
            for (int j=0;j<tab[i].length;j++){
                result=result*tab[i][j];
            }
        }
        return result;
    }

}        
    

