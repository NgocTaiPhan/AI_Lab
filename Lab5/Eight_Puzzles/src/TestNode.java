public class TestNode {

    public static void main(String[] args) {
        Puzzle p = new Puzzle();
        p.readInput("D:\\WorkSpace\\AI\\AI_Lab\\Lab5\\Eight_Puzzles\\src\\txt\\PuzzleMap.txt",
                "D:\\WorkSpace\\AI\\AI_Lab\\Lab5\\Eight_Puzzles\\src\\txt\\PuzzleGoalState.txt");

        Node initialState = p.getInitialState();
        Node tmp = new Node(initialState);
        System.out.println(initialState.equals(tmp));
//		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
        System.out.println("H: " + initialState.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
        Node re = p.moveWhiteTile(initialState, 'r');

//
        System.out.println(re);
        System.out.println(re.getH());
        System.out.println(initialState);
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

        // System.out.println(p.getInitialState());
        // System.out.println(p.getGoalState());
        //
        // List<Node> children = p.getSuccessors(initialState);
        // System.out.println("Size: "+children.size());
        // for (Node child : children) {
        // System.out.println(child.getH()+" "+p.computeH(child) );
        // }


        p.getInitialState().setH(p.computeH2(p.getInitialState()));
//		Node re2 = new Greedy().execute(p);
//		System.out.println(re2);
        Node re3 = new AStar().execute(p);
        System.out.println(re3);
    }
}
