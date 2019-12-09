import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pokemon extends Entity {

    private int HP;
    private int maxHP;
    private int level;
    private int EXP;
    private int maxEXP;
    private int evolutionaryState;
    private int evolutionaryStateMax;
    private Typing type1, type2;
    private MoveSet moveSet;

    public Pokemon(int x, int y) {
        super(x, y);
    }

    public int getHP() { return HP; }

    public void setHP(int HP) { this.HP = HP; }

    public int getMaxHP() { return maxHP; }

    public void setMaxHP(int value) { maxHP = value; }

    public void incHP(int value) { HP += value; }

    public int getLevel() { return level; }

    public void setLevel(int value) { level = value; }

    public int getEXP() { return EXP; }

    public void setEXP(int value) { EXP = value; }

    public int getMaxEXP() { return maxEXP; }

    public void setMaxEXP(int value) { maxEXP =  value; }

    public void setEvolutionaryState(int value) { evolutionaryState = value; }

    public int getEvolutionaryState() { return evolutionaryState; }

    public void setEvolutionaryStateMax(int value) { evolutionaryStateMax = value; }

    public int getEvolutionaryStateMax() { return evolutionaryStateMax; }

    public void setTyping(Typing type1, Typing type2) { this.type1 = type1; this.type2 = type2; }

    public List<Typing> getTyping() { return new ArrayList<Typing>(Arrays.asList(type1, type2)); }

    public MoveSet getMoveSet() { return moveSet; }

    public void setMoveSet(MoveSet moveSet) { this.moveSet = moveSet; }

    public void evolve() {
        if (evolutionaryState <= evolutionaryStateMax) {
            //load new sprite
            evolutionaryState++;
        }
    }

}
