import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationHandler {

    public void blink(Entity e) {
        Timer blinkTimer = new Timer(500, new ActionListener() {
            int count = 0;
            int maxCount = 4;
            boolean on = false;

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (count >= maxCount) {
                    e.setVisible(true);
                } else {
                    e.setVisible(false);
                    on = !on;
                    count++;
                }
            }
        });
        blinkTimer.start();
    }

}
