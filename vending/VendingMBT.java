public class VendingMBT {
    public static VendingMachine getVendingInstance() {
        System.out.println("Using VendingMachine instance from Modbat tests.");
        return VendingModel$.MODULE$.sut(); // Scala-objektets instans
    }
}