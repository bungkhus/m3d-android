package tk.bungkhus.d3m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btMenu1, btMenu2, btMenu3, btMenu4, btMenu5, btMenu6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMenu1 = findViewById(R.id.btn_meni_1);
        btMenu2 = findViewById(R.id.btn_meni_2);
        btMenu3 = findViewById(R.id.btn_meni_3);
        btMenu4 = findViewById(R.id.btn_meni_4);
        btMenu5 = findViewById(R.id.btn_meni_5);
        btMenu6 = findViewById(R.id.btn_meni_6);

        btMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PengertianActivity.class);
                startActivity(i);
            }
        });
        btMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PencegahanActivity.class);
                startActivity(i);
            }
        });
        btMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GejalaActivity.class);
                startActivity(i);
            }
        });
        btMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LingkarPerutActivity.class);
                startActivity(i);
            }
        });
        btMenu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, KomposisiMakananActivity.class);
                startActivity(i);
            }
        });
        btMenu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AktifitasActivity.class);
                startActivity(i);
            }
        });
    }
}
