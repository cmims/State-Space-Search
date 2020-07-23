package com.slethron.statespacesearch.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TowersOfHanoi {
    private static final int NUM_TOWERS = 3;
    private List<Stack<Integer>> towers;
    private int numDiscs;

    public TowersOfHanoi(int numDiscs) {
        this.numDiscs = numDiscs;
        towers = new ArrayList<>();

        for (var i = 0; i < getNumTowers(); i++) {
            towers.add(new Stack<>());
        }

        for (var i = numDiscs - 1; i >= 0; i--) {
            towers.get(0).push(i);
        }
    }

    public TowersOfHanoi(TowersOfHanoi towersOfHanoi) {
        numDiscs = towersOfHanoi.numDiscs;
        towers = new ArrayList<>(towersOfHanoi.towers);
        for (var i = 0; i < getNumTowers(); i++) {
            towers.set(i, new Stack<>());
            for (var disc : towersOfHanoi.getTower(i)) {
                getTower(i).add(disc);
            }
        }
    }

    public void moveDisc(int source, int dest) {
        if (source < 0 || source >= getNumTowers()) throw new IndexOutOfBoundsException("Source tower is out of bounds.");
        if (dest < 0 || dest >= getNumTowers()) throw new IndexOutOfBoundsException("Dest tower is out of bounds.");
        if (isTowerEmpty(source)) throw new IllegalStateException("Source tower is empty.");
        if (!isTowerEmpty(dest)
                && getTower(source).peek() > getTower(dest).peek()) {
            throw new IllegalStateException("Cannot place larger disc on smaller disc.");
        }

        getTower(dest).push(getTower(source).pop());
    }

    public boolean isTowerEmpty(int index) {
        return getTower(index).isEmpty();
    }

    public Stack<Integer> getTower(int index) {
        return towers.get(index);
    }

    public int getNumTowers() {
        return NUM_TOWERS;
    }

    public List<Stack<Integer>> getTowers() {
        return towers;
    }

    public int getNumDiscs() {
        return numDiscs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TowersOfHanoi)) return false;
        return towers.equals(((TowersOfHanoi) o).towers);
    }

    @Override
    public int hashCode() {
        return towers.hashCode();
    }

    @Override
    public String toString() {
        return "TowersOfHanoi [" + "towers=" + towers + ", numDiscs=" + numDiscs + "]";
    }
}
