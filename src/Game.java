import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener, ActionListener {
    private Window window;
    private Board board;
    private Timer timer;
    private int gameSpeed; // in milliseconds
    private int gameTimer;
    private int timerDelay;
    private boolean blockInProgress;
    public Game () {
        this.window = Window.getInstance();
        this.board = new Board();
        this.gameSpeed = 500;
        this.gameTimer = gameSpeed;
        this.blockInProgress = false;

        //Start game
        this.timerDelay = 50;
        this.timer = new Timer(timerDelay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!blockInProgress){
            board.createShape();
            blockInProgress = true;
        }
        if (gameTimer <= 0) {
            blockInProgress = board.moveShapeDown();
            gameTimer = gameSpeed;
        }
        gameTimer -= timerDelay;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
