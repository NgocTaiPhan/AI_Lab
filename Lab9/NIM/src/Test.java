import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Node node = new Node();
        MinimaxAlgo algo = new MinimaxAlgo();

        Integer[] data = {7};
        node.addAll(Arrays.asList(data));
        System.out.println("Numbers of tokens = 7");
        algo.execute(node);
        System.out.println("Best next move for MIN: " + node.getBestNextMove());
        System.out.println("========================");

		Integer[] data1 = { 5 };
		node.addAll(Arrays.asList(data1));
		System.out.println("Numbers of tokens = 5");
		algo.execute(node);
		System.out.println("Best next move for MIN: " + node.getBestNextMove());
    }
}