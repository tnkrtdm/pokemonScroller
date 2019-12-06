public class Projectile extends Entity {

    private final int BOARD_WIDTH = 700;
    private final int LASER_SPEED = 2;

    public Projectile(int x, int y) {
        super(x, y);

        initProjectile();
    }

    private void initProjectile() {

        loadImage("resources/bulletSeed.png");
        getImageDimensions();
    }

    public void move() {

        x += LASER_SPEED;

        if (x > BOARD_WIDTH)
            visible = false;
    }
}