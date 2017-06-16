package com.example.chipmunk.coffeestore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btn_Login;
    private EditText ed_userTel;
    private EditText ed_password;

    private Intent intent;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private CheckBox rememberPass;

    public static final String PREFERENCE_NAME = "SaveSetting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ed_userTel = (EditText) findViewById(R.id.usrTel);
        ed_password = (EditText) findViewById(R.id.usrPassword);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        btn_Login = (Button) findViewById(R.id.btn_login);
        boolean isRemember = sharedPreferences.getBoolean("Remember_Password",false);
        if(isRemember){
            String telephone = sharedPreferences.getString("Telephone","");
            String password = sharedPreferences.getString("Password","");

            ed_userTel.setText(telephone);
            ed_password.setText(password);

            rememberPass.setChecked(true);
        }
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telephone = ed_userTel.getText().toString();
                String password = ed_password.getText().toString();
                if(telephone.equals("110")&&password.equals("123456")){
                    editor = sharedPreferences.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("Remember_Password",true);
                        editor.putString("Telephone",telephone);
                        editor.putString("Password",password);
                    } else{
                        editor.clear();
                    }
                    editor.commit();
                    intent = new Intent(Login.this,MainPage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
