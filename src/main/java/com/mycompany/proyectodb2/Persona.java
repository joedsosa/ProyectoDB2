
package com.mycompany.proyectodb2;

public class Persona {
    private String id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private String estadoCivil;
    private DatosFamiliares datosFamiliares;
    private DatosSanitarios datosSanitarios;
    private DatosLegales datosLegales;
    private DatosAcademicos datosAcademicos;
    private DatosProfesionales datosProfesionales;
    private DatosLaborales datosLaborales;
    private RequisitosEmpleo requisitosEmpleo;
    private RequisitosCondicionesEmpleo requisitosCondicionesEmpleo;

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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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

    public DatosAcademicos getDatosAcademicos() {
        return datosAcademicos;
    }

    public void setDatosAcademicos(DatosAcademicos datosAcademicos) {
        this.datosAcademicos = datosAcademicos;
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

    public RequisitosEmpleo getRequisitosEmpleo() {
        return requisitosEmpleo;
    }

    public void setRequisitosEmpleo(RequisitosEmpleo requisitosEmpleo) {
        this.requisitosEmpleo = requisitosEmpleo;
    }

    public RequisitosCondicionesEmpleo getRequisitosCondicionesEmpleo() {
        return requisitosCondicionesEmpleo;
    }

    public void setRequisitosCondicionesEmpleo(RequisitosCondicionesEmpleo requisitosCondicionesEmpleo) {
        this.requisitosCondicionesEmpleo = requisitosCondicionesEmpleo;
    }
    
}
