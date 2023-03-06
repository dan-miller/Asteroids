import java.awt.*;

public class Bullet extends Circle {
    public static final double BULLET_SPEED = .3;
    public static final int MAX_DISTANCE = 2000;
    private int distanceTraveled = 0;

    public Bullet(Point _position, double _heading) {
        super(_position, _heading);
    }

    public void paint(Graphics brush) {
        super.paint(brush, 20);
    }

    public boolean move() {
        if (distanceTraveled < MAX_DISTANCE) {
            super.move(BULLET_SPEED);
            distanceTraveled++;
            return true;
        } else {
            return false;
        }
    }
}
