public abstract class Shape {
    private Point position;
    private double heading;

    public Shape(Point _position, double _heading) {
        this.position = _position;
        this.heading = _heading;
    }

    public Point getPosition() {
        return position;
    }
    public double getHeading() {
        return heading;
    }

    public void move(double velocityFactor) {
        
    } 

}
