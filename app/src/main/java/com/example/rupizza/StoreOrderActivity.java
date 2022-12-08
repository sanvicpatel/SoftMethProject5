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

/**
 * The Store Order activity.
 *
 * @author Ashrit Yarava, Sanvi Patel
 */
public class StoreOrderActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner orderIdList;
    private ListView storeOrdersDisplay;
    private ArrayAdapter<Pizza> list;
    private TextView orderTotalDisplay;
    private ArrayAdapter<Integer> adapter;

    /**
     * The On Create method for the activity.
     *
     * @param savedInstanceState The saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
        orderIdList = findViewById(R.id.orderNumChoose);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Constants.orders.getOrderIDList());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderIdList.setAdapter(adapter);
        orderIdList.setOnItemSelectedListener(this);

        storeOrdersDisplay = (ListView) findViewById(R.id.storeOrdersDisplay);
        orderTotalDisplay = (TextView) findViewById(R.id.orderTotalStoreDisplay);
    }

    /**
     * The on Item selected method for when a method is selected.
     *
     * @param parent The adaptor view parent.
     * @param view The view
     * @param position the position
     * @param id the id.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int idNum = (int) orderIdList.getSelectedItem();
        Order selectedOrder = Constants.orders.getOrderSelected(idNum);
        orderTotalDisplay.setText(selectedOrder.getOrderTotal());
        list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectedOrder.getPizzaList());
        storeOrdersDisplay.setAdapter(list);
    }

    /**
     * What to do if nothing is selected.
     *
     * @param adapterView The adaptor view.
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    /**
     * Remove the order button handler.
     *
     * @param view The view.
     */
    public void removeOrder(View view) {
        int idNum = (int) orderIdList.getSelectedItem();
        Constants.orders.remove(Constants.orders.getOrderSelected(idNum));
        if(Constants.orders.getOrderIDList().size() == 0) {
            onBackPressed();
        } else {
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, Constants.orders.getOrderIDList());
            orderIdList.setAdapter(adapter);
            orderIdList.setSelection(0);
            idNum = (int) orderIdList.getSelectedItem();
            Order selectedOrder = Constants.orders.getOrderSelected(idNum);
            orderTotalDisplay.setText(selectedOrder.getOrderTotal());
            list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectedOrder.getPizzaList());
            storeOrdersDisplay.setAdapter(list);
        }
        Toast.makeText(getApplicationContext(), "Removed Order: " + idNum, Toast.LENGTH_SHORT).show();
    }


}
