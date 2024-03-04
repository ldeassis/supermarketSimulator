package ia.nimoy;

import java.util.ArrayList;
import java.util.List;

public class itemlist {
    private ArrayList<Item> items;
    private int Num_FRUTAS;
    private int Num_LEGUMES;
    private int Num_CARNES;

    /**
     * Initializes a new instance of the ItemList class.
     * This constructor initializes the items list and sets the initial counts of FRUTAS, LEGUMES, and CARNES to zero.
     */
    void ItemList() {
        this.items = new ArrayList<>();
        this.Num_FRUTAS = 0;
        this.Num_LEGUMES = 0;
        this.Num_CARNES = 0;
    }

    /**
     * Adds an item to the item list and updates the category counters accordingly.
     * 
     * @param item the item to be added
     */
    public void addItem(Item item) {
        this.items.add(item);
        if (item.getCategory() == Category.FRUTAS) {
            this.Num_FRUTAS++;
        } else if (item.getCategory() == Category.LEGUMES) {
            this.Num_LEGUMES++;
        } else if (item.getCategory() == Category.CARNES) {
            this.Num_CARNES++;
        }
    }

    /**
     * Returns the list of items.
     *
     * @return the list of items
     */
    public ArrayList<Item> getItemList() {
        return this.items;
    }

    /**
     * Returns the number of FRUTAS.
     *
     * @return the number of FRUTAS
     */
    public int getNum_FRUTAS() {
        return this.Num_FRUTAS;
    }
    /**
     * Returns the number of LEGUMES.
     *
     * @return the number of LEGUMES
     */
    public int getNum_LEGUMES() {
        return this.Num_LEGUMES;
    }
    /**
     * Returns the number of CARNES.
     *
     * @return the number of CARNES
     */
    public int getNum_CARNES() {
        return this.Num_CARNES;
    }
        
    /**
     * Creates a family shopping list.
     * This method returns a list of items that includes fruits, vegetables, and meats.
     * Each item is represented by its name, quantity, price, and expiration date.
     * 
     * @return the list of items for the family shopping list
     */
    public void createFamilyShoppingList() {
        this.items = new ArrayList<>();

        // Frutas
        // Item(String description, int quantity, double price, String category, double checkoutTime)
        this.items.add(new Item("Maçã", 2, 2.00, Category.FRUTAS, 4));
        this.items.add(new Item("penca de Banana", 2, 1.50, Category.FRUTAS, 4));
        this.items.add(new Item("Laranja", 2, 1.00, Category.FRUTAS, 4));
        this.items.add(new Item("Pera", 2, 2.50, Category.FRUTAS, 4));
        this.items.add(new Item("Abacaxi", 1, 5.00, Category.FRUTAS, 8));
        this.items.add(new Item("Mamão", 1, 4.00, Category.FRUTAS, 8));
        this.items.add(new Item("Melão", 1, 10.00, Category.FRUTAS, 12));
        this.items.add(new Item("Uva", 1, 5.00, Category.FRUTAS, 8));
        this.items.add(new Item("Caixa com Morangos", 1, 7.00, Category.FRUTAS, 10));
        this.items.add(new Item("Mamão", 1, 4.00, Category.FRUTAS, 8));
        this.items.add(new Item("Melão", 1, 10.00, Category.FRUTAS, 12));

        // Legumes
        this.items.add(new Item("Tomate", 2, 3.00, Category.LEGUMES, 4));
        this.items.add(new Item("Cebola", 2, 2.00, Category.LEGUMES, 4));
        this.items.add(new Item("Batata", 2, 2.50, Category.LEGUMES, 4));
        this.items.add(new Item("Cenoura", 2, 1.50, Category.LEGUMES, 4));
        this.items.add(new Item("Alface", 1, 2.00, Category.LEGUMES, 4));
        this.items.add(new Item("Repolho", 1, 3.00, Category.LEGUMES, 6));
        this.items.add(new Item("Couve", 1, 2.00, Category.LEGUMES, 4));
        this.items.add(new Item("Pepino", 1, 3.00, Category.LEGUMES, 6));
        this.items.add(new Item("Cebolinha", 2, 2.00, Category.LEGUMES, 4));
        this.items.add(new Item("Alho", 1, 3.00, Category.LEGUMES, 6));
        this.items.add(new Item("Gengibre", 1, 4.00, Category.LEGUMES, 8));
        this.items.add(new Item("Pimentão", 1, 3.00, Category.LEGUMES, 6));
        this.items.add(new Item("Abobrinha", 1, 3.00, Category.LEGUMES,  6));
        this.items.add(new Item("Couve-flor", 1, 2.00, Category.LEGUMES, 4));
        this.items.add(new Item("Rúcula", 1, 2.00, Category.LEGUMES, 4));
        this.items.add(new Item("Brócolis", 1, 3.00, Category.LEGUMES, 6));
        
        // carnes
        this.items.add(new Item("Carne de boi", 2, 20.00, Category.CARNES, 10));
        this.items.add(new Item("Carne de porco", 2, 15.00, Category.CARNES, 8));
        this.items.add(new Item("Carne de frango", 2, 10.00, Category.CARNES, 6));
        this.items.add(new Item("Frango", 2, 10.00, Category.CARNES, 6));
        this.items.add(new Item("Peixe", 2, 15.00, Category.CARNES, 8));
        this.items.add(new Item("Bacalhau", 2, 20.00, Category.CARNES, 10));
        this.items.add(new Item("Salmão", 2, 25.00, Category.CARNES, 12));
        this.items.add(new Item("Camarão", 2, 20.00, Category.CARNES, 10));
        this.items.add(new Item("Carne de atum", 2, 20.00, Category.CARNES, 10));
        this.items.add(new Item("Carne de siri", 2, 25.00, Category.CARNES, 12));

    }

    /**
     * Inserts an item into the given list of items.
     * If the item already exists in the list, the quantity of the existing item is updated.
     * If the item does not exist, it is added to the list.
     *
     * @param items   the list of items
     * @param newItem the item to be inserted
     * @return true if the item already existed and its quantity was updated, false otherwise
     */
    public static boolean insertItem(List<Item> items, Item newItem) {
        int index = findItemIndex(items, newItem.getDescription());

        if (index != -1) {
            // Item já existe na lista, atualizar a quantidade
            Item existingItem = items.get(index);
            existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
            return true;
        } else {
            // Item não existe, adicionar à lista
            items.add(newItem);
            return false;
        }
    }

    /**
     * Removes an item from the given list based on its description.
     * If the item is found, it is removed from the list.
     *
     * @param items       the list of items
     * @param description the description of the item to be removed
     */
    public static void removeItem(List<Item> items, String description) {
        int index = findItemIndex(items, description);
        if (index != -1) {
            items.remove(index);
        }
    }

    /**
     * Finds the index of an item in a list based on its description.
     *
     * @param items      the list of items to search in
     * @param description the description of the item to find
     * @return the index of the item if found, or -1 if not found
     */
    private static int findItemIndex(List<Item> items, String description) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getDescription().equals(description)) {
                return i;
            }
        }
        return -1;
    }

    
}
