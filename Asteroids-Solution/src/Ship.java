import java.awt.*;
public class Ship extends Polygon {

    public Ship(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }

    public void paint(Graphics brush) {
        int[] xPositions = new int[3];
        int[] yPositions = new int[3];
        xPositions[0] = (int)this.getPoints()[0].x;
        xPositions[1] = (int)this.getPoints()[1].x;
        xPositions[2] = (int)this.getPoints()[2].x;
        yPositions[0] = (int)this.getPoints()[0].y;
        yPositions[1] = (int)this.getPoints()[1].y;
        yPositions[2] = (int)this.getPoints()[2].y;
        brush.setColor(Color.WHITE);
        brush.fillPolygon(xPositions, yPositions, 3);
    }
    
}
