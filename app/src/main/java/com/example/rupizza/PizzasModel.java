package com.example.rupizza;

/**
 * The Pizzas Model for the recycler view.
 *
 * @author Ashrit Yarava, Sanvi Patel
 */
public class PizzasModel {

    private String pizzaName;
    private int image;

    /**
     * The Pizzas Model Constructor.
     *
     * @param pizzaName The name of the pizza.
     * @param image The image id of the pizza.
     */
    public PizzasModel(String pizzaName, int image) {
        this.pizzaName = pizzaName;
        this.image = image;
    }

    /**
     * Getter for the pizza name.
     *
     * @return The pizza name.
     */
    public String getPizzaName() {
        return pizzaName;
    }

    /**
     * Getter for the image id.
     *
     * @return The Image id.
     */
    public int getImage() {
        return image;
    }
}
