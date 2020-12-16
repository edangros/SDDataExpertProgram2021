package geometry;

public class Rect extends Geometry{
    private int w,h; //getter setter 아직 안씀...

    /**
     * Generate Rectangle with given position and size
     * @param pos_x x position of the rectangle
     * @param pos_y y position of the rectangle
     * @param width width of the rectangle
     * @param height height of the rectangle
     */
    public Rect(int pos_x, int pos_y, int width, int height){
        super(pos_x,pos_y);
        w = width;
        h = height;
    }

    /**
     * The cover area of the rectangle
     * @return area of the rectangle
     */
    @Override
    public double getArea(){
        return w*h;
    }

    @Override
    public boolean isIn(int pos_x, int pos_y) {
        return ((pos_x>=this.x)^(pos_x>=(this.x+this.w))&&((pos_y>=this.y))^(pos_y>=(this.y+this.h)));
    }

    /**
     * AABB collision test for the two rectangle
     * @param rectangle another rectangle to check if overlapped
     * @return if the two rectangles are overlapped each other, return true. If not, return false.
     */
    private boolean overlappedWithRect(Rect rectangle){
        //네 꼭지점 찾기
        int[] ex = new int[4];
        int[] ey = new int[4];
        ex[0] = ex[1] = rectangle.x;
        ex[2] = ex[3] = rectangle.x+rectangle.w;
        ey[0] = ey[2] = rectangle.y;
        ey[1] = ey[3] = rectangle.y+rectangle.h;
        //네 꼭짓점 중 하나만 안에 있어도 ok.
        for(int i=0;i<4;i++){
            if(this.isIn(ex[i],ey[i])){return true;}
        }
        return false;
    }

    /**
     * collision test for the rectangle and circle
     * @param circle a circle to check if overlapped
     * @return if the rectangle and circle overlapped each other, return true. If not, return false.
     */
    private boolean overlappedWithCircle(Circle circle){
        //원과의 충돌도 비슷.
        //네 꼭짓점 중 하나만 원 안에 있으면 ok.
        //네 꼭지점 찾기
        int[] ex = new int[4];
        int[] ey = new int[4];
        ex[0] = ex[1] = this.x;
        ex[2] = ex[3] = this.x+this.w;
        ey[0] = ey[2] = this.y;
        ey[1] = ey[3] = this.y+this.h;
        for(int i=0;i<4;i++){
            if(circle.isIn(ex[i],ey[i])){return true;}
        }
        return false;
    }

    @Override
    //충돌판정 상대방에 따라 필요한 충돌함수를 실행
    public boolean overlappedWith(Geometry geo){
        if(geo instanceof Circle){ //geo가 Circle의 인스턴스인가?
            return this.overlappedWithCircle((Circle) geo);
        }
        else if(geo instanceof Rect){
            return this.overlappedWithRect((Rect) geo);
        }
        return false;
    }

}
