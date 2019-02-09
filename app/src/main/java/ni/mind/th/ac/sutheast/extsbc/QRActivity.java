package ni.mind.th.ac.sutheast.extsbc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentQRfragment, QrFragment.qrInstance(getIntent().getBooleanExtra("MyKey", true)))
                    .commit();
        }

    }
}
