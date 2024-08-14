package abstraction;

// SOLID, S -> Single responsibility principle


public class Android extends Phone implements IRepair {

    @Override
    public void repair() {
        // clean cache
        // clean history
        // clean ram
        // move cache to L2
        System.out.println("Android resetting");
    }

}
