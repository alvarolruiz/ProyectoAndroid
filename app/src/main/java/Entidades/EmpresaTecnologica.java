package Entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class EmpresaTecnologica extends Empresa implements Parcelable {

    private String webEmpresa;
    private String localizacion;
    private String mailContact;

    public EmpresaTecnologica(int logo, String nombreEmpresa, String webEmpresa, String localizacion, String mailContact) {
        super(logo, nombreEmpresa);
        this.webEmpresa = webEmpresa;
        this.localizacion = localizacion;
        this.mailContact = mailContact;
    }

    protected EmpresaTecnologica(Parcel in) {
        logo = in.readInt();
        nombreEmpresa = in.readString();
        webEmpresa = in.readString();
        localizacion = in.readString();
        mailContact = in.readString();
    }

    public static final Creator<EmpresaTecnologica> CREATOR = new Creator<EmpresaTecnologica>() {
        @Override
        public EmpresaTecnologica createFromParcel(Parcel in) {
            return new EmpresaTecnologica(in);
        }

        @Override
        public EmpresaTecnologica[] newArray(int size) {
            return new EmpresaTecnologica[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(logo);
        parcel.writeString(nombreEmpresa);
        parcel.writeString(webEmpresa);
        parcel.writeString(localizacion);
        parcel.writeString(mailContact);
    }
}
