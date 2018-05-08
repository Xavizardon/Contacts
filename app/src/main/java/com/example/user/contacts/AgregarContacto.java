package com.example.user.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AgregarContacto extends AppCompatActivity {

    EditText nombre, telefono, correo;
    FloatingActionButton boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        nombre = (EditText) findViewById(R.id.edit_nombre);
        telefono = (EditText) findViewById(R.id.edit_telefono);
        correo = (EditText) findViewById(R.id.edit_correo);
        boton = (FloatingActionButton) findViewById(R.id.boton_flotante);

        añadirContacto();
    }

    public void añadirContacto(){
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AgregarContacto.class);
                view.getContext().startActivity(i);
            }
        });
    }
}
