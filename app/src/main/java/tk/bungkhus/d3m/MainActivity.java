package tk.bungkhus.d3m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    Button btMenu1, btMenu2, btMenu3, btMenu4, btMenu5, btMenu6;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                System.out.println("onAdLoaded()");
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                System.out.println("onAdOpened()");
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                System.out.println("onAdClosed()");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                System.out.println("onAdFailedToLoad()");
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                System.out.println("onAdLeftApplication()");
            }
        });
        loadInterstitialAd();

        btMenu1 = findViewById(R.id.btn_meni_1);
        btMenu2 = findViewById(R.id.btn_meni_2);
        btMenu3 = findViewById(R.id.btn_meni_3);
        btMenu4 = findViewById(R.id.btn_meni_4);
        btMenu5 = findViewById(R.id.btn_meni_5);
        btMenu6 = findViewById(R.id.btn_meni_6);

        btMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent i = new Intent(MainActivity.this, PengertianActivity.class);
                startActivity(i);
            }
        });
        btMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent i = new Intent(MainActivity.this, PencegahanActivity.class);
                startActivity(i);
            }
        });
        btMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent i = new Intent(MainActivity.this, GejalaActivity.class);
                startActivity(i);
            }
        });
        btMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent i = new Intent(MainActivity.this, LingkarPerutActivity.class);
                startActivity(i);
            }
        });
        btMenu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent i = new Intent(MainActivity.this, KomposisiMakananActivity.class);
                startActivity(i);
            }
        });
        btMenu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent i = new Intent(MainActivity.this, AktifitasActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onPause() {
        // This method should be called in the parent Activity's onPause() method.
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        // This method should be called in the parent Activity's onResume() method.
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        // This method should be called in the parent Activity's onDestroy() method.
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    private void loadInterstitialAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.int_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                System.out.println("onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                System.out.println("onAdFailedToLoad");
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
}
