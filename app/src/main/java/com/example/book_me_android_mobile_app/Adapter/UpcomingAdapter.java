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
import com.example.book_me_android_mobile_app.Model.UpcomingModel;
import com.example.book_me_android_mobile_app.R;

import org.w3c.dom.Text;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {
    private List<UpcomingModel> upcomingList;
    private Context context;
    private OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingAdapter.ViewHolder holder, int position) {
        UpcomingModel upcomingItem = upcomingList.get(position);
        holder.titleTextView.setText(upcomingItem.getTitle());
        holder.dateTextView.setText(upcomingItem.getDate());
        holder.locationTextView.setText(upcomingItem.getLocation());
        holder.statusTextView.setText(upcomingItem.getStatus());
        holder.referenceTextView.setText(upcomingItem.getReference());
        Glide.with(context)
                .load(upcomingItem.getPicResId())
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.placeholder_image)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return upcomingList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(UpcomingModel upcomingItem);
    }
    public UpcomingAdapter(List<UpcomingModel> upcomingList, Context context, OnItemClickListener listener){
        this.upcomingList = upcomingList;
        this.context = context;
        this.listener = listener;
    }

    public class ViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private ImageView imageView;
        private TextView titleTextView;
        private TextView dateTextView;
        private TextView locationTextView;
        private  TextView statusTextView;
        private TextView referenceTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.upcoming_image);
            titleTextView = itemView.findViewById(R.id.upcoming_title);
            dateTextView = itemView.findViewById(R.id.upcoming_date);
            locationTextView = itemView.findViewById(R.id.upcoming_location);
            statusTextView = itemView.findViewById(R.id.upcoming_status);
            referenceTextView = itemView.findViewById(R.id.upcoming_reference);
        }

        @Override
        public void onClick(View v) {
            // Get clicked item position
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                // Invoke onItemClick method of the listener with clicked item
                listener.onItemClick(upcomingList.get(position));
            }
        }
    }
}
