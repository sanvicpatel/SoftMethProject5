package com.example.rupizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderView extends Activity {

    Intent intent;
    TextView pizzaName, orderTotal;
    Spinner pizzaSize;
    CheckBox sausage, pepperoni, greenpepper, onion, mushroom, bbqchicken, provolone, cheddar,
            beef, ham, spinach, pineapple, olives;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pizza_view);

        // Title
        intent = getIntent();
        pizzaName = (TextView) findViewById(R.id.pizza_name);

        // Toppings
        sausage = (CheckBox) findViewById(R.id.sausage);
        pepperoni = (CheckBox) findViewById(R.id.pepperoni);
        greenpepper = (CheckBox) findViewById(R.id.greenpepper);
        onion = (CheckBox) findViewById(R.id.onion);
        mushroom = (CheckBox) findViewById(R.id.mushroom);
        bbqchicken = (CheckBox) findViewById(R.id.bbqchicken);
        provolone = (CheckBox) findViewById(R.id.provolone);
        cheddar = (CheckBox) findViewById(R.id.cheddar);
        beef = (CheckBox) findViewById(R.id.beef);
        ham = (CheckBox) findViewById(R.id.ham);
        spinach = (CheckBox) findViewById(R.id.spinach);
        pineapple = (CheckBox) findViewById(R.id.pineapple);
        olives = (CheckBox) findViewById(R.id.olives);

        // Drop Down For Size
        pizzaSize = (Spinner) findViewById(R.id.pizza_size);

        // Order Total
        orderTotal = (TextView) findViewById(R.id.orderTotal);

        setupPizzaName();
        setupToppings();

    }

    private void setupPizzaName() {
        String pizza = intent.getStringExtra("pizzaname");
        pizzaName.setText(pizza);
    }

    private void setupToppings() {
    }

    public void submitOrder(View view) {
        Toast.makeText(view.getContext(), "Placed Order!", Toast.LENGTH_SHORT).show();
    }

}
