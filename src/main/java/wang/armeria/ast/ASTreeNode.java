package wang.armeria.ast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import wang.armeria.token.Position;
import wang.armeria.whkcc.Whkcc;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象语法树AST节点类
 */
public class ASTreeNode {

    private final Whkcc.SymbolKind symbolKind;
    private final Position position;
    private final Object value;
    private final List<ASTreeNode> children;
    private final int producer;
    private ASTreeNode father;

    /**
     * 新建AST节点
     * @param symbolKind 符号类型
     * @param position 程序位置
     * @param value 符号语义值
     * @param producer 产生式编号（终结符为-1）
     */
    public ASTreeNode(Whkcc.SymbolKind symbolKind, Position position, Object value, int producer) {
        this.symbolKind = symbolKind;
        this.position = position;
        this.value = value;
        this.producer = producer;
        children = new ArrayList<>();
        father = null;
    }

    public int getProducer() {
        return producer;
    }

    /**
     * 获取本节点的符号类型
     * @return 本节点的符号类型
     */
    public Whkcc.SymbolKind getSymbolKind() {
        return symbolKind;
    }

    /**
     * 获取本节点的程序位置
     * @return 本节点程序位置
     */
    public Position getPosition() {
        return position;
    }

    /**
     * 获取本节点的符号语义值
     * @return 本节点的符号语义值（字面值、标识符为非null值，其他类型为null）
     */
    public Object getValue() {
        return value;
    }

    /**
     * 获取本节点的父亲节点
     * @return 本节点的父亲节点（若本节点为根，返回null）
     */
    public ASTreeNode getFather() {
        return father;
    }

    /**
     * 获取本节点的子节点列表
     * @return 本节点的子节点列表（若无子节点，返回空列表）
     */
    public List<ASTreeNode> getChildren() {
        return new ArrayList<>(children);
    }

    /**
     * 为本节点设置子节点，并将子节点列表中节点的父节点全部设置为本节点
     * @param children 子节点列表
     * @throws RuntimeException 本节点已存在非空的子节点列表
     */
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

    /**
     * 按格式生成本节点的输出字符串
     * @return 本节点的输出字符串
     */
    @Override
    public String toString() {
        switch (symbolKind) {
            case S_CONST_BOOLEAN:
            case S_CONST_FLOAT:
            case S_CONST_INTEGER:
            case S_CONST_STRING:
            case S_ID:
                return symbolKind.getName() + ": " + value + " " + position;
        }
        return symbolKind.getName() + " " + position;
    }

    public Element getDomElement(Document document, int rank) {
        Element element = document.createElement("astNode");

        Element symbolKind = document.createElement("symbolKind");
        symbolKind.appendChild(document.createTextNode(String.valueOf(this.symbolKind)));
        element.appendChild(symbolKind);

        Element position = document.createElement("position");
        position.appendChild(document.createTextNode(String.valueOf(this.position)));
        element.appendChild(position);

        Element value = document.createElement("value");
        value.appendChild(document.createTextNode(String.valueOf(this.value)));
        element.appendChild(value);

        Element producer = document.createElement("producer");
        producer.appendChild(document.createTextNode(String.valueOf(this.producer)));
        element.appendChild(producer);

        Element sonRank = document.createElement("sonRank");
        sonRank.appendChild(document.createTextNode(String.valueOf(rank)));
        element.appendChild(sonRank);

        return element;
    }
}
