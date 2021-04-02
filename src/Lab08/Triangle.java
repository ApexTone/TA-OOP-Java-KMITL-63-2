package Lab08;

import java.util.Objects;

public class Triangle extends GeometricObject{
    private double a,b,c;

    public Triangle(){
        this(1,1,1);
    }
    public Triangle(double a, double b, double c){
        this(a,b,c,false, "Black");
    }

    public Triangle(double a, double b, double c,boolean isFilled, String color) {
        super(isFilled, color);
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    //Use this constructor since it can guaranteed the existence of triangle
    public Triangle(double xa, double ya, double xb,double yb, double xc,double yc,boolean isFilled, String color) {
        super(isFilled, color);
        this.setCoordinate(xa,ya,xb,yb,xc,yc);
    }

    private double calculateLength(double xa, double ya, double xb, double yb){
        return Math.sqrt(Math.pow(xb-xa,2)+Math.pow(yb-ya,2));
    }


    //TODO: Validate every sides of a triangle
    public double getA() {
        return a;
    }

    public void setA(double a) {
        if(a <= 0){
            System.err.println("Side length must be positive. Set to default as 1");
            this.a = 1;
        }
        else{
            this.a = a;
        }
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if(b <= 0){
            System.err.println("Side length must be positive. Set to default as 1");
            this.b = 1;
        }
        else {
            this.b = b;
        }
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if(c <= 0){
            System.err.println("Side length must be positive. Set to default as 1");
            this.c = 1;
        }
        else {
            this.c = c;
        }
    }

    public void setCoordinate(double xa, double ya, double xb,double yb, double xc,double yc){
        if(isSameCoordinate(xa,ya,xb,yb) || isSameCoordinate(xb,yb,xc,yc) || isSameCoordinate(xc,yc,xa,ya)){
            System.err.println("One or more coordinate is not distinct. Set all side to default length as 1.");//Prevent 0-length side
            this.setA(1);
            this.setB(1);
            this.setC(1);
            return;
        }
        this.setA(calculateLength(xa,ya,xb,yb));
        this.setB(calculateLength(xb,yb,xc,yc));
        this.setC(calculateLength(xc,yc,xa,ya));
    }
    private boolean isSameCoordinate(double xa, double ya, double xb,double yb){
        return xa==xb && ya==yb;
    }

    public static String max(Triangle t1, Triangle t2){
        if(t1.getArea() > t2.getArea()){
            return t1.toString();
        }
        if(t2.getArea() > t1.getArea()){
            return t2.toString();
        }
        return "EQUALS";
    }

    @Override
    public double getArea() {
        double s = (a+b+c)/2;
        double k2 = s*(s-a)*(s-b)*(s-c);
        return Math.sqrt(k2);
    }

    @Override
    public double getPerimeter() {
        return a+b+c;
    }

    @Override
    public String toString() {
        return super.toString()+"Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", area=" + this.getArea() +
                ", perimeter=" + this.getPerimeter()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.getArea(), this.getArea()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(0,0,0,3,4,0,false,"Black");
        System.out.println(triangle);
    }
}
