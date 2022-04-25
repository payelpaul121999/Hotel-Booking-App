package com.palpayel.hotelbookingapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
String [] countryName={
        "-Select Country-",
        "Afghanistan",
        "Albania",
        "Algeria",
        "Andorra",
        "Angola",
        "Antigua",
       " Argentina",
        "Armenia",
        "Australia",
        "India",
      };
 DatePickerDialog picker;
private TextView dateview,dateview2;
private Button button,update_btn,booking_btn;
String[] Adults={
      "--Select--" , "1","2","3","4","5","6","7","8","9","10"
};
String[] kids={"--Select--","0","1","2","3","4","5","6","7","8","9","10"};
String[] roomList={"--Select--","A/C","NON A/C"};
Spinner countrySpinner,kidsSpinner,adultSpinner,roomSpinner;
private EditText firstName,lastName,email,mobile,address,pincode;
private ImageButton checkin_btn,checkOut_btn;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countrySpinner=findViewById(R.id.countrySpinner);
        dateview=findViewById(R.id.dateview);
        booking_btn=findViewById(R.id.booking_btn);
        update_btn=findViewById(R.id.update_btn);
        firstName=findViewById(R.id.firstname_edt);
        lastName=findViewById(R.id.lastname_edt);
        email=findViewById(R.id.email_edt);
        mobile=findViewById(R.id.mobile_edt);
        address=findViewById(R.id.address_edt);
        pincode=findViewById(R.id.pincode_edt);
        checkOut_btn=findViewById(R.id.checkOut_btn);

        dateview=findViewById(R.id.dateview);
        dateview2=findViewById(R.id.dateview2);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!firstName.getText().toString().isEmpty() && !lastName.getText().toString().isEmpty()&&
                        !email.getText().toString().isEmpty() && !mobile.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty()
                ){
                    String leg=mobile.getText().toString();
                    String firstname= firstName.getText().toString();
                    String lName=lastName.getText().toString();
                    if(leg.length()==10){
                       // String uniqueId = UUID.randomUUID().toString();
                        Toast.makeText(getApplicationContext(), firstname+lName+" Your Details Submit Successfully.", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "please enter valid mobile number..", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(getApplicationContext(), "please enter all information", Toast.LENGTH_SHORT).show();

                }


            }
        });
        booking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!firstName.getText().toString().isEmpty() && !lastName.getText().toString().isEmpty()&&
                        !email.getText().toString().isEmpty() && !mobile.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty()
                ){
                    String leg=mobile.getText().toString();
                    String firstname= firstName.getText().toString();
                    String lName=lastName.getText().toString();
                    if(leg.length()==10){
                        String uniqueId = UUID.randomUUID().toString();
                        Toast.makeText(getApplicationContext(), firstname+" "+lName+" Your booking Id is generated... "+uniqueId, Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "please enter valid mobile number..", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(getApplicationContext(), "please enter all information", Toast.LENGTH_SHORT).show();

                }
            }
        });




        checkin_btn=findViewById(R.id.checkin_btn);
        kidsSpinner=findViewById(R.id.kidsSpinner);
        adultSpinner=findViewById(R.id.adultSpinner);
        roomSpinner=findViewById(R.id.roomSpinner);

        checkin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                com.palpayel.hotelbookingapp.DatePicker mDatePickerDialogFragment;
                mDatePickerDialogFragment = new com.palpayel.hotelbookingapp.DatePicker();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");


            }
        });
        checkOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateview2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();

            }
        });




        ArrayAdapter ad4 =new ArrayAdapter(this, android.R.layout.simple_spinner_item,roomList);
        ad4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomSpinner.setAdapter(ad4);
        roomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        ArrayAdapter ad =new ArrayAdapter(this, android.R.layout.simple_spinner_item,countryName);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(ad);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(i>0){
                    Toast.makeText(getApplicationContext(), countryName[i], Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter ad1 =new ArrayAdapter(this, android.R.layout.simple_spinner_item,Adults);
        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adultSpinner.setAdapter(ad1);
        adultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter ad2 =new ArrayAdapter(this, android.R.layout.simple_spinner_item,kids);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kidsSpinner.setAdapter(ad2);
        kidsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!firstName.getText().toString().isEmpty() && !lastName.getText().toString().isEmpty()&&
                        !email.getText().toString().isEmpty() && !mobile.getText().toString().isEmpty() &&
                        !pincode.getText().toString().isEmpty() && !address.getText().toString().isEmpty()

                ){


                  String firstname= firstName.getText().toString();
                  String lName=lastName.getText().toString();
                  String emailId=email.getText().toString();
                  String ph=  mobile.getText().toString();
                  String pin= pincode.getText().toString();
                  Toast.makeText(getApplicationContext(), firstname+" "+lName+"  Your details update successfully." , Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext()," Please enter all details.. ." , Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, i);
        mCalendar.set(Calendar.MONTH, i1);
        mCalendar.set(Calendar.DAY_OF_MONTH, i2);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        dateview.setText(selectedDate);

    }




}