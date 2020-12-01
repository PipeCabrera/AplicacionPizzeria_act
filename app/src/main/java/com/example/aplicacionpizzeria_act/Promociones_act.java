package com.example.aplicacionpizzeria_act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Clientes;
import Clases.Promociones;

public class Promociones_act extends AppCompatActivity {

    private Spinner spinner;
    private EditText edit1,edit2;
    private TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        spinner = (Spinner) findViewById(R.id.spincli);
        edit1 = (EditText) findViewById(R.id.etpromo);
        edit2 = (EditText) findViewById(R.id.etenvío);
        tv1 = (TextView) findViewById(R.id.tviewmensaje);
        tv2 = (TextView) findViewById(R.id.tviewprecio);

        ArrayList<String> listClientes = (ArrayList<String>) getIntent().getSerializableExtra("listClientes");
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listClientes);

        spinner.setAdapter(adapt);

    }

    public void calcular(View v)
    {
        Promociones pro = new Promociones();
        String nombre = spinner.getSelectedItem().toString();
        int sumatotal;
        int Envio = Integer.parseInt(edit2.getText().toString());

        if (edit1.getText().toString().equals("Pizzas promo"))
        {
            sumatotal = pro.getPizzaspromo() + Envio;
            tv1.setText("Estimado " + nombre + " el precio final según promoción y envío es");
            tv2.setText("$"+sumatotal);

        }
        if (edit1.getText().toString().equals("Master pizza"))
        {
            sumatotal = pro.getMasterpizza() + Envio;
            tv1.setText("Estimado " + nombre + " El precio final según promoción y envío es");
            tv2.setText("$"+sumatotal);

        }

        if (edit1.getText().toString().equals("Pizza max"))
        {
            sumatotal = pro.getPizzamax() + Envio;
            tv1.setText("Estimad o" + nombre + " El precio final según promoción y envío es");
            tv2.setText("$"+sumatotal);
        }


    }
}