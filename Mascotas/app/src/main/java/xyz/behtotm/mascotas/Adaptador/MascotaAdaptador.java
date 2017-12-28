package xyz.behtotm.mascotas.Adaptador;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import xyz.behtotm.mascotas.Modelo.Mascota;
import xyz.behtotm.mascotas.R;

/**
 * Created by mrmar on 27/12/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.FavoritosViewHolder> {

    private Activity activity;
    private List<Mascota> mascotas;

    public MascotaAdaptador(@NonNull Activity activity, @NonNull List<Mascota> data) {
        this.activity = activity;
        this.mascotas = data;
    }

    @Override
    public FavoritosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new FavoritosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FavoritosViewHolder holder, int i) {
        final Mascota mascota = mascotas.get(i);

        holder.foto.setImageResource(mascota.getFoto());
        holder.likes.setText("" + mascota.getLikes());
        holder.nombre.setText(mascota.getNombre());

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setLikes();
                holder.likes.setText("" + mascota.getLikes());
            }
        });

        holder.favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setFavorito();
                if(mascota.isFavorito())
                    Toast.makeText(activity, "Favorito", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity, "Ya no es avorito", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class FavoritosViewHolder extends RecyclerView.ViewHolder {

        private ImageView favorito;
        private ImageView foto;
        private ImageView like;
        private TextView likes;
        private TextView nombre;

        public FavoritosViewHolder(View itemView) {
            super(itemView);

            favorito = (ImageView)itemView.findViewById(R.id.activity_main_favorito);
            foto = (ImageView)itemView.findViewById(R.id.activity_main_foto);
            like = (ImageView)itemView.findViewById(R.id.activity_main_like);
            likes = (TextView)itemView.findViewById(R.id.activity_main_likes);
            nombre = (TextView)itemView.findViewById(R.id.activity_main_nombre);
        }
    }
}
