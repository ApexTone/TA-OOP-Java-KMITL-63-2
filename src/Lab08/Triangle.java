package Lab08;

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
        this.setA(calculateLength(xa,ya,xb,yb));
        this.setB(calculateLength(xb,yb,xc,yc));
        this.setC(calculateLength(xc,yc,xa,ya));
    }

    private double calculateLength(double xa, double ya, double xb, double yb){
        return Math.sqrt(Math.pow(xb-xa,2)+Math.pow(yb-ya,2));
    }

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

    //Maybe add coordinate as attribute

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

    public static void main(String[] args) {
        Triangle triangle = new Triangle(0,0,0,3,4,0,false,"Black");
        System.out.println(triangle);
    }
}
