package ia.nimoy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Supermarket {

    private List<Checkout> checkouts;
    private Queue<Customer> customers;
    private SupermarketState state;

    public Supermarket(int numCheckouts) {
        this.checkouts = new ArrayList<>();
        for (int i = 0; i < numCheckouts; i++) {
            checkouts.add(new Checkout());
        }
        this.customers = new LinkedList<>();
        this.state = SupermarketState.CLOSED;
    }

    public void open() {
        if (state == SupermarketState.CLOSED) {
            state = SupermarketState.OPENED;
        } else {
            throw new IllegalStateException("Supermarket is already open");
        }
    }

    public void startClosing() {
        if (state == SupermarketState.OPENED) {
            state = SupermarketState.CLOSING;
        } else {
            throw new IllegalStateException("Supermarket is not open");
        }
    }

    /**
     * Checks if the supermarket can be closed.
     * The supermarket can be closed if there are no customers in the supermarket
     * and all checkouts are not busy.
     *
     * @return true if the supermarket can be closed, false otherwise.
     */
    public boolean canClose() {
        return customers.isEmpty() && checkouts.stream().allMatch(checkout -> !checkout.isBusy());
    }

    public void close() {
        if (state == SupermarketState.CLOSING) {
            if (!customers.isEmpty()) {
                throw new IllegalStateException("Cannot close, there are customers in the queue");
            }
            for (Checkout checkout : checkouts) {
                if (checkout.isBusy()) {
                    throw new IllegalStateException("Cannot close, there is a customer at a checkout");
                }
            }
            state = SupermarketState.CLOSED;
        } else {
            throw new IllegalStateException("Supermarket is not closing");
        }
    }

    public void addCustomer(Customer customer) {
        if (state == SupermarketState.OPENED) {
            customers.add(customer);
        } else {
            throw new IllegalStateException("Cannot add customer, supermarket is not open");
        }
    }

    public void processCustomers() {
        if (state == SupermarketState.OPENED || state == SupermarketState.CLOSING) {
            while (!customers.isEmpty()) {
                for (Checkout checkout : checkouts) {
                    if (!checkout.isBusy()) {
                        checkout.processCustomer(customers.poll());
                    }
                }
            }
        } else {
            throw new IllegalStateException("Cannot process customers, supermarket is closed");
        }
    }

    public SupermarketState getState() {
        return state;
    }

}
