package ViewHolders;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder_EmpresaNoTecnologica extends ViewHolder_Empresa{
    public TextView actividadEmpresa;
    public TextView CNAE;

    public ViewHolder_EmpresaNoTecnologica(ImageView logo, TextView nombreEmpresa, TextView actividadEmpresa, TextView CNAE) {
        super(logo, nombreEmpresa);
        this.actividadEmpresa = actividadEmpresa;
        this.CNAE = CNAE;
    }

    public TextView getActividadEmpresa() {
        return actividadEmpresa;
    }

    public TextView getCNAE() {
        return CNAE;
    }
}
