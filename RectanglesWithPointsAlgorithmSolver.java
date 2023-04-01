import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectanglesWithPointsAlgorithmSolver {
    protected void brutForceSolve(Scanner in, PrintWriter out) {
        int rectCount = in.nextInt();
        List<Rectangle> rectangles = new ArrayList<>(rectCount);
        for(int i=0; i<rectCount; i++){
            rectangles.add(new Rectangle(new Point(in.nextInt(), in.nextInt()), new Point(in.nextInt(), in.nextInt())));
        }
        for(Rectangle rect:rectangles){
            System.out.println(rect);
        }
        int pointCount = in.nextInt();
        for(int i=0; i<pointCount; i++){
            Point point = new Point(in.nextInt(), in.nextInt());
            out.println(calcCountOfRectThatContainsPoint(point, rectangles));
        }
    }

    private static int calcCountOfRectThatContainsPoint(Point point, List<Rectangle> rectangles) {
        int count = 0;
        for(Rectangle rect:rectangles){
            if(rect.containsPoint(point)){
                count++;
            }
        }
        return count;
    }

    private void run() {
        brutForceSolve(new Scanner(System.in), new PrintWriter(System.out));
    }

    public static void main(String[] args) {
        new RectanglesWithPointsAlgorithmSolver().run();
    }
}

record Point(int x, int y){
    @Override
    public String toString() {
        return String.format("(%d,%d)", x(), y());
    }
}

record Rectangle(Point leftDown, Point rightUp){
    @Override
    public String toString() {
        return "{"+leftDown+","+rightUp+"}";
    }
    public boolean containsPoint(Point point) {
        return (point.x() >= leftDown.x() && point.y() >= leftDown.y()) &&
                (point.x() <= rightUp.x() && point.y() <= rightUp.y());
    }
}
