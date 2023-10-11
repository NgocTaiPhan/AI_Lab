package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {


    @Override
    public Node execute(Node root, String goal) {
        List<Node> stack = new ArrayList<>();
        Stack<Node> frontier = new Stack<Node>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.remove(0);

            if (!frontier.contains(currentNode)) {
                frontier.push(currentNode);
                System.out.println(currentNode.getLabel());

                List<Node> childrenNodes = currentNode.getChildrenNodes();

                for (Node childNode : childrenNodes) {
                    if (!frontier.contains(childNode)) {
                        childNode.setParent(currentNode);
                        stack.add(childNode);

                    }
                }
            }
        }
        for (Node goalNode : frontier
        ) {
            if (goalNode.getLabel().equals(goal)) return goalNode;
        }
        return null;
    }

    public static void DFS(Node startNode) {
        List<Node> stack = new ArrayList<>();
        Stack<Node> frontier = new Stack<Node>();

        stack.add(startNode);
        while (!stack.isEmpty()) {
            Node currentNode = stack.remove(0);

            if (!frontier.contains(currentNode)) {
                frontier.push(currentNode);
                System.out.println(currentNode.getLabel());

                List<Node> childrenNodes = currentNode.getChildrenNodes();

                for (Node childNode : childrenNodes) {
                    if (!frontier.contains(childNode)) {
                        childNode.setParent(currentNode);
                        stack.add(childNode);

                    }
                }
            }
        }
    }


    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }

    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        nodeS.addEdge(nodeA, 5);
        nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4);
        nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4);
        nodeB.addEdge(nodeG, 6);

        NodeUtils test = new NodeUtils();
        DepthFirstSearchAlgo dfsTest = new DepthFirstSearchAlgo();

        for (String nodeLabel : test.printPath(dfsTest.execute(nodeS, "G"))
        ) {
            System.out.print(nodeLabel + "->");

        }
    }
}
