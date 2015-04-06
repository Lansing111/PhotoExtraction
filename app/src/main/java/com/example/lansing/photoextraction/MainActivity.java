package com.example.lansing.photoextraction;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.app.Activity;

public class MainActivity extends ActionBarActivity {
    EditText emailTxt,passwordTxt;
    TextView signUpClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailTxt = (EditText)findViewById(R.id.txtEmail);
        passwordTxt = (EditText)findViewById(R.id.txtPassword);

        final Button logInbtn = (Button)findViewById(R.id.btnLogIn);
        logInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),FunctionPage.class);
                startActivityForResult(intent,0);
            }
        });

       passwordTxt.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
             logInbtn.setEnabled((!passwordTxt.getText().toString().trim().isEmpty()) && (!emailTxt.getText().toString().trim().isEmpty()));
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

        signUpClick=(TextView)findViewById(R.id.ctxtSignUp);
        signUpClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View b){
                Intent intent2 = new Intent(b.getContext(),Register.class);
                startActivityForResult(intent2,0);
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
