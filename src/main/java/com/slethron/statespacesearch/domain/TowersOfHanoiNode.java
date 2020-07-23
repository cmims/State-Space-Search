package com.slethron.statespacesearch.domain;

import com.slethron.statespacesearch.Node;
import com.slethron.statespacesearch.model.TowersOfHanoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TowersOfHanoiNode extends Node {
    private TowersOfHanoi towers;

    public TowersOfHanoiNode(TowersOfHanoi towersOfHanoi) {
        super(null);
        towers = towersOfHanoi;
    }

    private TowersOfHanoiNode(TowersOfHanoiNode parent) {
        super(parent);
        towers = new TowersOfHanoi(parent.towers);
    }

    @Override
    public List<TowersOfHanoiNode> getChildren() {
        var children = new ArrayList<TowersOfHanoiNode>();
        for (var source = 0; source < towers.getNumTowers(); source++) {
            if (towers.isTowerEmpty(source)) {
                continue;
            }
            for (var dest = 0; dest < towers.getNumTowers(); dest++) {
                if (source == dest) {
                    continue;
                }

                if (!towers.isTowerEmpty(dest)
                        && towers.getTower(source).peek() > towers.getTower(dest).peek()) {
                    continue;
                }
                var child = new TowersOfHanoiNode(this);
                child.towers.moveDisc(source, dest);
                children.add(child);
            }
        }

        return children;
    }

    public TowersOfHanoi getTowers() {
        return towers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(towers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TowersOfHanoiNode)) return false;
        return Objects.equals(towers, ((TowersOfHanoiNode) o).towers);
    }

    @Override
    public String toString() {
        return "TowersOfHanoiNode [towers=" + towers + "]";
    }
}
