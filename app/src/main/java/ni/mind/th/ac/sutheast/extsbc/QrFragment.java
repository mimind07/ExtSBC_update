package ni.mind.th.ac.sutheast.extsbc;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrFragment extends Fragment implements ZXingScannerView.ResultHandler{

    private ZXingScannerView zXingScannerView;
    private String qrString;
    private boolean statusABoolean;

    public static QrFragment qrInstance(boolean status) {
        QrFragment qrFragment = new QrFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("Status", status);
        qrFragment.setArguments(bundle);
        return qrFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        zXingScannerView = new ZXingScannerView(getActivity());
        return zXingScannerView;
    }



    @Override
    public void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {

        qrString = result.toString().trim();
        if (!qrString.isEmpty()) {
//            qrString อ่านค่าได้
            Log.d("9febV1", "qrString ==> " + qrString);

            statusABoolean = getArguments().getBoolean("Status");

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contentQRfragment, ResultQRFragment.resultQRInstance(statusABoolean, qrString))
                    .commit();

        }
//        qrString ว่างเปล่า

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                zXingScannerView.resumeCameraPreview(QrFragment.this);
            }
        }, 2000);

    }
}
