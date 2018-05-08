package com.example.user.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FragmentoFavoritos extends Fragment {

    View VistaAuxiliar;
    private RecyclerView RecyclerViewFavoritos;
    static List<Contactos> ListaDeContactos;

    public FragmentoFavoritos() {}

    //getters
    public static List<Contactos> getListaDeContactos() {
        return ListaDeContactos;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VistaAuxiliar = inflater.inflate(R.layout.favoritos_fragmento,container,false);

        return VistaAuxiliar;

    }

}

