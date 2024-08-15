package abstraction;

public class TestClass {
    public static void main(String[] args) {
        IRepair phone =  new Android();
        var mobileRepair = new MobileRepair();
        mobileRepair.repair(phone);
        mobileRepair.repair(new Nokia());
        mobileRepair.repair(new IOS());
    }
}
