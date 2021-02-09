package Lab05;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int choice;
        int n,side,x,y;
        menu: while(true){
            System.out.println("Pick a number:\n" +
                    "1) for No-args constructor\n" +
                    "2) for n, side constructor\n" +
                    "3) for n, side, x, y constructor\n" +
                    "others to quit");
            choice = scanner.nextInt();
            switch (choice){
                case 1: {
                    RegularPolygon polygon = new RegularPolygon();
                    System.out.println(polygon.getPerimeter() + " " + polygon.getArea());
                    break;
                }
                case 2: {
                    n=scanner.nextInt();
                    side=scanner.nextInt();
                    RegularPolygon polygon = new RegularPolygon(n,side);
                    System.out.println(polygon.getPerimeter() + " " + polygon.getArea());
                    break;
                }
                case 3: {
                    n=scanner.nextInt();
                    side=scanner.nextInt();
                    x=scanner.nextInt();
                    y=scanner.nextInt();
                    RegularPolygon polygon = new RegularPolygon(n,side,x,y);
                    System.out.println(polygon.getPerimeter() + " " + polygon.getArea());
                    break;
                }
                default: break menu;
            }
            scanner.close();
        }

    }
}
