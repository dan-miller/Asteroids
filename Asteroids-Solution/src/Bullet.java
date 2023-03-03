import java.awt.*;

public class Bullet {
    private Point position;
    private double heading;
    public static final double BULLET_SPEED = .25;
    public static final int MAX_DISTANCE = 2000;
    private int distanceTraveled = 0;

    public Bullet(Point _position, double _heading) {
        this.position = _position;
        this.heading = _heading;
    }

    public Point getPosition() {
        return this.position;
    }

    public void paint(Graphics brush) {
        brush.fillOval((int)this.position.x, (int)this.position.y, 20, 20);
    }

    public boolean move() {
        if (distanceTraveled > MAX_DISTANCE) {
            return false;
        }
        this.position.x += (BULLET_SPEED * Math.cos(Math.toRadians(this.heading)));
        this.position.y += (BULLET_SPEED * Math.sin(Math.toRadians(this.heading)));
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
        distanceTraveled++;
        return true;
    }
}
