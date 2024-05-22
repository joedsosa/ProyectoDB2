
import com.mycompany.proyectodb2.ConexionMongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mycompany.proyectodb2.DatosAcademicos;
import com.mycompany.proyectodb2.DatosFamiliares;
import com.mycompany.proyectodb2.DatosLaborales;
import com.mycompany.proyectodb2.DatosLegales;
import com.mycompany.proyectodb2.DatosProfesionales;
import com.mycompany.proyectodb2.DatosSanitarios;
import com.mycompany.proyectodb2.Persona;
import com.mycompany.proyectodb2.RequisitosCondicionesEmpleo;
import com.mycompany.proyectodb2.RequisitosEmpleo;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    private final MongoCollection<Document> collection;
    private final ConexionMongo conexion;

    public PersonaDAO(ConexionMongo conexion) {
        this.conexion = conexion;
        // Conectar a la base de datos
        MongoDatabase database = conexion.obtenerBaseDatos();
        // Obtener la colección
        this.collection = database.getCollection("agency_management");
    }

    // Método para insertar una nueva persona
    public void insertarPersona(Persona persona) {
        Document personaDocument = convertirPersonaADocumento(persona);
        collection.insertOne(personaDocument);
    }

    // Método para actualizar una persona existente
    public void actualizarPersona(Persona persona) {
        Document personaDocument = convertirPersonaADocumento(persona);
        String idPersona = persona.getId(); // Suponiendo que la persona tiene un ID único
        Document filtro = new Document("_id", idPersona);
        collection.replaceOne(filtro, personaDocument);
    }

    // Método para eliminar una persona
    public void eliminarPersona(String idPersona) {
        Document filtro = new Document("_id", idPersona);
        collection.deleteOne(filtro);
    }

    // Método para obtener todas las personas
    public List<Persona> obtenerTodasLasPersonas() {
        List<Persona> personas = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document personaDocument = cursor.next();
                Persona persona = convertirDocumentoAPersona(personaDocument);
                personas.add(persona);
            }
        }
        return personas;
    }

    // Método para convertir un objeto Persona a un Documento MongoDB
    private Document convertirPersonaADocumento(Persona persona) {
        Document documento = new Document("nombre", persona.getNombre())
                .append("apellidos", persona.getApellidos())
                .append("dni", persona.getDni())
                .append("direccion", persona.getDireccion())
                .append("telefono", persona.getTelefono())
                .append("email", persona.getEmail())
                .append("estadoCivil", persona.getEstadoCivil())
                .append("datosFamiliares", convertirDatosFamiliaresADocumento(persona.getDatosFamiliares()))
                .append("datosSanitarios", convertirDatosSanitariosADocumento(persona.getDatosSanitarios()))
                .append("datosLegales", convertirDatosLegalesADocumento(persona.getDatosLegales()))
                .append("datosProfesionales", convertirDatosProfesionalesADocumento(persona.getDatosProfesionales()))
                .append("datosLaborales", convertirDatosLaboralesADocumento(persona.getDatosLaborales()))
                .append("datosAcademicos", convertirDatosAcademicosADocumento(persona.getDatosAcademicos()))
                .append("requisitosEmpleo", convertirRequisitosEmpleoADocumento(persona.getRequisitosEmpleo()))
                .append("requisitosCondicionesEmpleo", convertirRequisitosCondicionesEmpleoADocumento(persona.getRequisitosCondicionesEmpleo()));
        return documento;
    }

    // Métodos para convertir cada subclase de datos a Documento
    private Document convertirDatosFamiliaresADocumento(DatosFamiliares datosFamiliares) {
        return new Document("estadoCivil", datosFamiliares.getEstadoCivil())
                .append("numeroHijos", datosFamiliares.getNumeroHijos())
                .append("nombreConyuge", datosFamiliares.getNombreConyuge());
    }

    private Document convertirDatosSanitariosADocumento(DatosSanitarios datosSanitarios) {
        return new Document("grupoSanguineo", datosSanitarios.getGrupoSanguineo())
                .append("alergias", datosSanitarios.getAlergias())
                .append("enfermedadesCronicas", datosSanitarios.getEnfermedadesCronicas());
    }

    private Document convertirDatosLegalesADocumento(DatosLegales datosLegales) {
        return new Document("servicioMilitar", datosLegales.isServicioMilitar())
                .append("antecedentesPenales", datosLegales.isAntecedentesPenales());
    }

    private Document convertirDatosProfesionalesADocumento(DatosProfesionales datosProfesionales) {
        return new Document("conocimientos", datosProfesionales.getConocimientos())
                .append("habilidades", datosProfesionales.getHabilidades());
    }

    private Document convertirDatosLaboralesADocumento(DatosLaborales datosLaborales) {
        return new Document("empresa", datosLaborales.getEmpresa())
                .append("puesto", datosLaborales.getPuesto())
                .append("aniosExperiencia", datosLaborales.getAniosExperiencia());
    }

    private Document convertirDatosAcademicosADocumento(DatosAcademicos datosAcademicos) {
        Document documento = new Document();
        if (datosAcademicos != null) {
            documento.append("titulo", datosAcademicos.getTitulo())
                    .append("institucion", datosAcademicos.getInstitucion())
                    .append("anioGraduacion", datosAcademicos.getAnioGraduacion());
        }
        return documento;
    }

    private Document convertirRequisitosEmpleoADocumento(RequisitosEmpleo requisitosEmpleo) {
        Document documento = new Document();
        if (requisitosEmpleo != null) {
            documento.append("puestosAceptables", requisitosEmpleo.getPuestosAceptables())
                    .append("puestosNoAceptables", requisitosEmpleo.getPuestosNoAceptables());
        }
        return documento;
    }

    private Document convertirRequisitosCondicionesEmpleoADocumento(RequisitosCondicionesEmpleo requisitosCondicionesEmpleo) {
        Document documento = new Document();
        if (requisitosCondicionesEmpleo != null) {
            documento.append("tipoContrato", requisitosCondicionesEmpleo.getTipoContrato())
                    .append("salarioMinimo", requisitosCondicionesEmpleo.getSalarioMinimo());
        }
        return documento;
    }

    // Método para convertir un Documento MongoDB a un objeto Persona
    private Persona convertirDocumentoAPersona(Document documento) {
        Persona persona = new Persona();
        persona.setId(documento.getString("_id"));
        persona.setNombre(documento.getString("nombre"));
        persona.setApellidos(documento.getString("apellidos"));
        persona.setDni(documento.getString("dni"));
        persona.setDireccion(documento.getString("direccion"));
        persona.setTelefono(documento.getString("telefono"));
        persona.setEmail(documento.getString("email"));
        persona.setEstadoCivil(documento.getString("estadoCivil"));
        persona.setDatosFamiliares(convertirDocumentoADatosFamiliares(documento.get("datosFamiliares", Document.class)));
        persona.setDatosSanitarios(convertirDocumentoADatosSanitarios(documento.get("datosSanitarios", Document.class)));
        persona.setDatosLegales(convertirDocumentoADatosLegales(documento.get("datosLegales", Document.class)));
        persona.setDatosProfesionales(convertirDocumentoADatosProfesionales(documento.get("datosProfesionales", Document.class)));
        persona.setDatosLaborales(convertirDocumentoADatosLaborales(documento.get("datosLaborales", Document.class)));
        // Completa la conversión de datos adicionales aquí
        return persona;
    }

    // Métodos para convertir de Documento a subclases de datos
    private DatosFamiliares convertirDocumentoADatosFamiliares(Document documento) {
        DatosFamiliares datosFamiliares = new DatosFamiliares();
        if (documento != null) {
            datosFamiliares.setEstadoCivil(documento.getString("estadoCivil"));
            datosFamiliares.setNumeroHijos(documento.getInteger("numeroHijos"));
            datosFamiliares.setNombreConyuge(documento.getString("nombreConyuge"));
        }
        return datosFamiliares;
    }

    private DatosSanitarios convertirDocumentoADatosSanitarios(Document documento) {
        DatosSanitarios datosSanitarios = new DatosSanitarios();
        if (documento != null) {
            datosSanitarios.setGrupoSanguineo(documento.getString("grupoSanguineo"));
            datosSanitarios.setAlergias(documento.getString("alergias"));
            datosSanitarios.setEnfermedadesCronicas(documento.getString("enfermedadesCronicas"));
        }
        return datosSanitarios;
    }

    private DatosLegales convertirDocumentoADatosLegales(Document documento) {
        DatosLegales datosLegales = new DatosLegales();
        if (documento != null) {
            datosLegales.setServicioMilitar(documento.getBoolean("servicioMilitar"));
            datosLegales.setAntecedentesPenales(documento.getBoolean("antecedentesPenales"));
        }
        return datosLegales;
    }

    private DatosProfesionales convertirDocumentoADatosProfesionales(Document documento) {
        DatosProfesionales datosProfesionales = new DatosProfesionales();
        if (documento != null) {
            datosProfesionales.setConocimientos(documento.getString("conocimientos"));
            datosProfesionales.setHabilidades(documento.getString("habilidades"));
        }
        return datosProfesionales;
    }

    private DatosLaborales convertirDocumentoADatosLaborales(Document documento) {
        DatosLaborales datosLaborales = new DatosLaborales();
        if (documento != null) {
            datosLaborales.setEmpresa(documento.getString("empresa"));
            datosLaborales.setPuesto(documento.getString("puesto"));
            datosLaborales.setAniosExperiencia(documento.getInteger("aniosExperiencia"));
        }
        return datosLaborales;
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        conexion.cerrarConexion();
    }
}
