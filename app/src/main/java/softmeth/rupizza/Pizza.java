package softmeth.rupizza;

import java.util.ArrayList;

/**
 * Abstract class for the each pizza.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public abstract class Pizza implements Customizeable {

    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    private static final double SALES_TAX = 0.006625;

    /**
     * Initialize the pizza with the defined crust.
     *
     * @param crust The crust to use.
     */
    public Pizza(Crust crust) {
        toppings = new ArrayList<>();
        this.crust = crust;
    }

    /**
     * Abstract method for calculating the price.
     *
     * @return The price of the current pizza.
     */
    public abstract double price();

    /**
     * Calculate the subtotal for the pizza. (Not including tax)
     *
     * @return double the subtotal
     */
    public double getSubtotal() {
        return this.price();
    }

    /**
     * Get the size of the pizza.
     *
     * @return Size enum indicating the current size of the pizza.
     */
    public Size getSize() {
        return this.size;
    }

    /**
     * Change the size of the current pizza.
     *
     * @param size The new Size enum to set the pizza to.
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Get the number of toppings in the current pizza.
     *
     * @return The number of toppings in the current pizza.
     */
    public int getNumToppings() {
        return toppings.size();
    }

    /**
     * Add a new topping to the current pizza.
     *
     * @param obj Object to add.
     * @return True if topping was added, false otherwise.
     */
    public boolean add(Object obj) {
        if(obj instanceof Topping) {
            toppings.add((Topping) obj);
        }

        return false;
    }

    /**
     * Remove a topping from the current pizza.
     *
     * @param obj Object to remove.
     * @return True if topping was removed, false otherwise.
     */
    public boolean remove(Object obj) {
        if(obj instanceof Topping) {
            toppings.remove((Topping) obj);
        }
        return false;
    }

    /**
     * Clear all toppings on the pizza.
     */
    public void clear() {
        toppings.clear();
    }

    /**
     * Get the style of the pizza (aka the crust).
     *
     * @param crust The type of crust.
     * @return The string representing the type of crust.
     */
    public abstract String getStyle(Crust crust);

    /**
     * Get the name (flavor) of the pizza.
     *
     * @return The string representation of the name of the pizza.
     */
    public abstract String getName();

    /**
     * Get the string representation of toppings on the pizza.
     *
     * @return The string representation of the toppings on the pizza.
     */
    private String getToppings() {
        String toppingList = "";
        for(int i = 0; i < this.toppings.size(); i++) {
            toppingList += toppings.get(i).name().toLowerCase() + ", ";
        }
        return toppingList;
    }

    /**
     * Get the string type of the crust.
     * 
     * @return String representation of the pizza.
     */
    @Override
    public String toString() {
        String style = this.getStyle(this.crust);
        return this.getName() + " (" + style + ") " + getToppings() + this.size
                + " $" + String.format("%.2f",
                ((int)(this.price() * 100) / 100.0));
    }

    /**
     * Get the image name for the pizza.
     *
     * @return The Image Name of the current pizza.
     */
    public String getImageName() {
        if(this instanceof Deluxe) {
            return "deluxe.png";
        } else if(this instanceof Meatzza) {
            return "meatzza.png";
        } else if(this instanceof BBQChicken) {
            return "bbqchicken.png";
        } else {
            return "buildyourown.png";
        }
    }



}
