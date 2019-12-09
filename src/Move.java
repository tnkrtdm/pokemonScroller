public class Move {

    private String moveName;
    private int currentPP;
    private int totalPP;
    private int damage;
    private Typing type;

    public int getCurrentPP() {return currentPP;}

    public int getTotalPP() {return totalPP;}

    public int getDamage() {return damage;}

    public Typing getType() {return type;}

    @Override
    public String toString() {
        return moveName;
    }

}
