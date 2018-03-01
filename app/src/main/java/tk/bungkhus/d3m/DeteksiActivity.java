package tk.bungkhus.d3m;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DeteksiActivity extends AppCompatActivity {

    private RadioGroup radio_q_3, radio_q_4, radio_q_5, radio_q_6, radio_q_7, radio_q_8, radio_q_9, radio_q_10, radio_q_11, radio_q_12, radio_q_13, radio_q_14, radio_q_15;
    private RadioButton radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, radioButton10, radioButton11, radioButton12, radioButton13, radioButton14, radioButton15;
    private Button bottomSubmit;
    private int answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer12, answer13, answer14, answer15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteksi);
        getSupportActionBar().setTitle("Deteksi Dini DM");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Double lingkarPerut = getIntent().getDoubleExtra("lingkarPerut", 0);
        Double imt = getIntent().getDoubleExtra("imt", 0);

        answer1 = (lingkarPerut > 80 ? 7 : 0);
        answer2 = (imt > 23 ? 9 : 0);

        radio_q_3 = (RadioGroup) findViewById(R.id.radio_q_3);
        radio_q_4 = (RadioGroup) findViewById(R.id.radio_q_4);
        radio_q_5 = (RadioGroup) findViewById(R.id.radio_q_5);
        radio_q_6 = (RadioGroup) findViewById(R.id.radio_q_6);
        radio_q_7 = (RadioGroup) findViewById(R.id.radio_q_7);
        radio_q_8 = (RadioGroup) findViewById(R.id.radio_q_8);
        radio_q_9 = (RadioGroup) findViewById(R.id.radio_q_9);
        radio_q_10 = (RadioGroup) findViewById(R.id.radio_q_10);
        radio_q_11 = (RadioGroup) findViewById(R.id.radio_q_11);
        radio_q_12 = (RadioGroup) findViewById(R.id.radio_q_12);
        radio_q_13 = (RadioGroup) findViewById(R.id.radio_q_13);
        radio_q_14 = (RadioGroup) findViewById(R.id.radio_q_14);
        radio_q_15 = (RadioGroup) findViewById(R.id.radio_q_15);
        bottomSubmit = (Button) findViewById(R.id.bottomSubmit);

        addListenerOnButtonJawab();
    }

    public void addListenerOnButtonJawab() {

        bottomSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // mencari radio button
                radioButton3 = (RadioButton) findViewById(radio_q_3.getCheckedRadioButtonId());
                radioButton4 = (RadioButton) findViewById(radio_q_4.getCheckedRadioButtonId());
                radioButton5 = (RadioButton) findViewById(radio_q_5.getCheckedRadioButtonId());
                radioButton6 = (RadioButton) findViewById(radio_q_6.getCheckedRadioButtonId());
                radioButton7 = (RadioButton) findViewById(radio_q_7.getCheckedRadioButtonId());
                radioButton8 = (RadioButton) findViewById(radio_q_8.getCheckedRadioButtonId());
                radioButton9 = (RadioButton) findViewById(radio_q_9.getCheckedRadioButtonId());
                radioButton10 = (RadioButton) findViewById(radio_q_10.getCheckedRadioButtonId());
                radioButton11 = (RadioButton) findViewById(radio_q_11.getCheckedRadioButtonId());
                radioButton12 = (RadioButton) findViewById(radio_q_12.getCheckedRadioButtonId());
                radioButton13 = (RadioButton) findViewById(radio_q_13.getCheckedRadioButtonId());
                radioButton14 = (RadioButton) findViewById(radio_q_14.getCheckedRadioButtonId());
                radioButton15 = (RadioButton) findViewById(radio_q_15.getCheckedRadioButtonId());

                answer3 = (radioButton3.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 12 : 0);
                answer4 = (radioButton4.getText().toString().equalsIgnoreCase(getResources().getString(R.string.tidak)) ? 7 : 0);
                answer5 = (radioButton5.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 12 : 0);
                answer6 = (radioButton6.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 3 : 0);
                answer7 = (radioButton7.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 2 : 0);
                answer8 = (radioButton8.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 3 : 0);
                answer9 = (radioButton9.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 7 : 0);
                answer10 = (radioButton10.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 7 : 0);
                answer11 = (radioButton11.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 12 : 0);
                answer12 = (radioButton12.getText().toString().equalsIgnoreCase(getResources().getString(R.string.tidak)) ? 7 : 0);
                answer13 = (radioButton13.getText().toString().equalsIgnoreCase(getResources().getString(R.string.tidak)) ? 2 : 0);
                answer14 = (radioButton14.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 3 : 0);
                answer15 = (radioButton15.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ya)) ? 7 : 0);

                System.out.println("sasa"+answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7 + answer8 + answer9 + answer10 + answer11 + answer12 + answer13 + answer14 + answer15);
                int total = answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7 + answer8 + answer9 + answer10 + answer11 + answer12 + answer13 + answer14 + answer15;

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choice) {
                        switch (choice) {
                            case DialogInterface.BUTTON_NEGATIVE:
                                Intent i = new Intent(DeteksiActivity.this, MainActivity.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(i);
                                finish();
                                break;
                        }
                    }
                };

                String beresiko = "Hati-hati anda beresiko Diabetes Mellitus. Segera periksa diri anda ke tenaga kesehatan terdekat untuk mendapatkan penanganan lebih lanjut :)";
                String rendah = ""+total+"% anda beresiko rendah pada diabetes mellitus";
                String msg = (total > 50 ? beresiko : rendah);

                AlertDialog.Builder builder = new AlertDialog.Builder(DeteksiActivity.this);
                builder.setCancelable(false);
                builder.setMessage(msg)
                        .setNegativeButton("Kembali ke Menu Utama", dialogClickListener).show();

            }

        });

    }

    @Override
    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int choice) {
                switch (choice) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i = new Intent(DeteksiActivity.this, MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(DeteksiActivity.this);
        builder.setMessage("Anda akan kembali ke Home. Apakah anda yakin??")
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }
}
