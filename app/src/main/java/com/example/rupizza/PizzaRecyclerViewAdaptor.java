package com.example.rupizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaRecyclerViewAdaptor extends RecyclerView.Adapter<PizzaRecyclerViewAdaptor.ViewHandler> {

    Context context;
    ArrayList<PizzasModel> pizzas;
    RecyclerViewInterface viewInterface;

    public PizzaRecyclerViewAdaptor(Context context, ArrayList<PizzasModel> pizzas, RecyclerViewInterface viewInterface) {
        this.context = context;
        this.pizzas = pizzas;
        this.viewInterface = viewInterface;
    }

    /**
     * Inflate the layout and give a look to the rows.
     *
     * @param parent The parent.
     * @param viewType The View Type.
     * @return A View Handler.
     */
    @NonNull
    @Override
    public PizzaRecyclerViewAdaptor.ViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_layout, parent, false);

        return new ViewHandler(view, this.viewInterface);
    }

    /**
     * Assign values to the rows created in the layout file.
     * Based on position of the recycler.
     *
     * @param holder The Holder.
     * @param position The position.
     */
    @Override
    public void onBindViewHolder(@NonNull PizzaRecyclerViewAdaptor.ViewHandler holder, int position) {
        holder.getPizzaName().setText(this.pizzas.get(position).getPizzaName());
        holder.getPizzaImage().setImageResource(this.pizzas.get(position).getImage());
    }

    /**
     * Get the number of items.
     *
     * @return The number of items.
     */
    @Override
    public int getItemCount() {
        return this.pizzas.size();
    }

    /**
     * The View Handler.
     *
     * @author Ashrit Yarava, Sanvi Patel
     */
    public static class ViewHandler extends RecyclerView.ViewHolder {

        ImageView pizzaImage;
        TextView pizzaName;

        /**
         * The view handler constructor.
         *
         * @param itemView The view.
         */
        public ViewHandler(@NonNull View itemView, RecyclerViewInterface viewInterface) {
            super(itemView);

            pizzaImage = itemView.findViewById(R.id.pizza_image);
            pizzaName = itemView.findViewById(R.id.pizza_name);

            itemView.setOnClickListener(view -> {
                if(viewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        viewInterface.onItemClick(pos);
                    }
                }
            });

        }

        /**
         * The getter for the pizza.
         *
         * @return The image view.
         */
        public ImageView getPizzaImage() {
            return pizzaImage;
        }

        /**
         * The text for the box.
         *
         * @return The text view.
         */
        public TextView getPizzaName() {
            return pizzaName;
        }
    }

}
