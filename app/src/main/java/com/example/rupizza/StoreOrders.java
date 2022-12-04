package com.example.rupizza;
import java.io.*;
import java.util.ArrayList;

/**
 * Class to keep track of the store's orders.
 *
 * @author Sanvi Patel, Ashrit Yarava
 */
public class StoreOrders implements Customizeable{
    private ArrayList<Order> orderList;


    /**
     * Constructor for the store orders.
     */
    public StoreOrders() {
        orderList = new ArrayList<>();
    }

    /**
     * Adds a new order to the list of orders.
     *
     * @param obj Object to add.
     * @return True if the order was added, false otherwise.
     */
    public boolean add(Object obj) {
        if(obj instanceof Order) {
            orderList.add((Order) obj);
        }
        return false;
    }

    /**
     * Remove an order from the store's orders.
     *
     * @param obj Object to remove.
     * @return True if the order was removed, false otherwise.
     */
    public boolean remove(Object obj) {
        if(obj instanceof Order) {
            orderList.remove((Order) obj);
        }
        return false;
    }

    /**
     * Clear the store's orders.
     */
    public void clear() {
        orderList.clear();
    }

    /**
     * Get an integer list of all the orders.
     *
     * @return The order numbers as an arraylist.
     */
    public ArrayList<Integer> getOrderIDList() {
        ArrayList<Integer> orderIDList = new ArrayList<>();
        for(int i = 0; i < orderList.size(); i++) {
            orderIDList.add(orderList.get(i).getOrderNumber());
        }
        return orderIDList;
    }

    /**
     * Get the selected order number.
     *
     * @param ID The order's id.
     * @return The Order that matches the id.
     */
    public Order getOrderSelected(int ID) {
        for(int i = 0; i < orderList.size(); i++) {
            if(orderList.get(i).getOrderNumber() == ID) {
                return orderList.get(i);
            }
        }

        return null;
    }

    /**
     * Export the orders to a txt file.
     */
    public void exportOrders() {

        try {
            File file = new File("Store Orders.txt");
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file);

            for(Order order: orderList) {
                writer.println("Order Number: " + order.getOrderNumber());
                for(Pizza pizza: order.getPizzaList()) {
                    writer.println("\t" + pizza);
                }
                writer.println("Order Total: " + order.getOrderTotal());
            }

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
