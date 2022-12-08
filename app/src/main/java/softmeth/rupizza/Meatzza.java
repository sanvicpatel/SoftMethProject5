package softmeth.rupizza;

/**
 * The Meatzza Pizza Type.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public class Meatzza extends Pizza{
    private static final double SMALL_PRICE =  15.99;
    private static final double MEDIUM_PRICE=  17.99;
    private static final double LARGE_PRICE =  19.99;

    /**
     * Constructor for the Meatzza Pizza.
     *
     * @param crust the crust
     */
    public Meatzza (Crust crust) {
        super(crust);

        super.add(Topping.SAUSAGE);
        super.add(Topping.PEPPERONI);
        super.add(Topping.BEEF);
        super.add(Topping.HAM);
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
     * Get the pizza style.
     *
     * @param crust The type of crust.
     * @return The style of the pizza.
     */
    public String getStyle(Crust crust) {
        if(crust.equals(Crust.STUFFED)) {
            return "Chicago Style - Stuffed";
        }
        else return "New York Style - Hand Tossed";
    }

    /**
     * Get the name of the pizza.
     *
     * @return Pizza name.
     */
    public String getName() {
        return "Meatzza";
    }


}
