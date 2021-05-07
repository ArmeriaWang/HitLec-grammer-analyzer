package wang.armeria.ast;

import wang.armeria.token.Position;
import wang.armeria.whkcc.Whkcc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ASTree {

    private ASTreeNode root;
    private ASTreeNode latestTerminal = null;
    private final Stack<ASTreeNode> nodeStack;

    public ASTree() {
        nodeStack = new Stack<>();
    }

    public void addTerminalNode(Whkcc.SymbolKind symbolKind, Position position, Object value) {
        switch (symbolKind) {
            case S_CONST_BOOLEAN:
            case S_CONST_FLOAT:
            case S_CONST_INTEGER:
            case S_CONST_STRING:
            case S_ID:
                if (value == null) {
                    throw new IllegalArgumentException("This symbolKind should be with a value! " + symbolKind);
                }
                break;
            default:
                if (value != null) {
                    throw new IllegalArgumentException("Unexpected symbolKind with a value! " + symbolKind + ", " + value);
                }
        }
        ASTreeNode node = new ASTreeNode(symbolKind, position, value);
        latestTerminal = node;
        nodeStack.push(node);
    }

    public void addNonTerminalNode(Whkcc.SymbolKind symbolKind, int reduceSymbolsNum) {
        List<ASTreeNode> children = new ArrayList<>();
        Stack<ASTreeNode> reverse = new Stack<>();
        for (int i = 0; i < reduceSymbolsNum; i++) {
            ASTreeNode child = nodeStack.pop();
            reverse.push(child);
        }
        while (!reverse.empty()) {
            children.add(reverse.pop());
        }
        Position position = reduceSymbolsNum == 0 ? latestTerminal.getPosition() : children.get(0).getPosition();
        ASTreeNode node = new ASTreeNode(symbolKind, position, null);
        node.setChildren(children);
        nodeStack.push(node);
        if (node.getSymbolKind() == Whkcc.SymbolKind.S_PROGRAM) {
            root = node;
        }
    }

    private void printSubtree(ASTreeNode node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(node);
        List<ASTreeNode> children = node.getChildren();
        if (children.size() > 0) {
            for (ASTreeNode child : children) {
                printSubtree(child, depth + 1);
            }
        }
    }

    public void printTree() {
        if (root == null) {
            throw new RuntimeException("Root of the tree is now null!");
        }
        printSubtree(root, 0);
    }

    public Position getLatestPosition() {
        return latestTerminal.getPosition();
    }

}
