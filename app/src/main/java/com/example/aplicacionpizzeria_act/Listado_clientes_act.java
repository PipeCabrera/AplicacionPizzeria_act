package com.example.aplicacionpizzeria_act;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Clases.Clientes;

public class Listado_clientes_act extends AppCompatActivity {

    private ListView list;
    private List<Clientes> listClientes = new ArrayList<Clientes>();
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    Clientes clienteSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);
        inicializarbase();
        list =(ListView)findViewById(R.id.listcli);

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot objSnapshot : snapshot.getChildren())
                {
                    Clientes clientes = objSnapshot.getValue(Clientes.class);
                    listClientes.add(clientes);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,listClientes);
                    list.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                clienteSelected =(Clientes) parent.getItemAtPosition(position);
            }
        });
    }

    public void inicializarbase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

    public void EliminarCliente(View v)
    {
        Clientes clientes = new Clientes();
        clientes.setId(clienteSelected.getId());
        databaseReference.child("Clientes").child(clientes.getId()).removeValue();
        Toast.makeText(this,"Se ha eliminado Cliente",Toast.LENGTH_LONG).show();


    }

}