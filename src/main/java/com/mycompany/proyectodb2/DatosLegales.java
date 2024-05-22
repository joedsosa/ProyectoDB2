package com.mycompany.proyectodb2;

public class DatosLegales {
    private boolean servicioMilitar;
    private String estadoLegal;
    private boolean antecedentesPenales;
    private int promedioGrad;
    private String nivelEducacion;
    private String institucionEducativa;
    private String titulosObtenidos;
    private String especializacion;

    // Getters y Setters para todos los atributos
    public boolean isServicioMilitar() {
        return servicioMilitar;
    }

    public void setServicioMilitar(boolean servicioMilitar) {
        this.servicioMilitar = servicioMilitar;
    }

    public String getEstadoLegal() {
        return estadoLegal;
    }

    public void setEstadoLegal(String estadoLegal) {
        this.estadoLegal = estadoLegal;
    }

    public boolean isAntecedentesPenales() {
        return antecedentesPenales;
    }

    public void setAntecedentesPenales(boolean antecedentesPenales) {
        this.antecedentesPenales = antecedentesPenales;
    }

    public int getPromedioGrad() {
        return promedioGrad;
    }

    public void setPromedioGrad(int promedioGrad) {
        this.promedioGrad = promedioGrad;
    }

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public String getInstitucionEducativa() {
        return institucionEducativa;
    }

    public void setInstitucionEducativa(String institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public String getTitulosObtenidos() {
        return titulosObtenidos;
    }

    public void setTitulosObtenidos(String titulosObtenidos) {
        this.titulosObtenidos = titulosObtenidos;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
}
