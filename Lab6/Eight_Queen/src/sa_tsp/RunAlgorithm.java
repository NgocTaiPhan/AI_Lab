package sa_tsp;

//https://www.baeldung.com/java-simulated-annealing-for-traveling-salesman
//other: http://www.theprojectspot.com/tutorial-post/simulated-annealing-algorithm-for-beginners/6
public class RunAlgorithm {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println("Optimized distance for travel: " + SimulatedAnnealing.simulateAnnealing(10, 10000, 0.9995));
	}

}
