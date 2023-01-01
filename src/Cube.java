import javax.swing.*;
import java.awt.*;

public class Cube {
    public boolean occupied, currentShape;
    int x;
    int y;


    public Cube() {
        this.occupied = false;
        this.currentShape = false;
    }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
