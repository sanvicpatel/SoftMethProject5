package com.example.rupizza;

/**
 * The Deluxe Pizza Type.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public class Deluxe extends Pizza{
    private static final double SMALL_PRICE =  14.99;
    private static final double MEDIUM_PRICE =  16.99;
    private static final double LARGE_PRICE =  18.99;

    /**
     * Constructor for the Deluxe Pizza.
     *
     * @param crust the crust name
     */
    public Deluxe (Crust crust) {
        super(crust);

        super.add(Topping.SAUSAGE);
        super.add(Topping.PEPPERONI);
        super.add(Topping.GREENPEPPER);
        super.add(Topping.ONION);
        super.add(Topping.MUSHROOM);
    }

    /**
     * Calculate the subtotal of the pizza.
     *
     * @return The subtotal of the pizza.
     */
    public double price() {
        if (this.getSize() == Size.SMALL) {
            return SMALL_PRICE;
        }
        else if (this.getSize() == Size.MEDIUM) {
            return MEDIUM_PRICE;
        }
        else return LARGE_PRICE;
    }

    /**
     * Returns string representation of the style
     *
     * @return string representation of the style
     */
    public String getStyle(Crust crust) {
        if(crust.equals(Crust.DEEPDISH)) {
            return "Chicago Style - DeepDish";
        }
        else return "New York Style - Brooklyn";
    }

    /**
     * Get the name.
     *
     * @return string the name.
     */
    public String getName() {
        return "Deluxe";
    }



}
