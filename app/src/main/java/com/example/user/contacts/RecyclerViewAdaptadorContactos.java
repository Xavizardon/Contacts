package com.example.user.contacts;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class RecyclerViewAdaptadorContactos
        extends RecyclerView.Adapter<RecyclerViewAdaptadorContactos.MyViewHolder> {

    private View view;
    private static Context Contexto;
    private List<Contactos> DatosContactos;

    public RecyclerViewAdaptadorContactos(Context contexto, List<Contactos> datosContactos) {
        this.Contexto = contexto;
        this.DatosContactos = datosContactos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Contexto);
        view = inflater.inflate(R.layout.contactos_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.TextViewNombre.setText(DatosContactos.get(position).getNombreContacto());
        //holder.FotoContacto.setImageResource(DatosContactos.get(position).getFotoContacto());
        holder.FotoContacto.setImageResource(R.drawable.ic_person_black_24dp);
    }

    @Override
    public int getItemCount() {
        return DatosContactos.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView TextViewNombre;
        ImageView FotoContacto;
        ImageView Favoritos;
        CardView ContactosCardView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            TextViewNombre = (TextView) itemView.findViewById(R.id.nombre_cardview);
            FotoContacto = (ImageView)  itemView.findViewById(R.id.foto_contacto);
            ContactosCardView = (CardView) itemView.findViewById(R.id.contactos_cardview);
            Favoritos = (ImageView) itemView.findViewById(R.id.boton_favorito);

            /**
             * Seteo un evento para que se levante la activity del perfil
             * @author Didier Cruz
             * @event OnLongClickListener
             * @params recibe como parámetro el cardview
             */
            // TODO: 5/7/2018
            ContactosCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent infoContacto = new Intent(view.getContext(), PerfilContacto.class);
                    String nombre = FragmentoContactos.ListaDeContactos.get(position).getNombreContacto();
                    String correo = FragmentoContactos.ListaDeContactos.get(position).getCorreContacto();
                    String telefono = FragmentoContactos.ListaDeContactos.get(position).getTelefonoContacto();
                    infoContacto.putExtra("nombre",nombre)
                            .putExtra("telefono",telefono)
                            .putExtra("correo", correo);
                    view.getContext().startActivity(infoContacto);
                }
            });

            /**
             * Seteo un evento le da funcionalidad al ImageView Favoritos
             * @author Didier Cruz
             * @event OnClickListener
             * @listener Es la Imagen Favoritos de la estrella
             */

            Favoritos.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    boolean isFavoritos;
                    Log.d(TAG, "onClick: "+position);
                    if (!FragmentoContactos.ListaDeContactos.get(position).isFavoritos()) {
                        FragmentoContactos.ListaDeContactos.get(position).setFavoritos(true);
                        Favoritos.setBackgroundResource(R.drawable.ic_star_black_24dp);
                    }
                    else{
                        FragmentoContactos.ListaDeContactos.get(position).setFavoritos(false);
                        Favoritos.setBackgroundResource(R.drawable.ic_star_border_black_24dp);
                    }
                }
            });
        }
    }
}