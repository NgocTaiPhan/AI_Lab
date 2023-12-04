package game_alphabeta_student;

public class Test {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E", 3);
        Node f = new Node("F", 12);
        Node g = new Node("G", 8);
        Node h = new Node("H", 2);
        Node i = new Node("I", 4);
        Node j = new Node("J", 6);
        Node k = new Node("K", 14);
        Node l = new Node("L", 5);
        Node m = new Node("M", 2);

        a.addChild(b);
        a.addChild(c);
        a.addChild(d);
        b.addChild(e);
        b.addChild(f);
        b.addChild(g);
        c.addChild(h);
        c.addChild(i);
        c.addChild(j);
        d.addChild(k);
        d.addChild(l);
        d.addChild(m);

        ISearchAlgo minimax = new MiniMaxSearchAlgo();
        MiniMaxSearchAlgo min = new MiniMaxSearchAlgo();
        System.out.println("Mini Max");
        System.out.println(min.minValue(b));
        minimax.execute(a);
        System.out.println("==============");
        ////
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D", 0);
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G", -5);
        Node H = new Node("H", 3);
        Node I = new Node("I", 8);
        Node J = new Node("J");
        Node K = new Node("K");
        Node L = new Node("L", 2);
        Node M = new Node("M");
        Node N = new Node("N", 4);
        Node O = new Node("O");
        Node P = new Node("P", 9);
        Node Q = new Node("Q", -6);
        Node R = new Node("R", 0);
        Node S = new Node("S", 3);
        Node T = new Node("T", 5);
        Node U = new Node("U", -7);
        Node V = new Node("V", -9);
        Node W = new Node("W", -3);
        Node X = new Node("X", -5);

        A.addChild(B);
        A.addChild(C);
        A.addChild(D);
        A.addChild(E);
        B.addChild(F);
        B.addChild(G);
        C.addChild(H);
        C.addChild(I);
        C.addChild(J);
        E.addChild(K);
        E.addChild(L);
        E.addChild(M);
        F.addChild(N);
        F.addChild(O);
        J.addChild(P);
        J.addChild(Q);
        J.addChild(R);
        K.addChild(S);
        K.addChild(T);
        M.addChild(U);
        M.addChild(V);
        O.addChild(W);
        O.addChild(X);

        ISearchAlgo alphaBeta = new AlphaBetaSearchAlgo();
        System.out.println("AlphaBeta-Left To Right");
        System.out.println("Pruned Node: ");
        alphaBeta.execute(A);
        System.out.println("Best next move for A: " + A.getBestNextMove());
        System.out.println("==============");

//		ISearchAlgo alphaBetarl = new AlphaBetaRightToLeftSearchAlgo();
//		System.out.println("AlphaBeta-Right To Left");
//        System.out.print("Node cut: ");
//		alphaBetarl.execute(A);


    }



}