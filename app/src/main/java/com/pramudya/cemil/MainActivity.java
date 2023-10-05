package com.pramudya.cemil;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pramudya.cemil.Fragment.DaftarprodukFragment;
import com.pramudya.cemil.Fragment.ListnegaraFragment;
import com.pramudya.cemil.Fragment.ListprodukFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private DaftarprodukFragment daftarprodukFragment = new DaftarprodukFragment();
    private ListprodukFragment listprodukFragment = new ListprodukFragment();
    private ListnegaraFragment listnegaraFragment = new ListnegaraFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomview);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, daftarprodukFragment).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.crvi) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, daftarprodukFragment).commit();
                    return true;
                } else if (itemId == R.id.lt) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, listprodukFragment).commit();
                    return true;
                } else if (itemId == R.id.btnkeluar) {
                    showExitConfirmationDialog();
                    return true;
                }
                return false;
            }
        });
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Konfirmasi Keluar");
        builder.setMessage("Apakah Anda yakin ingin keluar dari aplikasi?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                exitApp();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void exitApp() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
