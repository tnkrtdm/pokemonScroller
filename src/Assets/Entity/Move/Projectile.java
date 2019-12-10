package Assets.Entity.Move;

import Assets.Entity.Entity;

import java.util.Random;

public class Projectile extends Entity {

    private final int BOARD_WIDTH = 850;
    private int PROJECTILE_SPEED = 2;
    private ProjectileType type;

    public Projectile(int x, int y) {
        super(x, y);

        initProjectile();
    }

    private void initProjectile() {
        if (type == ProjectileType.BULLET_SEED) {
            loadImage("resources/bulletSeed.png");
        } else if (type == ProjectileType.SOLARBEAM){
            loadImage("resources/solarbeam.png");
            PROJECTILE_SPEED = 4;
        }
        getImageDimensions();
    }

    public void move() {

        x += PROJECTILE_SPEED;

        if (x > BOARD_WIDTH)
            visible = false;
    }
}