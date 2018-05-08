package com.example.user.contacts;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private TabLayout EspacioParaMenu;
    private ViewPager EspacioParaFragmentos;
    private ViewPagerAdapter AdaptadorParaFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EspacioParaMenu = (TabLayout) findViewById(R.id.tablayout);
        EspacioParaFragmentos = (ViewPager) findViewById(R.id.viewpager);
        AdaptadorParaFragmentos = new ViewPagerAdapter(getSupportFragmentManager());

        AdaptadorParaFragmentos.AddFragment(new FragmentoContactos(),"Contactos");
        //Aquí está el error
        AdaptadorParaFragmentos.AddFragment(new FragmentoFavoritos(),"Favoritos");
        EspacioParaFragmentos.setAdapter(AdaptadorParaFragmentos);

        EspacioParaMenu.setupWithViewPager(EspacioParaFragmentos);

        ActionBar BarraDeAccion = getSupportActionBar();
        BarraDeAccion.setElevation(0);
    }


}
