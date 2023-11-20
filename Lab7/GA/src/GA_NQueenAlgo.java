import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
    public static final int POP_SIZE = 100;// Population size
    public static final double MUTATION_RATE = 0.03;
    public static final int MAX_ITERATIONS = 1000;
    List<Node> population = new ArrayList<Node>();
    Random rd = new Random();

    public GA_NQueenAlgo() {
        // TODO Auto-generated constructor stub
        initPopulation();
    }
    // initialize the individuals of the population
    public void initPopulation() {
        for (int i = 0; i < POP_SIZE; i++) {
            Node ni = new Node();
            ni.generateBoard();
            population.add(ni);
        }
    }

    public Node execute() {
        // Enter your code here
        initPopulation();
        int k =0;
        while(k++<MAX_ITERATIONS) {
            List<Node> newPopulate= new ArrayList<Node>();
            for(int i=0; i<POP_SIZE; i++) {
                Node x = getParentByRandomSelection();
                Node y = getParentByRandomSelection();
                Node child = reproduce(x, y);
                if(rd.nextDouble() < MUTATION_RATE) {
                    mutate(child);
                }
                if(child.getH()==0) return child;
                newPopulate.add(child);
            }
            population = newPopulate;
        }
        Collections.sort(population);
        return population.get(0);
    }

    // Mutate an individual by selecting a random Queen and
    // move it to a random row.
    public void mutate(Node node) {
        // Enter your code here
        Node n = getParentByRandomSelection();
        n.setRow(rd.nextInt(Node.N), rd.nextInt(Node.N));
    }

    // Crossover x and y to reproduce a child
    public Node reproduce(Node x, Node y) {
        // Enter your code here
        Node child = new Node();
        child.generateBoard();
        int c = rd.nextInt(Node.N);
        System.out.println("C= "+c);
        for(int i=0; i<c; i++) {
            child.setRow(i, x.getRow(i));
        }
        for(int i=c; i<Node.N; i++) {
            child.setRow(i, y.getRow(i));
        }
        return child;
    }

    // Select K individuals from the population at random and
    // select the best out of these to become a parent.
    public Node getParentByTournamentSelection(int k) {
        // Enter your code here
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < k; i++) {
            list.add(population.get(rd.nextInt(Node.N)));
        }
        Collections.sort(list);
        return list.get(0);
    }

    // Select a random parent from the population
    public Node getParentByRandomSelection() {
        // Enter your code here
        return population.get(rd.nextInt(Node.N));
    }

    public static void main(String[] args) {
        GA_NQueenAlgo g = new GA_NQueenAlgo();
//		g.initPopulation();
//		System.out.println("cha");
//		Node x = g.getParentByRandomSelection();
//		x.displayBoard();
//		
//		System.out.println("me");
//		Node y = g.getParentByRandomSelection();
//		y.displayBoard();
//		
//		System.out.println("con");
//		Node z = g.reproduce(x, y);
//		z.displayBoard();

        Node n = g.execute();
        n.displayBoard();
        System.out.println(n.getH());
    }

}