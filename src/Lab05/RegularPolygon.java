package Lab05;

/*
* Testcase
* side < 3
* length (n) <= 0
* calculation correctness
* */
public class RegularPolygon {
    private int n;
    private double side,x,y;

    public RegularPolygon(){
        this(3,1,0,0);
    }
    public RegularPolygon(int n, double side) {
        this(n,side,0,0);
    }
    public RegularPolygon(int n, double side, double x, double y) {
        this.setN(n);
        this.setSide(side);
        this.setX(x);
        this.setY(y);
    }

    public int getN() {
        return n;
    }
    public void setN(int n) {
        if(n<3){
            System.err.println("Number of a polygon side must be 3 or higher");
            return;
        }
        this.n = n;
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        if(side<=0){
            System.err.println("A polygon side length must be a positive number");
            return;
        }
        this.side = side;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter(){
        return this.getN()*this.getSide();
    }
    public double getArea(){
        double numerator = this.getN()*this.getSide()*this.getSide();
        double denominator = 4*Math.tan(Math.PI/this.getN());
        return numerator/denominator;
    }

    @Override
    public String toString() {
        return "RegularPolygon{" +
                "n=" + n +
                ", side=" + side +
                ", x=" + x +
                ", y=" + y +
                ", perimeter=" + getPerimeter() +
                ", area=" + getArea() +
                '}';
    }

    public static void main(String[] args) {
        RegularPolygon polygonA = new RegularPolygon();
        RegularPolygon polygonB = new RegularPolygon(6,4);
        RegularPolygon polygonC = new RegularPolygon(10,4,5.6,7.8);

        System.out.println(polygonA);
        System.out.println(polygonB);
        System.out.println(polygonC);
        //System.out.println(polygonA.getPerimeter() + " " + polygonA.getArea());
        //System.out.println(polygonB.getPerimeter() + " " + polygonB.getArea());
        //System.out.println(polygonC.getPerimeter() + " " + polygonC.getArea());

    }
}
