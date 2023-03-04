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

    public void move() {
        this.position.x += (this.acceleration * Math.cos(Math.toRadians(this.rotation)));
        this.position.y += (this.acceleration * Math.sin(Math.toRadians(this.rotation)));
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

    public void accelerate() {
        if (this.acceleration < 1) {
            this.acceleration += 0.1;
        }
    }

    public void rotateLeft() {
        this.rotation -= 5;
    }

    public void rotateRight() {
        this.rotation += 5;
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
