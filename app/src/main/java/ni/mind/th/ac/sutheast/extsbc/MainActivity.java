package ni.mind.th.ac.sutheast.extsbc;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Add Fragment to activity
        if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment())
                    .commit();
        }
        /*if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentCalenderFragment, new CalenderFragment())
                    .commit();
        }*/


    }   //Main Method

} //Main Class
