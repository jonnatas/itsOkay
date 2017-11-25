package com.example.jonnatas.itsokay.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jonnatas.itsokay.R;
import com.example.jonnatas.itsokay.adapter.TarefaAdapter;
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
    private ArrayList<Tarefa> tarefas;
    private TextView cb1;
    private TextView cb2;
    private Button botao;
    private CheckBox CB1;
    private CheckBox CB2;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View V = inflater.inflate(R.layout.activity_inicio, container,false);
        cb1 = (TextView) V.findViewById(R.id.checkBox1);
        cb2 = (TextView) V.findViewById(R.id.checkBox2);
        botao = (Button) V.findViewById(R.id.button);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb1.setText("Texto 1");
                if(CB1.isChecked()) {
                    cb1.setText("Checado");
                }
                cb2.setText("Texto 2");
                if(CB2.isChecked()) {
                    cb2.setText("Checado");
                }
            }
        });

        View rootView = inflater.inflate(R.layout.tabs1tarefas, container, false);

        tarefas = new ArrayList<>();

        listView = (ListView) rootView.findViewById(R.id.lv_tarefas);
        /*adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_checked,
                tarefas
        );*/
        adapter = new TarefaAdapter(getActivity(), tarefas);

        listView.setAdapter(adapter);

        reference = ConfiguracaoFirebase.getFirebase().child("tarefas");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tarefas.clear();

                for (DataSnapshot dados: dataSnapshot.getChildren()) {
                    Tarefa tarefa = dados.getValue(Tarefa.class);
                    tarefas.add(tarefa);
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
