package Entidades;

public class Persona {

    private String nombre;
    private String apellido;
    private String cargo;
    private String mail;
    private int telefono;

    public Persona(String nombre, String apellido, String cargo, String mail, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.mail = mail;
        this.telefono = telefono;
    }

    public Persona(){
        this.nombre= "";
        this.apellido="";
        this.cargo = "";
        this.mail ="";

    };

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public String getMail() {
        return mail;
    }

    public int getTelefono() {
        return telefono;
    }
}
