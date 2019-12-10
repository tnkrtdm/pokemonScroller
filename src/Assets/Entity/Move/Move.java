package Assets.Entity.Move;

import Assets.Entity.Entity;
import Assets.Typing;

public class Move {

    private String moveName;
    private int currentPP;
    private int totalPP;
    private int damage;
    private Typing type;

    private String sprite;

    public Move(String moveName, int currentPP, int damage, Typing type, String sprite) {
        this.moveName = moveName;
        this.currentPP = currentPP;
        this.totalPP = currentPP;
        this.damage = damage;
        this.type = type;
        this.sprite = sprite;
    }

    public int getCurrentPP() {return currentPP;}

    public int getTotalPP() {return totalPP;}

    public int getDamage() {return damage;}

    public Typing getType() {return type;}

    public String getSprite() { return sprite; }

    @Override
    public String toString() {
        return moveName;
    }

}
