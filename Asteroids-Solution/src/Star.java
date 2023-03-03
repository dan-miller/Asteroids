import java.awt.*;
public class Star extends Circle {

    public Star(Point _position, double _heading) {
        super(_position, _heading);
    }

    public void move() {
        this.getPosition().x += (Math.cos(Math.toRadians(this.getHeading())) / 100);
        this.getPosition().y += (Math.sin(Math.toRadians(this.getHeading())) / 100);
    }

    public void paint(Graphics brush) {
        super.paint(brush, 5);
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
    }
    
}
