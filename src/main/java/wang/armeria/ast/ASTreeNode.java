package wang.armeria.ast;

import wang.armeria.token.Position;
import wang.armeria.whkcc.Whkcc;

import java.util.ArrayList;
import java.util.List;

public class ASTreeNode {

    private final Whkcc.SymbolKind symbolKind;
    private final Position position;
    private final Object value;
    private final List<ASTreeNode> children;
    private ASTreeNode father;

    public ASTreeNode(Whkcc.SymbolKind symbolKind, Position position, Object value) {
        this.symbolKind = symbolKind;
        this.position = position;
        this.value = value;
        children = new ArrayList<>();
        father = null;
    }

    public Whkcc.SymbolKind getSymbolKind() {
        return symbolKind;
    }

    public Position getPosition() {
        return position;
    }

    public Object getValue() {
        return value;
    }

    public ASTreeNode getFather() {
        return father;
    }

    public List<ASTreeNode> getChildren() {
        return new ArrayList<>(children);
    }

    public void setChildren(List<ASTreeNode> children) {
        if (this.children.size() > 0) {
            throw new RuntimeException("This node already have children");
        }
        for (ASTreeNode child : children) {
            if (child.father != null) {
                throw new IllegalArgumentException();
            }
            child.father = this;
        }
        this.children.addAll(children);
    }

    @Override
    public String toString() {
        switch (symbolKind) {
            case S_CONST_BOOLEAN:
            case S_CONST_FLOAT:
            case S_CONST_INTEGER:
            case S_CONST_STRING:
            case S_ID:
                return symbolKind + ": " + value + " " + position;
        }
        return symbolKind + " " + position;
    }
}
