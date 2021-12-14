package ViewHolders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.ListAdapter;

public class ViewHolder_EmpresaTecnologica extends ViewHolder_Empresa {
    public TextView ubicacion;
    public TextView mail;
    public TextView web;

    public ViewHolder_EmpresaTecnologica(ImageView logo, TextView nombreEmpresa, TextView ubicacion, TextView mail, TextView web) {
        super(logo, nombreEmpresa);
        this.ubicacion = ubicacion;
        this.mail = mail;
        this.web = web;
    }

    public TextView getUbicacion() {
        return ubicacion;
    }

    public TextView getMail() {
        return mail;
    }

    public TextView getWeb() {
        return web;
    }
}
