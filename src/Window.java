import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static Window window;
    private JPanel board;

    public static Window getInstance(){
        if (window == null) {
            window = new Window();
        }
        return window;
    }

    public Window() {
        this.setTitle("Tetris");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit button closes program

        this.setSize(750, 1000); //window size
        this.setLayout(null);
        this.setLocationRelativeTo(null); //window location is center of screen
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.board = initializeBoard();
        this.add(board);

        this.setVisible(true);
    }

    public JPanel initializeBoard() {
        int rows = 20; // number of rows
        int cols = 10; // number of columns
        int gridSizeFactor = 30; // size of board in respect to number of rows & cols

        //Create overarching board
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(rows, cols));
        grid.setSize(cols * gridSizeFactor,rows * gridSizeFactor);

        //Create each individual cube within the board
        JPanel[][] cubes = new JPanel[rows][cols];
        for (int row=0; row<rows; row++){
            for (int col=0; col<cols; col++){
                cubes[row][col] = new JPanel();
                cubes[row][col].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                cubes[row][col].setBackground(Color.BLACK);
                cubes[row][col].setVisible(true);
                grid.add(cubes[row][col]);
            }
        }
        grid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        grid.setBackground(Color.BLACK);
        grid.setVisible(true);
        return grid;
    }
}
