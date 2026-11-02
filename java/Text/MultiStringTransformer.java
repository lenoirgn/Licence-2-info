
import java.util.Arrays;

public class MultiStringTransformer{
    public String [] multiformer(String [] tableau,Transformation trans){
        String [] res= new String[tableau.length];
        for(int i=0;i<tableau.length;i++){
            res[i]=trans.transform(tableau[i]);   
        }
     return res;
    }
    public static void main(String [] args){
        String[] data = new String[] { "Timoleon", "jaVa", "JRR Tolkien" };
        MultiStringTransformer multi= new MultiStringTransformer();
        ToloWercaseTransformation transformation = new ToloWercaseTransformation();
        String[] res = multi.multiformer(data, transformation);
        System.out.println(Arrays.toString(res));
    }
}