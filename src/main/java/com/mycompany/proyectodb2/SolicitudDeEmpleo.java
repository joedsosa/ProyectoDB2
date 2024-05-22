
package com.mycompany.proyectodb2;

public class SolicitudDeEmpleo {
    private String id;
    private String idPersona;
    private String idEmpresa;
    private String puesto;
    private String estado;
    private String descripcion; // Nuevo atributo para la descripción

    // Getters y Setters (incluyendo para la descripción)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdPersona() { return idPersona; }
    public void setIdPersona(String idPersona) { this.idPersona = idPersona; }

    public String getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(String idEmpresa) { this.idEmpresa = idEmpresa; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDescripcion() { return descripcion; } // Getter para la descripción
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; } // Setter para la descripción
}


