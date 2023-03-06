import java.awt.*;
public class Star extends Circle {

    public Star(Point _position, double _heading) {
        super(_position, _heading);
    }

    public void move() {
        super.move(.01);
    }

    public void paint(Graphics brush) {
        super.paint(brush, 5);
    }
    
}
