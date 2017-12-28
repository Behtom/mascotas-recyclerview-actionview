package xyz.behtotm.mascotas.Adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xyz.behtotm.mascotas.Modelo.Mascota;
import xyz.behtotm.mascotas.R;

/**
 * Created by mrmar on 28/12/2017.
 */

public class FavoritoAdaptador extends RecyclerView.Adapter<FavoritoAdaptador.FavoritoViewHolder> {

    private List<Mascota> mascotas;

    public FavoritoAdaptador(@NonNull List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public FavoritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new FavoritoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FavoritoViewHolder holder, int i) {
        Mascota mascota = mascotas.get(i);

        holder.nombre.setText(mascota.getNombre());
        holder.likes.setText(mascota.getLikes());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class FavoritoViewHolder extends RecyclerView.ViewHolder {

        private ImageView favorito;
        private ImageView foto;
        private ImageView like;
        private TextView likes;
        private TextView nombre;

        public FavoritoViewHolder(View itemView) {
            super(itemView);

            favorito = (ImageView)itemView.findViewById(R.id.activity_main_favorito);
            foto = (ImageView)itemView.findViewById(R.id.activity_main_foto);
            like = (ImageView)itemView.findViewById(R.id.activity_main_like);
            likes = (TextView)itemView.findViewById(R.id.activity_main_likes);
            nombre = (TextView)itemView.findViewById(R.id.activity_main_nombre);
        }
    }
}
