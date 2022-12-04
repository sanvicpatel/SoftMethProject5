package com.example.rupizza;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ResourceBundle;

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
            R.drawable.newyorkbuildyourown
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
        Log.i("MAIN", "Hello World!" + position);
    }
}
