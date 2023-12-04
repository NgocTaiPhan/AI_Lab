package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	@Override
	public void execute(Node node) {
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("The optimal value is:" + v);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal())
			return node.getValue();
		else {
			int v = Integer.MIN_VALUE;
			Node bestMove = null;

			List<Node> successors = node.getChildren();
			List<Node> explored = new ArrayList<>();
			explored.addAll(successors);

			for (Node s : successors) {
				explored.remove(s);
				int minValueResult = minValue(s, alpha, beta);

				if (minValueResult > v) {
					node.setBestNextMove(s);
					v = minValueResult;
					bestMove = s;
				}

				if (v >= beta) {
					for (Node p : explored) {
						print(p);
					}
					return v;
				}
				alpha = Math.max(alpha, v);
			}
			return v;
		}
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal())
			return node.getValue();
		else {
			int v = Integer.MAX_VALUE;
			Node bestMove = null;

			List<Node> successors = node.getChildren();
			List<Node> explored = new ArrayList<>(successors);

			for (Node s : successors) {
				explored.remove(s);
				int maxValueResult = maxValue(s, alpha, beta);

				if (maxValueResult < v) {
					v = maxValueResult;
					bestMove = s;
				}

				if (v <= alpha) {
					// Pruning
					for (Node e : explored) {
						print(e);
					}
					return v;
				}

				beta = Math.min(beta, v);
			}

			return v;
		}
	}


	public void print(Node node) {
		if (node.isTerminal()) {
			System.out.println(node.getLabel() + ":" + node.getValue());
		} else {
			System.out.println(node.getLabel());
			for (Node child : node.getChildren()) {
				if (child.isTerminal()) {
					System.out.println(child.getLabel() + ":" + child.getValue());
					continue;
				}
				print(child);
			}
		}
	}


	public static void main(String[] args) {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		Node I = new Node("I");
		Node J = new Node("J");
		Node K = new Node("K");
		Node L = new Node("L");
		Node M = new Node("M");
		Node N = new Node("N");
		Node O = new Node("O");
		Node P = new Node("P");
		Node Q = new Node("Q");
		Node R = new Node("R");
		Node S = new Node("S");
		Node T = new Node("T");
		Node N0 = new Node("N0",0);
		Node M1 = new Node("M1", 1);
		Node Q1 = new Node("Q1", 1);
		Node T1 = new Node("T1", 1);
		Node L2 = new Node("L2", 2);
		Node P2 = new Node("P2", 2);
		Node K4 = new Node("K4", 4);
		Node O4 = new Node("O4", 4);
		Node S4 = new Node("S4", 4);
		Node R3 = new Node("R3", 3);
		Node T3 = new Node("T3", 3);
		Node N7 = new Node("N7", 7);
		Node S7 = new Node("S7", 7);
		Node Q8 = new Node("Q8", 8);
		Node K9 = new Node("K9", 9);
		Node M10 = new Node("M10", 10);

		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		B.addChild(E);
		B.addChild(F);
		C.addChild(G);
		C.addChild(H);
		D.addChild(I);
		D.addChild(J);
		E.addChild(K);
		E.addChild(L);
		K.addChild(K4);
		K.addChild(K9);
		L.addChild(L2);
		F.addChild(M);
		F.addChild(N);
		M.addChild(M1);
		M.addChild(M10);
		N.addChild(N0);
		N.addChild(N7);
		G.addChild(O);
		O.addChild(O4);
		H.addChild(P);
		H.addChild(Q);
		P.addChild(P2);
		Q.addChild(Q1);
		Q.addChild(Q8);
		I.addChild(R);
		I.addChild(S);
		R.addChild(R3);
		S.addChild(S7);
		S.addChild(S4);
		J.addChild(T);
		T.addChild(T3);
		T.addChild(T1);
		ISearchAlgo alphaBe = new AlphaBetaSearchAlgo();
		System.out.println("AlphaBeta-Left To Right");
		System.out.print("Node cut: ");
		alphaBe.execute(A);
//		System.out.println("Best next move for A: " + A.getBestNextMove());
		System.out.println("=============");
	}

}