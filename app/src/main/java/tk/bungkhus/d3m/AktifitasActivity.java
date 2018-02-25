package tk.bungkhus.d3m;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AktifitasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktifitas);
        getSupportActionBar().setTitle("Aktifitas Fisik");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
