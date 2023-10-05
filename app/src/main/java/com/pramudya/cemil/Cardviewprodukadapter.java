package com.pramudya.cemil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Cardviewprodukadapter extends RecyclerView.Adapter<Cardviewprodukadapter.Cardviewholder> {
    private ArrayList<Produk> listproduk;
    private OnItemClickCallback onItemClickCallback;
    private Context context;

    public Cardviewprodukadapter(Context context, ArrayList<Produk> list) {
        this.context = context;
        this.listproduk = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public Cardviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcardview_produk, parent, false);
        return new Cardviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cardviewholder holder, int position) {
        Produk produk = listproduk.get(position);
        Glide.with(holder.itemView.getContext())
                .load(produk.getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(holder.imgpoto);
        holder.txnama.setText(produk.getNama());
        holder.txdetail.setText(produk.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickCallback != null) {
                    onItemClickCallback.onItemClick(produk);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listproduk.size();
    }

    public class Cardviewholder extends RecyclerView.ViewHolder {
        ImageView imgpoto;
        TextView txnama, txdetail;
        Button btnbaca;

        public Cardviewholder(@NonNull View itemView) {
            super(itemView);
            imgpoto = itemView.findViewById(R.id.iv_item_foto);
            txnama = itemView.findViewById(R.id.tvTitle);
            txdetail = itemView.findViewById(R.id.tvDesk);
            btnbaca = itemView.findViewById(R.id.btnBaca);
        }
    }

    public interface OnItemClickCallback {
        void onItemClick(Produk produk);
    }
}
