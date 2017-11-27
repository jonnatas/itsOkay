package com.example.jonnatas.itsokay.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jonnatas.itsokay.R;
import com.example.jonnatas.itsokay.adapter.ConquistaAdapter;
import com.example.jonnatas.itsokay.config.ConfiguracaoFirebase;
import com.example.jonnatas.itsokay.model.Conquistas;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by jonnatas on 17/11/17.
 */

public class Tab3Conquistas extends Fragment {
    private DatabaseReference reference;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<Conquistas> conquistas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tabs3conquistas, container, false);

        conquistas = new ArrayList<>();

        listView = (ListView) rootView.findViewById(R.id.lv_conquista);
        adapter = new ConquistaAdapter(getActivity(), conquistas);

        listView.setAdapter(adapter);
        reference = ConfiguracaoFirebase.getFirebase().child("conquistas");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                conquistas.clear();
                for (DataSnapshot dados : dataSnapshot.getChildren()) {
                    Conquistas conquista = dados.getValue(Conquistas.class);
                    conquistas.add(conquista);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return rootView;
    }
}
