package com.rns.bmb.ui;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.rns.bmb.R;
import com.rns.bmb.web.MyGetThread;
import com.rns.bmb.web.MyPostThread;

import java.util.HashMap;


public class RegistrationActivity extends Activity implements View.OnClickListener{
    EditText editName, editEmail, editCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button btnRegister;

        editName =  (EditText)(findViewById(R.id.name));
        editEmail = (EditText)(findViewById(R.id.email));
        editCity = (EditText)(findViewById(R.id.city));
        btnRegister = (Button)(findViewById(R.id.btn_register));

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_register:
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String city = editCity.getText().toString();
                String device_id = Settings.Secure.getString(this.getContentResolver(),
                        Settings.Secure.ANDROID_ID);

                new MyPostThread(new HashMap<String,String>(), "http://192.168.0.104:8080/BookMyBook/user/saveUser?CITY=" + city +
                        "&DEVICE_ID=" + device_id + "&EMAIL_ID=" + email + "&NAME=" + name).start();
        }
    }
}
