package com.designpatterns.structural.flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * When drawing a forest with a huge number of trees, storing data for each tree
 * can consume a lot of memory. The Flyweight pattern helps to minimize memory usage,
 * by sharing as much data as possible with similar objects. In this example, the TreeType
 * class represents the intrinsic state (shared data) of a tree, while the Tree class
 * represents the extrinsic state (unique data) of a tree. The TreeFactory class ensures that
 * only one instance of each TreeType is created and shared among multiple Tree objects.
 */
public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}
