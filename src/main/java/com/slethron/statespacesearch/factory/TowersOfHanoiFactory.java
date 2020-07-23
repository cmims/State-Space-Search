package com.slethron.statespacesearch.factory;

import com.slethron.statespacesearch.model.TowersOfHanoi;

public class TowersOfHanoiFactory {
    public static TowersOfHanoi generateTowersOfHanoiSolutionForThreeDiscs() {
        var towersOfHanoi = new TowersOfHanoi(3);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(2, 1);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(1, 0);
        towersOfHanoi.moveDisc(1, 2);
        towersOfHanoi.moveDisc(0, 2);
        return towersOfHanoi;
    }

    public static TowersOfHanoi generateTowersOfHanoiSolutionForFourDiscs() {
        var towersOfHanoi = new TowersOfHanoi(4);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(1, 2);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(2, 0);
        towersOfHanoi.moveDisc(2, 1);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(1, 2);
        towersOfHanoi.moveDisc(1, 0);
        towersOfHanoi.moveDisc(2, 0);
        towersOfHanoi.moveDisc(1, 2);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(1, 2);
        return towersOfHanoi;
    }

    public static TowersOfHanoi generateTowersOfHanoiSolutionForFiveDiscs() {
        var towersOfHanoi = new TowersOfHanoi(5);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(2, 1);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(1, 0);
        towersOfHanoi.moveDisc(1, 2);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(2, 1);
        towersOfHanoi.moveDisc(2, 0);
        towersOfHanoi.moveDisc(1, 0);
        towersOfHanoi.moveDisc(2, 1);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(2, 1);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(1, 0);
        towersOfHanoi.moveDisc(1, 2);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(1, 0);
        towersOfHanoi.moveDisc(2, 1);
        towersOfHanoi.moveDisc(2, 0);
        towersOfHanoi.moveDisc(1, 0);
        towersOfHanoi.moveDisc(1, 2);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(0, 1);
        towersOfHanoi.moveDisc(2, 1);
        towersOfHanoi.moveDisc(0, 2);
        towersOfHanoi.moveDisc(1, 0);
        towersOfHanoi.moveDisc(1, 2);
        towersOfHanoi.moveDisc(0, 2);
        return towersOfHanoi;
    }
}
