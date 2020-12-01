package com.example.aplicacionpizzeria_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    public VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        videoView = (VideoView) findViewById(R.id.vdv);
        String ruta = "android.resource://"+ getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);



    }

    public void gestionarClientes (View v)
    {
        Intent i = new Intent (this, Firebase_act.class);
        startActivity(i);
    }

    public void Promociones_pizza(View v )
    {
        ArrayList<String> clientes = new ArrayList<String>();

        clientes.add("Ramiro");
        clientes.add("Rosa");
        clientes.add("Robert");
        Intent i = new Intent(this, Promociones_act.class);
        i.putExtra("listClientes",clientes);
        startActivity(i);
    }
}