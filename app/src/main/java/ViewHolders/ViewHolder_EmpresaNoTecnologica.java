package ViewHolders;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder_EmpresaNoTecnologica {
    public ImageView logo;
    public TextView nombreEmpresa;
    public TextView actividadEmpresa;
    public TextView CNAE;

    public ViewHolder_EmpresaNoTecnologica(ImageView logo, TextView nombreEmpresa, TextView actividadEmpresa, TextView CNAE) {
        this.logo = logo;
        this.nombreEmpresa = nombreEmpresa;
        this.actividadEmpresa = actividadEmpresa;
        this.CNAE = CNAE;
    }

    public ImageView getLogo() {
        return logo;
    }

    public TextView getNombreEmpresa() {
        return nombreEmpresa;
    }

    public TextView getActividadEmpresa() {
        return actividadEmpresa;
    }

    public TextView getCNAE() {
        return CNAE;
    }
}
