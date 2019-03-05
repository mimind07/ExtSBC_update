package ni.mind.th.ac.sutheast.extsbc;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
//import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderFragment extends Fragment {

    public CalenderFragment() {
        // Required empty public constructor
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.fragment_calender);
        if (savedInstanceState == null) {

            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.contentCalenderFragment, new CalenderFragment()).commit();
        }
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_calender, container, false);

    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createToolbar();
    }

    public void createToolbar() {

        Toolbar toolbar = getView().findViewById(R.id.toolbarCalender);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        //Add Title
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.calendar));

        //Add Navigation
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        /*toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("14AugV1","Click Bar");
            }
        });
    }*/


}
