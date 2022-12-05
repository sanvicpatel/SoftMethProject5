package com.example.rupizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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

        if(position < this.pizzaTypes.size() - 2) { // Only the available pizza options.
            PizzasModel selectedPizza = this.pizzaTypes.get(position);

            Intent intent = new Intent(this, OrderView.class);
            intent.putExtra("pizzaname", selectedPizza.getPizzaName());
            startActivity(intent);
        }


    }
}
