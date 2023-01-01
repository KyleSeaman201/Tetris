import java.awt.*;
import java.util.ArrayList;

public class Board {
    Cube[][] cubes;
    ArrayList<Cube> currentShape = new ArrayList<>();
    Window window = Window.getInstance();

    public Board(){
        this.cubes = new Cube[10][40];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 40; j++) {
                cubes[i][j] = new Cube();
                cubes[i][j].setPosition(i, j);
            }
        }
    }

    private void setCurrentShape(Cube cube){
        currentShape.add(cube);
        cube.currentShape = true;
        cube.occupied = true;
    }

    public void createShape() {
        setCurrentShape(cubes[4][19]);
        window.createCubeColor(4, 19);
    }

    public boolean moveShapeDown() {
        ArrayList<Cube> newShape = new ArrayList<>();
        for (Cube cube: currentShape) {
            int cubeX = cube.x;
            int cubeY = cube.y;
            if (cubeY - 1 < 0) {
                finalizeShape();
                return false; //shape is blocked and is in its final position
            }
            Cube newCube = cubes[cubeX][cubeY - 1];
            if (newCube.occupied ) {
                finalizeShape();
                return false; //shape is blocked and is in its final position
            }
            newShape.add(newCube);
        }
        window.updateCubeColor(currentShape, newShape);
        updateShape(newShape);

        return true;
    }

    public boolean moveShapeLeft() {
        ArrayList<Cube> newShape = new ArrayList<>();
        for (Cube cube: currentShape) {
            int cubeX = cube.x;
            int cubeY = cube.y;
            if (cubeX - 1 < 0) {
                finalizeShape();
                return false; //shape is blocked and is in its final position
            }
            Cube newCube = cubes[cubeX - 1][cubeY];
            if (newCube.occupied ) {
                finalizeShape();
                return false; //shape is blocked and is in its final position
            }
            newShape.add(newCube);
        }
        window.updateCubeColor(currentShape, newShape);
        updateShape(newShape);

        return true;
    }

    public boolean moveShapeRight() {
        ArrayList<Cube> newShape = new ArrayList<>();
        for (Cube cube: currentShape) {
            int cubeX = cube.x;
            int cubeY = cube.y;
            if (cubeX + 1 < 10) {
                finalizeShape();
                return false; //shape is blocked and is in its final position
            }
            Cube newCube = cubes[cubeX + 1][cubeY];
            if (newCube.occupied ) {
                finalizeShape();
                return false; //shape is blocked and is in its final position
            }
            newShape.add(newCube);
        }
        window.updateCubeColor(currentShape, newShape);
        updateShape(newShape);

        return true;
    }

    private void finalizeShape(){
        for (Cube cube : currentShape) {
            cube.currentShape = false;
        }
        currentShape = new ArrayList<>();
    }

    private void updateShape(ArrayList<Cube> newShape) {
        for (Cube cube : currentShape) {
            cube.occupied = false;
            cube.currentShape = false;
        }

        currentShape = newShape;
        for (Cube cube : newShape) {
            cube.occupied = true;
            cube.currentShape = true;
        }
    }
}
