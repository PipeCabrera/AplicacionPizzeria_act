package com.example.aplicacionpizzeria_act;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import Clases.Clientes;

public class Firebase_act extends AppCompatActivity {

    private EditText nombre, destino, promocion;
    private Button btn;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

       InicializarFirebase();

        nombre = (EditText) findViewById(R.id.etnombre);
        destino = (EditText) findViewById(R.id.etdestino);
        promocion = (EditText) findViewById(R.id.etpromocion);
        btn = (Button) findViewById(R.id.btncli);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!nombre.equals(""))
                {
                    Clientes clientes = new Clientes();
                    clientes.setId(UUID.randomUUID().toString());
                    clientes.setNombre(nombre.getText().toString());
                    clientes.setDestino(destino.getText().toString());
                    clientes.setPromocion(promocion.getText().toString());

                    databaseReference.child("Clientes").child(clientes.getId()).setValue(clientes);

                    Toast.makeText(getBaseContext(),"Se ha guardado Cliente", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(),"No se ha guardado Cliente", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void InicializarFirebase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();

    }

    public void listadoclientes(View v)
    {
        Intent i = new Intent(this,Listado_clientes_act.class);
        startActivity(i);
    }
}