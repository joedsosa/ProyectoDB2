package com.mycompany.proyectodb2;

public class Persona {
    private String id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private DatosFamiliares datosFamiliares;
    private DatosSanitarios datosSanitarios;
    private DatosLegales datosLegales;
    private DatosLaborales datosLaborales;
    private DatosProfesionales datosProfesionales;
    private RequisitosTrabajo requisitos;
    private String usuario;
    private String contrasena;
    private String genero; // Nuevo atributo
    private String fecha_nac;

    // Constructor
    public Persona() {
        // Constructor vacío
    }

    public DatosProfesionales getDatosProfesionales() {
        return datosProfesionales;
    }

    public void setDatosProfesionales(DatosProfesionales datosProfesionales) {
        this.datosProfesionales = datosProfesionales;
    }
    
    public DatosLaborales getDatosLaborales() {
        return datosLaborales;
    }

    public void setDatosLaborales(DatosLaborales datosLaborales) {
        this.datosLaborales = datosLaborales;
    }

    public RequisitosTrabajo getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(RequisitosTrabajo requisitos) {
        this.requisitos = requisitos;
    }
    

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nacl) {
        this.fecha_nac = fecha_nacl;
    }

    // Getters y setters para todos los atributos, incluyendo los nuevos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DatosFamiliares getDatosFamiliares() {
        return datosFamiliares;
    }

    public void setDatosFamiliares(DatosFamiliares datosFamiliares) {
        this.datosFamiliares = datosFamiliares;
    }

    public DatosSanitarios getDatosSanitarios() {
        return datosSanitarios;
    }

    public void setDatosSanitarios(DatosSanitarios datosSanitarios) {
        this.datosSanitarios = datosSanitarios;
    }

    public DatosLegales getDatosLegales() {
        return datosLegales;
    }

    public void setDatosLegales(DatosLegales datosLegales) {
        this.datosLegales = datosLegales;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
