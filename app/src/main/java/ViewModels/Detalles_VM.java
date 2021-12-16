package ViewModels;

import androidx.lifecycle.ViewModel;

import Entidades.EmpresaTecnologica;

public class Detalles_VM extends ViewModel {
private EmpresaTecnologica empresa;

    public Detalles_VM(EmpresaTecnologica empresa) {
        this.empresa = empresa;
    }

    public EmpresaTecnologica getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaTecnologica empresa) {
        this.empresa = empresa;
    }
}
