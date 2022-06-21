package chapter11.object;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}

class Circle implements Cloneable {
    Point point;
    private int radius;

    public Circle(int x, int y, int raidus) {
        point = new Point(x,y);
        this.radius = raidus;
    }
    public String toString() {
        return "원점은 " + this.point + "반지름은 " + radius;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ObjectCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Circle c = new Circle(10, 20, 5);
        Circle c_c = (Circle) c.clone();

        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(c_c));

        System.out.println(c.toString());
        System.out.println(c_c.toString());
    }
}
