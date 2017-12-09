package com.example.rathana.ui_components;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.ui_components.base.BaseTimePickerDialog;
import com.example.rathana.ui_components.dialog.EndTimePicker;
import com.example.rathana.ui_components.dialog.StartTimePicker;
import com.example.rathana.ui_components.enitiy.StudentEnroll;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentActivity extends AppCompatActivity
implements BaseTimePickerDialog.OnGetTimeListener{
    private Spinner studentIdSpinner, classSpinner;
    private CheckBox javaCk,htmlCk,oopCk,springCk;
    private TextView startTimeTv, endTimeTv;
    private Button btnPickStartTime, getBtnPickEndTime;
    private StudentEnroll studentEnroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);

        studentIdSpinner=findViewById(R.id.studenIdPinner);
        classSpinner=findViewById(R.id.classSpinner);
        javaCk=findViewById(R.id.javaCk);
        htmlCk=findViewById(R.id.htmlCk);
        oopCk=findViewById(R.id.oopCk);
        springCk=findViewById(R.id.springck);
        startTimeTv=findViewById(R.id.startTimeTv);
        endTimeTv=findViewById(R.id.textView7);
        btnPickStartTime=findViewById(R.id.btnStartTime);
        getBtnPickEndTime=findViewById(R.id.btnEnd);

        setupSpinnerView();
        setupCheckBoxView();
        //create object StudentEnroll
        //use to store data from UI form
        studentEnroll=new StudentEnroll();

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("student enroll->","click");
                if(!subjectList.isEmpty()){
                    studentEnroll.setSubject(subjectList);
                }
                Log.e("student enroll->",studentEnroll.toString());
                Intent intent=new Intent(EnrollmentActivity.this,
                        ResponseStudentEnrollActivity.class);
                intent.putExtra("ID",studentEnroll.getStudentId());
                intent.putExtra("CLASS",studentEnroll.getClassName());
                String subjects="";
                for(String s: studentEnroll.getSubject()){
                    subjects=subjects+s+", ";
                }
                intent.putExtra("SUBJECT",subjects);
                String time=studentEnroll.getStartTime() +"-" +studentEnroll.getEndTime();
                intent.putExtra("TIME",time);

                startActivity(intent);
            }
        });
    }

    List<String> subjectList=new ArrayList<>();
    private void setupCheckBoxView() {
    javaCk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                subjectList.add(javaCk.getText().toString());
                Toast.makeText(EnrollmentActivity.this,
                        ""+javaCk.getText().toString(), Toast.LENGTH_SHORT).show();
            }else subjectList.remove(javaCk.getText().toString());
        }
    });
    htmlCk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                subjectList.add(htmlCk.getText().toString());
                Toast.makeText(EnrollmentActivity.this,
                        ""+htmlCk.getText().toString(), Toast.LENGTH_SHORT).show();
            }else {
                subjectList.remove(htmlCk.getText().toString());
            }
        }
    });
        oopCk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    subjectList.add(oopCk.getText().toString());
                    Toast.makeText(EnrollmentActivity.this,
                            ""+oopCk.getText().toString(), Toast.LENGTH_SHORT).show();
                }else {
                    subjectList.remove(oopCk.getText().toString());
                }
            }
        });
        springCk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    subjectList.add(springCk.getText().toString());
                    Toast.makeText(EnrollmentActivity.this,
                            ""+springCk.getText().toString(), Toast.LENGTH_SHORT).show();
                }else subjectList.remove(springCk.getText().toString());
            }
        });
    }

    private String[] studentIdList={"1","2","3","4","5","6","7","8","9","10"};
    private String[] classes={"A","B","C","D"};
    private ArrayAdapter<String> studentIdAdatper;
    private ArrayAdapter<String> classAdapter;
    private void setupSpinnerView() {
        studentIdAdatper=new ArrayAdapter<String>(
                this,android.R.layout.simple_dropdown_item_1line,studentIdList
        );
        classAdapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_dropdown_item_1line,classes
        );
        studentIdSpinner.setAdapter(studentIdAdatper);
        classSpinner.setAdapter(classAdapter);

        studentIdSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                studentEnroll.setStudentId(Integer.parseInt(studentIdList[position]));
                Toast.makeText(EnrollmentActivity.this, ""+studentIdList[position], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                studentEnroll.setClassName(classes[position]);
                Toast.makeText(EnrollmentActivity.this, ""+classes[position], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onPickTime(String timeFormat) {
        if(null!=pickerDialog){
            if(pickerDialog instanceof  StartTimePicker){
                startTimeTv.setText("start :"+timeFormat);
                studentEnroll.setStartTime(timeFormat);
                Toast.makeText(this, "start Time", Toast.LENGTH_SHORT).show();
            }else if(pickerDialog instanceof  EndTimePicker){
                endTimeTv.setText("End :"+timeFormat);
                studentEnroll.setEndTime(timeFormat);
                Toast.makeText(this, "end Time", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private BaseTimePickerDialog pickerDialog;
    public void onGetStartTime(View view) {
        pickerDialog=new StartTimePicker();
        pickerDialog.show(getFragmentManager(),"start time");
    }

    public void onGetEndTime(View view) {
        pickerDialog=new EndTimePicker();
        pickerDialog.show(getFragmentManager(),"end time");
    }

    public void onSaveEnroll(View view) {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        Log.e("student enroll->","click");
        if(!subjectList.isEmpty()){
            studentEnroll.setSubject(subjectList);
        }

        Log.e("student enroll->",studentEnroll.toString());
    }

    public void onSaveStudentEnroll(View view) {
        Log.e("student enroll->","click");
        if(!subjectList.isEmpty()){
            studentEnroll.setSubject(subjectList);
        }

        Log.e("student enroll->",studentEnroll.toString());
    }
}
