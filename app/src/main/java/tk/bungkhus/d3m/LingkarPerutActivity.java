package tk.bungkhus.d3m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LingkarPerutActivity extends AppCompatActivity {

    EditText etUkuran;
    Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkar_perut);
        getSupportActionBar().setTitle("Berapa Lingkar Perut Anda?");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etUkuran = findViewById(R.id.etUkuran);
        btNext = findViewById(R.id.buttonNext);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUkuran.getText().toString().isEmpty()) {
                    Toast.makeText(LingkarPerutActivity.this, "Harap Masukkan Ukuran Lingkar Perut Anda!", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(LingkarPerutActivity.this, HitungImtActivity.class);
                    Double lingkarPerut = Double.parseDouble(etUkuran.getText().toString());
                    i.putExtra("lingkarPerut", lingkarPerut);
                    startActivity(i);
                }
            }
        });
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
