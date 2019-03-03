package ni.mind.th.ac.sutheast.extsbc;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button oneButton, twoButton, threeButton, fourButton;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        oneButton = getView().findViewById(R.id.btnOne);
        twoButton = getView().findViewById(R.id.btnTwo);
        threeButton = getView().findViewById(R.id.btnThree);
        fourButton = getView().findViewById(R.id.btnFour);

        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnOne:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentServiceFragment, new ListEventFragment()).addToBackStack(null).commit();
                break;
            case R.id.btnTwo:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentServiceFragment, new CalenderFragment()).addToBackStack(null).commit();
                break;
            case R.id.btnThree:
                Intent intent = new Intent(getActivity(), QRActivity.class);
                intent.putExtra("MyKey", true);
                startActivity(intent);
                break;
            case R.id.btnFour:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentServiceFragment, new CheckeventFragment()).addToBackStack(null).commit();
                break;
        }

    }
}
