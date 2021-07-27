package com.example.cine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class Pantalla2Activity extends AppCompatActivity {

    private TextView et1;
    WebView wv1;
    String pagina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        et1 = (TextView)findViewById(R.id.etPelicula);
        String peli=getIntent().getStringExtra("pelicula");
        et1.setText(peli);

        ImageView img = (ImageView) findViewById(R.id.Img);
        String url=getIntent().getStringExtra("url");
        Picasso.with(this).load(url).into(img);

        TextView sipnosis= (TextView) findViewById(R.id.etSipnosis);
        switch (peli){
            case "Avengers End game":
                sipnosis.setText("Despues de los eventos devastadores de 'Infinity War', el universo esta en ruinas debido a las acciones de Thanos. con la ayuda de lso aliados que quedaron, los vengadores deberan reunirse una vez mas para intentar deshacer susu acciones y restaruar el orden en el universo. ");
                pagina = "https://youtu.be/TcMBFSGVi1c";
                break;
            case "El hoyo":
                sipnosis.setText("El futuro, en una distopia. Dos personas por nivel. un numero desconocido de niveles y una plataforma con comida parra todos ellos.");
                pagina = "https://youtu.be/24Lf7fmKIXI";
                break;
            case "Ghost Rider":
                sipnosis.setText("Con el fin de controlar susu deseos de venganza, johnny Blaze, que ve sus poderes como una maldicion, vive apartado del mundo. sin embargo acaba siendo localizado  por el monje Moreau, que necesita de su ayuda para buscar a Nadya y a su hija");
                pagina = "https://youtu.be/8M0lLJfNPds";
                break;
            case "Amelie":
                sipnosis.setText("Amellie no es una chica como las demas . Ha visto a su pez de colores deslizarse hacia klas alcantarillas municipales , asu madre moriri en la plaza y asu padre dedicar todo su afecto a un gnomo de jardin.");
                pagina = "https://youtu.be/HUECWi5pX7o";
                break;
            case "Alicia en el país de las maravillas":
                sipnosis.setText("Una joven de 19 años, acude a una mansion victorina para asisitir a una fiesta. cuando esta a punto de recibir una propuesta de matrimonio, sale corriendo detras de de un conejo y va a parar al Pais de las maravillas");
                pagina = "https://youtu.be/paW6J97U7Eg";
                break;
            case "Milagro en la celda 7":
                sipnosis.setText("Un hombre con discapacidad intelectual es injustamente encarcelado por la muerte de una nña y debe demostrar su inocencia para poder estar de nuevo con su hija.");
                pagina = "https://youtu.be/W2CKOn6UPh8";
                break;
            default:
                Toast.makeText(this,"No encontrada",Toast.LENGTH_SHORT).show();

        }

    }

    public void trailer(View view){
        wv1 = (WebView)findViewById(R.id.wv1);
        wv1.setWebChromeClient(new WebChromeClient());
        wv1.loadUrl(pagina);
    }
}
