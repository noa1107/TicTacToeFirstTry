package com.appdevelopment.tictactoefirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sp=this.getSharedPreferences("details",MODE_PRIVATE);
        String emailisSaved=sp.getString("email","");
        if(!emailisSaved.equals(""))
            gotoGameActivity();
    }
    private void gotoGameActivity()
    {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void login(View view)
    {
        EditText etEmail= findViewById(R.id.editTextTextEmailAddress);
        String mail=etEmail.getText().toString();
        EditText etUserName=findViewById(R.id.editTextTextEmailAddress2);
        String userName=etUserName.getText().toString();
        SharedPreferences sp= this.getSharedPreferences("details",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("email",mail);
        editor.apply();
        gotoGameActivity();
    }
}