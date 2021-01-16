package assignment2.model;

public class Board {
    private Spot[][] boxes;

    public Board() {
        this.resetBoard();
    }

    public Spot[][] getBoxes() {
        return boxes;
    }

    public Spot getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }
        return boxes[x][y];
    }

    public void resetBoard() {
        // initialize white pieces
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, new Pawn(true));
            }
        }
        // initialize black pieces
        for (int i = 6; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, new Pawn(false));
            }
        }

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }
    }
}