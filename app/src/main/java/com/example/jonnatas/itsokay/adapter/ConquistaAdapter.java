package com.example.jonnatas.itsokay.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jonnatas.itsokay.R;
import com.example.jonnatas.itsokay.model.Conquista;

import java.util.ArrayList;

/**
 * Created by jonnatas on 27/11/17.
 */

public class ConquistaAdapter extends ArrayAdapter<Conquista> {

    private ArrayList<Conquista> conquistas;
    private Context context;

    public ConquistaAdapter(@NonNull Context context, @NonNull ArrayList<Conquista> objects) {
        super(context, 0, objects);
        this.conquistas = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;

        if (conquistas != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.list_conquistas, parent, false);

            TextView titulo = (TextView) view.findViewById(R.id.textViewTitulo);
            TextView descricao = (TextView) view.findViewById(R.id.textViewDescri);

            Conquista conquista = getItem(position);
            titulo.setText(conquista.getTitulo());
            descricao.setText(conquista.getDescricao());
        }
        return view;
    }
}
