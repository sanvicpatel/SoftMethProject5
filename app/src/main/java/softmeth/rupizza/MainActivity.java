package softmeth.rupizza;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * The main activity. Includes the recycler view.
 *
 * @author Ashrit Yarava, Sanvi Patel
 */
public class MainActivity extends Activity implements RecyclerViewInterface {

    private ArrayList<PizzasModel> pizzaTypes = new ArrayList<>();
    private int[] imageIndexes = {
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

    /**
     * On Create method for the activity.
     *
     * @param savedInstanceState The saved instance state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        setupRecyclerView();

    }

    /**
     * Sets up the recycle view with the pizza models.
     */
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

    /**
     * On Item Click handler.
     *
     * @param position The position of the selected item in the recycler view.
     */
    @Override
    public void onItemClick(int position) {
        // Pizza options
        if(position < this.pizzaTypes.size() - 2) { // Only the available pizza options.
            PizzasModel selectedPizza = this.pizzaTypes.get(position);

            Intent intent = new Intent(this, OrderViewActivity.class);
            intent.putExtra("pizzaname", selectedPizza.getPizzaName());
            startActivity(intent);
        }

        else if(position == this.pizzaTypes.size()-2) {
            Context context = getApplicationContext();
            CharSequence text = "Submit an order to continue.";

           if(Constants.currentOrder == null || Constants.currentOrder.isEmpty()) {
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

           } else {
               Intent intent = new Intent(this, CurrentOrderActivity.class);
               Toast.makeText(context, "coming here", Toast.LENGTH_SHORT).show();
               startActivity(intent);
           }
        }

        else {
            Intent intent = new Intent(this, StoreOrderActivity.class);
            startActivity(intent);
        }


    }
}
