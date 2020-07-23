package com.slethron.statespacesearch.model.test;

import com.slethron.statespacesearch.model.TowersOfHanoi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowersOfHanoiTest {
    private int n;
    private TowersOfHanoi towers;

    @BeforeEach
    void init() {
        n = 3;
        towers = new TowersOfHanoi(n);
    }

    @Test
    void allTowersExceptFirstAreEmptyOnInit() {
        assertFalse(towers.isTowerEmpty(0));
        assertFalse(towers.getTower(0).isEmpty());
        assertTrue(towers.isTowerEmpty(1));
        assertTrue(towers.getTower(1).isEmpty());
        assertTrue(towers.isTowerEmpty(2));
        assertTrue(towers.getTower(2).isEmpty());
    }

    @Test
    void allDiscsPlacedOntoFirstTowerOnInit() {
        assertEquals(n, towers.getTower(0).size());
        assertEquals(0, towers.getTower(1).size());
        assertEquals(0, towers.getTower(2).size());
    }

    @Test
    void moveRingFromEmptyTowerThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> towers.moveDisc(1, 0));
    }

    @Test
    void moveRingOutOfBoundsThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> towers.moveDisc(0, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> towers.moveDisc(3, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> towers.moveDisc(-1, 2));
    }

    @Test
    void moveLargerDiscOnTopOfSmallerDiscThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> {
            towers.moveDisc(0, 1);
            towers.moveDisc(0, 1);
        });
    }

    @Test
    void deepCopy() {
        var towersCopy = new TowersOfHanoi(towers);
        assertEquals(towers.toString(), towersCopy.toString());
        assertEquals(towers.hashCode(), towersCopy.hashCode());
        assertEquals(towers, towersCopy);
        towersCopy.moveDisc(0, 1);
        assertNotEquals(towers, towersCopy);
    }
}
