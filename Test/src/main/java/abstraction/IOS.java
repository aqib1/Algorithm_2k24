package abstraction;

public class IOS extends Phone implements IRepair {

    @Override
    public void repair() {
        System.out.println("Resting IOS");
    }
}
