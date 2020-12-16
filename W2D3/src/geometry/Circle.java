package geometry;

import java.awt.*;

public class Circle extends Geometry{
    public int r;

    /**
     *The circle object
     * @param pos_x the x position of the center
     * @param pos_y the y position of the center
     * @param radius the radius of the circle
     */
    public Circle(int pos_x, int pos_y, int radius){
        super(pos_x,pos_y);//부모 클래스 Geometry의 생성자를 실행
        r = radius;
    }


    @Override
    /**
     * The cover area of the circle. consider PI as 3.14
     * @return area of the circle
     */
    public double getArea(){
        return (r*r*3.14);
    }

    @Override
    public boolean isIn(int pos_x, int pos_y){
        int dx = this.x - pos_x;
        int dy = this.y - pos_y;
        return ((dx*dx+dy*dy)<=(this.r*this.r));
    }

    public boolean overlappedwithCircle(Circle circle){
        int dx = this.x - circle.x;
        int dy = this.y - circle.y;
        return ((this.r+ circle.r)*(this.r+circle.r)<=(dx*dx+dy*dy));
    }

    @Override
    public boolean overlappedWith(Geometry geo){
        if(geo instanceof Circle){
            return this.overlappedwithCircle((Circle) geo);
        }
        else if(geo instanceof Rect){
            return ((Rect)geo).overlappedWith(this);
        }
        return false;
    }
}
