package com.slethron.statespacesearch.domain.test;

import com.slethron.statespacesearch.Node;
import com.slethron.statespacesearch.StateSpaceSearch;
import com.slethron.statespacesearch.domain.TowersOfHanoiNode;
import com.slethron.statespacesearch.factory.TowersOfHanoiFactory;
import com.slethron.statespacesearch.model.TowersOfHanoi;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TowersOfHanoiNodeTest {
    @Test
    void findBfsPathForThreeDiscs() {
        var numDiscs = 3;
        var startNode = new TowersOfHanoiNode(new TowersOfHanoi(numDiscs));
        var goalNode = new TowersOfHanoiNode(
                TowersOfHanoiFactory.generateTowersOfHanoiSolutionForThreeDiscs());
        var result = StateSpaceSearch.bfs(startNode, goalNode);
        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        printResult(result);
    }

    @Test
    void findBfsPathForFourDiscs() {
        int numDiscs = 4;
        var startNode = new TowersOfHanoiNode(new TowersOfHanoi(numDiscs));
        var goalNode = new TowersOfHanoiNode(
                TowersOfHanoiFactory.generateTowersOfHanoiSolutionForFourDiscs());
        var result = StateSpaceSearch.bfs(startNode, goalNode);
        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        printResult(result);
    }

    @Test
    void findBfsPathForFiveDiscs() {
        var numDiscs = 5;
        var startNode = new TowersOfHanoiNode(new TowersOfHanoi(numDiscs));
        var goalNode = new TowersOfHanoiNode(
                TowersOfHanoiFactory.generateTowersOfHanoiSolutionForFiveDiscs());
        var result = StateSpaceSearch.bfs(startNode, goalNode);
        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        printResult(result);
    }

    @Test
    void findDfsPathForThreeDiscs() {
        var numDiscs = 3;
        var startNode = new TowersOfHanoiNode(new TowersOfHanoi(numDiscs));
        var goalNode = new TowersOfHanoiNode(
                TowersOfHanoiFactory.generateTowersOfHanoiSolutionForThreeDiscs());
        var result = StateSpaceSearch.dfs(startNode, goalNode);
        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        printResult(result);
    }

    @Test
    void findDfsPathForFourDiscs() {
        var numDiscs = 4;
        var startNode = new TowersOfHanoiNode(new TowersOfHanoi(numDiscs));
        var goalNode = new TowersOfHanoiNode(
                TowersOfHanoiFactory.generateTowersOfHanoiSolutionForFourDiscs());
        var result = StateSpaceSearch.dfs(startNode, goalNode);
        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        printResult(result);
    }

    @Test
    void findDfsPathForFiveDiscs() {
        var numDiscs = 5;
        var startNode = new TowersOfHanoiNode(new TowersOfHanoi(numDiscs));
        var goalNode = new TowersOfHanoiNode(
                TowersOfHanoiFactory.generateTowersOfHanoiSolutionForFiveDiscs());
        var result = StateSpaceSearch.dfs(startNode, goalNode);
        assertNotNull(result);
        assertTrue(result.contains(startNode));
        assertTrue(result.contains(goalNode));
        printResult(result);
    }

    private void printResult(List<Node> result) {
        for (var i = 0; i < result.size(); i++) {
            System.out.print("Step #" + i + ": ");
            System.out.println(result.get(i));
        }
    }
}
