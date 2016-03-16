import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class EventHandler {

    public EventHandler(GamePanel game) {
        game.setSize(1000, 1000);
        game.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                game.mouseClick(e.getX(), e.getY());
            }
        });
        game.addMouseMotionListener(new MouseAdapter() {

            public void mouseDragged(MouseEvent e) {
                game.mouseClick(e.getX(), e.getY());
            }
        });
        game.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if (e.getKeyCode() == 39) {
                    game.rightArrow();
                } else if (e.getKeyCode() == 37) {
                    game.leftArrow();
                }

            }
        });
        Action left = new AbstractAction() {
            private static final long serialVersionUID = 1L;
            public void actionPerformed(ActionEvent e) {
                game.leftArrow();
            }
        };
        game.getInputMap().put(KeyStroke.getKeyStroke("F2"), "left");
        game.getActionMap().put("left", left);
    }

}
