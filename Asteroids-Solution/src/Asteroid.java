import java.awt.*;
public class Asteroid extends Polygon {
    private double xVelocity;
    private double yVelocity;
    public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
        this.xVelocity = Math.random() / 10;
        this.yVelocity = Math.random() / 10;
        //this.rotation = Math.random() * 360;
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
        this.position.x += (this.xVelocity * Math.cos(Math.toRadians(this.rotation)));
        this.position.y += (this.yVelocity * Math.sin(Math.toRadians(this.rotation)));
        if (this.position.x > 800) {
            this.position.x = 0;
        }
        if (this.position.x < 0) {
            this.position.x = 800;
        }
        if (this.position.y > 600) {
            this.position.y = 0;
        }
        if (this.position.y < 0) {
            this.position.y = 600;
        }
    }
    
}
