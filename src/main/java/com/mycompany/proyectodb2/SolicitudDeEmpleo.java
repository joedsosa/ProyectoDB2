package com.mycompany.proyectodb2;

public class SolicitudDeEmpleo {
    private String id;
    private String idPersona; // ID de la persona que realiza la solicitud
    private String nombre;
    private String apellido;
    private String direccion;
    private String genero;
    private String nivelEducacion;
    private String titulo;
    private String promedioGraduacion;
    private String enfermedades;
    private String antecedentes;
    private String servicioMilitar;
    private String experiencia;
    private String anosExperiencia;
    private String habilidades;
    private String puestosDeseados;
    private String puestosNoDeseados;
    private String horario;
    private String sueldo;
    private String contrato;

    // Constructor vacío
    public SolicitudDeEmpleo() {
    }

    // Constructor con todos los atributos
    public SolicitudDeEmpleo(String idPersona, String nombre, String apellido, String direccion, String genero,
            String nivelEducacion, String titulo, String promedioGraduacion, String enfermedades, String antecedentes,
            String servicioMilitar, String experiencia, String anosExperiencia, String habilidades, String puestosDeseados,
            String puestosNoDeseados, String horario, String sueldo, String contrato) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.genero = genero;
        this.nivelEducacion = nivelEducacion;
        this.titulo = titulo;
        this.promedioGraduacion = promedioGraduacion;
        this.enfermedades = enfermedades;
        this.antecedentes = antecedentes;
        this.servicioMilitar = servicioMilitar;
        this.experiencia = experiencia;
        this.anosExperiencia = anosExperiencia;
        this.habilidades = habilidades;
        this.puestosDeseados = puestosDeseados;
        this.puestosNoDeseados = puestosNoDeseados;
        this.horario = horario;
        this.sueldo = sueldo;
        this.contrato = contrato;
    }

    // Getters y setters para todos los atributos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPromedioGraduacion() {
        return promedioGraduacion;
    }

    public void setPromedioGraduacion(String promedioGraduacion) {
        this.promedioGraduacion = promedioGraduacion;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getServicioMilitar() {
        return servicioMilitar;
    }

    public void setServicioMilitar(String servicioMilitar) {
        this.servicioMilitar = servicioMilitar;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(String anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getPuestosDeseados() {
        return puestosDeseados;
    }

    public void setPuestosDeseados(String puestosDeseados) {
        this.puestosDeseados = puestosDeseados;
    }

    public String getPuestosNoDeseados() {
        return puestosNoDeseados;
    }

        public void setPuestosNoDeseados(String puestosNoDeseados) {
        this.puestosNoDeseados = puestosNoDeseados;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
}
