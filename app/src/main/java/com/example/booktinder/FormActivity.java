package com.example.booktinder;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.booktinder.viewmodels.PostData;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FormActivity extends AppCompatActivity {

   EditText phone,loc,book;
   Button btnpost;
   DatabaseReference reff;
   PostData postdata;
   @Override
   protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.form);
      phone= (EditText) findViewById(R.id.getMobile);
      loc = (EditText) findViewById(R.id.getLocation);
      book = (EditText)findViewById(R.id.BookName);
      btnpost = (Button)findViewById(R.id.postbtn);
      postdata = new PostData();
      reff= FirebaseDatabase.getInstance().getReference().child("PostData");

      btnpost.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View v){
            postdata.setPhone(Integer.parseInt(phone.getText().toString().trim()));
            postdata.setLoc(loc.getText().toString().trim());
            postdata.setBook(book.getText().toString().trim());
            reff.push().setValue(postdata);
            startActivity(new Intent(FormActivity.this, Dashboard.class));
            Toast.makeText(FormActivity.this,"Data inserted successfully", Toast.LENGTH_LONG).show();
            Log.d("Successss", postdata.toString() );
         }
      });
   }



//    ProgressDialog pd;
//
//    EditText text1, text2;
//    Spinner spinner1, spinner2;
//    Button btnpost;
//
//    FirebaseDatabase fdb;
//    DatabaseReference db_ref;
//    FirebaseAuth mAuth;
//
//    Calendar cal;
//    String uid;
//    String Time, Date;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.form);
//
//        pd = new ProgressDialog(this);
//        pd.setMessage("Loading...");
//        pd.setCancelable(true);
//        pd.setCanceledOnTouchOutside(false);
//
//        getSupportActionBar().setTitle("Post Blood Request");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        text1 = findViewById(R.id.getMobile);
//        text2 = findViewById(R.id.getLocation);
//
//        spinner1 = findViewById(R.id.SpinnerBlood);
//        spinner2 = findViewById(R.id.SpinnerDivision);
//
//        btnpost = findViewById(R.id.postbtn);
//
//        cal = Calendar.getInstance();
//
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//        int month = cal.get(Calendar.MONTH);
//        int year = cal.get(Calendar.YEAR);
//        int hour = cal.get(Calendar.HOUR);
//        int min = cal.get(Calendar.MINUTE);
//        month+=1;
//        Time = "";
//        Date = "";
//        String ampm="AM";
//
//        if(cal.get(Calendar.AM_PM) ==1)
//        {
//            ampm = "PM";
//        }
//
//        if(hour<10)
//        {
//            Time += "0";
//        }
//        Time += hour;
//        Time +=":";
//
//        if(min<10) {
//            Time += "0";
//        }
//
//        Time +=min;
//        Time +=(" "+ampm);
//
//        Date = day+"/"+month+"/"+year;
//
//        FirebaseUser cur_user = mAuth.getInstance().getCurrentUser();
//
//        if(cur_user == null)
//        {
//            startActivity(new Intent(FormActivity.this, PostActivity.class));
//        } else {
//            uid = cur_user.getUid();
//        }
//
//        mAuth = FirebaseAuth.getInstance();
//        fdb = FirebaseDatabase.getInstance();
//        db_ref = fdb.getReference("posts");
//
//        try {
//            btnpost.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pd.show();
//                    final Query findname = fdb.getReference("users").child(uid);
//
//                    if(text1.getText().length() == 0)
//                    {
//                        Toast.makeText(getApplicationContext(), "Enter your contact number!",
//                                Toast.LENGTH_LONG).show();
//                    }
//                    else if(text2.getText().length() == 0)
//                    {
//                        Toast.makeText(getApplicationContext(), "Enter your location!",
//                                Toast.LENGTH_LONG).show();
//                    }
//                    else {
//                        findname.addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                                if (dataSnapshot.exists()) {
//                                    db_ref.child(uid).child("Name").setValue(dataSnapshot.getValue(UserData.class).getName());
//                                    db_ref.child(uid).child("Contact").setValue(text1.getText().toString());
//                                    db_ref.child(uid).child("Address").setValue(text2.getText().toString());
//                                    db_ref.child(uid).child("Division").setValue(spinner2.getSelectedItem().toString());
//                                    db_ref.child(uid).child("BloodGroup").setValue(spinner1.getSelectedItem().toString());
//                                    db_ref.child(uid).child("Time").setValue(Time);
//                                    db_ref.child(uid).child("Date").setValue(Date);
//                                    Toast.makeText(FormActivity.this, "Your post has been created successfully",
//                                            Toast.LENGTH_LONG).show();
//                                    startActivity(new Intent(FormActivity.this, Dashboard.class));
//
//                                } else {
//                                    Toast.makeText(getApplicationContext(), "Database error occured.",
//                                            Toast.LENGTH_LONG).show();
//                                }
//
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//                                Log.d("User", databaseError.getMessage());
//
//                            }
//                        });
//                    }
//                }
//            });
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        pd.dismiss();
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}