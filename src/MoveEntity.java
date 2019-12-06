import java.awt.EventQueue;
import javax.swing.JFrame;

public class MoveEntity extends JFrame {

    public MoveEntity() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setTitle("Moving sprite");
        setSize(850, 850);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MoveEntity moveEntity = new MoveEntity();
            moveEntity.setVisible(true);
        });
    }
}