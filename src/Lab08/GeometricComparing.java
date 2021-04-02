package Lab08;

import java.util.Scanner;

public class GeometricComparing {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true)
        {
            System.out.println("-------------------------------------------------");
            System.out.print("Menu (1=Circle, 2=Rectangle, 3=Triangle, 4=Exit) : ");
            choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    circleComparing(scanner);
                    break;
                case 2:
                    rectangleComparing(scanner);
                    break;
                case 3:
                    triangleComparing(scanner);
                    break;
                case 4:
                    System.out.println("End of program");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Not a viable choice. Please select from 1-4");
            }
        }
    }

    public static void circleComparing(Scanner scanner) {
        System.out.print("Circle c1 (name radius color): ");
        Circle c1 = new Circle();
        c1.setName(scanner.next());
        c1.setRadius(scanner.nextDouble());
        c1.setColor(scanner.next());
        System.out.print("Circle c2 (radius color weight): ");
        Circle c2 = new Circle();
        c2.setName(scanner.next());
        c2.setRadius(scanner.nextDouble());
        c2.setColor(scanner.next());

        System.out.println("Equal circle if their radii are the same: "+c1.equals(c2));
        System.out.println("The larger object using max method: "+Circle.max(c1,c2));
    }
    public static void rectangleComparing(Scanner scanner){
        System.out.print("Rectangle r1 (name width height color): ");
        Rectangle r1 = new Rectangle();
        r1.setName(scanner.next());
        r1.setWidth(scanner.nextDouble());
        r1.setHeight(scanner.nextDouble());
        r1.setColor(scanner.next());
        System.out.print("Rectangle r1 (name width height color): ");
        Rectangle r2 = new Rectangle();
        r2.setName(scanner.next());
        r2.setWidth(scanner.nextDouble());
        r2.setHeight(scanner.nextDouble());
        r2.setColor(scanner.next());

        System.out.println("Equal rectangle if their area are the same: "+r1.equals(r2));
        System.out.println("The larger object using max method: "+Rectangle.max(r1,r2));
    }
    public static void triangleComparing(Scanner scanner) {
        System.out.print("Triangle t1 (name a b c color): ");
        Triangle t1 = new Triangle();
        t1.setName(scanner.next());
        t1.setA(scanner.nextDouble());
        t1.setB(scanner.nextDouble());
        t1.setC(scanner.nextDouble());
        t1.setColor(scanner.next());
        System.out.print("Triangle t2 (name a b c color): ");
        Triangle t2 = new Triangle();
        t2.setName(scanner.next());
        t2.setA(scanner.nextDouble());
        t2.setB(scanner.nextDouble());
        t2.setC(scanner.nextDouble());
        t2.setColor(scanner.next());

        System.out.println("Equal rectangle if their area are the same: "+t1.equals(t2));
        System.out.println("The larger object using max method: "+Triangle.max(t1,t2));
    }
}
