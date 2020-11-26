package com.slethron.statespacesearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static List<Node> dfs(Node start, Node goal) {
        return getPath(
                dfs(start, goal, new HashSet<>())
        );
    }

    private static Node dfs(Node start, Node goal, Set<Node> visited) {
        if (start.equals(goal)) {
            return start;
        } else {
            visited.add(start);
            for (var node : start.getChildren()) {
                if (visited.contains(node)) {
                    continue;
                }
                var result = dfs(node, goal, visited);
                if (result != null) {
                    return result;
                }
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

    public static String describePath(List<Node> path) {
        var sb = new StringBuilder();
        for (var i = 0; i < path.size(); i++) {
            sb.append("Step #")
                    .append(i).append(": ")
                    .append(path.get(i))
                    .append('\n');
        }

        return sb.toString();
    }
}
