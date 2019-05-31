package com.example.firebasedatabaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentsDetails extends AppCompatActivity {

    private ListView listViewDetails;
    DatabaseReference databaseReference;
    private List<Student> studentList;
    private customAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_details);

        databaseReference = FirebaseDatabase.getInstance().getReference("Students");
        studentList = new ArrayList<>();
        customAdapter = new customAdapter(StudentsDetails.this,studentList);


        listViewDetails = findViewById(R.id.listViewDetails);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                studentList.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Student student =dataSnapshot1.getValue(Student.class);
                    studentList.add(student);
                }
                listViewDetails.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
