package ni.mind.th.ac.sutheast.extsbc;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private String genderString, dateString, levelString, divisionString, sectionString, email, pass, uidString;
    private boolean genderABoolean = true, dateBirthABoolean = true;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolbar
        createToolbar();

//        Level Controller
        levelController();

//        Create Division
        createDivision();

//        Create Section
        createSection();

//        Gender Controller
        genderController();

//        Create SetDateBirth
        createSetDateBirth();

    }   //Main Method

    private void createSetDateBirth() {
        Button button = getView().findViewById(R.id.btnSet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateBirthABoolean = false;

                final Calendar calendar = Calendar.getInstance();
                final int dayInt = calendar.get(Calendar.DAY_OF_MONTH);
                int monthInt = calendar.get(Calendar.MONTH);
                int yearInt = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                calendar.set(year, month, dayInt);
                                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                dateString = dateFormat.format(calendar.getTime());
                                TextView textView = getView().findViewById(R.id.txtDate);
                                textView.setText(dateString);
                            }
                        }, yearInt, monthInt, dayInt);
                datePickerDialog.show();

            }
        });
    }

    private void createSection() {
        final String[] strings = new String[]{"---------------------------","สาขาวิชาการบัญชี", "สาขาวิชาการตลาด", "สาขาวิชาการจัดการ", "สาขาการจัดการการท่องเที่ยวและการโรงแรม","สาขานิติศาสตรบัณฑิต","สาขาวิชาการจัดการโลจิสติกส์","สาขาวิชาภาษาอังกฤษธุรกิจ","สาขาวิชาเทคโนโลยีสารสนเทศ","สาขาวิชาคอมพิวเตอร์ธุรกิจ","สาขาวิชาเทคโนโลยีการจัดการอุตสาหกรรม","สาขาวิชาเทคโนโลยีคอมพิวเตอร์","สาขาวิชาเทคโนโลยีมัลติมีเดียและแอนิเมชัน"};
        Spinner spinner = getView().findViewById(R.id.spnGroup);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sectionString = strings[1];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sectionString = strings[0];
            }
        });
    }

    private void levelController() {
        final String[] strings = new String[]{"ชั่นปีที่1", "ชั่นปีที่2", "ชั่นปีที่3", "ชั่นปีที่4",};
        Spinner spinner = getView().findViewById(R.id.spnLevel);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                levelString = strings[1];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                levelString = strings[0];
            }
        });

    }

    private void genderController() {
        RadioGroup radioGroup = getView().findViewById(R.id.radGender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                genderABoolean = false;
                switch (checkedId) {
                    case R.id.radMail:
                        genderString = "Male";
                        break;
                    case R.id.radFemail:
                        genderString = "Female";
                        break;
                }
            }
        });
    }

    private void createDivision() {

        final String[] strings = new String[]{"---------------------------","คณะบัญชีและวิทยาการจัดการ", "คณะนิติศาสตร์", "คณะโลจิสติกส์และเทคโนโลยีการบิน", "คณะศิลปศาสตร์","คณะวิทยาศาสตร์และเทคโนโลยี"};
        Spinner spinner = getView().findViewById(R.id.spnDivition);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                divisionString = strings[1];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                divisionString = strings[0];
            }
        });


    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle( getString(R.string.register));
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.message_have_space));
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemCloud) {

            EditText id1EditText = getView().findViewById(R.id.edtID1);
            EditText passEditText = getView().findViewById(R.id.edtPassword1);
            EditText pass2EditText = getView().findViewById(R.id.edtPassword2);
            EditText nameEditText = getView().findViewById(R.id.edtName);
            EditText surnameEditText = getView().findViewById(R.id.edtSurname);
            EditText ageEditText = getView().findViewById(R.id.edtAge);
            EditText addressEditText = getView().findViewById(R.id.edtAddress);
            EditText emailEditText = getView().findViewById(R.id.edtEmail);
            EditText phoneEditText = getView().findViewById(R.id.edtPhone);

            final String id1 = id1EditText.getText().toString().trim();
            pass = passEditText.getText().toString().trim();
            String pass2 = pass2EditText.getText().toString().trim();
            final String name = nameEditText.getText().toString().trim();
            final String surname = surnameEditText.getText().toString().trim();
            final String age = ageEditText.getText().toString().trim();
            final String address = addressEditText.getText().toString().trim();
            email = emailEditText.getText().toString().trim();
            final String phone = phoneEditText.getText().toString().trim();

            if (id1.isEmpty() ||
                    pass.isEmpty() ||
                    pass2.isEmpty() ||
                    name.isEmpty() ||
                    surname.isEmpty() ||
                    age.isEmpty() ||
                    address.isEmpty() ||
                    email.isEmpty() ||
                    phone.isEmpty()) {
//                Have Space
                showAlert(getString(R.string.title_have_space), getString(R.string.message_have_space));

            } else if (id1.length() != 13) {
//                รหัสไม่เท่า 13 หลัก
                showAlert(getString(R.string.title_non13), getString(R.string.message_non13));
            } else if (!pass.equals(pass2)) {
//                    Password non Match
                showAlert(getString(R.string.title_nonMatch), getString(R.string.message_noMatch));
            } else if (genderABoolean) {
                showAlert("คุณยังไม่ได้เลือดเพศ", "กรุณาเลือกเพศของคุณ");
            } else if (dateBirthABoolean) {
                showAlert("คุณยังไม่ได้ใส่วันเดือนปีเกิด", "โปรดใส่วันเดือนปีเกิด");
            } else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Confirm Data").setMessage("id = " + id1 + "\n" +
                        "Name = " +  name + "\n" +
                        "Surname = " + surname + "\n" +
                        "Age = " + age + "\n" +
                        "Gender = " + genderString + "\n" +
                        "DateBirth = " + dateString + "\n" +
                        "Address = " + address + "\n" +
                        "Level = " + levelString + "\n" +
                        "Division = " + divisionString + "\n" +
                        "Section = " + sectionString + "\n" +
                        "Email = " + email + "\n" +
                        "Password = " + pass + "\n" +
                        "Phone = " + phone).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
//                            ToDo

                                    uidString = firebaseAuth.getUid();
                                    Log.d("9febV1", "uid ==> " + uidString);

                                    DataModel dataModel = new DataModel(address, age, dateString,
                                            divisionString, genderString, id1, levelString, name,
                                            phone, sectionString, surname);

                                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                    DatabaseReference databaseReference = firebaseDatabase.getReference().child("Student");
                                    databaseReference.child(uidString).setValue(dataModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            startActivity(new Intent(getActivity(), ServiceActivity.class));
                                            getActivity().finish();
                                        }
                                    });


                                } else {
                                    showAlert("Cannont Resigter", task.getException().toString());
                                }
                            }
                        });
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }   // if

        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlert(String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title).setMessage(message).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);


        inflater.inflate(R.menu.menu_register, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

}
