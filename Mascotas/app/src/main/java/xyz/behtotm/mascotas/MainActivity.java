package xyz.behtotm.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import xyz.behtotm.mascotas.Adaptador.PageAdapter;
import xyz.behtotm.mascotas.Fragments.ListaMascotasFragment;
import xyz.behtotm.mascotas.Fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar();

        tabLayout = (TabLayout) findViewById(R.id.activity_main_tablayout);
        viewPager = (ViewPager) findViewById(R.id.activity_main_viewpager);

        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_acerca:
                startActivity(new Intent(this, AcercaActivity.class));
                break;

            case R.id.action_contacto:
                startActivity(new Intent(this, FormularioActivity.class));
                break;

            case R.id.action_favorito:
                startActivity(new Intent(this, FavoritosActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListaMascotasFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

    public void setActionBar() {
        toolbar = (Toolbar)findViewById(R.id.activity_main_toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar ab = getSupportActionBar();
            ab.setTitle(getString(R.string.app_name));
            ab.setIcon(R.drawable.ic_pets);
        }
    }
}
