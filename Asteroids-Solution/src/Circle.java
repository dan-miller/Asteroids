import java.awt.*;

public abstract class Circle extends Shape {

    public Circle(Point _position, double _heading) {
        super(_position, _heading);
    }

    public void paint(Graphics brush, int diameter) {
        brush.fillOval((int)this.getPosition().x, (int)this.getPosition().y, diameter, diameter);
    }

}
