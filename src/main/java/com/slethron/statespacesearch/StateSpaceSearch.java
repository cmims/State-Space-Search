package com.slethron.statespacesearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class StateSpaceSearch {
    public static List<Node> bfs(Node start, Node goal) {
        var q = new ArrayDeque<Node>();
        var visited = new HashSet<>();
        q.add(start);
        while (!q.isEmpty()) {
            var node = q.poll();
            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            if (node.equals(goal)) {
                return getPath(node);
            } else {
                q.addAll(node.getChildren());
            }
        }

        return null;
    }

    private static List<Node> getPath(Node node) {
        if (node != null) {
            var path = new ArrayList<Node>();
            path.add(node);
            while (node.getParent() != null) {
                node = node.getParent();
                path.add(node);
            }

            Collections.reverse(path);

            return path;
        }

        return null;
    }
}
