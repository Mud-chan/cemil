package com.pramudya.cemil;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.content.pm.PackageManager;
import android.Manifest;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;
    TextView tv;
    ImageView imageView;
    Button button;
    private ActivityResultLauncher<Intent> cameraLauncher;
    private Spinner kelaminSpinner; // Ganti nama variabel sesuai dengan aturan penamaan Java
    private static final int CAMERA_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        kelaminSpinner = findViewById(R.id.genderspin);
        String[] genderOptions = {"Laki-laki", "Perempuan"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderOptions);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kelaminSpinner.setAdapter(genderAdapter);

        kelaminSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedGender = genderOptions[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        tvw = findViewById(R.id.textView6);
        eText = findViewById(R.id.txtdate);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        btnGet = findViewById(R.id.btndate);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selection Date: " + eText.getText());
            }
        });

        tv = findViewById(R.id.btnlogin);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(goToLogin);
                finish();
            }
        });


        button = findViewById(R.id.btnkamera);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA
            },100);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
         }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            // Buat dialog dengan tampilan custom
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            View dialogView = getLayoutInflater().inflate(R.layout.poto_dialog, null);
            ImageView photoImageView = dialogView.findViewById(R.id.imgpotoview);
            photoImageView.setImageBitmap(bitmap);

            builder.setView(dialogView);
            AlertDialog alertDialog = builder.create();

            Button closeButton = dialogView.findViewById(R.id.btnclose);
            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.show();
        }
    }


    @Override
    public void onBackPressed() {
        Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(goToLogin);
        finish();
    }
}
