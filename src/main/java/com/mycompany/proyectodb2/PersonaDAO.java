package com.mycompany.proyectodb2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;
//prueba

public class PersonaDAO {

    private final MongoCollection<Document> collection;
    private ConexionMongo conexion;

    public PersonaDAO(ConexionMongo conexion) {
        this.conexion = conexion;
        // Conectar a la base de datos
        MongoDatabase database = conexion.obtenerBaseDatos();
        // Obtener la colección
        this.collection = database.getCollection("personas");
    }

    public void insertarPersona(Persona persona) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("personas");

        Document doc = new Document("nombre", persona.getNombre())
                .append("apellidos", persona.getApellidos())
                .append("dni", persona.getDni())
                .append("direccion", persona.getDireccion())
                .append("telefono", persona.getTelefono())
                .append("email", persona.getEmail())
                .append("usuario", persona.getUsuario()) // Nuevo campo
                .append("contrasena", persona.getContrasena()) // Nuevo campo
                .append("fecha_nac", persona.getFecha_nac()) // Nuevo campo
                .append("genero", persona.getGenero())
                .append("datosFamiliares", new Document("estadoCivil", persona.getDatosFamiliares().getEstadoCivil())
                        .append("numeroHijos", persona.getDatosFamiliares().getNumeroHijos())
                        .append("nombreConyuge", persona.getDatosFamiliares().getNombreConyuge()))
                .append("datosSanitarios", new Document("grupoSanguineo", persona.getDatosSanitarios().getGrupoSanguineo())
                        .append("alergias", persona.getDatosSanitarios().getAlergias())
                        .append("enfermedadesCronicas", persona.getDatosSanitarios().getEnfermedadesCronicas()))
                .append("datosLegales", new Document("servicioMilitar", persona.getDatosLegales().isServicioMilitar())
                        .append("estadolegal", persona.getDatosLegales().getEstadoLegal())
                        .append("antecedentes", persona.getDatosLegales().isAntecedentesPenales())
                        .append("promedio", persona.getDatosLegales().getPromedioGrad())
                        .append("niveledu", persona.getDatosLegales().getNivelEducacion())
                        .append("institucion", persona.getDatosLegales().getInstitucionEducativa())
                        .append("titulos", persona.getDatosLegales().getTitulosObtenidos())
                        .append("especializacion", persona.getDatosLegales().getEspecializacion()))
                .append("requisitos", new Document("puestossi", persona.getRequisitos().getPuestosSI())
                        .append("puestosno", persona.getRequisitos().getPuestosNO())
                        .append("disponibilidad", persona.getRequisitos().getDisponibilidad())
                        .append("contrato", persona.getRequisitos().getContrato())
                        .append("salario", persona.getRequisitos().getSalario()))
                .append("datosLaborales", new Document("historial", persona.getDatosLaborales().getHistorialEmp())
                        .append("aniosexperiencia", persona.getDatosLaborales().getAniosExperiencia()))
                .append("datosProfesionales", new Document("habilidades", persona.getDatosProfesionales().getHabilidades())
                        .append("expLab", persona.getDatosProfesionales().isExpLab()));

