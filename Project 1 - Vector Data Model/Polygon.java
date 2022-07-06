package project1;

import java.util.Arrays;
import java.util.Stack;
import static project1.Point.distance;
/**
 *
 * @author 19COMP1024 Barış Girişmen & 19COMP1030 Emir Aksakal
 */
public class Polygon {
    Point first;
    Point last;
    int size;
    Point array[];
    boolean isClosed;
    Stack <Point> pointStack;

    public Polygon(int x, int y) { //nokta ile oluşturur
        Point newPoint = new Point(x, y);
        this.first = newPoint;
        this.last = newPoint;
        this.size = 1;
        this.isClosed = false;
    }
    
    Polygon(Point p1) {
        this.first = p1;
        this.last = null;
        this.size = 1;
        pointStack = new Stack < > ();
        pointStack.push(p1);
    }

    //bir tane daha polygon constructor olacak

    boolean isEmpty() {
        return this.size == 0;
    }
    public void close() {
        this.isClosed = true;
    }
    int numOfPoints() {
        return this.size;
    }

    void addPoint(int x, int y) {

        if (isClosed == true) {

            System.out.println("Error: Cannot add a new point because the polygon is closed!");

        } else {

            Point p1 = new Point(x, y);
            if (p1.equals(this.first)) {
                System.out.println("Polygon is closed.");
                this.isClosed = true;
                return;
            }
            if (isEmpty()) {
                this.first = p1;
                this.last = p1;
            } else {
                this.last.next = p1;
                this.last = p1;
            }
            this.size++;
            pointStack.push(p1);
        }
    }

    Point removeLastPoint() {
        if (isEmpty()) {
            return null;
        }

        //alttaki pdf'te yazmıyor
        if (this.isClosed) return null;

        Point tmp;
        Point secondLast = this.first;

        while (secondLast.next.next != null) {
            secondLast.next = secondLast.next.next;
        }
        tmp = secondLast.next;
        secondLast.next = null;
        this.last = secondLast;
        this.size--;
        pointStack.pop();
        return tmp; //silineni gösterir
    }

    void reverse() {
        if(pointStack.size() > 0) {
            Point point2 = pointStack.peek();
            pointStack.pop();
            reverse();
            insertAtBottom(point2);
        }
    }
    
    void insertAtBottom(Point point1) {
    if(pointStack.isEmpty()){
        pointStack.push(point1);
    } else {
        Point a = pointStack.peek();
        pointStack.pop();
        insertAtBottom(point1);
        pointStack.push(a);
    }
    }
    
    /*public void printStack(int num) {
        System.out.print(num + ". Polygon: ");
        String s = Arrays.toString(pointStack.toArray());
        System.out.println(s);
    }*/
    
    /*String printArray() {
        Point array[] = new Point[this.size];
        Point currPoint = this.first;
        String str = "[";
        for (int i = 0; i < this.size; i++) {
            array[i] = currPoint;
            currPoint = currPoint.next;
            // bir nokta silip print edersen hata veriyor
            str = str + array[i].toString() + ", ";
        }
        return str + "]";
    }*/

    public double calculateTotalLength() {
        double result = 0;
        Point currPoint = this.first;
        for (int i = 0; i < this.size - 1; i++) {
            result += distance(currPoint, currPoint.next);
            if (i != this.size - 2) {
                currPoint = currPoint.next;
            }
        }
        if (this.isClosed) {
            result += distance(this.last, this.first);
        }
        return result;
    }

    double area() throws Exception {
        if (this.isClosed == false) throw new Exception("You can't calculate an open polygon's area.");

        double result = 0;
        Point currPoint = this.first;
        for (int i = 0; i < this.size; i++) {
            double d = 0;
            if (i != this.size - 1) {
                d = (currPoint.x * currPoint.next.y) - (currPoint.y * currPoint.next.x);
                currPoint = currPoint.next;
            } else {
                d = (currPoint.x * this.first.y) - (currPoint.y * this.first.x);
            }
            result += d;
        }
        return Math.abs(result / 2);
    }

    /* Point array[] = new Point[this.size];
        double result = 0;
        double a=0;
        double b=0;
        double c=0;
        Point currPoint = this.first;
        for (int i = 0; i < this.size; i++) {
            array[i] = currPoint;
            currPoint = currPoint.next;}

            for (int w = 0; w < array.length - 1; w++) {

                a = array[w].x * array[w + 1].y;
                b = array[w + 1].x * array[w].y;
                result = result + ((a - b) / 2) - c;
            }
         return Math.abs(result );
    */

    public void concatenate(Polygon polygon) throws Exception {
        if ((this.isClosed || polygon.isClosed) == true) throw new Exception("You can't concatenate a closed polygon.");
        this.last.next = polygon.first;
        this.last = polygon.last;
    }

    @Override
    public String toString() {
        String extraInfo;
        if (isClosed) extraInfo = " closed";
        else extraInfo = "n open";
        String description = "This is a" + extraInfo + " polygon that has " + this.size + " corner and these corner points are: "+ pointStack.toString();
        return description;
    }
}