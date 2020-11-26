package com.slethron.statespacesearch.domain.test;

import com.slethron.statespacesearch.StateSpaceSearch;
import com.slethron.statespacesearch.domain.SlidingPuzzleNode;
import com.slethron.statespacesearch.factory.SlidingPuzzleFactory;
import com.slethron.statespacesearch.model.SlidingPuzzle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlidingPuzzleNodeTest {
    @Test
    void findBfsPathForSizeThreePuzzle() {
        var size = 3;
        var startNode = new SlidingPuzzleNode(new SlidingPuzzle(size));
        var goalNode = new SlidingPuzzleNode(SlidingPuzzleFactory.generateSolvedSlidingPuzzle(size));
        var result = StateSpaceSearch.bfs(startNode, goalNode);

        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        System.out.println(StateSpaceSearch.describePath(result));
    }

    @Test
    void findBfsPathForSizeFourPuzzle() {
        var size = 4;
        var startNode = new SlidingPuzzleNode(new SlidingPuzzle(size));
        var goalNode = new SlidingPuzzleNode(SlidingPuzzleFactory.generateSolvedSlidingPuzzle(size));
        var result = StateSpaceSearch.bfs(startNode, goalNode);

        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        System.out.println(StateSpaceSearch.describePath(result));
    }

    @Test
    void findBfsPathForSizeFivePuzzle() {
        var size = 5;
        var startNode = new SlidingPuzzleNode(new SlidingPuzzle(size));
        var goalNode = new SlidingPuzzleNode(SlidingPuzzleFactory.generateSolvedSlidingPuzzle(size));
        var result = StateSpaceSearch.bfs(startNode, goalNode);

        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        System.out.println(StateSpaceSearch.describePath(result));
    }

    @Test
    void findDfsPathForSizeThreePuzzle() {
        var size = 3;
        var startNode = new SlidingPuzzleNode(new SlidingPuzzle(size));
        var goalNode = new SlidingPuzzleNode(SlidingPuzzleFactory.generateSolvedSlidingPuzzle(size));
        var result = StateSpaceSearch.dfs(startNode, goalNode);

        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        System.out.println(StateSpaceSearch.describePath(result));
    }

    @Test
    void findDfsPathForSizeFourPuzzle() {
        var size = 4;
        var startNode = new SlidingPuzzleNode(new SlidingPuzzle(size));
        var goalNode = new SlidingPuzzleNode(SlidingPuzzleFactory.generateSolvedSlidingPuzzle(size));
        var result = StateSpaceSearch.dfs(startNode, goalNode);

        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        System.out.println(StateSpaceSearch.describePath(result));
    }

    @Test
    void findDfsPathForSizeFivePuzzle() {
        var size = 5;
        var startNode = new SlidingPuzzleNode(new SlidingPuzzle(size));
        var goalNode = new SlidingPuzzleNode(SlidingPuzzleFactory.generateSolvedSlidingPuzzle(size));
        var result = StateSpaceSearch.dfs(startNode, goalNode);

        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        System.out.println(StateSpaceSearch.describePath(result));
    }
}
