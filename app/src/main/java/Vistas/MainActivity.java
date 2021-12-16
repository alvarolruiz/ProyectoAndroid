package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.myapplication.ListAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Entidades.Empresa;
import Entidades.EmpresaNoTecnologica;
import Entidades.EmpresaTecnologica;
import Vistas.DetallesEmpresa;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView buscador;
    ListView lv;
    ArrayList<Empresa> listaEmpresas;
    ArrayList<String> listaNombresEmpresas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declararElementosVista();
        listaEmpresas = getListaEmpresas();
        ListAdapter listAdapter = new ListAdapter(this, listaEmpresas);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(this::clickListViewElement);

    }
/*
    private void setBuscadorOnClickListener() {
        buscador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                   String nombreEmpresa = adapterView.get(position);
                    for (int i = 0; i < listaEmpresas.size(); i++) {
                        String placeHolderET = (EmpresaTecnologica) listaEmpresas.get(position);
                        if(nombreEmpresa.equals(placeHolderET.getNombreEmpresa())){
                            et = (EmpresaTecnologica) listaEmpresas.get(position);
                        }
                    }
                    Intent i = new Intent(getApplicationContext(),DetallesEmpresa.class);
                    i.putExtra("Empresa",(EmpresaTecnologica) listaEmpresas.get(position));
                    startActivity(i);
                }
            }

        });


    private void setBuscadorAdapter() {
        ArrayAdapter<Empresa> adapterBuscador = new ArrayAdapter<Empresa>(this, android.R.layout.simple_dropdown_item_1line, listaEmpresas);
        buscador.setAdapter(adapterBuscador);
    }
    */


    private void declararElementosVista(){
        buscador = findViewById(R.id.autoCompleteTextView);
        lv=findViewById(R.id.lvEmpresas);
    }

    private void clickListViewElement(AdapterView<?> adapterView, View view, int pos, long id) {
        if(listaEmpresas.get(pos) instanceof EmpresaTecnologica) {
            Intent i = new Intent(this, DetallesEmpresa.class);
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

    private  ArrayList<String> getListaNombresEmpresa(List<Empresa> listaEmpresas){
        ArrayList<String> listaNombres = new ArrayList<>();
        for (Empresa e: listaEmpresas) {
            listaNombres.add(e.getNombreEmpresa());
        }
        return listaNombres;
    }
}