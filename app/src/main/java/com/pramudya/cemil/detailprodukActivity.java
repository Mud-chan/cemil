package com.pramudya.cemil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class detailprodukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailproduk);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String nama = bundle.getString("nama");
            String detail = bundle.getString("detail");
            Integer photo = bundle.getInt("photo");

            TextView namatxt = findViewById(R.id.txtjudul);
            TextView detailtxt = findViewById(R.id.txtdetail);
            ImageView imgv = findViewById(R.id.imgpoto);

            namatxt.setText(nama);
            detailtxt.setText(detail);
            imgv.setImageResource(photo);
        }

        Button btnBack = findViewById(R.id.btnbc);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
