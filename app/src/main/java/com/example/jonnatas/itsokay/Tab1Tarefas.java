package com.example.jonnatas.itsokay;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jonnatas.itsokay.config.ConfiguracaoFirebase;
import com.example.jonnatas.itsokay.model.Tarefa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by jonnatas on 17/11/17.
 */

public class Tab1Tarefas extends Fragment {

    DatabaseReference reference = ConfiguracaoFirebase.getFirebase();
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> tarefas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tabs1tarefas, container, false);

        tarefas = new ArrayList<>();
        tarefas.add("Seja feliz");
        tarefas.add("Seja triste");
        tarefas.add("Seja qualquer coisa");

        listView = (ListView) rootView.findViewById(R.id.lv_tarefas);
        adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_checked,
                tarefas
        );

        listView.setAdapter(adapter);

        reference = ConfiguracaoFirebase.getFirebase().child("tarefas");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tarefas.clear();

                for (DataSnapshot dados: dataSnapshot.getChildren()) {
                    Tarefa tarefa = dados.getValue(Tarefa.class);
                    tarefas.add(tarefa.getEnunciado());
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
