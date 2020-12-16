package geometry;

public class Geometry {
    public int x, y;
    public Geometry(int pos_x, int pos_y){
        x = pos_x;
        y = pos_y;
    }

    /**
     * Calculate the area of the geometry
     * @return the area of the geometry
     */
    public double getArea(){
        return 0;
    }

    /**
     * move the object
     * @param dx x offset
     * @param dy y offset
     */
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    //정적 메서드 isOverlapped
    public static boolean isOverlapped(Geometry geo1, Geometry geo2){
        return geo1.overlappedWith(geo2);
    }

    /**
     * check the object is overlapped with other geometry
     * @param geo the another geometry to check overlapping
     * @return if the object is overlapped with another, return true. If not, return false
     */
    public boolean overlappedWith(Geometry geo) {
        return false;
        //충돌 판정은 여기서는 따로 구현 안함(자식개체에서 구현)
    }

    public boolean isIn(int pos_x, int pos_y){
        return false;
    }
}
