package com.example.projectutopia.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectutopia.R;
import com.example.projectutopia.model.CategoryItem;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    private final List<CategoryItem> items;

    public InfoAdapter(List<CategoryItem> items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, addressText, contactText, scheduleText;

        public ViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameText);
            addressText = itemView.findViewById(R.id.addressText);
            contactText = itemView.findViewById(R.id.contactText);
            scheduleText = itemView.findViewById(R.id.scheduleText);
        }

        public void bind(CategoryItem item) {
            nameText.setText(item.getName());
            addressText.setText("Address: " + item.getAddress());

            if (item.getContact() != null && !item.getContact().isEmpty()) {
                contactText.setVisibility(View.VISIBLE);
                contactText.setText("Contact: " + item.getContact());
            } else {
                contactText.setVisibility(View.GONE);
            }

            if (item.getSchedule() != null && !item.getSchedule().isEmpty()) {
                scheduleText.setVisibility(View.VISIBLE);
                scheduleText.setText("Schedule: " + item.getSchedule());
            } else {
                scheduleText.setVisibility(View.GONE);
            }

            itemView.setOnClickListener(v -> {
                if (item.getContact() != null && !item.getContact().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + item.getContact()));
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
