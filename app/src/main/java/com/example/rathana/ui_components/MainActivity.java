package com.example.rathana.ui_components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.rathana.ui_components.base.BaseActivity;
import com.example.rathana.ui_components.base.UserSession;

public class MainActivity extends BaseActivity {

    RadioGroup rdGroup;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(UserSession.getInstance().getName().equals("")
                && UserSession.getInstance().getPassword().equals("")){
            checkUserSession();
        }

        rdGroup=findViewById(R.id.rdGroup);
        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd=findViewById(checkedId);
                if(rd.isChecked()){
                    Toast.makeText(MainActivity.this, rd.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void showMessageError() {

    }

    public void onLogout(View view) {

        UserSession.logout();
        checkUserSession();
    }
}
