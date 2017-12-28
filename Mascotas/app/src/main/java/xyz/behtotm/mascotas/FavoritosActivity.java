package xyz.behtotm.mascotas;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import xyz.behtotm.mascotas.Adaptador.FavoritoAdaptador;
import xyz.behtotm.mascotas.Adaptador.MascotaAdaptador;
import xyz.behtotm.mascotas.Modelo.Mascota;

public class FavoritosActivity extends AppCompatActivity {

    private List<Mascota> mascotas;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        setActionBar();

        inicializarMascotas();
        inicializarRecyclerView();
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(false, R.drawable.pongo, 9, "Pongo"));
        mascotas.add(new Mascota(false, R.drawable.milo, 8, "Milo"));
        mascotas.add(new Mascota(false, R.drawable.popi, 7, "Popi"));
        mascotas.add(new Mascota(false, R.drawable.max, 6, "Max"));
        mascotas.add(new Mascota(false, R.drawable.pluto, 5, "Pluto"));
    }

    public void inicializarRecyclerView() {
        recyclerView = (RecyclerView)findViewById(R.id.activity_favoritos_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new FavoritoAdaptador(mascotas));
    }

    public void setActionBar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.activity_favoritos_action_bar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(getString(R.string.app_name));
        ab.setIcon(R.drawable.ic_pets);
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
