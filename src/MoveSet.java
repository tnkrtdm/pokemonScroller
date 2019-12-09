import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveSet {

    private List<Move> moveList;

    public MoveSet(Move m1, Move m2, Move m3, Move m4) {
        moveList = new ArrayList<>(Arrays.asList(m1, m2, m3, m4));
    }

    public List<Move> getMoveSet() {
        return moveList;
    }

}
