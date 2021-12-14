package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Entidades.Empresa;
import Entidades.EmpresaNoTecnologica;
import Entidades.EmpresaTecnologica;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    List<Empresa> listaEmpresas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lvEmpresas);
        listaEmpresas = getListaEmpresas();
        ListAdapter listAdapter = new ListAdapter(this, listaEmpresas);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(this::clickListViewElement);

    }

    private void clickListViewElement(AdapterView<?> adapterView, View view, int pos, long id) {
        if(listaEmpresas.get(pos) instanceof EmpresaTecnologica) {
            Intent i = new Intent(MainActivity.this, DetallesEmpresa.class);
            i.putExtra("Empresa",(EmpresaTecnologica) listaEmpresas.get(pos));
            startActivity(i);
        }
    }

    private ArrayList<Empresa> getListaEmpresas() {
        ArrayList<Empresa> listaEmpresas = new ArrayList();
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.mediamarkt_logo, "Media Markt", "https://www.mediamarkt.es/", "Av. de Palmas Altas, S/N, 41014 Sevilla", "mediamarke@gmail.es", 999882233));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.mercadona_logo, "Mercadona", "Alimentación", 4711));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.dia_logo, "Dia", "Alimentacion", 4711));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.decathlon_logo, "Decathlon", "Deportes", 4764));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.pc_componentes_logo, "Pc Componentes", "https://www.pccomponentes.com/", "C. de Cavanilles, 35, 28007 Madrid", "pcComponentes@gmail.com",933778866));
        return listaEmpresas;
    }
}