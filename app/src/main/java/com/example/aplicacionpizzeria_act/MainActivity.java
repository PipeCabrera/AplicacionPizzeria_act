package com.example.aplicacionpizzeria_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Nombre;
    private EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (EditText) findViewById(R.id.Nombre);
        Password = (EditText) findViewById(R.id.Contraseña);
    }

    public void Menu(View v)
    {
        String V_user = Nombre.getText().toString();
        String V_pass = Password.getText().toString();
        if (V_user.equals("android") && V_pass.equals("123"))
        {
            Intent i = new Intent(this,Menu_act.class);
            startActivity(i);
        }
    }

}