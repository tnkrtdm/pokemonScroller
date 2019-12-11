import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;

public class PokemonScroller extends JFrame {

    public PokemonScroller() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Pokémon Scroller");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            PokemonScroller fc = new PokemonScroller();
            fc.setVisible(true);
        });
    }
}