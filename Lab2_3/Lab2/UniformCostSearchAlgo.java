package Lab2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		double pathCost = 0;
		root.setPathCost(pathCost);
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		Set<Node> explored = new HashSet<>();
		//
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			explored.add(current);
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					child.setPathCost(current.getPathCost() + edge.getWeight());
					frontier.add(child);
				} else {
					double newPathCost = current.getPathCost() + edge.getWeight();
					if (child.getPathCost() > newPathCost) {
						child.setParent(current);
						child.setPathCost(newPathCost);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		double pathCost = 0;
		root.setPathCost(pathCost);
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		Set<Node> explored = new HashSet<Node>();
		//
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				current.setParent(null);
				current.setPathCost(0);
				frontier.clear();
				explored.clear();
			}
			if (current.getLabel().equals(goal) && started == true)
				return current;
			explored.add(current);
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!explored.contains(child)) {
					if (!frontier.contains(child)) {
						child.setParent(current);
						child.setPathCost(current.getPathCost() + edge.getWeight());
						frontier.add(child);
					} else {
						double newPathCost = current.getPathCost() + edge.getWeight();
						if (child.getPathCost() > newPathCost) {
							child.setPathCost(newPathCost);
							child.setParent(current);

						}
					}
				}
			}

		}
		return null;

	}

	@Override
	public Node execute_TreeS(Node root, String goal) {
		// TODO Auto-generated method stub
		double pathCost = 0;
		root.setPathCost(pathCost);
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		//
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!frontier.contains(child)) {
					child.setParent(current);
					child.setPathCost(current.getPathCost() + edge.getWeight());
					frontier.add(child);

				} else {
					double newPathCost = current.getPathCost() + edge.getWeight();
					if (child.getPathCost() > newPathCost) {
						child.setPathCost(newPathCost);
						child.setParent(current);
						frontier.add(child);
					}
				}
			}
		}

		return null;
	}

	@Override
	public Node execute_TreeS(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		double pathCost = 0;
		root.setPathCost(pathCost);
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		//
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				current.setParent(null);
				current.setPathCost(0);
				frontier.clear();
			}
			if (current.getLabel().equals(goal) && started == true)
				return current;
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!frontier.contains(child)) {
					child.setParent(current);
					child.setPathCost(current.getPathCost() + edge.getWeight());
					frontier.add(child);
				} else {
					double newPathCost = current.getPathCost() + edge.getWeight();
					if (child.getPathCost() > newPathCost) {
						child.setPathCost(newPathCost);
						child.setParent(current);
						frontier.add(child);

					}
				}
			}

		}
		return null;
	}
	
	//Depth-limited search
	@Override
		public Node execute(Node root, String goal, int limitedDepth) {
			Stack<Node> frontier = new Stack<Node>();
			frontier.add(root);
			List<Node> explored = new LinkedList<Node>();
			//
			while(!frontier.isEmpty()) {
				Node current = frontier.pop();
				if(current.getLabel().equals(goal)) return current;
				explored.add(current);
				if(current.getDepth()<limitedDepth) {
				List<Node> children = current.getChildrenNodes();
				Collections.sort(children, new Comparator<Node>() {

					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						return o2.getLabel().compareTo(o1.getLabel());
					}
					
				});
				for (Node child : children) {
				    if(!frontier.contains(child) && !explored.contains(child)) {
				    	frontier.add(child);
				    	child.setParent(current);
				    	child.setDepth(current.getDepth()+1);
				    }
				}
			}
			}
			return null;
		}

	public class NodeComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			if (o1.getPathCost() == o2.getPathCost()) {
				return o1.compareTo(o2);
			}
			return Double.compare(o1.getPathCost(), o2.getPathCost());

		}

	}
	
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
		
//		Node nodeS = new Node("S");
//		Node nodeA = new Node("A");
//		Node nodeB = new Node("B");
//		Node nodeC = new Node("C");
//		Node nodeD = new Node("D");
//		Node nodeE = new Node("E");
//		Node nodeG = new Node("G");
//		nodeS.addEdge(nodeA, 10);
//		nodeS.addEdge(nodeE, 11);
//		nodeS.addEdge(nodeD, 5);
//		nodeA.addEdge(nodeB, 7);
//		nodeA.addEdge(nodeC, 4);
//		nodeB.addEdge(nodeG, 1);
//		nodeE.addEdge(nodeG, 7);
//		nodeC.addEdge(nodeG, 3);
//		nodeC.addEdge(nodeD, 8);
//		nodeC.addEdge(nodeE, 6);
//		nodeD.addEdge(nodeA, 6);
//
		ISearchAlgo algo3 = new UniformCostSearchAlgo();
		//
		Node res = algo3.execute(nodeS, "G");
		for (String temp : NodeUtils.printPath(res)) {
			System.out.println(temp);
		}
		System.out.println(res);
		
//		ISearchAlgo algoUni = new UniformCostSearchAlgo();
//		Node result4 = algoUni.execute(nodeS,"G");
//		System.out.println("Đường đi UCS: ");
//		print(result4);
	}

}
