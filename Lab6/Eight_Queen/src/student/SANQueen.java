package student;

public class SANQueen {
	public Node execute(Node initialState) {
		double T = 1000.0;
		Node current = initialState;
		Node next = null;
		
		while(current.getH() != 0) {
			if(T==0) {
				return current;
			}
			next = current.selectNextRandomCandidate();
			int deltaE = next.getH() - current.getH();
			if(deltaE < 0) {
				current = next;
			} else if(Math.exp(deltaE/T) > Math.random()) {
				current = next;
			}
			T *= 0.995;
		}
		System.out.println("T= " + T);
		return current;
	}


}
