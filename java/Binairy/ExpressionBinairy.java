public class ExpressionBinairy{
    private int x;
    private int y;
    private Operator opera;

    public ExpressionBinairy(int x, int y, Operator opera){
        this.x=x;
        this.y=y;
        this.opera=opera;
    }
    public int getValues(){
        return this.opera.compute(this.x, this.y);
    }
    public String toString(){
        return Integer.toString(this.x) + this.opera.getChar()+Integer.toString(this.y);
    }

    public static void main(String[] args) {
        Operator add=new Add();
        Operator mult=new Mult();
        ExpressionBinairy binAdd=new ExpressionBinairy(1,2,add);
        System.out.println(binAdd.getValues());
        System.out.println(binAdd.toString());
        ExpressionBinairy bin=new ExpressionBinairy(6,7,mult);
        System.out.println(bin.getValues());
        System.out.println(bin.toString());


    }
}