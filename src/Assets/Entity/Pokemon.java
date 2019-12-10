package Assets.Entity;

import Assets.Entity.Move.Move;
import Assets.Typing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pokemon extends Entity {

    private String name;
    private int HP;
    private int maxHP;
    private int level;
    private int EXP;
    private int maxEXP;
    private int evolutionaryState;
    private int evolutionaryStateMax;
    private String spriteSlot1;
    private String spriteSlot2;
    private String spriteSlot3;
    private Typing type1, type2;
    private List<Move> moveSet;

    public Pokemon(int x, int y) {
        super(x, y);
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

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

    public void setSpriteSlot1(String value) { spriteSlot1 = value; }

    public void setSpriteSlot2(String value) { spriteSlot2 = value; }

    public void setSpriteSlot3(String value) { spriteSlot3 = value; }

    public String getSpriteSlot1(String value) { return spriteSlot1; }

    public String getSpriteSlot2(String value) { return spriteSlot2; }

    public String getSpriteSlot3(String value) { return spriteSlot3; }

    public void setTyping(Typing type1, Typing type2) { this.type1 = type1; this.type2 = type2; }

    public List<Typing> getTyping() { return new ArrayList<Typing>(Arrays.asList(type1, type2)); }

    public List<Move> getMoveSet() { return moveSet; }

    public void setMoveSet(List<Move> moveSet) { this.moveSet = moveSet; }

    public void evolve() {
        if (evolutionaryState <= evolutionaryStateMax) {
            if (evolutionaryState == 1) {
                loadImage(spriteSlot2); // Load sprite of evolution
                setEXP(0); // Reset EXP
                setMaxEXP(maxEXP * 2); // Increase Max EXP
                evolutionaryState++;
            }
            if (evolutionaryState == 2) {
                loadImage(spriteSlot3); // Load sprite of evolution
                setEXP(0); // Reset EXP
                setMaxEXP(maxEXP * 2); // Increase Max EXP
                evolutionaryState++;
            }
        }
    }

}
