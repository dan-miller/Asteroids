
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
    // Game Objects

    private Ship ship;
    private Bullet bullet1;
    private Bullet bullet2;
    private ArrayList<Asteroid> asteroids;

    public Asteroids() {
        super("Asteroids!", 800, 600);
        this.setFocusable(true);

        // SET UP GAME OBJECTS
        Point[] shipPoints = { new Point(0, 0), new Point(35, 10), new Point(0, 20), new Point(5, 10) };
        ship = new Ship(shipPoints, new Point(300, 300), 0);

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
                new Asteroid(asteroidPoints, new Point(100, 80), 0),
                new Asteroid(asteroidPoints, new Point(400, 250), 0),
                new Asteroid(asteroidPoints, new Point(30, 550), 0),
                new Asteroid(asteroidPoints, new Point(200, 180), 0)
        };
        asteroids = new ArrayList<Asteroid>(Arrays.asList(array));

        this.addKeyListener(new Keyboard());
    }

  public void paint(Graphics brush) {
    brush.setColor(Color.black);
    brush.fillRect(0, 0, width, height);
    brush.setColor(Color.white);

    // GET MOUSE POSITION
    java.awt.Point mousePos = this.getMousePosition();
    int xPos = mousePos != null ? mousePos.x : -1;
    int yPos = mousePos != null ? mousePos.y : -1;
    brush.drawString("X: " + xPos + " Y: " + yPos, 700, 550);
    ////////////////////

    ship.move();
    ship.paint(brush);

    asteroids.forEach((a) -> a.paint(brush));

    for (Asteroid a : asteroids) {
      if (a.collidesWith(ship)) {
        this.on = false;
        var defaultFont = brush.getFont();
        brush.setFont(new Font("Arial", Font.BOLD, 128));
        brush.drawString("YOU DIED", 100, 200);
        brush.setFont(defaultFont);
      }
      if (bullet1 != null && a.contains(bullet1.getPosition())) {
        bullet1 = null;
      }
      if (bullet2 != null && a.contains(bullet2.getPosition())) {
        bullet2 = null;
      }
    }

    if (bullet1 != null) {
      bullet1.paint(brush);
      if (!bullet1.move()) {
        bullet1 = null;
      }
    }
    if (bullet2 != null) {
      bullet2.paint(brush);
      if (!bullet2.move()) {
        bullet2 = null;
      }
    }
  }

    public void shoot() {
        if (bullet1 == null) {
            bullet1 = new Bullet(new Point(ship.position.x, ship.position.y), ship.rotation);
        } else if (bullet2 == null) {
            bullet2 = new Bullet(new Point(ship.position.x, ship.position.y), ship.rotation);
        }
    }

    public static void main(String[] args) {
        new Asteroids();
    }

    class Keyboard implements KeyListener {
        public Keyboard() {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                ship.accelerate();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                ship.rotateRight();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                ship.rotateLeft();
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                shoot();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }
}
