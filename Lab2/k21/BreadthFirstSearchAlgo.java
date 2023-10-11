package Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		boolean check = false;
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		//
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			List<Edge> path = current.getChildren();
			for (Edge e : path) {
				Node endNode = e.getEnd();
				if (check == false) {
					endNode.setPathCost(e.getBegin().getPathCost() + e.getWeight());
					if (endNode.getLabel().equals(goal)) {
						check = true;
						break;
					}
				}
			}
			List<Node> children = current.getChildrenNodes();
			for (Node child : children) {
				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					child.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean check = false;
		boolean started = false;
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		//
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);
			}
			if (current.getLabel().equals(goal) && started == true)
				return current;
			explored.add(current);
			List<Edge> path = current.getChildren();
			for (Edge e : path) {
				Node endNode = e.getEnd();
				if (check == false && started == true) {
					endNode.setPathCost(e.getBegin().getPathCost() + e.getWeight());
					if (endNode.getLabel().equals(goal)) {
						check = true;
						break;
					}
				}
			}
			List<Node> children = current.getChildrenNodes();
			for (Node child : children) {
				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					child.setParent(current);
				}
			}
		}
		return null;
	}
	// Tree_Search

	@Override
	public Node execute_TreeS(Node root, String goal) {
		// TODO Auto-generated method stub
		boolean visited = false;
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		//
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;
			List<Edge> path = current.getChildren();
			for (Edge e : path) {
				Node endNode = e.getEnd();
				if (visited == false) {
					endNode.setPathCost(e.getBegin().getPathCost() + e.getWeight());
					if (endNode.getLabel().equals(goal)) {
						visited = true;
						break;
					}
				}
			}
			List<Node> children = current.getChildrenNodes();
			ACS_Sort(children);
			for (Node child : children) {
				frontier.add(child);
				if (child.getParent() == null)
					child.setParent(current);
			}
		}
		return null;
	}

	public void ACS_Sort(List<Node> children) {
		// TODO Auto-generated method stub
		Collections.sort(children, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.getLabel().compareTo(o2.getLabel());
			}
		});
	}

	@Override
	public Node execute_TreeS(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean visitedG = false;
		boolean started = false;
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		//
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				current.setParent(null);
			}
			if (current.getLabel().equals(goal) && started == true)
				return current;
			List<Edge> path = current.getChildren();
			for (Edge e : path) {
				Node endNode = e.getEnd();

				if (visitedG == false && started == true) {
					endNode.setPathCost(e.getBegin().getPathCost() + e.getWeight());
					if (endNode.getLabel().equals(goal)) {
						visitedG = true;
						break;
					}
				}
			}
			List<Node> children = current.getChildrenNodes();
			ACS_Sort(children);
			for (Node child : children) {
				frontier.add(child);
				if (child.getParent() == null)
					child.setParent(current);
			}
		}
		return null;
	}

	public static void main(String[] args) {
//		Node nodeS = new Node("S");
//		Node nodeA = new Node("A");
//		Node nodeB = new Node("B");
//		Node nodeC = new Node("C");
//		Node nodeD = new Node("D");
//		Node nodeE = new Node("E");
//		Node nodeF = new Node("F");
//		Node nodeG = new Node("G");
//		Node nodeH = new Node("H");
//		nodeS.addEdge(nodeA, 5);
//		nodeS.addEdge(nodeB, 2);
//		nodeS.addEdge(nodeC, 4);
//		nodeA.addEdge(nodeD, 9);
//		nodeA.addEdge(nodeE, 4);
//		nodeB.addEdge(nodeG, 6);
//		nodeC.addEdge(nodeF, 2);
//		nodeD.addEdge(nodeH, 7);
//		nodeE.addEdge(nodeG, 6);
//		nodeF.addEdge(nodeG, 1);

		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeG = new Node("G");
		nodeS.addEdge(nodeA, 10);
		nodeS.addEdge(nodeE, 11);
		nodeS.addEdge(nodeD, 5);
		nodeA.addEdge(nodeB, 7);
		nodeA.addEdge(nodeC, 4);
		nodeB.addEdge(nodeG, 1);
		nodeE.addEdge(nodeG, 7);
		nodeC.addEdge(nodeG, 3);
		nodeC.addEdge(nodeD, 8);
		nodeC.addEdge(nodeE, 6);
		nodeD.addEdge(nodeA, 6);
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		Node result = algo1.execute(nodeS, "G");
		for (String temp : NodeUtils.printPath(result)) {
			System.out.println(temp);
		}
		System.out.println(result);
		//
//		Node re = algo1.execute_TreeS(nodeS, "G");
//		for (String tem : NodeUtils.printPath(re)) {
//			System.out.println(tem);
//		}
//		System.out.println(re);
		//
//		Node res = algo1.execute_TreeS(nodeS, "A", "G");
//		for (String tem1 : NodeUtils.printPath(res)) {
//			System.out.println(tem1);
//		}
//		System.out.println(res);

	}

}
