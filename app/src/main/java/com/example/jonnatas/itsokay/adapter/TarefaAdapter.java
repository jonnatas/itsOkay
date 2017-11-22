package com.example.jonnatas.itsokay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

import com.example.jonnatas.itsokay.R;
import com.example.jonnatas.itsokay.model.Tarefa;

import java.util.ArrayList;

/**
 * Created by jonnatas on 19/11/17.
 */

public class TarefaAdapter extends ArrayAdapter<Tarefa> {
    private ArrayList<Tarefa> tarefas;
    private Context context;

    public TarefaAdapter(@NonNull Context context, @NonNull ArrayList<Tarefa> objects) {
        super(context, 0, objects);
        this.tarefas = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = null;

        if (tarefas!= null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.list_tarefas, parent, false);
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.textchecked);

            Tarefa tarefa = tarefas.get(position);
            checkedTextView.setText(tarefa.getEnunciado());
        }
        return view;
    }
}
