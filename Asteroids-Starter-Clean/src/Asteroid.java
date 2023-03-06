import java.awt.*;
public class Asteroid extends Polygon {
    private double xVelocity;
    private double yVelocity;

    public Asteroid(Point[] _vertices, Point _position, double _heading) {
        super(_vertices, _position, _heading);
    }

    public void paint(Graphics brush) {
        Point[] astPoints = this.getPoints();
        int numPoints = astPoints.length;
        int[] xPositions = new int[numPoints];
        int[] yPositions = new int[numPoints];
        for (int i = 0; i < numPoints; i++) {
            xPositions[i] = (int)astPoints[i].x;
            yPositions[i] = (int)astPoints[i].y;
        }
        brush.setColor(Color.WHITE);
        brush.drawPolygon(xPositions, yPositions, numPoints);
    }

    public void move() {

    }
}
