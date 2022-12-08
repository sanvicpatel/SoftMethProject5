package softmeth.rupizza;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * The Order View Activity for the current order.
 *
 * @author Ashrit Yarava, Sanvi Patel
 */
public class OrderViewActivity extends Activity {

    private Intent intent;
    private TextView pizzaName, orderTotal;
    private Spinner pizzaSize;
    private Pizza pizza;
    private ArrayList<CheckBox> toppings = new ArrayList<>();

    /**
     * The On create method for the Order View.
     *
     * @param savedInstanceState The saved instance state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_view);
        intent = getIntent();
        pizzaName = (TextView) findViewById(R.id.pizza_name);

        addToppings();
        pizzaSize = (Spinner) findViewById(R.id.pizza_size);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pizzaSize.setAdapter(adapter);
        pizzaSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * On item selected event handler
             * @param adapterView adapterView
             * @param view Size
             * @param i position
             * @param l id
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                changeSize();
            }
            /**
             * On nothing selected event handler
             * @param adapterView adapterView
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                changeSize();
            }
        });

        orderTotal = (TextView) findViewById(R.id.orderTotal);
        setupPizzaName();
        setupToppings();
        createPizza();
    }

    /**
     * Helper method to add toppings
     */
    private void addToppings() {
        toppings.add((CheckBox) findViewById(R.id.sausage)); // 0
        toppings.add((CheckBox) findViewById(R.id.pepperoni)); // 1
        toppings.add((CheckBox) findViewById(R.id.greenpepper)); // 2
        toppings.add((CheckBox) findViewById(R.id.onion)); // 3
        toppings.add((CheckBox) findViewById(R.id.mushroom)); // 4
        toppings.add((CheckBox) findViewById(R.id.bbqchicken)); // 5
        toppings.add((CheckBox) findViewById(R.id.provolone)); // 6
        toppings.add((CheckBox) findViewById(R.id.cheddar)); // 7
        toppings.add((CheckBox) findViewById(R.id.beef)); // 8
        toppings.add((CheckBox) findViewById(R.id.ham)); // 9
        toppings.add((CheckBox) findViewById(R.id.spinach)); // 10
        toppings.add((CheckBox) findViewById(R.id.pineapple)); // 11
        toppings.add((CheckBox) findViewById(R.id.olives)); // 12
    }

    /**
     * Setup the pizza name.
     */
    private void setupPizzaName() {
        String pizza = intent.getStringExtra("pizzaname");
        pizzaName.setText(pizza);
    }

    /**
     * Setup the toppings checkboxes.
     */
    private void setupToppings() {
        for(CheckBox topping: toppings) {
            topping.setClickable(false);
        }
        String name = pizzaName.getText().toString();
        if(name.equals("Chicago Style Deluxe")) {
            for(int i: new int[]{Constants.SAUSAGE, Constants.PEPPERONI, Constants.GREENPEPPER,
                    Constants.ONION, Constants.MUSHROOM}) {
                toppings.get(i).setChecked(true);
            }
        } else if(name.equals("New York Deluxe")) {
            for(int i: new int[]{Constants.SAUSAGE, Constants.PEPPERONI,  Constants.GREENPEPPER,
                    Constants.ONION, Constants.MUSHROOM}) {
                toppings.get(i).setChecked(true);
            }
        } else if(name.equals("Chicago BBQ Chicken")) {
            for(int i: new int[]{Constants.BBQCHICKEN, Constants.GREENPEPPER, Constants.PROVOLONE,
                    Constants.CHEDDAR}) {
                toppings.get(i).setChecked(true);
            }
        } else if(name.equals("New York BBQ Chicken")) {
            for(int i: new int[]{Constants.BBQCHICKEN, Constants.GREENPEPPER, Constants.PROVOLONE,
                    Constants.CHEDDAR}) {
                toppings.get(i).setChecked(true);
            }
        } else if(name.equals("Chicago Meatzza")) {
            for(int i: new int[]{Constants.SAUSAGE, Constants.PEPPERONI, Constants.BEEF,
                    Constants.HAM}) {
                toppings.get(i).setChecked(true);
            }
        } else if(name.equals("New York Meatzza")) {
            for(int i: new int[]{Constants.SAUSAGE, Constants.PEPPERONI, Constants.BEEF,
                    Constants.HAM}) {
                toppings.get(i).setChecked(true);
            }
        } else if(name.equals("Chicago Build Your Own") || name.equals("New York Build Your Own")) {
            for(CheckBox topping: toppings) {
                topping.setClickable(true);
            }
        }
    }

    /**
     * Manage the buttons, check off the right elements.
     *
     * @param view The view.
     */
    public void manageButtons(View view) {
        int numSelected = Constants.EMPTY;
        for(CheckBox topping: toppings) {
            if (topping.isChecked())
                numSelected++;
        }
        if(numSelected >= Constants.MAX_TOPPINGS) {
            for (CheckBox topping : toppings)
                if (!topping.isChecked())
                    topping.setClickable(false);
        } else {
            for (CheckBox topping : toppings)
                topping.setClickable(true);
        }
        createPizza();
    }

    /**
     * Change the size of the pizza.
     */
    public void changeSize() {
        createPizza();
    }

    /**
     * Create the pizza with the given options.
     */
    private void createPizza() {
        Size size = Size.valueOf(((String) pizzaSize.getSelectedItem()).toUpperCase());
        switch (pizzaName.getText().toString()) {
            case "Chicago Style Deluxe":
                pizza = new ChicagoPizza().createDeluxe();
                break;
            case "New York Deluxe":
                pizza = new NYPizza().createDeluxe();
                break;
            case "Chicago BBQ Chicken":
                pizza = new ChicagoPizza().createBBQChicken();
                break;
            case "New York BBQ Chicken":
                pizza = new NYPizza().createBBQChicken();
                break;
            case "Chicago Meatzza":
                pizza = new ChicagoPizza().createMeatzza();
                break;
            case "New York Meatzza":
                pizza = new NYPizza().createMeatzza();
                break;
            case "Chicago Build Your Own":
                pizza = new ChicagoPizza().createBuildYourOwn();
                selectedToppings();
                break;
            case "New York Build Your Own":
                pizza = new NYPizza().createBuildYourOwn();
                selectedToppings();
                break;
        }
        pizza.setSize(size);
        double total = pizza.getSubtotal();
        total = ((int)(total * Constants.ROUNDER)) / Constants.ROUNDER;
        orderTotal.setText(String.format("$%s", total));
    }

    /**
     * Enable only the selected toppings.
     */
    private void selectedToppings() {
        if(pizzaName.getText().toString().equals("Chicago Build Your Own")
                || pizzaName.getText().toString().equals("New York Build Your Own") ) {
            for (CheckBox topping : toppings) {
                if (topping.isChecked()) {
                    pizza.add(Topping.valueOf(topping.getText().toString()
                            .replaceAll(" ", "").toUpperCase()));
                }
            }
        }
    }

    /**
     * Submit the order. Button event handler.
     *
     * @param view The view.
     */
    public void submitOrder(View view) {
        new AlertDialog.Builder(view.getContext())
                .setTitle("Pizza Submission")
                .setMessage("Are you sure you want to submit this entry?")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    if(Constants.currentOrder == null) {
                        Constants.currentOrder = new Order();
                    }
                    Constants.currentOrder.add(pizza);
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}