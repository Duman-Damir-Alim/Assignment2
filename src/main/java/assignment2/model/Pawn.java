package assignment2.model;

public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white);
    }

//    public Spot[][] move(Board board, Spot start, Spot end) {
//        if (!canMove(board, start, end)) {
//            return board.getBoxes();
//        }
//        Spot[][] spots = board.getBoxes();
//        spots[start.getX()][start.getY()] = new Spot(end.getX(), end.getY(), this);
//        return spots;
//    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        int startx = start.getX();
        int starty = start.getY();

        int x = end.getX();
        int y = end.getY();


        //check for friends
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        //cant go backwards
        if (start.getPiece().isWhite()) {
            if ((y - starty) < 0) {
                return false;
            }
        } else {
            if ((starty - y) < 0) {
                return false;
            }
        }

        //out of bounds check
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }

        //can't go further than 2 cells
        if (Math.abs(y - starty) > 2) {
            return false;
        }

        //diagonal check
        if (Math.abs(x - startx) > 1 && Math.abs(y - starty) > 1) {
            return false;
        }

        return true;
    }
}
