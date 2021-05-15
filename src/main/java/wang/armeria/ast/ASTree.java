package wang.armeria.ast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import wang.armeria.token.Position;
import wang.armeria.whkcc.Whkcc;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 抽象语法树AST类
 */
public class ASTree {

    private ASTreeNode root;
    private ASTreeNode latestTerminal = null;
    private final Stack<ASTreeNode> nodeStack;

    /**
     * 新建AST
     */
    public ASTree() {
        nodeStack = new Stack<>();
    }

    /**
     * 向AST中添加终结符节点
     *
     * @param symbolKind 符号类型
     * @param position   程序位置
     * @param value      符号语义值（字面值、标识符需要非null值，其他类型传入null）
     */
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
        ASTreeNode node = new ASTreeNode(symbolKind, position, value, -1);
        latestTerminal = node;
        nodeStack.push(node);
    }

    /**
     * 向AST中添加非终结符节点
     *
     * @param symbolKind       符号类型
     * @param reduceSymbolsNum 需要规约的符号数
     */
    public void addNonTerminalNode(Whkcc.SymbolKind symbolKind, int reduceSymbolsNum, int producer) {
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
        ASTreeNode node = new ASTreeNode(symbolKind, position, null, producer);
        node.setChildren(children);
        nodeStack.push(node);
        if (node.getSymbolKind() == Whkcc.SymbolKind.S_PROGRAM) {
            root = node;
        }
    }

    private void printSubtree(ASTreeNode node, Document document, Element father, int sonRank) {
        Element element = node.getDomElement(document, sonRank);
        Element childrenElement = document.createElement("children");
        List<ASTreeNode> children = node.getChildren();
        int rank = 0;
        if (children.size() > 0) {
            for (ASTreeNode child : children) {
                printSubtree(child, document, childrenElement, rank);
                rank++;
            }
        }
        element.appendChild(childrenElement);
        father.appendChild(element);
    }

    /**
     * 按格式打印AST。仅当全部解析完成后才能调用
     *
     * @throws RuntimeException 根节点为null
     */
    public void printTree() {
        if (root == null) {
            throw new RuntimeException("Root of the tree is now null!");
        }
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            if (doc != null) {
                Element ast = doc.createElement("ast");
                printSubtree(root, doc, ast, 0);
                doc.appendChild(ast);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取AST中加入的最新节点的程序位置
     *
     * @return 最新节点的程序位置
     */
    public Position getLatestPosition() {
        return latestTerminal.getPosition();
    }

}
