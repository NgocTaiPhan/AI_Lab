package lab1_Task2;

import lab1_Task2.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if (p.getLocationState().equals(LocationState.DIRTY)) {
			return Environment.SUCK_DIRT;
		} else if (p.getAgentLocation().equals(Environment.LOCATION_A)) {
			return Environment.MOVE_RIGHT;
		} else if (p.getAgentLocation().equals(Environment.LOCATION_B)) {
			return Environment.MOVE_DOWN;
		} else if (p.getAgentLocation().equals(Environment.LOCATION_C)) {
			return Environment.MOVE_UP;
		} else if (p.getAgentLocation().equals(Environment.LOCATION_D)) {
			return Environment.MOVE_LEFT;

		}
		return NoOpAction.NO_OP;

	}
}