import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;

public class Player extends Pokemon {

    private int dx;
    private int dy;
    private List<Projectile> projectiles;
    private List<Item> items;
    private boolean state;

    public Player(int x, int y) {
        super(x, y);
        initPlayer();
        state = true;
    }

    public void initPlayer() {
        projectiles = new ArrayList<>();
        loadImage("resources/bulbasaur.png");
        getImageDimensions();
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean b) {
        state = b;
    }

//    public void evolve() {
//        if (evolutionaryState == 1) {
//            loadImage("resources/ivysaur.png");
//            evolutionaryState++;
//        }
//        else if (evolutionaryState == 2) {
//            loadImage("resources/venusaur.png");
//            evolutionaryState++;
//        }
//    }

//    public void decHP (int amount) {
//        hp -= amount;
//        //ah.blink(this);
//        Timer timer = new Timer(3000, actionEvent -> setState(true));
//        timer.start();
//    }

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void fire() {
        projectiles.add(new Projectile(x + width, y + height / 2));
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}