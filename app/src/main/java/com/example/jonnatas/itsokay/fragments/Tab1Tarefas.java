package com.example.jonnatas.itsokay.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jonnatas.itsokay.R;
import com.example.jonnatas.itsokay.adapter.TarefaAdapter;
import com.example.jonnatas.itsokay.config.ConfiguracaoFirebase;
import com.example.jonnatas.itsokay.model.Tarefa;
import com.example.jonnatas.itsokay.model.UsuarioTarefa;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by jonnatas on 17/11/17.
 */

public class Tab1Tarefas extends Fragment {

    private DatabaseReference reference;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<Tarefa> tarefas;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tabs1tarefas, container, false);

        tarefas = new ArrayList<>();

        mAuth = ConfiguracaoFirebase.getFirebaseAuth();
        final FirebaseUser user = mAuth.getCurrentUser();

        listView = (ListView) rootView.findViewById(R.id.lv_tarefas);
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                reference = ConfiguracaoFirebase.getFirebase().child("usuario_tarefa");
                boolean checkMark;
                reference.child(Integer.valueOf(position+1).toString())
                        .child(user.getUid())
                        .child("resposta").setValue(true);
            }
        });
        return rootView;
    }

}
