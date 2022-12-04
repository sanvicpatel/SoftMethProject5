package com.example.rupizza;

import java.util.ArrayList;

/**
 * Keeps track of the current order:
 * * Pizzas
 * * Order Total
 * * Order Number
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public class Order implements Customizeable{
    private ArrayList<Pizza> pizzaList;
    private static int currOrder = 0;
    private int orderNumber;
    private double orderTotal;
    private static final double SALES_TAX = 0.006625;

    /**
     * Constructor for the Order class.
     * Get the order number and create a new arraylist of pizzas.
     */
    public Order() {
        orderNumber = currOrder++;
        pizzaList = new ArrayList<>();
        orderTotal = 0;
    }

    /**
     * Clone constructor for order.
     *
     * @param order The order to clone.
     */
    public Order(Order order) {
        this.pizzaList = (ArrayList<Pizza>) order.pizzaList.clone();
        this.orderNumber = order.getOrderNumber();
        this.orderTotal = order.getOrderTotalDouble();
    }

    /**
     * Clears the order and initializes it as a new order.
     */
    public void newOrder() {
        orderNumber = currOrder++;
        pizzaList = new ArrayList<>();
        orderTotal = 0;
    }

    /**
     * Get the order total as a double.
     *
     * @return The order total.
     */
    public double getOrderTotalDouble() {
        return this.orderTotal;
    }

    /**
     * Adds pizzas to the order. Updates orderTotal.
     *
     * @param obj The Pizza to add.
     * @return True if pizza was added, false otherwise.
     */
    public boolean add(Object obj) {
        if(obj instanceof Pizza) {
            pizzaList.add((Pizza) obj);
            orderTotal += ((Pizza) obj).getSubtotal();
            return true;
        }
        return false;
    }

    /**
     * Remove the pizza from the roder. Updates orderTotal.
     *
     * @param obj Object to remove.
     * @return True if the pizza was removed, false otherwise.
     */
    public boolean remove(Object obj) {
        if(obj instanceof Pizza) {
            orderTotal -= ((Pizza) obj).getSubtotal();
            pizzaList.remove((Pizza) obj);
            return true;
        }
        return false;
    }

    /**
     * Get a list of the pizzas.
     *
     * @return ArrayList of the pizzas in the current order.
     */
    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    /**
     * Get the order number of the current order.
     *
     * @return The order number.
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Checks if the order is empty (no pizzas yet).
     *
     * @return True if there are no pizzas, false otherwise.
     */
    public boolean isEmpty() {
        return pizzaList.isEmpty();
    }

    /**
     * Get the order subtotal.
     *
     * @return String representation of the order subtotal.
     */
    public String getOrderSubTotal() {
        String output = String.format("%.2f",
                ((int)(orderTotal * 100) / 100.0));
        return output;
    }

    /**
     * Get the order total as a string.
     *
     * @return The order total as a string.
     */
    public String getOrderTotal() {
        String output = String.format("%.2f",
                ((int)(orderTotal*(1+SALES_TAX) * 100) / 100.0));
        return output;
    }

    /**
     * Get the sales tax.
     *
     * @return Sales tax as a string.
     */
    public String getSalesTax() {
        double total = ((int)(orderTotal*SALES_TAX * 100)) / 100.0;
        return String.format("%.2f", total);
    }

    /**
     * Clear the order of all pizzas.
     */
    public void clear() {

        while(pizzaList.size() > 0) {
            pizzaList.remove(0);
        }
        this.orderTotal = 0;
    }

}
