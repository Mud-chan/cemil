package com.pramudya.cemil.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.pramudya.cemil.R;

public class ListprodukFragment extends Fragment {
    private ListView lvScp;
    ArrayAdapter<CharSequence> adapter;

    public ListprodukFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static ListprodukFragment newInstance(String param1, String param2) {
        ListprodukFragment fragment = new ListprodukFragment();
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
        View view = inflater.inflate(R.layout.fragment_listproduk, container, false);
        lvScp = view.findViewById(R.id.list_scp);
        adapter = ArrayAdapter.createFromResource(requireContext(), R.array.daftarscp, android.R.layout.simple_list_item_1);
        lvScp.setAdapter(adapter);
        lvScp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(requireContext(), adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    }
