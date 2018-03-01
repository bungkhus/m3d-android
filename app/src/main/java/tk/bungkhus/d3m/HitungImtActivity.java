package tk.bungkhus.d3m;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class HitungImtActivity extends AppCompatActivity {

    TextView txtBerat, txtTinggi, txtHasil, txtKeterangan1,txtKeterangan2;
    EditText edBerat, edTinggi;
    Button btHitung, btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_imt);

        getSupportActionBar().setTitle("Hitung Index Masa Tubuh");

        txtBerat = (TextView) findViewById(R.id.txtBerat);
        edBerat = (EditText) findViewById(R.id.edBerat);
        txtTinggi = (TextView) findViewById(R.id.txtTinggi);
        edTinggi = (EditText) findViewById(R.id.edTinggi);
        btHitung = (Button) findViewById(R.id.btHitung);
        txtHasil = (TextView) findViewById(R.id.txtHasil);
        txtKeterangan1 = (TextView) findViewById(R.id.txtKeterangan1);
        txtKeterangan2 = (TextView) findViewById(R.id.txtKeterangan2);
        btNext = findViewById(R.id.buttonNext);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtKeterangan1.getText().toString().isEmpty()) {
                    Toast.makeText(HitungImtActivity.this, "Harap Hitung IMT Anda!", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(HitungImtActivity.this, DeteksiActivity.class);
                    Double lingkarPerut = getIntent().getDoubleExtra("lingkarPerut", 0);
                    Double imt = Double.parseDouble(txtKeterangan1.getText().toString());
                    i.putExtra("lingkarPerut", lingkarPerut);
                    i.putExtra("imt", imt);
                    startActivity(i);
                }
            }
        });

        btHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hasil = "";
                Double hitung = 0.0;
                if (view.getId() == btHitung.getId()) {
                    try {
                        Double x1 = Double.parseDouble(edBerat.getText().toString());
                        Double x2 = Double.parseDouble(edTinggi.getText().toString());
                        Double hitung1 = x2 / 100;
                        hitung = (x1 / (hitung1 * hitung1));
                        hasil = String.valueOf(hitung);
                        // txtHasil = String.valueOf(hasil);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (hitung <= 18.5) {
                        txtKeterangan1.setText(hasil.toString());
                        txtKeterangan2.setText("Berat Badan Kurang".toString());
                    } else if (hitung <= 22.9) {
                        txtKeterangan1.setText(hasil.toString());
                        txtKeterangan2.setText("Normal".toString());
                    } else if (hitung <= 24.9) {
                        txtKeterangan1.setText(hasil.toString());
                        txtKeterangan2.setText("Beresiko Obesitas".toString());
                    } else if (hitung <= 29.9) {
                        txtKeterangan1.setText(hasil.toString());
                        txtKeterangan2.setText("Obesitas 1".toString());
                    } else if (hitung >= 30) {
                        txtKeterangan1.setText(hasil.toString());
                        txtKeterangan2.setText("Obesitas 2".toString());
                    }

                }
            }
        });
    }

    public void hapus (View arg0) {
        edBerat.setText("");
        edTinggi.setText("");
        txtKeterangan1.setText("");
        txtKeterangan2.setText("");
        edTinggi.setFocusable(true);
    }

    @Override
    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int choice) {
                switch (choice) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i = new Intent(HitungImtActivity.this, MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(HitungImtActivity.this);
        builder.setMessage("Anda akan kembali ke Home. Apakah anda yakin??")
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

}
