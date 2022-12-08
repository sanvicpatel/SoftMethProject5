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


public class StoreOrderActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner orderIdList;
    private ListView storeOrdersDisplay;
    private ArrayAdapter<Pizza> list;
    private TextView orderTotalDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
        orderIdList = findViewById(R.id.orderNumChoose);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, Constants.orders.getOrderIDList());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderIdList.setAdapter(adapter);
        orderIdList.setOnItemSelectedListener(this);

        storeOrdersDisplay = (ListView) findViewById(R.id.storeOrdersDisplay);
        orderTotalDisplay = (TextView) findViewById(R.id.orderTotalStoreDisplay);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int idNum = (int) orderIdList.getSelectedItem();
        Order selectedOrder = Constants.orders.getOrderSelected(idNum);
        orderTotalDisplay.setText(selectedOrder.getOrderTotal());
        list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectedOrder.getPizzaList());
        storeOrdersDisplay.setAdapter(list);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}


}
