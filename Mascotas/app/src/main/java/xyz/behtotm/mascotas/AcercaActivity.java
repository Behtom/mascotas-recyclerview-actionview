package xyz.behtotm.mascotas;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AcercaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        setActionBar();
    }

    private void setActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_acerca_toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar ab = getSupportActionBar();
            ab.setTitle(R.string.acerca_title);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setIcon(R.drawable.ic_pets);
        }
    }
}
