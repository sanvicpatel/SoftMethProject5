package com.example.rupizza;

/**
 * Interface to allow for addition and removal of toppings.
 *
 * @param <E> The type of object to add and remove.
 * @author Sanvi Patel, Ashrit Yarava
 */
public interface Customizeable<E>{

    /**
     * Add the Object.
     *
     * @param obj Object to add.
     * @return Whether object was added successfully.
     */
    boolean add(Object obj);

    /**
     * Remove the object.
     *
     * @param obj Object to remove.
     * @return Whether object was removed successfully.
     */
    boolean remove(Object obj);
}
