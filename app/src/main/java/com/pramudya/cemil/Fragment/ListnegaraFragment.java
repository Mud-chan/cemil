package com.pramudya.cemil.Fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pramudya.cemil.R;

public class ListnegaraFragment extends Fragment {

    private Spinner genderspinner;
    private String selectedGender;
    private String[] genderOptions = {"Laki-laki", "Perempuan"};
    private static final int CAMERA_REQUEST_CODE = 1001;

    public ListnegaraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listnegara, container, false);

        genderspinner = view.findViewById(R.id.genderspin);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, genderOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderspinner.setAdapter(adapter);

        genderspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedGender = genderOptions[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Tidak ada tindakan yang diperlukan ketika tidak ada yang dipilih
            }
        });

        // Tombol untuk mengambil foto
        Button takePhotoButton = view.findViewById(R.id.btnkamera);
        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (cameraIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
                } else {
                    Toast.makeText(requireContext(), "Tidak ada aplikasi kamera yang tersedia.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
