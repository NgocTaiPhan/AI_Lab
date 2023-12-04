package game_alphabeta_student;

public class TestABRightToLeftAlgo {
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

        ISearchAlgo alphaBeta = new AlphaBetaSearchAlgo();
        System.out.println("AlphaBeta-Left To Right");
        System.out.print("Node cut: ");
        alphaBeta.execute(A);
        System.out.println("Best next move for A: " + A.getBestNextMove());
        System.out.println("=============");

        AlphaBetaRightToLeftSearchAlgo alphaBeta1 = new AlphaBetaRightToLeftSearchAlgo();
        System.out.println("AlphaBeta-Right To Left");
        System.out.print("Node cut: ");
        alphaBeta1.execute(A);
        System.out.println("Best next move for A: " + A.getBestNextMove());
    }

}