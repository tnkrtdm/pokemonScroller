import java.util.Random;

public class Item extends Entity {

    private final int BOARD_WIDTH = 700;
    private final ItemType type;

    public Item(int x, int y) {
        super(x, y);
        if (new Random().nextInt(2) == 0) {
            type = ItemType.RARE_CANDY;
        } else {
            type = ItemType.POTION;
        }
        initItem();
    }

    private void initItem() {
        if (type == ItemType.RARE_CANDY) {
            loadImage("resources/rare_candy.png");
        }
        if (type == ItemType.POTION) {
            loadImage("resources/potion.png");
        }
        getImageDimensions();
    }

    public ItemType getType() {
        return type;
    }

}