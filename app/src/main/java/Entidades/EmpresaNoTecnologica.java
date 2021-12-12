package Entidades;

public class EmpresaNoTecnologica extends Empresa{
    private String actividadEmpresarial;
    private int CNAE;

    public EmpresaNoTecnologica(int logo, String nombreEmpresa, String actividadEmpresarial, int CNAE) {
        super(logo, nombreEmpresa);
        this.actividadEmpresarial = actividadEmpresarial;
        this.CNAE = CNAE;
    }

    public String getActividadEmpresarial() {
        return actividadEmpresarial;
    }

    public void setActividadEmpresarial(String actividadEmpresarial) {
        this.actividadEmpresarial = actividadEmpresarial;
    }

    public int getCNAE() {
        return CNAE;
    }

    public void setCNAE(int CNAE) {
        this.CNAE = CNAE;
    }
}
