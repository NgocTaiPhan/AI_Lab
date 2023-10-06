package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS implements ISearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        Stack<Node> frontier = new Stack<>();
        List<Node> visitedNode = new ArrayList<Node>();

        frontier.push(root);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();

            if (!visitedNode.contains(currentNode)) {
                visitedNode.add(currentNode);
//                System.out.println(currentNode.getLabel());

                if (currentNode.getLabel().equals(goal)) {
                    return currentNode;
                }

                for (Node childNode : currentNode.getChildrenNodes()) {
                    if (!visitedNode.contains(childNode)) {
                        frontier.push(childNode);
                    }
                }
            }
        }

        return null;
    }
    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }

}
