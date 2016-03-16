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
        Action leftArrow = new AbstractAction() {
            private static final long serialVersionUID = 1L;
            public void actionPerformed(ActionEvent e) {
                game.leftArrow();
            }
        };
        Action rightArrow = new AbstractAction() {
            private static final long serialVersionIUD = 1L;
            public void actionPerformed(ActionEvent e) {
                game.rightArrow();
            }
        };
        Action upArrow = new AbstractAction() {
            private static final long serialVersionIUD = 1L;
            public void actionPerformed(ActionEvent e) {
                game.upArrow();
            }
        };
        Action downArrow = new AbstractAction() {
            private static final long serialVersionIUD = 1L;
            public void actionPerformed(ActionEvent e) {
                game.downArrow();
            }
        };
        game.getInputMap(game.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "leftArrow");
        game.getActionMap().put("leftArrow", leftArrow);
        game.getInputMap(game.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "rightArrow");
        game.getActionMap().put("rightArrow", rightArrow);
        game.getInputMap(game.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "upArrow");
        game.getActionMap().put("upArrow", upArrow);
        game.getInputMap(game.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "downArrow");
        game.getActionMap().put("downArrow", downArrow);
        game.setFocusable(true);
        System.out.println("Event Handler");
        
    }

}
