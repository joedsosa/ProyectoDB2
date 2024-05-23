package com.mycompany.proyectodb2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class PuestoDeTrabajoDAO {

    private final MongoCollection<Document> collection;
    private final ConexionMongo conexion;

    public PuestoDeTrabajoDAO(ConexionMongo conexion) {
        this.conexion = conexion;
        MongoDatabase database = conexion.obtenerBaseDatos();
        this.collection = database.getCollection("puestosDeTrabajo");
    }

    public void insertarPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("puestosDeTrabajo");
        Document doc = new Document("tipoPuesto", puesto.getTipoPuesto())
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
                .append("empresa", puesto.getEmpresa())
                .append("anosExperiencia", puesto.getAnosExperiencia())
                .append("habilidadesRequeridas", puesto.getHabilidadesRequeridas())
                .append("disponible", puesto.isDisponible());
        collection.insertOne(doc);
    }

    public PuestoDeTrabajo buscarPuestoDeTrabajoPorId(String id) {
        ObjectId objectId = new ObjectId(id);
        Document filtro = new Document("_id", objectId);
        Document resultado = collection.find(filtro).first();
        if (resultado != null) {
            return convertirDocumentoAPuestoDeTrabajo(resultado);
        }
        return null; // Retorna null si no se encontró ningún resultado

    }

    public List<PuestoDeTrabajo> obtenerTodosLosPuestosDeTrabajo() {
        List<PuestoDeTrabajo> puestos = new ArrayList<>();
        for (Document doc : collection.find()) {
            puestos.add(convertirDocumentoAPuestoDeTrabajo(doc));
        }
        return puestos;
    }

    public void actualizarPuestoDeTrabajo(PuestoDeTrabajo puesto) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("puestosDeTrabajo");
        ObjectId objectId = new ObjectId(puesto.getId());
        Document query = new Document("_id", objectId);
        Document update = new Document("$set", new Document("empresa", puesto.getEmpresa())
                .append("tipoPuesto", puesto.getTipoPuesto())
                .append("ubicacion", puesto.getUbicacion())
                .append("genero", puesto.getGenero())
                .append("nivelEducacion", puesto.getNivelEducacion())
                .append("titulo", puesto.getTitulo())
                .append("promedioGraduacion", puesto.getPromedioGraduacion()) // Agregar usuario
                .append("enfermedadesNoPermitidas", puesto.getEnfermedadesNoPermitidas())
                .append("antecedentesPenalesPermitidos", puesto.getAntecedentesPenalesPermitidos())
                .append("servicioMilitar", puesto.getServicioMilitar())
                .append("sueldo", puesto.getSueldo())
                .append("horario", puesto.getHorario())
                .append("tipoContrato", puesto.getTipoContrato())
                .append("experiencia", puesto.isExperiencia())
                .append("anosExperiencia", puesto.getAnosExperiencia())
                .append("habilidadesRequeridas", puesto.getHabilidadesRequeridas())
                .append("disponible", puesto.isDisponible()));
        collection.updateOne(query, update);
    }

    public void eliminarPuestoDeTrabajo(String id) {
        Document filtro = new Document("_id", id);
        collection.deleteOne(filtro);
    }

    private Document convertirPuestoDeTrabajoADocumento(PuestoDeTrabajo puesto) {
        ObjectId objectId = new ObjectId(puesto.getId());
        return null;
    }

    private PuestoDeTrabajo convertirDocumentoAPuestoDeTrabajo(Document documento) {
        PuestoDeTrabajo puesto = new PuestoDeTrabajo();
        puesto.setId(documento.getObjectId("_id").toString());
        puesto.setTipoPuesto(documento.getString("tipoPuesto"));
        puesto.setUbicacion(documento.getString("ubicacion"));
        puesto.setGenero(documento.getString("genero"));
        puesto.setNivelEducacion(documento.getString("nivelEducacion"));
        puesto.setTitulo(documento.getString("titulo"));
        puesto.setPromedioGraduacion(documento.getInteger("promedioGraduacion"));
        puesto.setEnfermedadesNoPermitidas(documento.getString("enfermedadesNoPermitidas"));
        puesto.setAntecedentesPenalesPermitidos(documento.getString("antecedentesPenalesPermitidos"));
        puesto.setServicioMilitar(documento.getString("servicioMilitar"));
        puesto.setSueldo(documento.getInteger("sueldo"));
        puesto.setHorario(documento.getString("horario"));
        puesto.setTipoContrato(documento.getString("tipoContrato"));
        puesto.setExperiencia(documento.getBoolean("experiencia"));
        puesto.setEmpresa(documento.getString("empresa"));
        puesto.setAnosExperiencia(documento.getInteger("anosExperiencia"));
        puesto.setHabilidadesRequeridas(documento.getString("habilidadesRequeridas"));
        puesto.setDisponible(documento.getBoolean("disponible"));
        return puesto;
    }
}
