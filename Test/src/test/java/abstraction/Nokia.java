package abstraction;

public class Nokia extends Phone implements IRepair {

    @Override
    public void repair() {
        // clean history
        // clean cache
        // clean ram
        // move cache to L2
        System.out.println("Nokia resetting");
    }
}
