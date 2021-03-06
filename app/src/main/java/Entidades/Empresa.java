package Entidades;

import android.os.Parcelable;

public abstract class Empresa  {
    protected int logo;
    protected String nombreEmpresa;

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Empresa(int logo, String nombreEmpresa) {
        this.logo = logo;
        this.nombreEmpresa = nombreEmpresa;
    }

    public Empresa() {
    }
}
