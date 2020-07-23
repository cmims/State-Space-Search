package com.slethron.statespacesearch;

import java.util.List;

public abstract class Node {
    private Node parent;

    public Node(Node parent) {
        this.parent = parent;
    }

    Node getParent() {
        return parent;
    }

    public abstract List<? extends Node> getChildren();
}
