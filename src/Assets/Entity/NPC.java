package Assets.Entity;

import java.util.Random;

public class NPC extends Pokemon {

    private final int INITIAL_X = 850;

    public NPC(int x, int y) {
        super(x, y);
        initNPC();
    }

    private void initNPC() {
        switch (new Random().nextInt(4 + 1)) {
            case (0):
                loadImage("resources/magikarp.png");
                break;
            case (1):
                loadImage("resources/omanyte.png");
                break;
            case (2):
                loadImage("resources/poliwag.png");
                break;
            case (3):
                loadImage("resources/staryu.png");
                break;
            case (4):
                loadImage("resources/squirtle.png");
                break;
        }

        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}