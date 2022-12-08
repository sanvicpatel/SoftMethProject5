package softmeth.rupizza;

/**
 * Create a custom pizza that the user can add toppings to.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public class BuildYourOwn extends Pizza {
    private static final double SMALL_PRICE =  8.99;
    private static final double MEDIUM_PRICE=  10.99;
    private static final double LARGE_PRICE =  12.99;
    private static final double EXTRA_PRICE = 1.59;

    /**
     * Create a custom pizza with the selected crust type.
     *
     * @param crust The crust.
     */
    public BuildYourOwn(Crust crust) {
        super(crust);
    }

    /**
     * Calculate the price of the pizza without tax.
     *
     * @return Prize of the pizza.
     */
    public double price() {
        double v = this.getNumToppings() * EXTRA_PRICE;
        switch (this.getSize()) {
            case SMALL:
                v += SMALL_PRICE;
                break;
            case MEDIUM:
                v += MEDIUM_PRICE;
                break;
            case LARGE:
                v += LARGE_PRICE;
                break;
        }
        return v;
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
        else return "New York Style - Hand Tossed";
    }

    /**
     * Get the name of the class.
     *
     * @return The string representation of the name of the class.
     */
    public String getName() {
        return "Build Your Own";
    }


}
