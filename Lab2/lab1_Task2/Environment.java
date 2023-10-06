package lab1_Task2;

import lab1_Task1.Environment.LocationState;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState, LocationState locCState,
			LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	private String getLeft(String currentState) {
		String loc = "";
		if (currentState == LOCATION_B) {
			loc = LOCATION_A;
		} else if (currentState == LOCATION_D) {
			loc = LOCATION_C;
		}
		return loc;
	}

	private String getRight(String currentState) {
		String loc = "";
		if (currentState == LOCATION_A) {
			loc = LOCATION_B;
		} else if (currentState == LOCATION_C) {
			loc = LOCATION_D;
		}
		return loc;
	}

	private String getUP(String currentState) {
		String loc = "";
		if (currentState == LOCATION_C) {
			loc = LOCATION_A;
		} else if (currentState == LOCATION_D) {
			loc = LOCATION_B;
		}
		return loc;
	}

	private String getDOWN(String currentState) {
		String loc = "";
		if (currentState == LOCATION_A) {
			loc = LOCATION_C;
		} else if (currentState == LOCATION_B) {
			loc = LOCATION_D;
		}
		return loc;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		// TODO
		if (action == SUCK_DIRT) {
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		} else if (action == MOVE_LEFT) {
			envState.setAgentLocation(getLeft(envState.getAgentLocation()));
		} else if (action == MOVE_RIGHT) {
			envState.setAgentLocation(getRight(envState.getAgentLocation()));
		} else if (action == MOVE_UP) {
			envState.setAgentLocation(getUP(envState.getAgentLocation()));
		}else if(action == MOVE_DOWN) {
			envState.setAgentLocation(getDOWN(envState.getAgentLocation()));
		}
		return envState;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		// TODO
		return new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction + "\nPoint: " + point());

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_D) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}
	int mark = 0;
	public int point() {
		if(agent.execute(getPerceptSeenBy()) == Environment.SUCK_DIRT) {
			this.mark += 500;
		}
		if(agent.execute(getPerceptSeenBy()) == NoOpAction.NO_OP) {
			this.mark -=100;
		}
		else {
			this.mark -=10;
		}
		return  mark;
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
