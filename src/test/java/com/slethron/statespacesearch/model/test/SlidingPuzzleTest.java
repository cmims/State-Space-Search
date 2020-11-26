package com.slethron.statespacesearch.model.test;

import com.slethron.statespacesearch.model.SlidingPuzzle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SlidingPuzzleTest {
    private SlidingPuzzle puzzle;

    @BeforeEach
    void init() {
        puzzle = new SlidingPuzzle(3);
    }

    @Test
    void slideDiscWithoutAdjacentEmptySpaceThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> puzzle.slidePiece(0, 0));
    }

    @Test
    void slideEmptySpaceThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> puzzle.slidePiece(2, 2));
    }

    @Test
    void outOfBoundsSourceThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> puzzle.slidePiece(9));
    }
}
