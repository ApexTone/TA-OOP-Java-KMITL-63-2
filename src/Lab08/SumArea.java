package Lab08;

public class SumArea {
    public static double sumArea(GeometricObject[] a){
        double sum = 0;
        for(GeometricObject geometricObject : a){
            if(geometricObject != null){
                System.out.println(geometricObject.getClass().toString()+" "+geometricObject.getArea());
                sum += geometricObject.getArea();
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