        collection.insertOne(doc);
    }

    public Persona buscarPersonaPorId(String id) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("personas");
        ObjectId objectId = new ObjectId(id);
        Document query = new Document("_id", objectId);
        Document result = collection.find(query).first();

        if (result != null) {
            Persona persona = new Persona();
            persona.setId(result.getObjectId("_id").toString());
            persona.setNombre(result.getString("nombre"));
            persona.setApellidos(result.getString("apellidos"));
            persona.setDni(result.getString("dni"));
            persona.setDireccion(result.getString("direccion"));
            persona.setTelefono(result.getString("telefono"));
            persona.setEmail(result.getString("email"));
            persona.setUsuario(result.getString("usuario")); // Nuevo campo
            persona.setContrasena(result.getString("contrasena")); // Nuevo campo
            persona.setGenero(result.getString("genero"));
            persona.setFecha_nac(result.getString("fecha_nac"));
            Document datosFamiliaresDoc = (Document) result.get("datosFamiliares");
            DatosFamiliares datosFamiliares = new DatosFamiliares();
            datosFamiliares.setEstadoCivil(datosFamiliaresDoc.getString("estadoCivil"));
            datosFamiliares.setNumeroHijos(datosFamiliaresDoc.getInteger("numeroHijos"));
            datosFamiliares.setNombreConyuge(datosFamiliaresDoc.getString("nombreConyuge"));
            persona.setDatosFamiliares(datosFamiliares);

            Document datosSanitariosDoc = (Document) result.get("datosSanitarios");
            DatosSanitarios datosSanitarios = new DatosSanitarios();
            datosSanitarios.setGrupoSanguineo(datosSanitariosDoc.getString("grupoSanguineo"));
            datosSanitarios.setAlergias(datosSanitariosDoc.getString("alergias"));
            datosSanitarios.setEnfermedadesCronicas(datosSanitariosDoc.getString("enfermedadesCronicas"));
            persona.setDatosSanitarios(datosSanitarios);

            Document datosLegalesDoc = (Document) result.get("datosLegales");
            DatosLegales datosLegales = new DatosLegales();
            datosLegales.setServicioMilitar(datosLegalesDoc.getBoolean("servicioMilitar"));
            datosLegales.setAntecedentesPenales(datosLegalesDoc.getBoolean("antecedentes"));
            datosLegales.setEspecializacion(datosLegalesDoc.getString("especializacion"));
            datosLegales.setEstadoLegal(datosLegalesDoc.getString("estadolegal"));
            datosLegales.setInstitucionEducativa(datosLegalesDoc.getString("institucion"));
            datosLegales.setNivelEducacion(datosLegalesDoc.getString("niveledu"));
            datosLegales.setPromedioGrad(datosLegalesDoc.getInteger("promedio"));
            datosLegales.setTitulosObtenidos(datosLegalesDoc.getString("titulos"));
            persona.setDatosLegales(datosLegales);

            Document requisitos = (Document) result.get("requisitos");
            RequisitosTrabajo req = new RequisitosTrabajo();
            req.setContrato(requisitos.getString("contrato"));
            req.setDisponibilidad(requisitos.getString("disponibilidad"));
            req.setPuestosNO(requisitos.getString("puestosno"));
            req.setPuestosSI(requisitos.getString("puestossi"));
            req.setSalario(requisitos.getInteger("salario"));
            persona.setRequisitos(req);
            
            Document datosLaborales = (Document) result.get("datosLaborales");
            DatosLaborales dat = new DatosLaborales();
            dat.setHistorialEmp(datosLaborales.getString("historial"));
            dat.setAniosExperiencia(datosLaborales.getInteger("aniosexperiencia"));
            persona.setDatosLaborales(dat);

            Document datosProfesionales = (Document) result.get("datosProfesionales");
            DatosProfesionales prof = new DatosProfesionales();
            prof.setHabilidades(datosProfesionales.getString("habilidades"));
            prof.setExpLab(datosProfesionales.getBoolean("expLab"));
            persona.setDatosProfesionales(prof);
            return persona;
        } else {
            return null;
        }
    }

    public Persona buscarPersonaPorUsuario(String usuario) {
        Document filtro = new Document("usuario", usuario);
        Document resultado = collection.find(filtro).first();
        if (resultado != null) {
            return convertirDocumentoAPersona(resultado);
        }
        return null;
    }

    public void actualizarPersona(Persona persona) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("personas");
        ObjectId objectId = new ObjectId(persona.getId());
        Document query = new Document("_id", objectId);
        Document update = new Document("$set", new Document("nombre", persona.getNombre())
                .append("apellidos", persona.getApellidos())
                .append("dni", persona.getDni())
                .append("direccion", persona.getDireccion())
                .append("telefono", persona.getTelefono())
                .append("email", persona.getEmail())
                .append("usuario", persona.getUsuario()) // Nuevo campo
                .append("contrasena", persona.getContrasena()) // Nuevo campo
                .append("genero", persona.getGenero())
                .append("fecha_nac", persona.getFecha_nac())
                .append("datosFamiliares", new Document("estadoCivil", persona.getDatosFamiliares().getEstadoCivil())
                        .append("numeroHijos", persona.getDatosFamiliares().getNumeroHijos())
                        .append("nombreConyuge", persona.getDatosFamiliares().getNombreConyuge()))
                .append("datosSanitarios", new Document("grupoSanguineo", persona.getDatosSanitarios().getGrupoSanguineo())
                        .append("alergias", persona.getDatosSanitarios().getAlergias())
                        .append("enfermedadesCronicas", persona.getDatosSanitarios().getEnfermedadesCronicas()))
                .append("datosLegales", new Document("servicioMilitar", persona.getDatosLegales().isServicioMilitar()).append("estadolegal", persona.getDatosLegales().getEstadoLegal())
                        .append("antecedentes", persona.getDatosLegales().isAntecedentesPenales())
                        .append("promedio", persona.getDatosLegales().getPromedioGrad())
                        .append("niveledu", persona.getDatosLegales().getNivelEducacion())
                        .append("institucion", persona.getDatosLegales().getInstitucionEducativa())
                        .append("titulos", persona.getDatosLegales().getTitulosObtenidos())
                        .append("especializacion", persona.getDatosLegales().getEspecializacion()))
                .append("requisitos", new Document("puestossi", persona.getRequisitos().getPuestosSI())
                        .append("puestosno", persona.getRequisitos().getPuestosNO())
                        .append("disponibilidad", persona.getRequisitos().getDisponibilidad())
                        .append("contrato", persona.getRequisitos().getContrato())
                        .append("salario", persona.getRequisitos().getSalario()))
                .append("datosLaborales", new Document("historial", persona.getDatosLaborales().getHistorialEmp())
                        .append("aniosexperiencia", persona.getDatosLaborales().getAniosExperiencia()))
                .append("datosProfesionales", new Document("habilidades", persona.getDatosProfesionales().getHabilidades())
                        .append("expLab", persona.getDatosProfesionales().isExpLab())));

        collection.updateOne(query, update);
    }

    public void eliminarPersona(String id) {
        MongoDatabase database = conexion.obtenerBaseDatos();
        MongoCollection<Document> collection = database.getCollection("personas");

        Document query = new Document("id", id);
        collection.deleteOne(query);
    }

    private Persona convertirDocumentoAPersona(Document result) {
        Persona persona = new Persona();
        persona.setId(result.getObjectId("_id").toString());
        persona.setNombre(result.getString("nombre"));
        persona.setApellidos(result.getString("apellidos"));
        persona.setDni(result.getString("dni"));
        persona.setDireccion(result.getString("direccion"));
        persona.setTelefono(result.getString("telefono"));
        persona.setEmail(result.getString("email"));
        persona.setUsuario(result.getString("usuario")); // Nuevo campo
        persona.setContrasena(result.getString("contrasena")); // Nuevo campo
        persona.setGenero(result.getString("genero"));
        persona.setFecha_nac(result.getString("fecha_nac"));
        Document datosFamiliaresDoc = (Document) result.get("datosFamiliares");
        DatosFamiliares datosFamiliares = new DatosFamiliares();
        datosFamiliares.setEstadoCivil(datosFamiliaresDoc.getString("estadoCivil"));
        datosFamiliares.setNumeroHijos(datosFamiliaresDoc.getInteger("numeroHijos"));
        datosFamiliares.setNombreConyuge(datosFamiliaresDoc.getString("nombreConyuge"));
        persona.setDatosFamiliares(datosFamiliares);

        Document datosSanitariosDoc = (Document) result.get("datosSanitarios");
        DatosSanitarios datosSanitarios = new DatosSanitarios();
        datosSanitarios.setGrupoSanguineo(datosSanitariosDoc.getString("grupoSanguineo"));
        datosSanitarios.setAlergias(datosSanitariosDoc.getString("alergias"));
        datosSanitarios.setEnfermedadesCronicas(datosSanitariosDoc.getString("enfermedadesCronicas"));
        persona.setDatosSanitarios(datosSanitarios);

        Document datosLegalesDoc = (Document) result.get("datosLegales");
        DatosLegales datosLegales = new DatosLegales();
        datosLegales.setServicioMilitar(datosLegalesDoc.getBoolean("servicioMilitar"));
        datosLegales.setAntecedentesPenales(datosLegalesDoc.getBoolean("antecedentes"));
        datosLegales.setEspecializacion(datosLegalesDoc.getString("especializacion"));
        datosLegales.setEstadoLegal(datosLegalesDoc.getString("estadolegal"));
        datosLegales.setInstitucionEducativa(datosLegalesDoc.getString("institucion"));
        datosLegales.setNivelEducacion(datosLegalesDoc.getString("niveledu"));
        datosLegales.setPromedioGrad(datosLegalesDoc.getInteger("promedio"));
        datosLegales.setTitulosObtenidos(datosLegalesDoc.getString("titulos"));
        persona.setDatosLegales(datosLegales);

        Document requisitos = (Document) result.get("requisitos");
        RequisitosTrabajo req = new RequisitosTrabajo();
        req.setContrato(requisitos.getString("contrato"));
        req.setDisponibilidad(requisitos.getString("disponibilidad"));
        req.setPuestosNO(requisitos.getString("puestosno"));
        req.setPuestosSI(requisitos.getString("puestossi"));
        req.setSalario(requisitos.getInteger("salario"));
        persona.setRequisitos(req);

        Document datosLaborales = (Document) result.get("datosLaborales");
        DatosLaborales dat = new DatosLaborales();
        dat.setHistorialEmp(datosLaborales.getString("historial"));
        dat.setAniosExperiencia(datosLaborales.getInteger("aniosexperiencia"));
        persona.setDatosLaborales(dat);

        Document datosProfesionales = (Document) result.get("datosProfesionales");
        DatosProfesionales prof = new DatosProfesionales();
        prof.setHabilidades(datosProfesionales.getString("habilidades"));
        prof.setExpLab(datosProfesionales.getBoolean("expLab"));
        persona.setDatosProfesionales(prof);
        return persona;
    }

    public List<Persona> obtenerTodasLasPersonas() {
        List<Persona> personas = new ArrayList<>();
        try ( MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document personaDocument = cursor.next();
                Persona persona = convertirDocumentoAPersona(personaDocument);
                personas.add(persona);
                System.out.println(persona.toString());
            }
        }
        return personas;
    }
}
