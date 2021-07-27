package adapters;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cine.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import model.Pelicula;

/**
 * Proyecto Alexandra García y equipo
 */

public class Pelicula_adapter extends BaseAdapter {

    Activity activity;
   List<Pelicula> data;

    public Pelicula_adapter(Activity activity, List<Pelicula> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v==null){

            v= View.inflate(activity, R.layout.template_pelicula, null);
        }

        Pelicula  p=data.get(position);

        TextView titulo = (TextView) v.findViewById(R.id.title);
        TextView duracion = (TextView)v.findViewById(R.id.txt_duracion);
        TextView fecha = (TextView) v.findViewById(R.id.txt_fecha);
        ImageView img = (ImageView) v.findViewById(R.id.Img);

         titulo.setText(p.getNombre());
         duracion.setText(p.getDuracion());
         fecha.setText(p.getFechaEstreno());

        Uri uri =  Uri.parse(p.getUrlImagen());
        Picasso.with(activity).load(uri).into(img);

        return v;
    }
}
