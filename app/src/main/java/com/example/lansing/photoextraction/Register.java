package com.example.lansing.photoextraction;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Lansing on 4/5/15 AD.
 */
public class Register extends ActionBarActivity {
    EditText nameTxt, emailTxt,passwordTxt;
    TextView backLoginClick;
    @Override
    protected void onCreate(Bundle savedInstanceState2){
        super.onCreate(savedInstanceState2);
        setContentView(R.layout.registration);
        nameTxt=(EditText)findViewById(R.id.txtName);
        emailTxt=(EditText)findViewById(R.id.txtEmail);
        passwordTxt=(EditText)findViewById(R.id.txtPassword);

        final Button Registerbtn = (Button)findViewById(R.id.btnRegister);
        Registerbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View a){
                Intent intent1 = new Intent(a.getContext(),MainActivity.class);
                startActivityForResult(intent1,0);
            }
        });

        passwordTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              Registerbtn.setEnabled(!emailTxt.getText().toString().trim().isEmpty()&&!passwordTxt.getText().toString().trim().isEmpty() && !emailTxt.getText().toString().trim().isEmpty() );
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        backLoginClick = (TextView)findViewById(R.id.ctxtBackToLogIn);
        backLoginClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View a){
                Intent intent3 = new Intent(a.getContext(),MainActivity.class);
                startActivityForResult(intent3,0);

            }
        });








    }




}
