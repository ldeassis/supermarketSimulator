package ia.nimoy;

/**
 * The Checkout class represents a checkout counter in a supermarket.
 * It keeps track of whether the checkout counter is currently busy or available,
 * and can process customers by assigning them to the counter.
 */
public class Checkout {
    private boolean isBusy;
    private Customer currentCustomer;

    /**
     * Constructs a new Checkout object with the initial state of not being busy.
     */
    public Checkout() {
        this.isBusy = false;
    }

    /**
     * Checks if the checkout counter is currently busy.
     *
     * @return true if the checkout counter is busy, false otherwise.
     */
    public boolean isBusy() {
        return isBusy;
    }

    /**
     * Processes a customer by assigning them to the checkout counter.
     * Sets the checkout counter to busy while processing the customer's items.
     * Once the customer's items are processed, sets the checkout counter to available.
     *
     * @param customer the customer to be processed.
     */
    public void processCustomer(Customer customer) {
        this.isBusy = true;
        this.currentCustomer = customer;
        // Process the customer's items...
        this.isBusy = false;
    }
}
