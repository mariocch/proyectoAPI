package com.fime.proyectoapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    protected Context context;
    private ArrayList<Estudiante> items;

    public ListViewAdapter (Context context, ArrayList<Estudiante> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.listview_item, null);

        Estudiante estudiante = items.get(position);

        TextView carrera = convertView.findViewById(R.id.tvCarrera);
        TextView nombre = convertView.findViewById(R.id.tvNombre);
        TextView matricula = convertView.findViewById(R.id.tvMatricula);

        carrera.setText(estudiante.getCarrera());
        nombre.setText(estudiante.getNombre());
        matricula.setText(estudiante.getMatricula());

        return convertView;
    }
}
