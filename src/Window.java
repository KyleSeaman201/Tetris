import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
    private static Window window;
    private JPanel board;
    public JPanel[][] cubes;
    private JPanel menu;

    final int width = 750;
    final int height = 700;

    public static Window getInstance(){
        if (window == null) {
            window = new Window();
        }
        return window;
    }

    public Window() {
        this.setTitle("Tetris");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit button closes program

        this.setSize(width, height); //window size
        this.setLayout(null);
        this.setLocationRelativeTo(null); //window location is center of screen
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);

        initializeBoard();
        this.add(board);

        this.menu = createMenu();
        this.add(menu);

        this.setVisible(true);
    }

    public void initializeBoard() {
        int x = 10; // number of columns
        int y = 20; // number of rows
        int gridSizeFactor = 30; // size of board in respect to number of rows & cols

        //Create overarching board
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(y, x));
        grid.setSize(x * gridSizeFactor,y * gridSizeFactor);

        //Create each individual cube within the board
        JPanel[][] cubes = new JPanel[y][x];
        for (int i=0; i<y; i++){
            for (int j=0; j<x; j++){
                cubes[i][j] = new JPanel();
                cubes[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                cubes[i][j].setBackground(Color.BLACK);
                cubes[i][j].setVisible(true);
                grid.add(cubes[i][j]);
            }
        }
        grid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        grid.setBackground(Color.BLACK);
        grid.setLocation(25,25);
        grid.setVisible(true);

        this.cubes = cubes;
        this.board = grid;

        cubes[0][0].setBackground(Color.YELLOW);
        cubes[19][0].setBackground(Color.PINK);
        cubes[0][9].setBackground(Color.ORANGE);
        cubes[19][9].setBackground(Color.blue);
    }

    public JPanel createMenu() {
        JPanel menu = new JPanel();
        menu.setLayout(new BorderLayout());
        menu.setBackground(Color.BLACK);
        menu.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        menu.setSize(200,150);
        menu.setLocation(width - 300, height -300);
        menu.setVisible(true);
        return menu;
    }

    public void createCubeColor(int x, int y){
        System.out.println("x value: " + x);
        System.out.println("y value: " + y);
        cubes[19-y][9-x].setBackground(Color.RED);
    }

    public void updateCubeColor(ArrayList<Cube> oldShape, ArrayList<Cube> newShape){
        for (Cube cube: oldShape) {
            int oldX = cube.x;
            int oldY = cube.y;
            cubes[19-oldY][9-oldX].setBackground(Color.BLACK);
        }

        for (Cube cube: newShape) {
            int newX = cube.x;
            int newY = cube.y;
            cubes[19-newY][9-newX].setBackground(Color.RED);
        }
    }
}
