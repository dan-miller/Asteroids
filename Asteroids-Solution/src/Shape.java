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
    public void setHeading(double newHeading) {
        this.heading = newHeading;
    }

    public void move(double velocity) {
        move(velocity, velocity);
    }

    public void move(double xVelocity, double yVelocity) {
        this.position.x += (xVelocity * Math.cos(Math.toRadians(this.heading)));
        this.position.y += (yVelocity * Math.sin(Math.toRadians(this.heading)));
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
