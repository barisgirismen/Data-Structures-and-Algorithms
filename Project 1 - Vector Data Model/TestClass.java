package project1;

import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author 19COMP1024 Barış Girişmen & 19COMP1030 Emir Aksakal
 */
public class TestClass {

    public static void main(String[] args) throws Exception {
        int x, y;
        int o1 = 1;
        int o2 = 1;
        int o3 = 1;
        String answer;
        Point point1, point2;
        Polygon poly1;
        int count = 0;
        Stack < Polygon > array = new Stack < > ();

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("");
        System.out.println("In this application, you can do various actions such as creating a polygon, calculating the distance between two points etc.");
        System.out.println("First, you need to have at least one point (X, Y).");
        System.out.println("");
        System.out.println("Please enter the coordinates of your first point below. Then, options will appear:");
        System.out.print("Enter the X value of (X, Y): ");
        x = input.nextInt();
        System.out.print("Enter the Y value of (" + x + ", Y): ");
        y = input.nextInt();
        point1 = new Point(x, y);
        System.out.println("Your first point is: " + point1.toString());

        while (true) {
            System.out.println("");
            System.out.println("The following options are available for you:");
            System.out.println("  1. Create a polygon");
            System.out.println("  2. Add a new point");
            System.out.println("  3. Remove a point");
            System.out.println("  4. Calculate distance to other points");
            System.out.println("  5. Print amount of your points and their coordinates");
            System.out.println("  6. Reverse the points in your polygon");
            System.out.println("  7. Close your polygon");
            System.out.println("  8. Calculate the total length of your polygon");
            System.out.println("  9. Calculate the area of your polygon");
            System.out.println("  10. Concatenate with another polygon");
            System.out.println("  11. Exit");
            System.out.println("");
            System.out.print("Your choice: ");
            int options = input.nextInt();

            switch (options) {
                /*case 1:
                    System.out.println("1: selected point\n" +
                            "2: new point\n" +
                            "3: stack of points\n" +
                            "4: queue of points");
                    o2 = input.nextInt();
                    if (o2 == 1){
                        poly1 = new Polygon(point1);
                        array.push(point1);
                    }else if (o2 == 2){
                        System.out.println("x: ");
                        x = input.nextInt();
                        System.out.println("y: ");
                        y = input.nextInt();
                        point1 = new Point(x, y);
                        System.out.println("Point created:  " + point1.toString());
                        poly1 = new Polygon(point1);
                        array.push(point1);
                    }else if (o2 == 3){

                    }else if (o2 == 4){

                    }else{
                        System.out.println("Invalid input!");
                    }

                    break;*/
                    
                case 2:
                    System.out.println("Enter x value: ");
                    x = input.nextInt();
                    System.out.println("Enter y value: ");
                    y = input.nextInt();
                    point1 = new Point(x, y);
                    System.out.println("New point: " + point1.toString());
                    System.out.println("");
                    break;
                    
                case 3:
                    System.out.println("Enter point to be removed: ");
                    o2 = input.nextInt();
                    if (array.elementAt(o2 - 1) == null){
                        System.out.println("Empty!");
                        break;
                    }
                    array.elementAt(o2 - 1).removeLastPoint();
                   
                    System.out.println("");
                    break;
                    
                case 4:
                    System.out.println("enter the first point:");
                    System.out.print("x: ");
                    x = input.nextInt();
                    System.out.print("y: ");
                    y = input.nextInt();
                    point1 = new Point(x, y);

                    System.out.println("enter the second point: ");
                    System.out.print("x: ");
                    x = input.nextInt();
                    System.out.print("y: ");
                    y = input.nextInt();
                    point2 = new Point(x, y);
                    System.out.println("Distance between " + point1.toString() + " and " + point2.toString() + " is: " + Point.distance(point1, point2));

                    break;
                    
                case 5:
                    System.out.println("Enter polygon number to learn its size: ");
                    o2 = input.nextInt();
                    if (array.elementAt(o2 - 1) == null){
                        System.out.println("Empty!");
                        break;
                    }
                    System.out.println("Size: " + array.elementAt(o2 - 1).size);
                    
                    System.out.println("Enter polygon number to learn its points: ");
                    o2 = input.nextInt();
                    if (array.elementAt(o2 - 1) == null){
                        System.out.println("Empty!");
                        break;
                    }
                    System.out.println(array.elementAt(o2 - 1).pointStack.toString());
                
                    System.out.println("");
                    break;
                    
                case 6:
                    System.out.println("Enter polygon number to reverse: ");
                    o2 = input.nextInt();
                    if (array.elementAt(o2 - 1) == null){
                        System.out.println("Null place!");
                        break;
                    }
                    array.elementAt(o2 - 1).reverse();
                    break;
                case 7:
                    System.out.print("Enter the polygon you want to close: ");
                    o2 = input.nextInt();
                    if (!array.contains(o2))
                        System.out.println("Wrong polygon entered");
                    array.elementAt(o2).close();
                    break;
                case 8:
                    System.out.print("Enter the polygon whose total length you want to know: ");
                    o2 = input.nextInt();
                    if (!array.contains(o2))
                        System.out.println("Wrong polygon entered");
                    System.out.println("Total length is " + array.elementAt(o2).calculateTotalLength());
                    break;
                case 9:
                    System.out.print("Enter the polygon whose area you want to know: ");
                    o2 = input.nextInt();
                    if (!array.contains(o2))
                        System.out.println("Wrong polygon entered");
                    System.out.println("Area: " + array.elementAt(o2).area());
                    break;
                case 10:
                    System.out.print("Which polygon do you want to concatenate?");
                    o2 = input.nextInt();
                    if (!array.contains(o2))
                        System.out.println("Wrong polygon entered");
                    System.out.println("And for the another polygon? ");
                    int opt3 = input.nextInt();
                    if (!array.contains(o2))
                        System.out.println("Wrong polygon entered");
                    else if (o2 == o3)
                        System.out.println("You need to select different!");
                    array.elementAt(o2).concatenate(array.elementAt(opt3));
                    break;
                case 11:
                    System.out.println("Bye");
                    System.exit(0);
            }
        }
    }
}