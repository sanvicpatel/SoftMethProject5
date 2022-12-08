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
 *
 * @author Ashrit Yarava, Sanvi Patel
 */
public class CurrentOrderActivity extends Activity  {

    private ListView pizzaOrdersDisplay;
    private ArrayAdapter<Pizza> list;

    /**
     * The On create method for the activity.
     *
     * @param savedInstanceState The saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);

        list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constants.currentOrder.getPizzaList());

        pizzaOrdersDisplay = (ListView) findViewById(R.id.pizzaOrdersDisplay);
        pizzaOrdersDisplay.setAdapter(list);

        pizzaOrdersDisplay.setOnItemClickListener((adapterView, view, i, l) -> removeOrder(list.getItem(i)));

        updateOrder();
    }

    /**
     * Remove the order.
     *
     * @param pizzaToRemove The pizza to remove.
     */
    public void removeOrder(Pizza pizzaToRemove) {
        Constants.currentOrder.remove(pizzaToRemove);
        updateOrder();
    }

    /**
     * Place the order.
     *
     * @param view The view.
     */
    public void placeOrder(View view) {
        if(Constants.currentOrder.isEmpty()) {
            Context context = getApplicationContext();
            CharSequence text = "Submit an order to continue.";
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            return;
        }

        if(Constants.orders == null) {
            Constants.orders = new StoreOrders();
        }
        Constants.orders.add(Constants.currentOrder);
        Constants.currentOrder = new Order();
        list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constants.currentOrder.getPizzaList());
        updateOrder();
    }

    /**
     * Clear order.
     *
     * @param view The view.
     */
    public void clearOrder(View view) {
        Constants.currentOrder = new Order(Constants.currentOrder);
        Constants.currentOrder.clear();
        list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constants.currentOrder.getPizzaList());
        updateOrder();

        ((TextView) findViewById(R.id.orderNumberPH)).setText("");
    }

    /**
     * Update the order and the asssociated ui elements.
     */
    private void updateOrder() {

        Log.e("UpdateOrder", Constants.currentOrder.getOrderNumber() + "");

        TextView orderNumDisplay = (TextView) findViewById(R.id.orderNumberPH);
        orderNumDisplay.setText(Constants.currentOrder.getOrderNumber() + "");

        pizzaOrdersDisplay.setAdapter(list);

        TextView subtotalDisplay = (TextView) findViewById(R.id.subtotalPlaceHolder);
        subtotalDisplay.setText(Constants.currentOrder.getOrderSubTotal());

        TextView salesTaxDisplay = (TextView) findViewById(R.id.salesTaxPlaceHolder);
        salesTaxDisplay.setText(Constants.currentOrder.getSalesTax());

        TextView orderTotalDisplay = (TextView) findViewById(R.id.orderTotalPlaceHolder);
        orderTotalDisplay.setText(Constants.currentOrder.getOrderTotal());

    }





}
