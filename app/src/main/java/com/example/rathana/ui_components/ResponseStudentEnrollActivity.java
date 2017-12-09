package com.example.rathana.ui_components;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResponseStudentEnrollActivity extends AppCompatActivity {

    private TextView tvStudentId, tvClass,tvSubject,tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_student_enroll);
        tvStudentId=findViewById(R.id.tvStudentId);
        tvClass=findViewById(R.id.tvClass);
        tvSubject=findViewById(R.id.tvSubject);
        tvTime=findViewById(R.id.tvTime);

        Intent intent=getIntent();
        if(null!=intent){
            int id= intent.getIntExtra("ID",0);
            String className=intent.getStringExtra("CLASS");
            String subject=intent.getStringExtra("SUBJECT");
            String time=intent.getStringExtra("TIME");

            tvStudentId.setText(id+"");
            tvClass.setText(className);
            tvSubject.setText(subject);
            tvTime.setText(time);
        }
    }
}
