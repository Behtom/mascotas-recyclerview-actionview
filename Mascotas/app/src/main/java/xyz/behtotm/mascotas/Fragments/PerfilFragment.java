package xyz.behtotm.mascotas.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.behtotm.mascotas.Adaptador.PerfilAdaptador;
import xyz.behtotm.mascotas.Modelo.Mascota;
import xyz.behtotm.mascotas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inicializarMascotas();
        inicializarRecyclerView();
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(false, R.drawable.max, 9, "Max"));
        mascotas.add(new Mascota(false, R.drawable.max, 2, "Max"));
        mascotas.add(new Mascota(false, R.drawable.max, 5, "Max"));
        mascotas.add(new Mascota(false, R.drawable.max, 13, "Max"));
        mascotas.add(new Mascota(false, R.drawable.max, 4, "Max"));
        mascotas.add(new Mascota(false, R.drawable.max, 9, "Max"));
        mascotas.add(new Mascota(false, R.drawable.max, 10, "Max"));
        mascotas.add(new Mascota(false, R.drawable.max, 6, "Max"));
        mascotas.add(new Mascota(false, R.drawable.max, 7, "Max"));
    }

    public void inicializarRecyclerView() {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.fragment_perfil_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new PerfilAdaptador(getActivity(), mascotas));
    }
}
