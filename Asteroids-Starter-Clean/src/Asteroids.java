
/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
*/
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Asteroids extends Game {
    // Game state variables and objects
    private Ship ship;
    private Bullet bullet1;
    private Bullet bullet2;
    private ArrayList<Asteroid> asteroids;
    private ArrayList<Star> stars;
    private boolean turningLeft;
    private boolean turningRight;
    private boolean accelerating;

    public Asteroids() {
        // Call the Game constructor to create a new "Asteroids!" window that is 800 x 600 pixels
        super("Asteroids!", 800, 600);

        // Don't worry about this...
        this.setFocusable(true);

        Point[] shipPoints = { 
            new Point(0, 0), 
            new Point(35, 10), 
            new Point(0, 20), 
            new Point(5, 10) 
        };
        ship = new Ship(shipPoints, new Point(300, 300), 0);

        // This draws each asteroid as a perfect hexagon.
        Point[] asteroidPoints = {
            new Point(20, 0),
            new Point(0, 10),
            new Point(0, 30),
            new Point(20, 40),
            new Point(40, 30),
            new Point(40, 10)
        };

        Asteroid[] array = {
            new Asteroid(asteroidPoints, new Point(50, 50), 0),
            new Asteroid(asteroidPoints, new Point(50, 250), 0),
        };
        asteroids = new ArrayList<Asteroid>(Arrays.asList(array));

        stars = new ArrayList<Star>();
    }

    public void paint(Graphics brush) {
        brush.setColor(Color.black);
        brush.fillRect(0, 0, width, height);
        brush.setColor(Color.white);

        // Show the mouse position in the lower right -- useful for debugging
        java.awt.Point mousePos = this.getMousePosition();
        int xPos = mousePos != null ? mousePos.x : -1;
        int yPos = mousePos != null ? mousePos.y : -1;
        brush.drawString("X: " + xPos + " Y: " + yPos, 700, 550);

        ship.paint(brush);
    }

    private void shoot() {

    }

    public static void main(String[] args) {
        new Asteroids();
    }

    // Begin KeyListener
    class Keyboard implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                accelerating = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                turningRight = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                turningLeft = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                shoot();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                accelerating = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                turningRight = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                turningLeft = false;
            }
        }
        
    }
}