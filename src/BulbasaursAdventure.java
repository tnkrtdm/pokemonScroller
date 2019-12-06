import java.awt.EventQueue;
import javax.swing.JFrame;

public class BulbasaursAdventure extends JFrame {

    public BulbasaursAdventure() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Bulbasaur's Adventure");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            BulbasaursAdventure fc = new BulbasaursAdventure();
            fc.setVisible(true);
        });
    }
}