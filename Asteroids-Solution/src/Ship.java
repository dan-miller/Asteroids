import java.awt.*;
public class Ship extends Polygon {

    public Ship(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }

    public void paint(Graphics brush) {
        brush.fillPolygon(null, null, 0);
    }
    
}
