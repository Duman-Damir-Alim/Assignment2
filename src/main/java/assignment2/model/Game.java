package assignment2.model;

import java.util.List;

/**
 * Not tested yet
 */

enum GameStatus {
    ACTIVE,
    BLACK_WIN,
    WHITE_WIN,
    FORFEIT,
    STALEMATE,
    RESIGNATION
}

public class Game {
    private Player player;
    private Board board;
    private GameStatus status;
    private List<Move> movesPlayed;

    public boolean isCurrentTurn() {
        if (!player.isWhiteSide()) {
            return false;
        }
        return true;
    }

    //call this method from outside after make move
    public Board getNewBoard() {
        return board;
    }

    //if isCurrentTurn() true, call this method
    private void initialize(Player player) {
        this.player = player;
        board.resetBoard();
        movesPlayed.clear();
    }

    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(Player player, int startX,
                              int startY, int endX, int endY) throws Exception {
        Spot startBox = board.getBox(startX, startY);
        Spot endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player) throws Exception {
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            return false;
        }

        // valid move?
        if (!sourcePiece.canMove(board, move.getStart(),
                move.getEnd())) {
            return false;
        }

        // kill?
        Piece destPiece = move.getEnd().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        // castling?
//        if (sourcePiece != null && sourcePiece instanceof King
//                && sourcePiece.isCastlingMove()) {
//            move.setCastlingMove(true);
//        }

        // store the move
        movesPlayed.add(move);

        // move piece from the start box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        //update board
        board.getBoxes()[move.getStart().getY()][move.getStart().getX()] =
                board.getBoxes()[move.getEnd().getY()][move.getEnd().getX()];
//Client sends data(board, status) to server. But status is not realized yet TODO
        return true;
//        if (destPiece != null) {
//            if (player.isWhiteSide()) {
//                this.setStatus(GameStatus.WHITE_WIN);
//            }
//            else {
//                this.setStatus(GameStatus.BLACK_WIN);
//            }
//        }

        // set the current turn to the other player
    }
}