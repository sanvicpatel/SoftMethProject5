package com.example.rupizza;

public class PizzasModel {

    String pizzaName;
    int image;

    public PizzasModel(String pizzaName, int image) {
        this.pizzaName = pizzaName;
        this.image = image;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public int getImage() {
        return image;
    }
}
