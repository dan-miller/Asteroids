import java.awt.*;
public class Ship extends Polygon {

    private double velocity = 0;

    public Ship(Point[] _vertices, Point _position, double _heading) {
        super(_vertices, _position, _heading);
    }

    public void paint(Graphics brush) {
        // Get the rotation-adjusted array of points from the superclass
        Point[] shipPoints = this.getPoints();
        int numPoints = shipPoints.length;
        int[] xPositions = new int[numPoints];
        int[] yPositions = new int[numPoints];
        for (int i = 0; i < numPoints; i++) {
            xPositions[i] = (int)shipPoints[i].x;
            yPositions[i] = (int)shipPoints[i].y;
        }

        // Draw the ship on the canvas
        brush.setColor(Color.GREEN);
        brush.drawPolygon(xPositions, yPositions, numPoints);
    }

    public void accelerate() {
        if (this.velocity < 1) {
            this.velocity += 0.0001;
        }
    }

    public void move() {
        this.getPosition().x += (this.velocity * Math.cos(Math.toRadians(this.getHeading())));
        this.getPosition().y += (this.velocity * Math.sin(Math.toRadians(this.getHeading())));
        if (this.getPosition().x > 800) {
            this.getPosition().x = 0;
        }
        if (this.getPosition().x < 0) {
            this.getPosition().x = 800;
        }
        if (this.getPosition().y > 600) {
            this.getPosition().y = 0;
        }
        if (this.getPosition().y < 0) {
            this.getPosition().y = 600;
        }
    }

    public void rotateLeft() {
        this.setHeading(this.getHeading() - 0.25);
    }

    public void rotateRight() {
        this.setHeading(this.getHeading() + 0.25);
    }
}
