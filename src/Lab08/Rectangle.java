package Lab08;

public class Rectangle extends GeometricObject{
    private double height, width;

    public Rectangle() {
        this(1,1);
    }

    public Rectangle(double height, double width) {
        this(height,width,false,"Black");
    }

    public Rectangle( double height, double width,boolean isFilled, String color) {
        super(isFilled, color);
        this.setHeight(height);
        this.setWidth(width);
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        if(height <= 0){
            System.err.println("Height must be positive. Set to default as 1");
            this.height = 1;
        }
        else{
            this.height = height;
        }

    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        if(width <= 0){
            System.err.println("width  must be positive. Set to default as 1");
            this.width  = 1;
        }
        else{
            this.width  = width ;
        }
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return (width*2)+(height*2);
    }
}
