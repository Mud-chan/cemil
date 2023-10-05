package com.pramudya.cemil.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pramudya.cemil.Cardviewprodukadapter;
import com.pramudya.cemil.Produk;
import com.pramudya.cemil.R;

import java.util.ArrayList;

public class DaftarprodukFragment extends Fragment {
    private RecyclerView rvProduk;
    private ArrayList<Produk> list = new ArrayList<>();

    public DaftarprodukFragment() {
    }

    public static DaftarprodukFragment newInstance(String param1, String param2) {
        DaftarprodukFragment fragment = new DaftarprodukFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daftarproduk, container, false);
        rvProduk = view.findViewById(R.id.rvProduk);
        rvProduk.setHasFixedSize(true);

        list.addAll(com.pramudya.cemil.Datarproduk.getListData());
        showRecyclerCardView();

        return view;
    }

    private void showRecyclerCardView() {
        rvProduk.setLayoutManager(new LinearLayoutManager(getContext()));
        Cardviewprodukadapter cardviewprodukadapter = new Cardviewprodukadapter(getContext(), list);
        rvProduk.setAdapter(cardviewprodukadapter);

        cardviewprodukadapter.setOnItemClickCallback(new Cardviewprodukadapter.OnItemClickCallback() {
            @Override
            public void onItemClick(Produk produk) {
                Intent intent = new Intent(getContext(), com.pramudya.cemil.detailprodukActivity.class);
                intent.putExtra("nama", produk.getNama());
                intent.putExtra("detail", produk.getDetail());
                intent.putExtra("photo", produk.getPhoto());
                startActivity(intent);
            }
        });
    }
}
