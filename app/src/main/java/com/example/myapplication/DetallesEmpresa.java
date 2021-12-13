package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import Entidades.EmpresaTecnologica;

public class DetallesEmpresa extends AppCompatActivity {

    public int pos;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_empresa);
        i = getIntent();
        EmpresaTecnologica empresa =(EmpresaTecnologica) i.getParcelableExtra("Empresa");
    }
}