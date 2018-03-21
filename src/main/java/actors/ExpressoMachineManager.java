package actors;

import java.util.ArrayList;
import java.util.List;

public class ExpressoMachineManager {
    private List<ExpressoMachine> expMachines;

    public ExpressoMachineManager() {
        expMachines = new ArrayList<>();
    }

    public void add(ExpressoMachine machine) {
        expMachines.add(machine);
    }

    public List<ExpressoMachine> getAllMachines() {
        return expMachines;
    }

}
