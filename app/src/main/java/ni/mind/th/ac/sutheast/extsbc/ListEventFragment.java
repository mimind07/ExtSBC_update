package ni.mind.th.ac.sutheast.extsbc;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListEventFragment extends Fragment {


    public ListEventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        createToolbar();


    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarEven);
        ((ServiceActivity)getActivity()).setSupportActionBar(toolbar);
        ((ServiceActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.message));
        ((ServiceActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((ServiceActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_event, container, false);
    }

}
