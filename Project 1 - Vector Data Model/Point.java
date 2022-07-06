package project1;
/**
 *
 * @author 19COMP1024 Barış Girişmen & 19COMP1030 Emir Aksakal
 */
public class Point {
    int x;
    int y;
    Point next;

    Point(int a, int b) {
        this.x = a;
        this.y = b;
    }
    
    static double distance(Point a, Point b) {
        double r = Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
        return Math.sqrt(r);
    }

    public String toString() {
        String s = "("+x+", "+y+ ")";
        return s;
    }
}