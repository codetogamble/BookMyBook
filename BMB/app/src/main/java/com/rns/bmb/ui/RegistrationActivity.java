package com.rns.bmb.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rns.bmb.R;


public class RegistrationActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        EditText name,email,city;
        Button btnRegister;

        name =  (EditText)(findViewById(R.id.name));
        email = (EditText)(findViewById(R.id.email));
        city = (EditText)(findViewById(R.id.city));
        btnRegister = (Button)(findViewById(R.id.btn_register));

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_register:

        }
    }
}
