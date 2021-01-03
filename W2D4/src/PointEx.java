class Point {
    private int x,y;//좌표 변수 선언 -> 밖에선 안보이게 할거야

    public void set(int x, int y){
        this.x = x; this.y = y;
    }

    public void showPoint(){
        System.out.println("("+x+","+y+")");
    }
}

class ColorPoint extends Point{
    private String color;
    public void setColor(String color){
        this.color = color;
    }
    public void showColorPoint(){
        System.out.print(color+" at ");
        showPoint();
    }
}

public class PointEx{
    public static void main(String[] args){
        Point p = new Point();
        p.set(1,2);
        p.showPoint();

        p = new ColorPoint();//이렇게 집어넣을 수 있음!(다형성)
        p.set(3,4);
        p.showPoint();

        ColorPoint cp = new ColorPoint();
        cp.set(3,4);
        cp.setColor("Blue");
        cp.showColorPoint();
    }
}