package com.example.rathana.ui_components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rathana.ui_components.base.BaseActivity;
import com.example.rathana.ui_components.base.UserSession;
import com.example.rathana.ui_components.enitiy.User;

public class LoginActivity extends BaseActivity {

    EditText edUserName;
    EditText edPassword;
    User userMemory;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edPassword=findViewById(R.id.edPassword);
        edUserName=findViewById(R.id.edUserName);

    }

    public void onLogin(View view) {
        User userForm =new User(
                edUserName.getText().toString(),
                edPassword.getText().toString()
        );

        userMemory=new User("admin","admin");

        authentication(userForm,userMemory);
    }

    private void authentication(User userForm,User userMemory){
        if(userForm.getName().equals(userMemory.getName())){
            if(userForm.getPassword().equals(userMemory.getPassword())){
                UserSession.getInstance().setName(userMemory.getName());
                UserSession.getInstance().setPassword(userMemory.getPassword());
                checkUserSession();
                Log.e("user memory-> " ,userMemory.toString());
                Log.e("user Form-> ", userForm.toString());
                Log.e("user session-> ",UserSession.getInstance().toString());
                finish();
            }else{
                checkUserSession();
                showMessageError();
                finish();
            }
        }else{
            checkUserSession();
            showMessageError();
            finish();
        }
    }

    @Override
    public void showMessageError() {
        Toast.makeText(this, "invalid user name and password!", Toast.LENGTH_SHORT).show();
    }
}
