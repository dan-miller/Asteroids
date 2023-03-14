import java.awt.*;
public class Bullet {
    public static final double BULLET_SPEED = .3;
    public static final int MAX_DISTANCE = 2000;
    private int distanceTraveled = 0;
    private Point position;
    private double heading;

    public Bullet(Point _position, double _heading) {
        this.position = _position;
        this.heading = _heading;
    }

    public void paint(Graphics brush) {
        brush.setColor(Color.white);
        brush.fillOval((int)this.position.x, (int)this.position.y, 20, 20);
    }

    public boolean move() {
        if (distanceTraveled < MAX_DISTANCE) {
            distanceTraveled++;
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
            return true;
        } else {
            return false;
        }
    }
}
