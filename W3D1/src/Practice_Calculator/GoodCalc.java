package Practice_Calculator;

public class GoodCalc extends Calculator{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }

    @Override
    public double average(int[] a) {
        double res = 0.0;
        for (int i = 0;i< a.length;i++){
            res += a[i];
        }
        return res/a.length;
    }

    public static void main(String[] args){
        Calculator c= new GoodCalc();
        System.out.println("2+3="+c.add(2,3));
        System.out.println("2-3="+c.subtract(2,3));
        System.out.println("ava(2,3,4)="+c.average(new int[] {2,3,4}));
    }
}
