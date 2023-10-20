package Lab2;

public class Test {
	public static void print(Node n) {
		for (String string : NodeUtils.printPath(n)) {
			System.out.print(string + " ");
		}
		System.out.println();
		System.out.print(n);
		System.out.println();

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
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		
		ISearchAlgo algoUni = new UniformCostSearchAlgo();
		Node result5 = algoUni.execute(nodeS,"G",4);
		System.out.println("Depth-limited search:");
		for (String string : NodeUtils.printPath(result5)) {
			System.out.print(string + " ");
		}
		System.out.println();
		System.out.println(result5.getDepth());
	}

}
