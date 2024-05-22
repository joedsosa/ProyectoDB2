
package com.mycompany.proyectodb2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDAO {
    private final MongoCollection<Document> collection;
    private final ConexionMongo conexion;

    public SolicitudDAO() {
        // Conectar a la base de datos
        conexion = new ConexionMongo();
        // Obtener la colección
        this.collection = conexion.obtenerBaseDatos().getCollection("solicitudes_de_empleo");
    }

    // Método para insertar una nueva solicitud de empleo
    public void insertarSolicitud(SolicitudDeEmpleo solicitud) {
        Document solicitudDocument = convertirSolicitudADocumento(solicitud);
        collection.insertOne(solicitudDocument);
    }

    // Método para obtener todas las solicitudes de empleo
    public List<SolicitudDeEmpleo> obtenerTodasLasSolicitudes() {
        List<SolicitudDeEmpleo> solicitudes = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document solicitudDocument = cursor.next();
                SolicitudDeEmpleo solicitud = convertirDocumentoASolicitud(solicitudDocument);
                solicitudes.add(solicitud);
            }
        }
        return solicitudes;
    }

    // Método para convertir un objeto SolicitudDeEmpleo a un Documento MongoDB
    private Document convertirSolicitudADocumento(SolicitudDeEmpleo solicitud) {
        Document documento = new Document("idPersona", solicitud.getIdPersona())
                .append("idEmpresa", solicitud.getIdEmpresa())
                .append("puesto", solicitud.getPuesto())
                .append("estado", solicitud.getEstado())
                .append("descripcion", solicitud.getDescripcion());
        return documento;
    }

    // Método para convertir un Documento MongoDB a un objeto SolicitudDeEmpleo
    private SolicitudDeEmpleo convertirDocumentoASolicitud(Document documento) {
        SolicitudDeEmpleo solicitud = new SolicitudDeEmpleo();
        solicitud.setId(documento.getString("_id"));
        solicitud.setIdPersona(documento.getString("idPersona"));
        solicitud.setIdEmpresa(documento.getString("idEmpresa"));
        solicitud.setPuesto(documento.getString("puesto"));
        solicitud.setEstado(documento.getString("estado"));
        solicitud.setDescripcion(documento.getString("descripcion"));
        return solicitud;
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        conexion.cerrarConexion();
    }
}
