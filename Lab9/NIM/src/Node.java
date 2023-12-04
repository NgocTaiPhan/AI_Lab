
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
    private List<Integer> data = new ArrayList<Integer>();
    private int value;
    private Node bestNextMove;

    public Node() {
    }

    public Node(Node that) {
        addAll(that.data);
    }

    public void add(Integer val) {
        this.data.add(val);
    }

    public void addAll(List<Integer> data) {
        this.data.addAll(data);
    }

    public void clear() {
        this.data.clear();
    }

    public Integer set(int index, Integer element) {
        return this.data.set(index, element);
    }

    // Get children of the current nodes
    public List<Node> getSuccessors() {
        int first = data.get(0), tokens;
        Node child;
        List<Node> re = new ArrayList<Node>();

        for (int i = 1; i <= first / 2; i++) {
            tokens = first - i;
            if (tokens != i) {
                child = new Node(this);
                child.set(0, tokens);
                child.add(i);
                Collections.sort(child.data, DESCOMPARATOR);
                re.add(child);
            }
        }
        return re;
    }

    // Check whether a node is terminal or not
    public boolean isTerminal() {
        return data.get(0) == 2;
    }

    public int getValue() {
        return isTerminal() ? (data.size() % 2 == 0) ? (value = 0) : (value = 1) : value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getBestNextMove() {
        return bestNextMove;
    }

    public void setBestNextMove(Node bestNextMove) {
        this.bestNextMove = bestNextMove;
    }

    public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    @Override
    public String toString() {
        Collections.sort(this.data, DESCOMPARATOR);
        return this.data.toString();
    }

}