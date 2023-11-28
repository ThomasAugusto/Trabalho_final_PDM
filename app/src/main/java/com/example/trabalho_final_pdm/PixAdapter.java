package com.example.trabalho_final_pdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho_final_pdm.model.PixItem;

import java.util.List;

public class PixAdapter extends RecyclerView.Adapter<PixAdapter.PixViewHolder> {

    private List<PixItem> pixItemList;

    public PixAdapter(List<PixItem> pixItemList) {
        this.pixItemList = pixItemList;
    }

    @NonNull
    @Override
    public PixViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pixkey_list, parent, false);
        return new PixViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PixViewHolder holder, int position) {
        PixItem pixItem = pixItemList.get(position);
        holder.bind(pixItem);
    }

    @Override
    public int getItemCount() {
        return pixItemList.size();
    }

    public class PixViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, typeTextView, keyTextView;
        ImageView statusImageView;

        public PixViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.list_pix_name);
            typeTextView = itemView.findViewById(R.id.list_pix_type);
            keyTextView = itemView.findViewById(R.id.list_pix_key);
            statusImageView = itemView.findViewById(R.id.item_pix_status);
        }

        public void bind(PixItem pixItem) {
            nameTextView.setText("Nome: " + pixItem.getName());
            typeTextView.setText("Tipo: " + pixItem.getType());
            keyTextView.setText("Chave: " + pixItem.getKey());
            statusImageView.setImageResource(pixItem.isFavorite() ? R.drawable.favorite_true : R.drawable.favorite_false);
        }
    }
}
