package xyz.behtotm.mascotas.Adaptador;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import xyz.behtotm.mascotas.Modelo.Mascota;
import xyz.behtotm.mascotas.R;

/**
 * Created by mrmar on 08/01/2018.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    private Activity activity;
    private ArrayList<Mascota> mascotas;

    public PerfilAdaptador(@NonNull Activity activity, @NonNull ArrayList<Mascota> mascotas) {
        this.activity = activity;
        this.mascotas = mascotas;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_perfil, parent, false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int i) {
        Mascota mascota = mascotas.get(i);

        holder.foto.setImageResource(mascota.getFoto());
        holder.likes.setText("" + mascota.getLikes());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView likes;

        public PerfilViewHolder(View itemView) {
            super(itemView);

            foto = (ImageView)itemView.findViewById(R.id.card_view_perfil_foto);
            likes = (TextView)itemView.findViewById(R.id.card_view_perfil_likes);
        }
    }
}
