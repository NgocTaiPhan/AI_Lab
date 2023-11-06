
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStar implements IPuzzleAlgo {

    @Override
    public Node execute(Puzzle model) {
        // TODO Auto-generated method stub
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
        List<Node> explored = new ArrayList<>();
        frontier.add(model.getInitialState());
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.getH() == 0) return current;
            else {
                explored.add(current);
                List<Node> children = model.getSuccessors(current);
                for (Node child : children) {
                    if (!explored.contains(child) && !frontier.contains(child)) {
                        child.setG(current.getG() + 1);
                        frontier.add(child);
                    } else if (frontier.contains(child) && child.getF() > current.getF() + 1) {
                        frontier.remove(child);
                        child.setG(current.getG() + 1);
                        frontier.add(child);
                    }
                }
            }
        }
        return null;
    }

}
