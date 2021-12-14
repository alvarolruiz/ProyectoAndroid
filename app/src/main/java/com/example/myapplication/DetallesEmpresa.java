package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import Entidades.EmpresaTecnologica;

public class DetallesEmpresa extends AppCompatActivity {
ImageView ivLogo;
TextView tvNombre;
TextView tvWeb;
TextView tvMail;
EditText etlocalizacion;
EditText etTelefonos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_empresa);
        Intent i = getIntent();
            EmpresaTecnologica empresa =(EmpresaTecnologica) i.getParcelableExtra("Empresa");
        declararElementosView();
        asignarValorElementos(empresa);

    }

    private void declararElementosView(){
        ivLogo = findViewById(R.id.ivLogoDetails);
        tvNombre = findViewById(R.id.tvNombreDetails);
        tvWeb = findViewById(R.id.tvWebDetails);
        tvMail = findViewById(R.id.tvMailDetails);
        etlocalizacion = findViewById(R.id.tvLocalizacionDetails);
        etTelefonos = findViewById(R.id.etTelefonosDetails);
    }

    private void asignarValorElementos(EmpresaTecnologica empresa){
        ivLogo.setImageResource(empresa.getLogo());
        tvNombre.setText(empresa.getNombreEmpresa());
        tvWeb.setText(empresa.getWebEmpresa());
        tvMail.setText(empresa.getMailContact());
        etlocalizacion.setText(empresa.getLocalizacion());
        etTelefonos.setText(String.valueOf(empresa.getTelefonoContacto()));
    }
}