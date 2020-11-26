package com.slethron.statespacesearch.model;

import java.util.Arrays;

public class SlidingPuzzle {
    private int[][] board;

    public SlidingPuzzle(int size) {
        board = new int[size][size];

        var piece = size * size - 1;
        for (var i = 0; i < size; i++) {
            for (var j = 0; j < size; j++) {
                board[i][j] = piece--;
            }
        }
    }

    public SlidingPuzzle(SlidingPuzzle slidingPuzzle) {
        board = new int[slidingPuzzle.board.length][slidingPuzzle.board.length];

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board.length; j++) {
                board[i][j] = slidingPuzzle.board[i][j];
            }
        }
    }

    public void slidePiece(int piece) {
        if (piece == 0) throw new IllegalArgumentException("Cannot move empty space.");
        if (piece < 0 || piece > (board.length * board.length) - 1)
            throw new IndexOutOfBoundsException("Piece does not exist.");

        found: for (var x = 0; x < board.length; x++) {
            for (var y = 0; y < board.length; y++) {
                if (board[x][y] == piece) {
                    slidePiece(x, y);
                    break found;
                }
            }
        }
    }

    public void slidePiece(int sourceX, int sourceY) {
        if (sourceX < 0 || sourceX >= board.length || sourceY < 0 || sourceY >= board.length)
            throw new IndexOutOfBoundsException("Source is out of bounds.");
        if (isSpaceEmpty(sourceX, sourceY)) throw new IllegalArgumentException("Cannot move empty space.");

        if (sourceX > 0 && isSpaceEmpty(sourceX - 1, sourceY)) {
            slidePiece(sourceX, sourceY, sourceX - 1, sourceY);
        } else if (sourceX < board.length - 1 && isSpaceEmpty(sourceX + 1, sourceY)) {
            slidePiece(sourceX, sourceY, sourceX + 1, sourceY);
        } else if (sourceY > 0 && isSpaceEmpty(sourceX, sourceY - 1)) {
            slidePiece(sourceX, sourceY, sourceX, sourceY - 1);
        } else if (sourceY < board.length - 1 && isSpaceEmpty(sourceX, sourceY + 1)) {
            slidePiece(sourceX, sourceY, sourceX, sourceY + 1);
        } else {
            throw new IllegalStateException("There is no empty space next to the piece.");
        }
    }

    private void slidePiece(int sourceX, int sourceY, int emptySpaceX, int emptySpaceY) {
        board[emptySpaceX][emptySpaceY] = board[sourceX][sourceY];
        board[sourceX][sourceY] = 0;
    }

    public boolean isSpaceEmpty(int x, int y) {
        return board[x][y] == 0;
    }

    public int[][] getBoard() {
        return board;
    }

    public String draw() {
        var sb = new StringBuilder();
        for (int[] rows : board) {
            for (var y = 0; y < board.length; y++) {
                sb.append(rows[y]);
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SlidingPuzzle)) return false;

        return Arrays.deepEquals(board, ((SlidingPuzzle) o).board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    @Override
    public String toString() {
        return "SlidingPuzzle [board=" + Arrays.deepToString(board) + "]";
    }
}
