package com.example.cine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import adapters.Pelicula_adapter;
import model.Pelicula;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    //String peliculas[];
    List<Pelicula> data;
    Pelicula_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)  findViewById(R.id.list);
        list.setOnItemClickListener(this);
        //peliculas = getResources().getStringArray(R.array.Pelicula);


        data= new ArrayList<>();
        adapter = new Pelicula_adapter(this, data);

        list.setAdapter(adapter);

        loadPeliculas();
    }

    public  void loadPeliculas(){
        Pelicula p1 = new Pelicula();
        p1.setNombre("Avengers End game");
        p1.setDuracion("3h 2m");
        p1.setFechaEstreno("25 de abril de 2019");
        p1.setUrlImagen("https://www.latercera.com/resizer/T8oTqNj-QxjSChc_3HI_OyekP00=/900x600/smart/arc-anglerfish-arc2-prod-copesa.s3.amazonaws.com/public/OF2GHTEXJFBSVNCTNCUES4ESAQ.jpg");

        Pelicula p2 = new Pelicula();
        p2.setNombre("El hoyo");
        p2.setDuracion("1h 34m");
        p2.setFechaEstreno("21 de febrero de 2020");
        p2.setUrlImagen("https://laverdadnoticias.com/__export/1585319124797/sites/laverdad/img/2020/03/27/pelicula_el_hoyo_que_ha_dejado_con_trauma_al_publico.jpg_1709243748.jpg");

        Pelicula p3 = new Pelicula();
        p3.setNombre("Ghost Rider");
        p3.setDuracion("1h 50m");
        p3.setFechaEstreno("16 de febrero de 2007");
        p3.setUrlImagen("https://i.pinimg.com/originals/70/c0/80/70c080a19f44f0f91d868d9facbb26cb.jpg");

        Pelicula p4 = new Pelicula();
        p4.setNombre("Amelie");
        p4.setDuracion("2h 9m");
        p4.setFechaEstreno("22 de febrero de 2002");
        p4.setUrlImagen("http://www.redcapitalmx.com/wp-content/uploads/2017/05/amelie.jpg");

        Pelicula p5 = new Pelicula();
        p5.setNombre("Alicia en el país de las maravillas");
        p5.setDuracion("1h 48m");
        p5.setFechaEstreno("5 de marzo de 2010");
        p5.setUrlImagen("https://lh4.googleusercontent.com/YKv0nWwYbUyKAwR-2ZIo58r9Md5-Iv3gCSU1MwGBJoCyNmr52vUNUJGAi-enVUnMKMv7QTzAZqDnvRdgHJfGMWJqTMTX8QXlU48jQEpaYEQNefd9SW9g1-GRNFBVOEmkuQ=s412");

        Pelicula p6 = new Pelicula();
        p6.setNombre("Milagro en la celda 7");
        p6.setDuracion("2h 12m");
        p6.setFechaEstreno("10 de octubre de 2019");
        p6.setUrlImagen("https://i.medyatava.com/2/1640/900/storage/old/uploads/news/0f16b1ef-4af4-43e9-8858-c0dbed68469b.jpg");


        data.add(p1);
        data.add(p2);
        data.add(p3);
        data.add(p4);
        data.add(p5);
        data.add(p6);

        adapter.notifyDataSetChanged();

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //String p = peliculas[position];
        //Toast.makeText(this,"Seleccionó la película " +p,Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,Pantalla2Activity.class);
        intent.putExtra("pelicula",data.get(position).getNombre());
        intent.putExtra("url",data.get(position).getUrlImagen());
        startActivity(intent);

    }
}
