/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
*/
import java.awt.*;
import java.awt.event.*;

public class Asteroids extends Game {
  public Asteroids() {
    super("Asteroids!",800,600);
  }
  
	public void paint(Graphics brush) {
    brush.setColor(Color.black);
    brush.fillRect(0,0,width,height);
    brush.setColor(Color.white);

    // GET MOUSE POSITION
    java.awt.Point mousePos = this.getMousePosition();
    int xPos = mousePos != null ? mousePos.x : -1;

    
    brush.drawString("X: " + this.getMousePosition().x + " Y: " + this.getMousePosition().y, 200, 200);

    Point[] shipPoints = {new Point(0,0), new Point(50, 50), new Point(0, 50)};
    Ship ship = new Ship(shipPoints, new Point(300,300), 15);
    ship.paint(brush);
  }
  
	public static void main (String[] args) {
    new Asteroids();
  }
}