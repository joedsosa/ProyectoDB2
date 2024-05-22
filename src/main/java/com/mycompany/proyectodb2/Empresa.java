
package com.mycompany.proyectodb2;


public class Empresa {
    private String id;
    private String nombre;
    private String CIF;
    private String direccion;
    private String telefono;
    private String email;
    private String representante;

    public String getCIF() {return CIF;}
    public void setCIF(String CIF) {this.CIF = CIF;}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRepresentante() { return representante; }
    public void setRepresentante(String representante) { this.representante = representante; }
}

