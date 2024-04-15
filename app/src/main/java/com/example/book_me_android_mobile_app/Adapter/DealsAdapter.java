package com.example.book_me_android_mobile_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.book_me_android_mobile_app.Model.DealsModel;
import com.example.book_me_android_mobile_app.R;

import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {

    private List<DealsModel> dealsList;
    private Context context;

    public DealsAdapter(List<DealsModel> dealsList, Context context) {
        this.dealsList = dealsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DealsModel dealItem = dealsList.get(position);
        double price = dealItem.getPrice();

        String formattedPrice;

        // Check if the price has a decimal part of .0 or .5
        if (price % 1 == 0) {
            // Price is a whole number (e.g., 79.0)
            formattedPrice = String.format("$%.0f", price); // Display without decimal places
        } else if (price % 1 == 0.5) {
            // Price has .5 as the decimal part (e.g., 79.5)
            formattedPrice = String.format("$%.1f", price); // Display with one decimal place
        } else {
            // Default case (shouldn't happen if price is properly formatted)
            formattedPrice = String.format("$%.2f", price); // Display with two decimal places
        }
        holder.titleTextView.setText(dealItem.getTitle());
        holder.ratingTextView.setText(dealItem.getRating());
        holder.bestBetweenTextView.setText(dealItem.getBestBetween());
        holder.savesTextView.setText(dealItem.getSaves());
        holder.spacesTextView.setText(dealItem.getSpaces());
        holder.priceTextView.setText(formattedPrice);

        // Load image using Glide or any other image loading library
        Glide.with(context)
                .load(dealItem.getPicResId())
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.placeholder_image)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dealsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTextView;
        private TextView ratingTextView;
        private TextView bestBetweenTextView;
        private TextView savesTextView;
        private TextView spacesTextView;
        private TextView priceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.deals_image);
            titleTextView = itemView.findViewById(R.id.deals_title);
            ratingTextView = itemView.findViewById(R.id.deals_rating);
            bestBetweenTextView = itemView.findViewById(R.id.deals_bestBetween);
            savesTextView = itemView.findViewById(R.id.deals_save);
            spacesTextView = itemView.findViewById(R.id.deals_space);
            priceTextView = itemView.findViewById(R.id.deals_price);
        }
    }
}
