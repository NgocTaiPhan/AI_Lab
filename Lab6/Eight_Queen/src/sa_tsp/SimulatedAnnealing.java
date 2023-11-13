package sa_tsp;

public class SimulatedAnnealing {
	public static double simulateAnnealing(double startingTemperature, int numberOfIterations, double coolingRate) {
		System.out.println("Starting SA with temperature: " + startingTemperature + ", # of iterations: "
				+ numberOfIterations + " and colling rate: " + coolingRate);
		Travel travel = new Travel(10);
		double t = startingTemperature;
		travel.generateInitialTravel();
		double bestDistance = travel.getDistance();
		System.out.println("Initial distance of travel: " + bestDistance);
		Travel bestSolution = travel;
		Travel currentSolution = bestSolution;

		for (int i = 0; i < numberOfIterations; i++) {
			if (t == 0) {
				return currentSolution.getDistance();
			} else {
				currentSolution.swapCities();
				double currentDistance = currentSolution.getDistance();
				if (currentDistance < bestDistance) {// better solution is found
					bestDistance = currentDistance;
				} else if (Math.exp((bestDistance - currentDistance) / t) < Math.random()) {
					//if (e^((bestDistance - currentDistance) / t) > math.random([0, 1))
					//==> accept current solution.
					currentSolution.revertSwap();
				}
				t *= coolingRate;
			}
			//for printing temperature t
			if (i % 100 == 0) {
				System.out.println("Iteration #" + i + " t: " + t);
			}
		}
		return bestDistance;
	}

	public static void main(String[] args) {
		double best = SimulatedAnnealing.simulateAnnealing(10, 10000, 0.9995);
		System.out.println(best);
	}
}
