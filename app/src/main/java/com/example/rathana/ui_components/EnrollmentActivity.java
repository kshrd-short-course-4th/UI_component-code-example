package com.example.rathana.ui_components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class EnrollmentActivity extends AppCompatActivity {

    private Spinner studentIdSpinner, classSpinner;
    private CheckBox javaCk,htmlCk,oopCk,springCk;
    private TextView startTimeTv, endTimeTv;
    private Button btnPickStartTime, getBtnPickEndTime;

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
    }
}
