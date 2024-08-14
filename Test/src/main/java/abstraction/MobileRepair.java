package abstraction;

// SOLID O => open for extension close for modification
public class MobileRepair {

    public void repair(IRepair IRepair) {
        IRepair.repair();
    }
}
