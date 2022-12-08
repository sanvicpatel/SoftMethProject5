package com.example.rupizza;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Current Order Activity
 */
public class CurrentOrderActivity extends Activity  {

    private ArrayList<Pizza> pizzaList;
    private ListView pizzaOrdersDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);

        updateOrder();
    }

    public void removeOrder() {
        Pizza pizzaToRemove = (Pizza) pizzaOrdersDisplay.getSelectedItem();
        Constants.currentOrder.remove(pizzaToRemove);
        updateOrder();
    }

    public void placeOrder() {
        if(Constants.currentOrder.isEmpty()) {
            Context context = getApplicationContext();
            CharSequence text = "Submit an order to continue.";
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            return;
        }

        Constants.orders.add(Constants.currentOrder);
        Constants.currentOrder = new Order();
        updateOrder();
    }

    public void clearOrder() {
        Constants.currentOrder = new Order();
        updateOrder();

        ((TextView) findViewById(R.id.orderNumberPH)).setText(" ");
    }

    private void updateOrder() {
        pizzaList = Constants.currentOrder.getPizzaList();

        TextView orderNumDisplay = (TextView) findViewById(R.id.orderNumberPH);
        orderNumDisplay.setText(Constants.currentOrder.getOrderNumber());

        pizzaOrdersDisplay = (ListView) findViewById(R.id.pizzaOrdersDisplay);
        pizzaOrdersDisplay.setAdapter(null);
        ArrayAdapter<Pizza> list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pizzaList);
        pizzaOrdersDisplay.setAdapter(list);

        TextView subtotalDisplay = (TextView) findViewById(R.id.subtotalPlaceHolder);
        subtotalDisplay.setText(Constants.currentOrder.getOrderSubTotal());

        TextView salesTaxDisplay = (TextView) findViewById(R.id.salesTaxPlaceHolder);
        salesTaxDisplay.setText(Constants.currentOrder.getSalesTax());

        TextView orderTotalDisplay = (TextView) findViewById(R.id.orderTotalPlaceHolder);
        orderTotalDisplay.setText(Constants.currentOrder.getOrderTotal());
    }





}
