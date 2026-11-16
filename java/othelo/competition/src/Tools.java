public class Tools{

    public static boolean isPowerOf2(int n){
        if (n<= 2){
            return false;
        }
        while (n%2 == 0){
            n = n/2;
        }
        return n == 1;
    }

    
}