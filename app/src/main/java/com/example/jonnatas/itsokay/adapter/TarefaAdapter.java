package com.example.jonnatas.itsokay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.Toast;

import com.example.jonnatas.itsokay.R;
import com.example.jonnatas.itsokay.model.Tarefa;

import java.util.ArrayList;

/**
 * Created by jonnatas on 19/11/17.
 */

public class TarefaAdapter extends ArrayAdapter<Tarefa> {
    private ArrayList<Tarefa> tarefas;
    private Context context;
    private CheckedTextView checkedTextView;
    String value;

    public TarefaAdapter(@NonNull Context context, @NonNull ArrayList<Tarefa> objects) {
        super(context, 0, objects);
        this.tarefas = objects;
        this.context = context;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent){
        View view = convertView;

        if (tarefas!= null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.list_tarefas, parent, false);
            checkedTextView = (CheckedTextView) view.findViewById(R.id.textchecked);

            Tarefa tarefa = tarefas.get(position);
            checkedTextView.setText(tarefa.getEnunciado());
            checkedTextView.setTag(tarefa);
            checkedTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((CheckedTextView)v).toggle();
                }
            });
        }

        return view;
    }

    public CheckedTextView getCheckedTextView() {
        return checkedTextView;
    }

    public void setCheckedTextView() {
        checkedTextView.toggle();
    }

    public void updateRecords(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Tarefa getItem(int i) {
        return tarefas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

}
