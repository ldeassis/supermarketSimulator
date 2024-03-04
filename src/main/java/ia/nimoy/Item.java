package ia.nimoy;

/**
 * Represents an item in a supermarket.
 * An item has a description, quantity, and price.
 * It can be compared to other items based on their total price.
 */
public class Item implements Comparable<Item> {
    private final String description;
    private  int quantity;
    private final double price;
    private final double checkoutTime;
    private final Category category;

    /**
     * Constructs an Item object with the given description, price, and checkout time.
     * The default quantity is set to 1.
     *
     * @param description  the description of the item
     * @param price        the price of the item
     * @param category     the category of the item
     * @param checkoutTime the time needed to perform checkout of the item
     * @throws IllegalArgumentException if the description is null or empty, or if
     *                                  the description is longer than 100
     *                                  characters,
     *                                  or if the quantity is less than or equal to
     *                                  0, or if the quantity is greater than 1000,
     *                                  or if the price is less than 0.01, or if the
     *                                  price is greater than 1,000,000,
     *                                  or if the checkout time is less than or equal to 0,
     *                                  or if the checkout time is greater than 1200
     */
    public Item(String description, double price, Category category, double checkoutTime) {
        this(description, 1, price, category, checkoutTime); // default quantity is 1
    }

    /**
     * Constructs an Item object with the specified description, quantity, price, and checkout time.
     *
     * @param description  the description of the item
     * @param quantity     the quantity of the item
     * @param price        the price of the item
     * @param category     the category of the item
     * @param checkoutTime the time needed to perform checkout of the item
     * @throws IllegalArgumentException if the description is null or empty, or if
     *                                  the description is longer than 100
     *                                  characters,
     *                                  or if the quantity is less than or equal to
     *                                  0, or if the quantity is greater than 1000,
     *                                  or if the price is less than 0.01, or if the
     *                                  price is greater than 1,000,000,
     *                                  or if the checkout time is less than or equal to 0,
     *                                  or if the checkout time is greater than 1200
     */
    public Item(String description, int quantity, double price, Category category, double checkoutTime) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (description.length() > 100) {
            throw new IllegalArgumentException("Description cannot be longer than 100 characters");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (quantity > 1000) {
            throw new IllegalArgumentException("Quantity cannot be greater than 1000");
        }
        if (price < 0.01) {
            throw new IllegalArgumentException("Price must be at least 0.01");
        }
        if (price > 1000000) {
            throw new IllegalArgumentException("Price cannot be greater than 1,000,000");
        }
        if (checkoutTime <= 0) {
            throw new IllegalArgumentException("Checkout time must be greater than 0");
        }
        if (checkoutTime > 1200) {
            throw new IllegalArgumentException("Checkout time cannot be greater than 1200");
        }
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.checkoutTime = checkoutTime;
        this.category = category;
    }

    /**
     * Returns the category of the item.
     *
     * @return the category of the item as a String.
     */
    public Category getCategory() {
        return this.category;
    }   

    /**
     * Returns the description of the item.
     *
     * @return the description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the quantity of the item.
     *
     * @param quantity the new quantity of the item
     */
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the time needed to perform checkout of the item.
     *
     * @return the time needed to perform checkout of the item
     */
    public double getCheckoutTime() {
        return checkoutTime;
    }

    /**
     * Returns the hash code value for this item.
     * The hash code is calculated based on the description, quantity, price, and checkout time of the item.
     *
     * @return the hash code value for this item
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        // Calculate hash code based on description, quantity, price
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + quantity;
        long priceBits = Double.doubleToLongBits(price);
        result = prime * result + (int) (priceBits ^ (priceBits >>> 32));
        return result;
    }

     /**
     * Returns the total price of the item, which is calculated by multiplying the quantity and price.
     *
     * @return the total price of the item
     */
    public double getTotalPrice() {
        return quantity * price;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * 
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (quantity != other.quantity)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }

    /**
     * Compares this item to the specified item for order.
     * Items are compared based on their description, quantity, and price.
     *
     * @param o the item to be compared
     * @return a negative integer, zero, or a positive integer as this item is less
     *         than, equal to, or greater than the specified item
     */
    @Override
    public int compareTo(Item o) {
        // Compare items based on their description
        final int descrptCompare = this.description.compareTo(o.getDescription());
        if (descrptCompare != 0) {
            return descrptCompare;
        }
        // Compare items based on their auantity
        final int quantityCompare = Integer.compare(this.quantity, o.getQuantity());
        if (quantityCompare != 0) {
            return quantityCompare;
        }
        // If the descriptions and quantitiesare the same, compare items based on their
        // price
        final int priceCompare = Double.compare(this.price, o.getPrice());

        return priceCompare;

    }

    /**
     * Returns a string representation of the Item object.
     *
     * @return a string representation of the Item object.
     */
    @Override
    public String toString() {
        return "Item [description=" + description + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
