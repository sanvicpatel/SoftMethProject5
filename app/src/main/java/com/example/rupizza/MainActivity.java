package com.example.rupizza;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends Activity implements RecyclerViewInterface {

    ArrayList<PizzasModel> pizzaTypes = new ArrayList<>();
    int[] imageIndexes = {
            R.drawable.chicagodeluxe,
            R.drawable.newyorkdeluxe,
            R.drawable.chicagobbqchicken,
            R.drawable.newyorkbbqchicken,
            R.drawable.chicagomeatzza,
            R.drawable.newyorkmeatzza,
            R.drawable.chicagobuildyourown,
            R.drawable.newyorkbuildyourown,
            R.drawable.blackimage,
            R.drawable.blackimage
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        String[] pizzaNames = getResources().getStringArray(R.array.pizzas);

        for(int i = 0; i < pizzaNames.length; i++) {
            pizzaTypes.add(new PizzasModel(pizzaNames[i], imageIndexes[i]));
        }

        RecyclerView recycler = findViewById(R.id.options);
        PizzaRecyclerViewAdaptor adaptor = new PizzaRecyclerViewAdaptor(this, this.pizzaTypes, this);
        recycler.setAdapter(adaptor);
        recycler.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void onItemClick(int position) {
        // Pizza options
        if(position < this.pizzaTypes.size() - 2) { // Only the available pizza options.
            PizzasModel selectedPizza = this.pizzaTypes.get(position);

            Intent intent = new Intent(this, OrderViewActivity.class);
            intent.putExtra("pizzaname", selectedPizza.getPizzaName());
            startActivity(intent);
        }

        // Current Order
        else if(position == this.pizzaTypes.size()-2) {
            Context context = getApplicationContext();
            CharSequence text = "Submit an order to continue.";

           if(Constants.currentOrder == null || Constants.currentOrder.isEmpty()) {

                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                return;
           }

           Intent intent = new Intent(this, CurrentOrderActivity.class);
           Toast.makeText(context, "coming here", Toast.LENGTH_SHORT).show();
           startActivity(intent);
        }

        // Store Order
        else {
            Intent intent = new Intent(this, StoreOrderActivity.class);
            startActivity(intent);
        }


    }
}
