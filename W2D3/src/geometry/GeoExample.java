package geometry;

public class GeoExample {
    public static void main(String[] args){
        Rect rec1 = new Rect(0,0,3,5);
        Rect rec2 = new Rect(1,3,1,5);//rec1과 겹치는 사각형
        Rect rec3 = new Rect(4,4,2,2);//rec1과 겹치지 않는 사각형
        Circle cir1 = new Circle(4,4,2);//rec1과 겹치는 원
        Circle cir2 = new Circle(5,5,1);//rec1과 겹치지 않는 원
        System.out.println(rec1.overlappedWith(rec2));
        System.out.println(rec1.overlappedWith(rec3));
        System.out.println(rec1.overlappedWith(cir1));
        System.out.println(cir1.overlappedWith(rec1));
        System.out.println(rec1.overlappedWith(cir2));
        System.out.println(rec1.overlappedWith(rec1));
    }
}
