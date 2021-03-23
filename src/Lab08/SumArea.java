package Lab08;
public class SumArea {
    public static double sumArea(GeometricObject[] geometricObjects){
        double sum = 0;
        for(GeometricObject geometricObject : geometricObjects){
            if(geometricObject != null){
                if(geometricObject instanceof Triangle){
                    Triangle t = (Triangle)geometricObject;
                    System.out.println("Triangle: "+ t.getA()+" "+t.getB()+" "+t.getC());

                    sum += t.getArea();
                }
                else if(geometricObject instanceof Rectangle){
                    Rectangle r = (Rectangle)geometricObject;
                    System.out.println("Rectangle: "+ r.getWidth()+" "+r.getHeight());
                    sum += r.getArea();
                }
                else if(geometricObject instanceof Circle){
                    Circle c = (Circle)geometricObject;
                    System.out.println("Circle: "+ c.getRadius());
                    sum += c.getArea();
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        GeometricObject[] list = new GeometricObject[5];
        list[0] = new Rectangle(5,5);
        list[1] = new Rectangle(7,10);
        list[2] = new Circle(2);
        list[3] = new Circle(3);
        list[4] = new Triangle(5,4,3);
        System.out.println("Sum of all area: "+sumArea(list));
    }
}
