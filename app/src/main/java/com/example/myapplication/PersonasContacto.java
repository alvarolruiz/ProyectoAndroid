package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Entidades.EmpresaTecnologica;
import Entidades.Persona;

public class PersonasContacto extends AppCompatActivity {

    Spinner spContactos;
    ImageView ivLogoEmpresa;
    TextView tvNombreEmpresa, tvNombre, tvCargo, tvTelefono, tvMail;
    Persona personaSeleccionada;
    String nombreEmpresa;
    int logoEmpresa;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas_contacto);
        getDatosIntent();
        declararElementosVista();
        asignarValorElementos();
        setSpinnerOnItemSelected();
    }

    private void getDatosIntent() {
        i = getIntent();
        nombreEmpresa =i.getStringExtra("nombreEmpresa");
        logoEmpresa = i.getIntExtra("logoEmpresa",0);
    }

    private void setSpinnerOnItemSelected() {

        spContactos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            personaSeleccionada = (Persona) spContactos.getSelectedItem();
            actualizarPersona();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                personaSeleccionada=new Persona();
            }
        });
    }

    public void actualizarPersona(){
        tvNombre.setText(personaSeleccionada.getNombre());
        tvCargo.setText(personaSeleccionada.getCargo());
        tvTelefono.setText(String.valueOf(personaSeleccionada.getTelefono()));
        tvMail.setText(personaSeleccionada.getMail());
    }

    private void declararElementosVista(){
        spContactos= findViewById(R.id.spContatos);
        tvNombreEmpresa =findViewById(R.id.nombreEmpresa);
        ivLogoEmpresa =findViewById(R.id.ivLogoContacto);
        tvNombre = findViewById(R.id.nombreContacto);
        tvCargo = findViewById(R.id.cargoContacto);
        tvTelefono = findViewById(R.id.telefonoContacto);
        tvMail = findViewById(R.id.mailContacto);
    }

    private void asignarValorElementos(){
    personaSeleccionada=new Persona();
    spContactos.setAdapter(new SpinnerAdapter(this,R.layout.row_spinner,getContactos()));
    ivLogoEmpresa.setImageResource(logoEmpresa);
    tvNombreEmpresa.setText(nombreEmpresa);
    tvNombre.setText(personaSeleccionada.getNombre());
    tvCargo.setText(personaSeleccionada.getCargo());
    tvTelefono.setText(String.valueOf(personaSeleccionada.getTelefono()));
    tvMail.setText(personaSeleccionada.getMail());
    }

    private List<Persona> getContactos() {
        List<Persona> listadoContactos = new ArrayList<Persona>();
        listadoContactos.add(new Persona("George","Sadouski","Programador de front end","geori@gmail.com",7788333));
        listadoContactos.add(new Persona("Carlos", "Rasero", "Animador 3d","carlete@gmail.com",62287722));
        listadoContactos.add(new Persona("Chayma", "Taha", "Publicidad","chay@gmail.com", 7778866));
        listadoContactos.add(new Persona("Jesus", "Rivero", "Ingeniero", "jesulito@gmail.com",633573622));
    return listadoContactos;
    }
}