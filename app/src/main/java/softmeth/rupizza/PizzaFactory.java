package softmeth.rupizza;

/**
 * Generic Pizza factory for the different types of pizzas a pizza type.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public interface PizzaFactory {
    /**
     * Create a deluxe pizza.
     *
     * @return Return the newly created deluxe pizza.
     */
    Pizza createDeluxe();

    /**
     * Create a Meatzza pizza.
     *
     * @return Return the newly created Meatzza pizza.
     */
    Pizza createMeatzza();

    /**
     * Create a BBQChicken pizza.
     *
     * @return Return the newly created BBQChicken pizza.
     */
    Pizza createBBQChicken();

    /**
     * Create a custom pizza.
     *
     * @return Return the newly created custom pizza.
     */
    Pizza createBuildYourOwn();
}
