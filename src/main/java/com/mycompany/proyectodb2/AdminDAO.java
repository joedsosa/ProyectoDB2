package com.mycompany.proyectodb2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class AdminDAO {

    private final MongoCollection<Document> collection;

    public AdminDAO(ConexionMongo conexion) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        this.collection = database.getCollection("admins");
    }

    // Método para insertar un nuevo admin
    public void insertarAdmin(Admin admin) {
        Document adminDocument = convertirAdminADocumento(admin);
        collection.insertOne(adminDocument);
    }

    // Método para convertir un objeto Admin a un Documento MongoDB
    private Document convertirAdminADocumento(Admin admin) {
        return new Document("nombre", admin.getNombre())
                .append("apellido", admin.getApellido())
                .append("nombreUsuario", admin.getNombreUsuario())
                .append("contrasena", admin.getContrasena());
    }

    public Admin buscarAdminPorUsuario(String usuario) {
        Document filtro = new Document("nombreUsuario", usuario); // Asegúrate de que el campo en la base de datos se llama "nombreUsuario"
        Document resultado = collection.find(filtro).first();
        if (resultado != null) {
            return convertirDocumentoAAdmin(resultado);
        }
        return null; // Retorna null si no se encontró ningún resultado
    }

    private Admin convertirDocumentoAAdmin(Document documento) {
        Admin admin = new Admin();
        admin.setNombre(documento.getString("nombre"));
        admin.setApellido(documento.getString("apellido"));
        admin.setNombreUsuario(documento.getString("nombreUsuario"));
        admin.setContrasena(documento.getString("contrasena"));
        return admin;
    }

}