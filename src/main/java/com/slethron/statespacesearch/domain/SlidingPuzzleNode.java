package com.slethron.statespacesearch.domain;

import com.slethron.statespacesearch.Node;
import com.slethron.statespacesearch.model.SlidingPuzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SlidingPuzzleNode extends Node {
    private SlidingPuzzle puzzle;

    public SlidingPuzzleNode(SlidingPuzzle slidingPuzzle) {
        super(null);
        puzzle = slidingPuzzle;
    }

    private SlidingPuzzleNode(SlidingPuzzleNode parent) {
        super(parent);
        puzzle = new SlidingPuzzle(parent.puzzle);
    }

    @Override
    public List<SlidingPuzzleNode> getChildren() {
        var children = new ArrayList<SlidingPuzzleNode>();

        for (var sourceX = 0; sourceX < puzzle.getBoard().length; sourceX++) {
            for (var sourceY = 0; sourceY < puzzle.getBoard().length; sourceY++) {
                if (puzzle.isSpaceEmpty(sourceX, sourceY)) {
                    continue;
                }

                var child = new SlidingPuzzleNode(this);
                try {
                    child.puzzle.slidePiece(sourceX, sourceY);
                } catch (IllegalStateException e) {
                    continue;
                }
                children.add(child);
            }
        }

        return children;
    }

    public SlidingPuzzle getPuzzle() {
        return puzzle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SlidingPuzzleNode)) return false;

        return Objects.equals(puzzle, ((SlidingPuzzleNode) o).puzzle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(puzzle);
    }

    @Override
    public String toString() {
        return "SlidingPuzzleNode [puzzle=" + puzzle + "]";
    }
}
