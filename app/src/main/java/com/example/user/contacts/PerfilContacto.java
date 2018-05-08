package com.example.user.contacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilContacto extends AppCompatActivity {

    ImageView imagenPerfil, llamar, compartir;
    TextView nombreContacto, numeroContacto, correoContacto;
    Intent Rintent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_contacto);

        imagenPerfil = (ImageView) findViewById(R.id.foto_perfil);
        nombreContacto = (TextView) findViewById(R.id.nombre_contacto);
        numeroContacto = (TextView) findViewById(R.id.numero_contacto);
        correoContacto = (TextView) findViewById(R.id.correo_contacto);
        llamar = (ImageView) findViewById(R.id.llamar);
        compartir = (ImageView) findViewById(R.id.compartir);

        recibirIntent();

        setListeners();


    }

    /**
     * Recibe Intent que manda RecyclerViewAdaptadorContactos
     */

    private void recibirIntent(){
        Rintent = getIntent();
        nombreContacto.setText(Rintent.getExtras().getString("nombre"));
        numeroContacto.setText(Rintent.getExtras().getString("telefono"));
        correoContacto.setText(Rintent.getExtras().getString("correo"));
    }

    /**Llamadas
     */

    private void setListeners(){
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CallIntent = new Intent(Intent.ACTION_CALL);
                CallIntent.setData(Uri.parse("tel:" + Rintent.getExtras().getString("telefono")));
                startActivity(CallIntent);
            }
        });

        /**
         * Compartir los datos del contacto
         */
        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent compartir = new Intent(Intent.ACTION_SEND);
                Intent menu_apps = Intent.createChooser(compartir, "Enviar");
                startActivity(menu_apps);
                compartir.putExtra(Intent.EXTRA_TEXT,"Datos:\nNombre: "+Rintent.getExtras().getString("nombre")+"\nTelefono: "+Rintent.getExtras().getString("telefono")+"\nCorreo: "+Rintent.getExtras().getString("correo"));
                compartir.setType("text/plain");
                startActivity(compartir);
            }
        });
    }
}

