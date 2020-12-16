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
        super(pos_x,pos_y);
        r = radius;
    }


    /**
     * The cover area of the circle. consider PI as 3.14
     * @return area of the circle
     */
    public double getArea(){
        return (r*r*3.14);
    }

    public boolean overlappedwithCircle(Circle circle){
        int dx = this.x - circle.x;
        int dy = this.y - circle.y;
        return ((this.r+ circle.r)*(this.r+circle.r)<=(dx*dx+dy*dy));
    }

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
