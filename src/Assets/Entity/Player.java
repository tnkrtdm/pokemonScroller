package Assets.Entity;

import Assets.Entity.Item.Item;
import Assets.Entity.Move.Move;
import Assets.Entity.Move.Projectile;
import Assets.Typing;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        initPokemon();
        initPlayer();
        state = true;
    }

    public void initPokemon() {
        setName("Bulbasaur");
        setHP(50);
        setMaxHP(50);
        setLevel(1);
        setEXP(0);
        setMaxEXP(40);
        setEvolutionaryState(1);
        setEvolutionaryStateMax(3);
        setSpriteSlot1("resources/bulbasaur.png");
        setSpriteSlot2("resources/ivysaur.png");
        setSpriteSlot3("resources/venusaur.png");
        setTyping(Typing.GRASS, Typing.POISON);
        setMoveSet(new ArrayList<Move>(Arrays.asList(
                new Move("Bullet Seed", 20, 25, Typing.GRASS, "resources/bulletSeed.png"),
                new Move("Poison Powder", 10, 5, Typing.POISON, null),
                null,
                null
        )));
    }

    public void initPlayer() {
        projectiles = new ArrayList<>();
        loadImage(getSpriteSlot1());
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

    public void decHP (int amount) {
        incHP(-amount);
        //ah.blink(this);
        Timer timer = new Timer(3000, actionEvent -> setState(true));
        timer.start();
    }

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

        if (key == KeyEvent.VK_1) {

        }

        if (key == KeyEvent.VK_2) {

        }

        if (key == KeyEvent.VK_3) {

        }

        if (key == KeyEvent.VK_4) {

        }

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

    // Get the move data, check for remaining PP, how much damage the projectile will do, and the typing
    public void moveSlot1() {
        Move move = getMoveSet().get(0);

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