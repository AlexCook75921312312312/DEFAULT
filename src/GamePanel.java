import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    boolean running = true;
    Graphics g;
    static Dot sje;
    static GamePanel game;

    public static void main(String[] args) {
        game = new GamePanel();
        Thread thread = new Thread(game);
        thread.start();
        initialize();
    }

    @Override
    public void run() {
        initializeDot();
        while (running) {
            gameUpdate();
        }
    }

    public static void initialize() {
        JFrame gameFrame = new JFrame();
        gameFrame.setVisible(true);
        gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.add(game);
        game.setBackground(Color.red);
        game.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        game.setVisible(true);
        game.setFocusable(true);
        EventHandler Event = new EventHandler(game);
    }

    public static void initializeDot() {
        sje = new Dot(250, 250, 50);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameRender(g);
    }

    private void gameUpdate() {

    }

    private void gameRender(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        sje.draw(g);
        repaint();
    }

    public void mouseClick(int x, int y) {
        sje.setCoordinates(x, y);
    }

    public void leftArrow() {
        sje.offsetCoordinates(-10, 0);
        System.out.println("left");
    }

    public void rightArrow() {
        sje.offsetCoordinates(10, 0);
    } 

}

//TODO implement creation of game components in files
//TODO implement key listening and mouse listening
//TODO implement imaging from files
//TODO implement fullscreen
//TOOD implement a class to track game state
