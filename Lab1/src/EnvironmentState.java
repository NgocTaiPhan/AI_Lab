
import java.util.HashMap;
import java.util.Map;


public class EnvironmentState {
    private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
    private String agentLocation = null;//

    public EnvironmentState(Environment.LocationState locAState, Environment.LocationState locBState) {
        this.state.put(Environment.LOCATION_A, locAState);
        this.state.put(Environment.LOCATION_B, locBState);
    }

    public void setAgentLocation(String location) {
        this.agentLocation = location;
    }

    public String getAgentLocation() {
        return this.agentLocation;
    }

    public Environment.LocationState getLocationState(String location) {
        return this.state.get(location);
    }

    public void setLocationState(String location, Environment.LocationState locationState) {
        this.state.put(location, locationState);
    }

    public void display() {
        System.out.println("Environment state: \n\t" + this.state);
    }
}