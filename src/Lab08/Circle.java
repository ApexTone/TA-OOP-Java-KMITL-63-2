package Lab08;


public class Circle extends GeometricObject{
    private double radius;

    public Circle() {
        this(1);
    }
    public Circle(double radius) {
        this(radius,false,"Black");
    }
    public Circle(double radius,boolean isFilled, String color) {
        super(isFilled, color);
        this.setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        if(radius <= 0){
            System.err.println("Radius must be positive. Set to default as 1");
            this.radius = 1;
        }
        else {
            this.radius = radius;
        }
    }
    public double getDiameter(){
        return this.radius*2;
    }

    @Override
    public double getArea() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI*2*this.radius;
    }
}
