package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import Entidades.Persona;

public class SpinnerAdapter extends ArrayAdapter<Persona> {
    private Context myContext;
    private List<Persona> elementosSpinner;
    private int mResource;
    private LayoutInflater mInflater;

    public SpinnerAdapter(@NonNull Context context, int resource, List<Persona> elementosSpinner) {
        super(context, resource,elementosSpinner);
        this.myContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        this.elementosSpinner = elementosSpinner;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        View view = mInflater.inflate(mResource, parent, false);
        TextView tvNombre = view.findViewById(R.id.spNombre);
        TextView tvApellidos = view.findViewById(R.id.spApellido);
        Persona p = elementosSpinner.get(position);
        tvNombre.setText(p.getNombre());
        tvApellidos.setText(p.getApellido());

        return view;
    }
}

