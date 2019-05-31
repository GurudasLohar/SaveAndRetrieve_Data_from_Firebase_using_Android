package com.example.firebasedatabaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtUser,txtPass;
    Spinner spnState;
    Button btnSubmit,btnLoad;

    DatabaseReference databaseFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseFirebase = FirebaseDatabase.getInstance().getReference("Students");

        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        spnState = findViewById(R.id.spnState);
        btnSubmit = findViewById(R.id.btnSumbit);
        btnLoad = findViewById(R.id.btnLoad);

        String[] state = getResources().getStringArray(R.array.states);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,state);
        spnState.setAdapter(arrayAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    sumbitDetails();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StudentsDetails.class);
                startActivity(intent);
            }
        });
    }


    private void sumbitDetails(){
            String user = txtUser.getText().toString();
            String pass = txtPass.getText().toString();
            String state = spnState.getSelectedItem().toString();

            if(!TextUtils.isEmpty(user)){

                String id = databaseFirebase.push().getKey();

                Student student =new Student(id,user,pass,state);

                databaseFirebase.child(id).setValue(student);

                Toast.makeText(this, "Details Submitted", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
    }
}
