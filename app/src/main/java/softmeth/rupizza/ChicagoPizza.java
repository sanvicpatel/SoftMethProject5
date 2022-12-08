package softmeth.rupizza;

/**
 * Factory Class for creating the different types of pizzas.
 * Chicago Style.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public class ChicagoPizza implements PizzaFactory{

    /**
     * Create a Deluxe Pizza in Chicago Style.
     *
     * @return A Deluxe Chicago Style pizza.
     */
    public Pizza createDeluxe() {
        return new Deluxe(Crust.DEEPDISH);
    }

    /**
     * Create a BBQ Chicken Pizza in Chicago Style.
     *
     * @return A BBQ Chicken Chicago Style pizza.
     */
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.PAN);
    }

    /**
     * Create a Meatzza Pizza in Chicago Style.
     *
     * @return A Meatzza Chicago Style pizza.
     */
    public Pizza createMeatzza() {
        return new Meatzza(Crust.STUFFED);
    }

    /**
     * Create a Custom Pizza in Chicago Style.
     *
     * @return A Custom Chicago Style pizza.
     */
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.PAN);
    }


}
