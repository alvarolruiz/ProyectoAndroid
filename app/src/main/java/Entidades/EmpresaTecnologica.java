package Entidades;

public class EmpresaTecnologica extends Empresa{

    private String webEmpresa;
    private String localizacion;
    private String mailContact;

    public EmpresaTecnologica(int logo, String nombreEmpresa, String webEmpresa, String localizacion, String mailContact) {
        super(logo, nombreEmpresa);
        this.webEmpresa = webEmpresa;
        this.localizacion = localizacion;
        this.mailContact = mailContact;
    }

    public String getWebEmpresa() {
        return webEmpresa;
    }

    public void setWebEmpresa(String webEmpresa) {
        this.webEmpresa = webEmpresa;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getMailContact() {
        return mailContact;
    }

    public void setMailContact(String mailContact) {
        this.mailContact = mailContact;
    }
}
