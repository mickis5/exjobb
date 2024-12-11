import java.util.Random;

public class VendingMachine {
    private int choice = -1; // inget val har gjorts
    private int expectedAmount = 0;
    private boolean paymentMade = false;
    private final Random random = new Random();
    private boolean wrongpay = false;
    private boolean ok = false;
    private boolean harderror = false;
    private int[] pricelist = { 10, 5, 5, 20, 35 };

    public void choose(int userChoice) {
        if (choice != -1) {
            throw new IllegalStateException("choice has already been made.");
        }

        // giltigt intervall (1 till 5)
        if (userChoice < 1 || userChoice > pricelist.length) {
            throw new IllegalArgumentException(
                    "Invalid choice ");
        }

        choice = userChoice;
        expectedAmount = price(choice); // Satt pris baserat pa valet
        System.out.println("Choice made: " + choice + ", Price: " + expectedAmount);
    }

    // get price
    public int price(int item) {
        System.out.println("item?? :" + item);
        return pricelist[item - 1];
    }

    public void cancel() {
        reset();
        System.out.println("Choice cancelled");
    }

    public void pay(int amount) {
        System.out.println("pay method :" + amount + " choice? " + choice);
        if (choice == -1) {
            throw new IllegalStateException("No choice has been made");
        }
        if (amount != expectedAmount) {
            wrongpay = true;
            throw new IllegalArgumentException("Incorrect payment");
        }
        paymentMade = true;
        System.out.println("Payment accepted");
    }

    public void dispense() {
        System.out.println("dispense method " + "choice: " + choice + " payment? " + paymentMade);
        if (choice == -1 || !paymentMade) {
            throw new IllegalStateException("Cannot dispense without a valid choice or payment");
        }
        // if (random.nextDouble() < 0.1) { // Simulera 10 % hardvarufel
        // harderror = true;
        // throw new RuntimeException("Hardware error");
        // }
        ok = true; // Dispensering lyckades
        System.out.println("Product dispensed for choice: " + choice);
        // reset();
    }

    public void reset() {
        choice = -1;
        expectedAmount = 0;
        paymentMade = false;
        ok = false;
        wrongpay = false;
        harderror = false;
    }

    // statusvarden
    public boolean isWrongpay() {
        return wrongpay;
    }

    public boolean isOk() {
        return ok;
    }

    public boolean isHardError() {
        return harderror;
    }

    public int exAmount() {
        return expectedAmount;
    }

    public boolean paymade() {
        return paymentMade;
    }

}
