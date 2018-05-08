package com.example.user.contacts;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentoContactos extends Fragment {

    View VistaAuxiliar;
    private RecyclerView RecyclerViewContactos;
    static List<Contactos> ListaDeContactos;

    public FragmentoContactos(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LeyendoContactos();
    }

    public List<Contactos> getListaDeContactos() {
        return ListaDeContactos;
    }

    public void LeyendoContactos(){

        ListaDeContactos = new ArrayList<>();

        String[] Proyeccion = new String[] { ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.TYPE };

        String ConsultaBaseDeDatos = ContactsContract.Data.MIMETYPE + "='" +
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "
                + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";

        String ReglaDeOrdenamiento = ContactsContract.Data.DISPLAY_NAME + " ASC";

        Cursor LeeContactos = getActivity().getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                Proyeccion,
                ConsultaBaseDeDatos,
                null,
                ReglaDeOrdenamiento);

        while(LeeContactos.moveToNext()){
            ListaDeContactos.add(new Contactos(LeeContactos.getString(1), LeeContactos.getString(2),"00013812@uca.edu.sv", R.drawable.perfil2, false));
        }
        LeeContactos.close();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VistaAuxiliar= inflater.inflate(R.layout.contactos_fragmento, container, false);
        RecyclerViewContactos = (RecyclerView) VistaAuxiliar.findViewById(R.id.recyclerview_contactos);

        RecyclerViewAdaptadorContactos recyclerViewAdapterContact = new RecyclerViewAdaptadorContactos(getContext(),ListaDeContactos);
        RecyclerViewContactos.setLayoutManager(new GridLayoutManager(getActivity(),3));
        RecyclerViewContactos.setAdapter(recyclerViewAdapterContact);

        return VistaAuxiliar;
    }


}
