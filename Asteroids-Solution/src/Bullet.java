import java.awt.*;

public class Bullet extends Circle {
    public static final double BULLET_SPEED = .25;
    public static final int MAX_DISTANCE = 2000;
    private int distanceTraveled = 0;

    public Bullet(Point _position, double _heading) {
        super(_position, _heading);
    }

    public void paint(Graphics brush) {
        super.paint(brush, 20);
    }

    public boolean move() {
        if (distanceTraveled > MAX_DISTANCE) {
            return false;
        }
        this.getPosition().x += (BULLET_SPEED * Math.cos(Math.toRadians(this.getHeading())));
        this.getPosition().y += (BULLET_SPEED * Math.sin(Math.toRadians(this.getHeading())));
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
        distanceTraveled++;
        return true;
    }
}
