package xyz.behtotm.mascotas.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.behtotm.mascotas.Adaptador.MascotaAdaptador;
import xyz.behtotm.mascotas.Modelo.Mascota;
import xyz.behtotm.mascotas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMascotasFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;

    public ListaMascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_mascotas, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inicializarMascotas();
        inicializarRecyclerView();
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
        recyclerView = (RecyclerView)getActivity().findViewById(R.id.fragment_lista_mascotas_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new MascotaAdaptador(getActivity(), mascotas));
    }
}
