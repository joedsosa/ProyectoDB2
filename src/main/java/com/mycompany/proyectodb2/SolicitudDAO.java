package com.mycompany.proyectodb2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolicitudDAO {

    private final MongoCollection<Document> collection;
    private ConexionMongo conexion;

    public SolicitudDAO(ConexionMongo conexion) {
        this.conexion = conexion;
        // Conectar a la base de datos
        MongoDatabase database = conexion.obtenerBaseDatos();
        // Obtener la colección
        this.collection = database.getCollection("solicitudes_de_empleo");
    }

    public void insertarSolicitud(SolicitudDeEmpleo solicitud) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("solicitudes_de_empleo");

        Document doc = new Document("idPersona", solicitud.getIdPersona())
                .append("nombre", solicitud.getNombre())
                .append("estado", solicitud.getEstado())
                .append("apellido", solicitud.getApellido())
                .append("nombreEmpresa", solicitud.getNombreEmpresa())
                .append("direccion", solicitud.getDireccion())
                .append("genero", solicitud.getGenero())
                .append("nivelEducacion", solicitud.getNivelEducacion())
                .append("titulo", solicitud.getTitulo())
                .append("promedioGraduacion", solicitud.getPromedioGraduacion())
                .append("enfermedades", solicitud.getEnfermedades())
                .append("antecedentes", solicitud.getAntecedentes())
                .append("servicioMilitar", solicitud.getServicioMilitar())
                .append("experiencia", solicitud.getExperiencia())
                .append("anosExperiencia", solicitud.getAnosExperiencia())
                .append("habilidades", solicitud.getHabilidades());

        collection.insertOne(doc);
    }

    public List<SolicitudDeEmpleo> obtenerSolicitudesPorPersona(String idPersona) {
        List<SolicitudDeEmpleo> solicitudes = new ArrayList<>();
        Document query = new Document("idPersona", idPersona);
        try (MongoCursor<Document> cursor = collection.find(query).iterator()) {
            while (cursor.hasNext()) {
                Document solicitudDoc = cursor.next();
                SolicitudDeEmpleo solicitud = convertirDocumentoASolicitud1(solicitudDoc);
                solicitudes.add(solicitud);
            }
        }
        return solicitudes;
    }

    public void eliminarSolicitud(String id) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("solicitudes_empleo");

        Document query = new Document("id", id);
        collection.deleteOne(query);
    }

    private Document convertirSolicitudDeEmpleoADocumento(SolicitudDeEmpleo solicitud) {
        ObjectId objectId = new ObjectId(solicitud.getId());
        return null;
    }

   public void actualizarSolicitudDeEmpleo(SolicitudDeEmpleo solicitud) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("solicitudes_de_empleo");
        ObjectId objectId = new ObjectId(solicitud.getId());
        Document query = new Document("_id", objectId);
        Document update = new Document("$set", new Document("nombre", solicitud.getNombre())
                .append("idPersona", solicitud.getIdPersona())
                .append("nombre", solicitud.getNombre())
                .append("apellido", solicitud.getApellido())
                .append("nombreEmpresa", solicitud.getNombreEmpresa())
                .append("estado", solicitud.getEstado())
                .append("direccion", solicitud.getDireccion()) // Agregar usuario
                .append("genero", solicitud.getDireccion())
                .append("nivelEducacion", solicitud.getNivelEducacion())
                .append("titulo", solicitud.getTitulo())
                .append("promedioGraduacion", solicitud.getPromedioGraduacion())
                .append("enfermedades", solicitud.getEnfermedades())
                .append("antecedentes", solicitud.getAntecedentes())
                .append("servicioMilitar", solicitud.getServicioMilitar())
                .append("Experiencia", solicitud.getExperiencia())
                .append("anosExperiencia", solicitud.getAnosExperiencia())
                .append("habilidades", solicitud.getHabilidades())
                .append("puestosDeseados", solicitud.getPuestosDeseados())
                .append("puestosNoDeseados", solicitud.getPuestosNoDeseados())
                .append("horario", solicitud.getHorario())
                .append("sueldo", solicitud.getSueldo())
                .append("contrato", solicitud.getContrato()));
        collection.updateOne(query, update);
    }

    private SolicitudDeEmpleo convertirDocumentoASolicitud(Document solicitudDoc) {
        SolicitudDeEmpleo solicitud = new SolicitudDeEmpleo();
        solicitud.setId(solicitudDoc.getObjectId("_id").toString());
        solicitud.setIdPersona(solicitudDoc.getString("idPersona"));
        solicitud.setEstado(solicitudDoc.getString("estado"));
        solicitud.setNombre(solicitudDoc.getString("nombre"));
        solicitud.setApellido(solicitudDoc.getString("apellido"));
        solicitud.setDireccion(solicitudDoc.getString("direccion"));
        solicitud.setNombreEmpresa(solicitudDoc.getString("empresa"));
        solicitud.setGenero(solicitudDoc.getString("genero"));
        solicitud.setNivelEducacion(solicitudDoc.getString("nivelEducacion"));
        solicitud.setTitulo(solicitudDoc.getString("titulo"));
        solicitud.setPromedioGraduacion(solicitudDoc.getString("promedioGraduacion"));
        solicitud.setEnfermedades(solicitudDoc.getString("enfermedades"));
        solicitud.setAntecedentes(solicitudDoc.getString("antecedentes"));
        solicitud.setServicioMilitar(solicitudDoc.getString("servicioMilitar"));
        solicitud.setExperiencia(solicitudDoc.getString("experiencia"));
        solicitud.setAnosExperiencia(solicitudDoc.getString("anosExperiencia"));
        solicitud.setHabilidades(solicitudDoc.getString("habilidades"));
        return solicitud;
    }

     private SolicitudDeEmpleo convertirDocumentoASolicitud1(Document solicitudDoc) {
        SolicitudDeEmpleo solicitud = new SolicitudDeEmpleo();
        solicitud.setId(solicitudDoc.getObjectId("_id").toString());
        solicitud.setIdPersona(solicitudDoc.getString("idPersona"));
        solicitud.setEstado(solicitudDoc.getString("estado"));
        solicitud.setNombreEmpresa(solicitudDoc.getString("nombreEmpresa"));
        return solicitud;
    }
     
    public List<SolicitudDeEmpleo> obtenerTodasLasSolicitudes() {
        List<SolicitudDeEmpleo> solicitudes = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document solicitudDoc = cursor.next();
                SolicitudDeEmpleo solicitud = convertirDocumentoASolicitud(solicitudDoc);
                solicitudes.add(solicitud);
            }
        }
        return solicitudes;
    }

    public List<SolicitudDeEmpleo> obtenerSolicitudesPorPersona() {
        List<SolicitudDeEmpleo> solicitudes = new ArrayList<>();
        for (Document doc : collection.find()) {
            solicitudes.add(convertirDocumentoASolicitud(doc));
        }
        return solicitudes;
    }
}
