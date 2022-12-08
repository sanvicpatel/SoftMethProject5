package softmeth.rupizza;

/**
 * Create a Barbeque Chicken Pizza.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public class BBQChicken extends Pizza{
    private static final double SMALL_PRICE =  13.99;
    private static final double MEDIUM_PRICE=  15.99;
    private static final double LARGE_PRICE =  17.99;

    /**
     * Constructor for the BBQ Pizza.
     *
     * @param crust The type of crust to use.
     */
    public BBQChicken(Crust crust) {
        super(crust);

        super.add(Topping.BBQCHICKEN);
        super.add(Topping.GREENPEPPER);
        super.add(Topping.PROVOLONE);
        super.add(Topping.CHEDDAR);
    }

    /**
     * Calculate the price of the pizza without tax.
     *
     * @return Price of the pizza.
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
     * Get the crust style.
     *
     * @param crust The type of crust.
     * @return The string representation of the style of the crust.
     */
    public String getStyle(Crust crust) {
        if(crust.equals(Crust.PAN)) {
            return "Chicago Style - Pan";
        }
        else return "New York Style - Thin";
    }

    /**
     * Get the name of the class.
     *
     * @return The string representation of the name of the class.
     */
    public String getName() {
        return "BBQChicken";
    }


}
