import java.awt.*;
public class Star {
    private Point position;
    private double heading;

    public Star(Point _position, double _heading) {
        this.position = _position;
        this.heading = _heading;
    }

    public void paint(Graphics brush) {
        brush.fillOval((int)this.position.x, (int)this.position.y, 5, 5);
    }

    public void move() {
        this.position.x += (0.01 * Math.cos(Math.toRadians(this.heading)));
        this.position.y += (0.01 * Math.sin(Math.toRadians(this.heading)));
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
