package student;

public class Test {
	public static void main(String[] args) {
		Node initialState = new Node();
		
		System.out.println("======Hill Climbing test part ======");
		HillClimbingSearchQueen hAlgo = new HillClimbingSearchQueen();
		Node res = hAlgo.executeHillClimbingWithRandomRestart(initialState);
//		Node res = hAlgo.execute(initialState);
		System.out.println("Hill Climbing Search: ");
		System.out.println("H: " + res.getH());
		res.displayBoard();
		
		System.out.println();
		System.out.println("======SA test part======");
		SANQueen saAlgo = new SANQueen();
		Node re = saAlgo.execute(initialState);
		System.out.println("SA: ");
		System.out.println("H: " + re.getH());
		re.displayBoard();
	}
}
