package com.mycompany.proyectodb2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class PuestoDeTrabajoDAO {
    private final MongoCollection<Document> collection;
    private final ConexionMongo conexion;

    public PuestoDeTrabajoDAO(ConexionMongo conexion) {
        this.conexion = conexion;
        MongoDatabase database = conexion.obtenerBaseDatos();
        this.collection = database.getCollection("puestosDeTrabajo");
    }

    public void insertarPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        Document documento = convertirPuestoDeTrabajoADocumento(puesto);
        collection.insertOne(documento);
    }

    public List<PuestoDeTrabajo> obtenerTodosLosPuestosDeTrabajo() {
        List<PuestoDeTrabajo> puestos = new ArrayList<>();
        for (Document doc : collection.find()) {
            puestos.add(convertirDocumentoAPuestoDeTrabajo(doc));
        }
        return puestos;
    }

    public void actualizarPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        Document filtro = new Document("_id", puesto.getId());
        Document nuevoPuesto = convertirPuestoDeTrabajoADocumento(puesto);
        collection.replaceOne(filtro, nuevoPuesto);
    }

    public void eliminarPuestoDeTrabajo(String id) {
        Document filtro = new Document("_id", id);
        collection.deleteOne(filtro);
    }

    private Document convertirPuestoDeTrabajoADocumento(PuestoDeTrabajo puesto) {
        return new Document("_id", puesto.getId())
                .append("tipoPuesto", puesto.getTipoPuesto())
                .append("ubicacion", puesto.getUbicacion())
                .append("genero", puesto.getGenero())
                .append("nivelEducacion", puesto.getNivelEducacion())
                .append("titulo", puesto.getTitulo())
                .append("promedioGraduacion", puesto.getPromedioGraduacion())
                .append("enfermedadesNoPermitidas", puesto.getEnfermedadesNoPermitidas())
                .append("antecedentesPenalesPermitidos", puesto.getAntecedentesPenalesPermitidos())
                .append("servicioMilitar", puesto.getServicioMilitar())
                .append("sueldo", puesto.getSueldo())
                .append("horario", puesto.getHorario())
                .append("tipoContrato", puesto.getTipoContrato())
                .append("experiencia", puesto.isExperiencia())
                .append("anosExperiencia", puesto.getAnosExperiencia())
                .append("habilidadesRequeridas", puesto.getHabilidadesRequeridas());
    }

    private PuestoDeTrabajo convertirDocumentoAPuestoDeTrabajo(Document documento) {
        PuestoDeTrabajo puesto = new PuestoDeTrabajo();
        puesto.setId(documento.getString("_id"));
        puesto.setTipoPuesto(documento.getString("tipoPuesto"));
        puesto.setUbicacion(documento.getString("ubicacion"));
        puesto.setGenero(documento.getString("genero"));
        puesto.setNivelEducacion(documento.getString("nivelEducacion"));
        puesto.setTitulo(documento.getString("titulo"));
        puesto.setPromedioGraduacion(documento.getDouble("promedioGraduacion"));
        puesto.setEnfermedadesNoPermitidas(documento.getString("enfermedadesNoPermitidas"));
        puesto.setAntecedentesPenalesPermitidos(documento.getString("antecedentesPenalesPermitidos"));
        puesto.setServicioMilitar(documento.getString("servicioMilitar"));
        puesto.setSueldo(documento.getDouble("sueldo"));
        puesto.setHorario(documento.getString("horario"));
        puesto.setTipoContrato(documento.getString("tipoContrato"));
        puesto.setExperiencia(documento.getBoolean("experiencia"));
        puesto.setAnosExperiencia(documento.getInteger("anosExperiencia"));
        puesto.setHabilidadesRequeridas(documento.getString("habilidadesRequeridas"));
        return puesto;
    }
}
