package ni.mind.th.ac.sutheast.extsbc;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultQRFragment extends Fragment {

    private String qrString, uidString, Check, Detail, EndDate, Member, Place, RunTime, StartDate, name;
    private boolean statusABoolean;


    public ResultQRFragment() {
        // Required empty public constructor
    }

    public static ResultQRFragment resultQRInstance(boolean status, String qr) {
        ResultQRFragment resultQRFragment = new ResultQRFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("Status", status);
        bundle.putString("QR", qr);
        resultQRFragment.setArguments(bundle);
        return resultQRFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        qrString = getArguments().getString("QR");
        statusABoolean = getArguments().getBoolean("Status");
        Log.d("9febV1", "qr ==> " + qrString);
        Log.d("9febV1", "status ==> " + statusABoolean);

        try {

            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            uidString = firebaseAuth.getUid();

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference().child("Event").child(qrString);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    EventModel eventModel = dataSnapshot.getValue(EventModel.class);
                    Check = eventModel.getCheck();
                    Detail = eventModel.getDetail();
                    EndDate = eventModel.getEndDate();
                    Member = eventModel.getMember();
                    Place = eventModel.getPlace();
                    RunTime = eventModel.getRunTime();
                    StartDate = eventModel.getStartDate();
                    name = eventModel.getName();

                    TextView checktextView = getView().findViewById(R.id.txtCheck);
                    TextView detailtextView = getView().findViewById(R.id.txtDetail);
                    TextView endDatetextView = getView().findViewById(R.id.txtEndDate);
                    TextView membertextView = getView().findViewById(R.id.txtMember);
                    TextView placetextView = getView().findViewById(R.id.txtPlace);
                    TextView runtimetextView = getView().findViewById(R.id.txtRunTime);
                    TextView startDatetextView = getView().findViewById(R.id.txtStartDate);
                    TextView nametextView = getView().findViewById(R.id.txtName);

                    checktextView.setText(Check);
                    detailtextView.setText(Detail);
                    endDatetextView.setText(EndDate);
                    membertextView.setText(Member);
                    placetextView.setText(Place);
                    runtimetextView.setText(RunTime);
                    startDatetextView.setText(StartDate);
                    nametextView.setText(name);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_qr, container, false);
    }

}
