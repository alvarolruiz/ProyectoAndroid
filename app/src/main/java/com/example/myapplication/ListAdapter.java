package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import Entidades.Empresa;
import Entidades.EmpresaNoTecnologica;
import Entidades.EmpresaTecnologica;
import ViewHolders.ViewHolder_EmpresaNoTecnologica;
import ViewHolders.ViewHolder_EmpresaTecnologica;

public class ListAdapter extends BaseAdapter {
    public Context context;
    public List<Empresa> lista;

    public ListAdapter(@NonNull Context context,@NonNull List<Empresa> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lista.get(i).hashCode();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int result = 0;
        if(lista.get(position) instanceof EmpresaTecnologica){
           result= 1;
        }
        return  result;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder_EmpresaTecnologica holderEmpTecnologica = null;
        ViewHolder_EmpresaNoTecnologica holderEmpNoTecnologica = null;
        ImageView ivLogo;
        TextView tvNombre, tvActividadEmpresa, tvCNAE;
        TextView tvUbicacion, tvMail, tvWeb;
        LayoutInflater  inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(getItemViewType(i)==1){
            if(row==null) {
                row = inflarRowEmpresaTecnologica(row, inflater, parent);
                ivLogo = row.findViewById(R.id.ivLogoDetails);
                tvNombre = row.findViewById(R.id.tvNombreET);
                tvUbicacion = row.findViewById(R.id.tvLocalizacionET);
                tvMail = row.findViewById(R.id.tvMailET);
                tvWeb = row.findViewById(R.id.tvWebDetails);
                holderEmpTecnologica=new ViewHolder_EmpresaTecnologica(ivLogo,tvNombre,tvUbicacion,tvMail,tvWeb);
                row.setTag(holderEmpTecnologica);
            }else{
                holderEmpTecnologica = (ViewHolder_EmpresaTecnologica) row.getTag();
            }
            holderEmpTecnologica.getLogo().setImageResource((lista.get(i)).getLogo());
            holderEmpTecnologica.getNombreEmpresa().setText((lista.get(i)).getNombreEmpresa());
            holderEmpTecnologica.getUbicacion().setText(((EmpresaTecnologica)lista.get(i)).getLocalizacion());
            holderEmpTecnologica.getMail().setText(((EmpresaTecnologica)lista.get(i)).getMailContact());
            holderEmpTecnologica.getWeb().setText(((EmpresaTecnologica)lista.get(i)).getWebEmpresa());
        }else{
            if(row==null){
                row = inflarRowEmpresaNoTecnologica(row, inflater,parent);
                ivLogo = row.findViewById(R.id.ivLogo);
                tvNombre=row.findViewById(R.id.tvActividadEmpresa);
                tvActividadEmpresa = row.findViewById(R.id.tvActividadEmpresa);
                tvCNAE = row.findViewById(R.id.tvCNAE);
                holderEmpNoTecnologica = new ViewHolder_EmpresaNoTecnologica(ivLogo,tvNombre,tvActividadEmpresa,tvCNAE);
                row.setTag(holderEmpNoTecnologica);
            }else{
                holderEmpNoTecnologica = (ViewHolder_EmpresaNoTecnologica) row.getTag();
            }
                holderEmpNoTecnologica.getLogo().setImageResource((lista.get(i)).getLogo());
                holderEmpNoTecnologica.getNombreEmpresa().setText((lista.get(i)).getNombreEmpresa());
                holderEmpNoTecnologica.getActividadEmpresa().setText(((EmpresaNoTecnologica)lista.get(i)).getActividadEmpresarial());
                holderEmpNoTecnologica.getCNAE().setText(String.valueOf(((EmpresaNoTecnologica)lista.get(i)).getCNAE()));
            }
        return row;

    }



    private View inflarRowEmpresaTecnologica(View row, LayoutInflater inflater,ViewGroup parent) {
        return row = inflater.inflate(R.layout.row_empresa_tecnologica,parent,false);
    }

    private View inflarRowEmpresaNoTecnologica(View row, LayoutInflater inflater,ViewGroup parent) {
        return row = inflater.inflate(R.layout.row_empresa_notecnologica,parent,false);
    }
}
