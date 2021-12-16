package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.PersonasContacto;
import com.example.myapplication.R;

import Entidades.EmpresaTecnologica;

public class DetallesEmpresa extends AppCompatActivity {
ImageView ivLogo;
TextView tvNombre;
ImageButton btWeb;
TextView tvWeb;
ImageButton btEmail;
TextView tvMail;
ImageButton btLocalizacion;
EditText etlocalizacion;
EditText etTelefonos;
EmpresaTecnologica empresa;
Button btContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_empresa);
        Intent i = getIntent();
        empresa =(EmpresaTecnologica) i.getParcelableExtra("Empresa");
        declararElementosView();
        asignarValorElementos(empresa);
        btEmail.setOnClickListener(this::clickOnEmailImageButton);
        btLocalizacion.setOnClickListener(this::clickOnLocationButton);
        btWeb.setOnClickListener(this::clickOnWebButton);
        btContacto.setOnClickListener(this::clickOnPersonasDeContacto);

    }

    private void declararElementosView(){
        ivLogo = findViewById(R.id.ivLogoDetails);
        tvNombre = findViewById(R.id.tvNombreDetails);
        tvWeb = findViewById(R.id.tvWebDetails);
        tvMail = findViewById(R.id.tvMailDetails);
        etlocalizacion = findViewById(R.id.tvLocalizacionDetails);
        etTelefonos = findViewById(R.id.etTelefonosDetails);
        btEmail = findViewById(R.id.idMail);
        btWeb = findViewById(R.id.idWeb);
        btLocalizacion = findViewById(R.id.idLocalizacion);
        btContacto = findViewById(R.id.btnContacto);
    }

    private void asignarValorElementos(EmpresaTecnologica empresa){
        ivLogo.setImageResource(empresa.getLogo());
        tvNombre.setText(empresa.getNombreEmpresa());
        tvWeb.setText(empresa.getWebEmpresa());
        tvMail.setText(empresa.getMailContact());
        etlocalizacion.setText(empresa.getLocalizacion());
        etTelefonos.setText(String.valueOf(empresa.getTelefonoContacto()));
    }

    private void clickOnPersonasDeContacto(View view) {
        Intent i  = new Intent(this, PersonasContacto.class);
        i.putExtra("nombreEmpresa", empresa.getNombreEmpresa());
        i.putExtra("logoEmpresa", empresa.getLogo());
        startActivity(i);
    }


    private void clickOnWebButton(View view) {
        try {
            Uri uri = Uri.parse("googlechrome://navigate?url=" + empresa.getWebEmpresa());
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No application can handle this request."
                    + " Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void clickOnLocationButton(View view) {
        String url = "http://maps.google.com/maps?daddr="+empresa.getLocalizacion();
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void clickOnEmailImageButton(View view) {
        Intent intent  = new Intent(Intent.ACTION_SEND);
        String[] strTo = {empresa.getMailContact()};
        intent.putExtra(Intent.EXTRA_EMAIL, strTo);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Prueba Correo");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensaje a enviar a la empresa");
        intent.setType("message/rfc822");
        intent.setPackage("com.google.android.gm");
        startActivity(intent);
    }



}