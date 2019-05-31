package com.example.firebasedatabaseapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class customAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;

    public customAdapter(Activity context, List<Student> studentList) {
        super(context, R.layout.sample_layout, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout,null,true);

        Student student = studentList.get(position);

        TextView tv1 = view.findViewById(R.id.txtLayoutUser);
        TextView tv2 = view.findViewById(R.id.txtLayoutPass);
        TextView tv3 = view.findViewById(R.id.txtLayoutState);

        tv1.setText("Username : "+student.getStdUsername());
        tv2.setText("Password : "+student.getStdPassword());
        tv3.setText("State : "+student.getStdState());

        return view;
    }
}
