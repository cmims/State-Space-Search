package com.slethron.statespacesearch.factory;

import com.slethron.statespacesearch.model.SlidingPuzzle;

public class SlidingPuzzleFactory {
    public static SlidingPuzzle generateSolvedSlidingPuzzle(int size) {
        var slidingPuzzle = new SlidingPuzzle(size);
        var board = slidingPuzzle.getBoard();

        var piece = 1;
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board.length; j++) {
                board[i][j] = piece++;
                if (piece > board.length * board.length) {
                    board[i][j] = 0;
                }
            }
        }

        return slidingPuzzle;
    }
}
