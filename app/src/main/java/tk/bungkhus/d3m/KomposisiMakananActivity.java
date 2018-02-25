package tk.bungkhus.d3m;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class KomposisiMakananActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komposisi_makanan);
        getSupportActionBar().setTitle("Komposisi Makanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);
        TextView tv5 = findViewById(R.id.tv5);

        tv1.setText("45-65 % total asupan energi (karbohidrat nonolahan berserat tinggi, dibagi dalam 3x makan/hari).");
        tv2.setText("20-25 % kebutuhan kalori (konsumsi <200mg/hari).");
        tv3.setText("10-20% total asupan energi (seafood, daging tanpa lemak, ayam tanpa kulit, produksi susu rendah lemak, kacang-kacangan, tahu, tempe).");
        tv4.setText("<3 gram atau 1 sdt garam dapur.");
        tv5.setText("25 g/hari (kacang-kacangan, buah, dan sayuran serta karbohidrat tinggi serat).");
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
