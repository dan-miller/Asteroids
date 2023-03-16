
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

        // Define the set of points for the ship and draw it in the middle of the canvas
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
            // Add more asteroids here
        };
        asteroids = new ArrayList<Asteroid>(Arrays.asList(array));

        // Create two new star objects with random coordinates on the canvas and with random headings
        // so they can move in random directions.
        stars = new ArrayList<Star>();
        stars.add(new Star(new Point(Math.random() * 800, Math.random() * 600), Math.random() * 360));
        stars.add(new Star(new Point(Math.random() * 800, Math.random() * 600), Math.random() * 360));

        this.addKeyListener(new Keyboard());
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

        // Ship /////////////////////////////////////////////////////////////
        if (this.play) {
            if (turningRight) {
                ship.rotateRight();
            }
            if (turningLeft) { 
                ship.rotateLeft();
            }
            if (accelerating) {
                ship.accelerate();
            }
            ship.move();
        }
        ship.paint(brush);
        // End Ship //////////////////////////////////////////////////////////

        // Stars /////////////////////////////////////////////////////////////
        if (this.stars != null) {
            // Milestone 3: Add a for loop to move (only if this.play is true) and paint each star
        }
        // End Stars /////////////////////////////////////////////////////////

        // Asteroids /////////////////////////////////////////////////////////
        if (this.asteroids != null) {
            // Milestone 4: Add a for loop to move (only if this.play is true) and paint each asteroid

            // Milestone 5: Add another for loop (or do it in the same loop above) that will
            // 1. Check and see if the current asteroid has collided with the ship
            // 1.2. If so, end the game (see packet for details)
            // 2. Check and see if the current asteroid "contains" bullet1 or bullet2 (after making sure that the bullet is not null)
            // 2.1. If so, set the bullet to null so it disappears, and remove the asteroid
            //      from the asteroids list (remember to adjust the loop variable accordingly)
        }
        // End Asteroids /////////////////////////////////////////////////////

        // Bullets ///////////////////////////////////////////////////////////
        if (bullet1 != null) {
            bullet1.paint(brush);
            if (bullet1.move() == false) {
                bullet1 = null;
            }
        }
        if (bullet2 != null) {
            bullet2.paint(brush);
            if (bullet2.move() == false) {
                bullet2 = null;
            }
        }
        // End Bullets ///////////////////////////////////////////////////////
        
        // Redraw the entire Canvas to apply changes made to objects
        repaint();
    }

    private void shoot() {
        if (bullet1 == null) {
            bullet1 = new Bullet(new Point(ship.getPosition().x, ship.getPosition().y), ship.getHeading());
        } else if (bullet2 == null) {
            bullet2 = new Bullet(new Point(ship.getPosition().x, ship.getPosition().y), ship.getHeading());
        }
    }

    public static void main(String[] args) {
        new Asteroids();
    }

    // Begin KeyListener
    class Keyboard implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {

            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {

            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Do not add any code here.
        }
        
    }
}