package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<Node>();
        List<Node> exploed = new ArrayList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (currentNode.getLabel().equals(goal)) {
                return currentNode;
            }
            exploed.add(currentNode);
            System.out.println(currentNode.getLabel());
            for (Node childNode : currentNode.getChildrenNodes()) {
                if (!frontier.contains(childNode) && (!exploed.contains(childNode))) {
                    childNode.setParent(currentNode);
                    frontier.add(childNode);

                }
            }
        }


//  

        return null;

    }

    private void BFS(Node root) {

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
        BreadthFirstSearchAlgo bfsTest = new BreadthFirstSearchAlgo();

        for (String nodeLabel : test.printPath(bfsTest.execute(nodeS, "G"))
        ) {
            System.out.print(nodeLabel + "->");

        }
    }
}
