package ViewHolders;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder_Empresa {
    public ImageView logo;
    public TextView nombreEmpresa;

    public ViewHolder_Empresa(ImageView logo, TextView nombreEmpresa) {
        this.logo = logo;
        this.nombreEmpresa = nombreEmpresa;
    }

    public ImageView getLogo() {
        return logo;
    }

    public TextView getNombreEmpresa() {
        return nombreEmpresa;
    }
}
