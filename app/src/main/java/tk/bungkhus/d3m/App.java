package tk.bungkhus.d3m;

import com.google.android.gms.ads.MobileAds;
import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, "ca-app-pub-2550623112476567~3607581837");
    }
}
