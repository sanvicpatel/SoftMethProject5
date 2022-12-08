package softmeth.rupizza;

/**
 * Factory Class for creating the different types of pizzas.
 * New York Style.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public class NYPizza implements PizzaFactory{

    /**
     * Create a Deluxe Pizza in New York Style.
     *
     * @return A Deluxe New York Style pizza.
     */
    public Pizza createDeluxe() {
        return new Deluxe(Crust.BROOKLYN);
    }

    /**
     * Create a BBQ Chicken Pizza in New York Style.
     *
     * @return A BBQ Chicken New York Style pizza.
     */
    public Pizza createMeatzza() {
        return new Meatzza(Crust.HANDTOSSED);
    }

    /**
     * Create a Meatzza Pizza in New York Style.
     *
     * @return A Meatzza New York Style pizza.
     */
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.THIN);
    }

    /**
     * Create a Custom Pizza in New York Style.
     *
     * @return A Custom New York Style pizza.
     */
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.HANDTOSSED);
    }

}
