package com.mycompany.proyectodb2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    private final MongoCollection<Document> collection;
    private final ConexionMongo conexion;

    public EmpresaDAO(ConexionMongo conexion) {
        this.conexion = conexion;
        // Conectar a la base de datos
        MongoDatabase database = conexion.obtenerBaseDatos();
        // Obtener la colección
        this.collection = database.getCollection("empresas");
    }

    // Método para insertar una nueva empresa
    public void insertarEmpresa(Empresa empresa) {
        Document empresaDocument = convertirEmpresaADocumento(empresa);
        collection.insertOne(empresaDocument);
    }

    // Método para actualizar una empresa existente
    public void actualizarEmpresa(Empresa empresa) {
        Document empresaDocument = convertirEmpresaADocumento(empresa);
        String idEmpresa = empresa.getId(); // Suponiendo que la empresa tiene un ID único
        Document filtro = new Document("_id", idEmpresa);
        collection.replaceOne(filtro, empresaDocument);
    }

    // Método para eliminar una empresa
    public void eliminarEmpresa(String idEmpresa) {
        Document filtro = new Document("_id", idEmpresa);
        collection.deleteOne(filtro);
    }

    // Método para obtener todas las empresas
    public List<Empresa> obtenerTodasLasEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document empresaDocument = cursor.next();
                Empresa empresa = convertirDocumentoAEmpresa(empresaDocument);
                empresas.add(empresa);
            }
        }
        return empresas;
    }

    // Método para convertir un objeto Empresa a un Documento MongoDB
    private Document convertirEmpresaADocumento(Empresa empresa) {
        Document documento = new Document("nombre", empresa.getNombre())
                .append("CIF", empresa.getCIF())
                .append("direccion", empresa.getDireccion())
                .append("telefono", empresa.getTelefono())
                .append("email", empresa.getEmail())
                .append("representante", empresa.getRepresentante());
        return documento;
    }

    // Método para convertir un Documento MongoDB a un objeto Empresa
    private Empresa convertirDocumentoAEmpresa(Document documento) {
        Empresa empresa = new Empresa();
        empresa.setId(documento.getString("_id"));
        empresa.setNombre(documento.getString("nombre"));
        empresa.setCIF(documento.getString("CIF"));
        empresa.setDireccion(documento.getString("direccion"));
        empresa.setTelefono(documento.getString("telefono"));
        empresa.setEmail(documento.getString("email"));
        empresa.setRepresentante(documento.getString("representante"));
        return empresa;
    }
}
