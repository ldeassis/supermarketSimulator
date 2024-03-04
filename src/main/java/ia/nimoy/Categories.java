package ia.nimoy;

public class Categories {
    final private Category category;
    private int quantity;

    /**
     * Represents a category of items in a supermarket.
     */
    public Categories(Category category, int quantity) {
        this.category = category;
        this.quantity = quantity;
    }

    /**
     * Returns the category of the object.
     *
     * @return the category of the object
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Returns the quantity of the category.
     *
     * @return the quantity of the category
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity of the category.
     *
     * @param quantity the new quantity value
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
