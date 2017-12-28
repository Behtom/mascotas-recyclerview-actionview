package xyz.behtotm.mascotas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.behtotm.mascotas.Adaptador.MascotaAdaptador;
import xyz.behtotm.mascotas.Modelo.Mascota;

public class MainActivity extends AppCompatActivity {

    private List<Mascota> mascotas;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar();

        inicializarMascotas();
        inicializarRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem favoritosItem = menu.findItem(R.id.action_favorito);
        favoritosItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this, FavoritosActivity.class));
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(false, R.drawable.max, 0, "Max"));
        mascotas.add(new Mascota(false, R.drawable.milo, 0, "Milo"));
        mascotas.add(new Mascota(false, R.drawable.pluto, 0, "Pluto"));
        mascotas.add(new Mascota(false, R.drawable.pongo, 0, "Pongo"));
        mascotas.add(new Mascota(false, R.drawable.popi, 0, "Popi"));
    }

    public void inicializarRecyclerView() {
        recyclerView = (RecyclerView)findViewById(R.id.activity_main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new MascotaAdaptador(this, mascotas));
    }

    public void setActionBar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.activity_main_action_bar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(getString(R.string.app_name));
        ab.setIcon(R.drawable.ic_pets);
    }
}
