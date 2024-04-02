package com.marsha.tugas5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_VIEW_TYPE = 0;
    private static final int ITEM_VIEW_TYPE = 1;

    private Context context;
    private List<Item> itemList;
    private OnItemClickListener listener;

    public ItemAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == HEADER_VIEW_TYPE) {
            View headerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.header_layout, parent, false);
            return new HeaderViewHolder(headerView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_layout, parent, false);
            return new ItemViewHolder(itemView, listener);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ITEM_VIEW_TYPE) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            Item item = itemList.get(position - 1); // Adjust position for header
            itemViewHolder.itemName.setText(item.getName());
            itemViewHolder.itemDescription.setText(item.getDescription());
            itemViewHolder.itemPrice.setText(item.getPrice());

            // Load image using Glide library
            Glide.with(context)
                    .load(item.getImageResourceId())
                    .into(itemViewHolder.itemImage);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size() + 1; // Add 1 for header
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_VIEW_TYPE;
        } else {
            return ITEM_VIEW_TYPE;
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tokoTitle, collaborationText, phoneNumber;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tokoTitle = itemView.findViewById(R.id.tokoTitle);
            collaborationText = itemView.findViewById(R.id.collaborationText);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);

            // Set header text
            tokoTitle.setText("Marugame Udon x Maca");
            collaborationText.setText("Sebuah kolaborasi menu Marugame Udon " +
                    "oleh Chef @marsyacaa__ ");
            phoneNumber.setText("Telepon: 08525300 8870");
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName, itemDescription, itemPrice;

        public ItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemPrice = itemView.findViewById(R.id.itemPrice);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position - 1); // Adjust position for header
                    }
                }
            });
        }
    }
}
