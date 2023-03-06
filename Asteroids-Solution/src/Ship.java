import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
public class Ship extends Polygon implements ActionListener {
    Timer timer = new Timer(300, this);
    private double acceleration = 0;

    public Ship(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
        timer.start();
    }

    public void paint(Graphics brush) {
        Point[] shipPoints = this.getPoints();
        int numPoints = shipPoints.length;
        int[] xPositions = new int[numPoints];
        int[] yPositions = new int[numPoints];
        for (int i = 0; i < numPoints; i++) {
            xPositions[i] = (int)shipPoints[i].x;
            yPositions[i] = (int)shipPoints[i].y;
        }
        brush.setColor(Color.GREEN);
        brush.drawPolygon(xPositions, yPositions, numPoints);

        
    }

    public void accelerate() {
        if (this.acceleration < 1) {
            this.acceleration += 0.0001;
        }
    }

    public void move() {
        super.move(this.acceleration);
    }

    public void rotateLeft() {
        this.setHeading(this.getHeading() - 0.25);
    }

    public void rotateRight() {
        this.setHeading(this.getHeading() + 0.25);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            if (this.acceleration > 0.01) {
                this.acceleration -= 0.01;
            } else {
                this.acceleration = 0;
            }
        }
    }
}
