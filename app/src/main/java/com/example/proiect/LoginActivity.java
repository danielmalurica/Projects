package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences logPref;
    private SharedPreferences.Editor logEditor;

    private EditText Nume;
    private EditText Parola;
    private Button Login;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Nume=(EditText) findViewById(R.id.etName);
        Parola=(EditText) findViewById(R.id.etPassw);
        Login=(Button)findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkBox.isChecked()){
                    logEditor.putString(getString(R.string.checkbox), "True");
                    logEditor.commit();

                    String nume=Nume.getText().toString();
                    logEditor.putString(getString(R.string.nume), nume);
                    logEditor.commit();

                    String parola=Parola.getText().toString();
                    logEditor.putString(getString(R.string.parola), parola);
                    logEditor.commit();
                }else
                { logEditor.putString(getString(R.string.checkbox), "False");
                    logEditor.commit();


                    logEditor.putString(getString(R.string.nume), "");
                    logEditor.commit();


                    logEditor.putString(getString(R.string.parola), "");
                    logEditor.commit();

                }

                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }
        });
        checkBox=(CheckBox)findViewById(R.id.checkBox);

        logPref=getSharedPreferences("com.example.proiect", Context.MODE_PRIVATE);
        logEditor=logPref.edit();

       checkSharedPreferences();



    }

    private void checkSharedPreferences(){
        String checkbox=logPref.getString(getString(R.string.checkbox), "False");
        String nume=logPref.getString(getString(R.string.nume), "");
        String parola=logPref.getString(getString(R.string.parola), "");

        Nume.setText(nume);
        Parola.setText(parola);

        if(checkbox.equals("True")){
            checkBox.setChecked(true);
        }else
        {
            checkBox.setChecked(false);
        }
    }

    @Override
    public void onClick(View view) {


    }





}

