/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectodb2;

import java.util.Scanner;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.lang.System;
import java.lang.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
//import com.mongodb.*;
//import org.bson.BsonDocument;
//import org.bson.BsonInt64;
//import org.bson.Document;
//import org.bson.conversions.Bson;

/**
 *
 * @author HTS
 */




public class LogIn extends javax.swing.JFrame {
public static MongoClient mongoClient = null;
public static MongoDatabase database = null;
    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
        mando();
        this.setExtendedState(MAXIMIZED_BOTH);
        JP_Contrataciones.setVisible(false);
        JP_CrearEmpresa.setVisible(false);
        JP_CrearPersonaFamiliares_Sanitarios.setVisible(false);
        JP_CrearPersonaLegales_Academicos.setVisible(false);
        JP_CrearPersonaPersonal.setVisible(false);
        JP_CrearPersonaProfesional_Laboral.setVisible(false);
        JP_CrearPersonaRequisitos_Condiciones.setVisible(false);
        JP_CrearPuesto.setVisible(false);
        JP_CrearSolicitud.setVisible(false);
        JP_EliminarEmpresa.setVisible(false);
        JP_EliminarPersona.setVisible(false);
        JP_EliminarPuesto.setVisible(false);
        JP_EliminarSolicitud.setVisible(false);
        JP_MiSolicitudPersona.setVisible(false);
        JP_ModEmpresa.setVisible(false);
        JP_ModPersonaFamiliares_Sanitarios.setVisible(false);
        JP_ModPersonaLegales_Academicos.setVisible(false);
        JP_ModPersonaPersonal.setVisible(false);
        JP_ModPersonaProfesional_Laboral.setVisible(false);
        JP_ModPersonaRequisitos_Condiciones.setVisible(false);
        JP_ModPuesto.setVisible(false);
        JP_PuestosDispiniblesPersona.setVisible(false);
        JP_SolicitudesEmpresas.setVisible(false);
        JP_PuestosOfrecidosEmpresa.setVisible(false);
        JP_SolicitudesEmpresas.setVisible(false);
        JP_PuestosOfrecidosEmpresa.setVisible(false);
        System.out.println("Hola");
        System.out.println("prueba");
    }
private static boolean connect() {
        if (mongoClient == null) {
            try {
                ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
                MongoClientSettings settings = MongoClientSettings.builder()
                        .applyConnectionString(connectionString)
                        .build();
                mongoClient = MongoClients.create(settings);
                database = mongoClient.getDatabase("empresa_db");
                System.out.println("Connected to MongoDB successfully.");
                return true;
            } catch (Exception e) {
                System.err.println("Failed to connect to MongoDB: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        if (!connect()) {
            throw new RuntimeException("Failed to connect to MongoDB.");
        }
        return database.getCollection(collectionName);
    }

    public static void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = getCollection(collectionName);
        collection.insertOne(document);
        System.out.println("Document inserted successfully into collection: " + collectionName);
    }

    public static List<Document> findDocuments(String collectionName) {
        MongoCollection<Document> collection = getCollection(collectionName);
        return collection.find().into(new ArrayList<>());
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            System.out.println("Disconnected from MongoDB.");
        }
    }

    public static void mando(){
        try {
            // Insert a document
            Document doc = new Document("name", "Project A")
                    .append("description", "A sample project")
                    .append("status", "active");
            insertDocument("proyecto", doc);

            // Find and print all documents
            List<Document> documents = findDocuments("proyecto");
            for (Document document : documents) {
                System.out.println(document.toJson());
            }
        } finally {
            // Close the connection
            close();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JF_Admin = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        JB_CrudAdmin = new javax.swing.JButton();
        JB_CerrarSesionAdmin = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JB_Contrataciones = new javax.swing.JButton();
        JP_CRUD = new javax.swing.JPanel();
        JB_CRUDPersonas = new javax.swing.JButton();
        JB_CRUDEmpresas = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        JB_CRUDSolicitudes = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        JB_CRUDPuestos = new javax.swing.JButton();
        JP_Contrataciones = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        JT_Solicitudes = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        JB_Contratar = new javax.swing.JButton();
        JF_CrudPersonas = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        JB_CrearPersona = new javax.swing.JButton();
        JB_ModificarPersona = new javax.swing.JButton();
        JB_EliminarPersona = new javax.swing.JButton();
        JP_CrearPersonaPersonal = new javax.swing.JPanel();
        TF_CrearUsuarioPersona = new javax.swing.JTextField();
        TF_CrearPasswordPersona = new javax.swing.JTextField();
        JB_CrearSiguientePersonalPersona = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jl_TelefonoCompania = new javax.swing.JLabel();
        TF_DireccionCrearPersona = new javax.swing.JTextField();
        TF_CrearNombrePersona = new javax.swing.JTextField();
        TF_CrearCelular = new javax.swing.JTextField();
        TF_CrearCorreoPersona = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        TF_CrearApellidoPersona = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TF_CrearFechaPersona = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CB_CrearGeneroPersona = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        TF_CrearIdPersona = new javax.swing.JTextField();
        JP_CrearPersonaFamiliares_Sanitarios = new javax.swing.JPanel();
        TF_CrearConyugePersona = new javax.swing.JTextField();
        TF_Crear2HijoPersona = new javax.swing.JTextField();
        CB_CrearGrupoSanguineoPersona = new javax.swing.JComboBox<>();
        JB_CrearSiguienteFamiliar_SanitariosPersona = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        TF_CrearDependiente2Persona = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        TF_CrearAlergiasPersona = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        TF_CrearEnfermedadesCronicasPersona = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        TF_CrearDependiente3Persona = new javax.swing.JTextField();
        TF_CrearDependiente1Persona = new javax.swing.JTextField();
        TF_Crear3HijoPersona = new javax.swing.JTextField();
        TF_Crear1HijoPersona = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        CB_CrearEstadoCivilPersona = new javax.swing.JComboBox<>();
        JP_CrearPersonaLegales_Academicos = new javax.swing.JPanel();
        TF_CrearAntecedentesPenalesPersona = new javax.swing.JTextField();
        CB_CrearNivelEducacionPersona = new javax.swing.JComboBox<>();
        JB_CrearSiguienteLegales_AcademicosPersona = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        TF_CrearDNIPersona = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jl_TelefonoCompania4 = new javax.swing.JLabel();
        TF_CrearTitulosObtenidos2Persona = new javax.swing.JTextField();
        TF_CrearEspecializacionPersona = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        TF_CrearInstitucionEducativaPersona = new javax.swing.JTextField();
        CB_CrearServicioMilitarPersona = new javax.swing.JComboBox<>();
        TF_CrearTitulosObtenidos3Persona = new javax.swing.JTextField();
        TF_CrearTitulosObtenidos1Persona = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        JS_CrearPromedioGraduacionPersona = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        CB_CrearEstadoLegalPersona = new javax.swing.JComboBox<>();
        JP_CrearPersonaProfesional_Laboral = new javax.swing.JPanel();
        TF_CrearHabilidadesPersona = new javax.swing.JTextField();
        TF_CrearCertificaciones2Persona = new javax.swing.JTextField();
        CB_CrearExperienciaLaboralPersona = new javax.swing.JComboBox<>();
        JB_CrearSiguienteProfesional_LaboralPersona = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        TF_CrearCertificaciones3Persona = new javax.swing.JTextField();
        TF_CrearCertificaciones1Persona = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_CrearHistorialEmpleoPersona = new javax.swing.JTextArea();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        JS_CrearYearsExperienciaPersona = new javax.swing.JSpinner();
        jLabel132 = new javax.swing.JLabel();
        JP_CrearPersonaRequisitos_Condiciones = new javax.swing.JPanel();
        JB_ConfirmarCrearPersona = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_CrearPuestosDeseadosPersona = new javax.swing.JTextArea();
        jLabel102 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TA_CrearPuestosNoDeseadosPersona = new javax.swing.JTextArea();
        jLabel101 = new javax.swing.JLabel();
        JS_CrearSalarioDeseadoPersona = new javax.swing.JSpinner();
        jLabel91 = new javax.swing.JLabel();
        CB_CrearDisponibilidadHorariaPersona = new javax.swing.JComboBox<>();
        CB_CrearTipoContratoPersona = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        JP_ModPersonaPersonal = new javax.swing.JPanel();
        ModSiguientePersonaPersonal = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        JT_ModPersona = new javax.swing.JTable();
        jLabel66 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        TF_ModNombrePersona = new javax.swing.JTextField();
        TF_ModApellidoPersona = new javax.swing.JTextField();
        TF_ModCorreoPersona = new javax.swing.JTextField();
        CB_ModGeneroPersona = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jl_TelefonoCompania1 = new javax.swing.JLabel();
        TF_ModCelularPersona = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        TF_ModDireccionPersona = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TF_ModFechaNaciemientoPersona = new javax.swing.JTextField();
        TF_ModIdPersona = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        JP_ModPersonaFamiliares_Sanitarios = new javax.swing.JPanel();
        TF_ModConyugePersona = new javax.swing.JTextField();
        TF_Mod2HijoPersona = new javax.swing.JTextField();
        CB_ModGrupoSanguineoPersona = new javax.swing.JComboBox<>();
        JB_ModSiguienteLegales_AcademicosPersonas = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        TF_ModDependiente2Persona = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        TF_ModAlergiasPersona = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        TF_ModEnfermedadesCronicasPersona = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        TF_ModDependiente3Persona = new javax.swing.JTextField();
        TF_ModDependiente1Persona = new javax.swing.JTextField();
        TF_Mod3HijoPersona = new javax.swing.JTextField();
        TF_Mod1HijoPersona = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        CB_ModEstadoCivilPersona = new javax.swing.JComboBox<>();
        JP_ModPersonaLegales_Academicos = new javax.swing.JPanel();
        TF_ModAntecedentesPenalesPersona = new javax.swing.JTextField();
        CB_ModNivelEducacionPersona = new javax.swing.JComboBox<>();
        JB_ModSiguienteProfecionales_LaboralesPersona = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        TF_ModDNIPersona = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jl_TelefonoCompania5 = new javax.swing.JLabel();
        TF_ModTitulosObtenidos2Persona = new javax.swing.JTextField();
        TF_ModEspecializacionPersona = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        TF_ModInstitucionEducativaPersona = new javax.swing.JTextField();
        CB_ModEstadoLegalPersona = new javax.swing.JComboBox<>();
        TF_ModTitulosObtenidos3Persona = new javax.swing.JTextField();
        TF_ModrTitulosObtenidos1Persona = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        JS_ModPromedioGraduacionPersona = new javax.swing.JSpinner();
        CB_ModServicioMilitarPersona = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        JP_ModPersonaProfesional_Laboral = new javax.swing.JPanel();
        TF_ModHabilidadesPersona = new javax.swing.JTextField();
        TF_ModCertificaciones2Persona = new javax.swing.JTextField();
        CB_ModExperienciaLaboralPersona = new javax.swing.JComboBox<>();
        JB_ModSiguienteRequisitos_CondicionesPersona = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        TF_ModCertificaciones3Persona = new javax.swing.JTextField();
        TF_ModCertificaciones1Persona = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TA_ModHistorialEmpleoPersona = new javax.swing.JTextArea();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        JS_CrearAñosExperienciaPersona = new javax.swing.JSpinner();
        JP_ModPersonaRequisitos_Condiciones = new javax.swing.JPanel();
        JB_ConfirmarModPersona = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TA_ModPuestosDeseadosPersona = new javax.swing.JTextArea();
        jLabel122 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TA_ModPuestosNoDeseadosPersona = new javax.swing.JTextArea();
        jLabel123 = new javax.swing.JLabel();
        JS_ModSalarioDeseadoPersona = new javax.swing.JSpinner();
        jLabel124 = new javax.swing.JLabel();
        CB_ModDisponibilidadHorariaPersona = new javax.swing.JComboBox<>();
        CB_ModTipoContratoPersona = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        JP_EliminarPersona = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        JT_EliminarPersona = new javax.swing.JTable();
        JB_ConfirmarEliminarPersona = new javax.swing.JButton();
        JF_CrudEmpresa = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        JB_CrearEmpresa = new javax.swing.JButton();
        JB_ModificarEmpresa = new javax.swing.JButton();
        JB_EliminarEmpresa = new javax.swing.JButton();
        JP_CrearEmpresa = new javax.swing.JPanel();
        TF_CrearUsuarioEmpresa = new javax.swing.JTextField();
        TF_CrearContrasenaEmpresa = new javax.swing.JTextField();
        JB_ConfirmarCrearEmpresa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        TF_CrearIdEmpresa = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jl_TelefonoCompania2 = new javax.swing.JLabel();
        TF_CrearDireccionEmpresa = new javax.swing.JTextField();
        TF_CrearNombreEmpresa = new javax.swing.JTextField();
        TF_CrearCorreoEmpresa = new javax.swing.JTextField();
        TF_CrearTelefonoEmpresa = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        TF_CrearCIFEmpresa = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        TF_CrearSectorActividadEmpresa = new javax.swing.JTextField();
        JP_ModEmpresa = new javax.swing.JPanel();
        JB_ConfirmarModEmpresa = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        JT_ModEmpresa = new javax.swing.JTable();
        jLabel67 = new javax.swing.JLabel();
        TF_ModIdEmpresa = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        TF_ModSectorActividadEmpresa = new javax.swing.JTextField();
        TF_ModNombreEmpresa = new javax.swing.JTextField();
        TF_ModCIFEmpresa = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        TF_ModDireccionEmpresa = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        jl_TelefonoCompania6 = new javax.swing.JLabel();
        TF_ModCorreoEmpresa = new javax.swing.JTextField();
        TF_ModTelefonoEmpresa = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        JP_EliminarEmpresa = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        JT_EliminarEmpresa = new javax.swing.JTable();
        JB_ConfirmarEliminarEmpresa = new javax.swing.JButton();
        JF_CrudPuestoDeTrabajo = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        JB_CrearPuesto = new javax.swing.JButton();
        JB_ModificarPuesto = new javax.swing.JButton();
        JB_EliminarPuesto = new javax.swing.JButton();
        JP_CrearPuesto = new javax.swing.JPanel();
        TF_CrearNivelEducacionPuesto = new javax.swing.JTextField();
        JB_ConfirmarCrearPuesto = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jl_TelefonoCompania3 = new javax.swing.JLabel();
        TF_CrearHabilidadesPuesto = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        TF_CrearTituloPuesto = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        TF_CrearTipodePuesto = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        CB_CrearGeneroPuesto = new javax.swing.JComboBox<>();
        JS_CrearPromedioGraduacionPuesto = new javax.swing.JSpinner();
        jLabel93 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        TF_CrearEnfermedadesPuesto = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        TF_CrearAntecedentesPuesto = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        CB_CrearExperienciaPuesto = new javax.swing.JComboBox<>();
        jLabel153 = new javax.swing.JLabel();
        CB_CrearHorarioSueldo = new javax.swing.JComboBox<>();
        jLabel154 = new javax.swing.JLabel();
        JS_CrearSueldoPuesto = new javax.swing.JSpinner();
        jLabel155 = new javax.swing.JLabel();
        JS_CrearAñosExperienciaPuesto = new javax.swing.JSpinner();
        CB_CrearServicioMilitarPuesto = new javax.swing.JComboBox<>();
        CB_CrearContratoPuesto = new javax.swing.JComboBox<>();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        JT_CrearPuestroDeTrabajo = new javax.swing.JTable();
        TF_CrearDireccionPuesto = new javax.swing.JTextField();
        jLabel205 = new javax.swing.JLabel();
        JP_ModPuesto = new javax.swing.JPanel();
        JB_ConfirmarModEmpresa1 = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        JT_ModPuestroDeTrabajo = new javax.swing.JTable();
        jLabel156 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        TF_ModDireccionPuesto = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        CB_ModGeneroPuesto = new javax.swing.JComboBox<>();
        jLabel160 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        TF_ModNivelEducacionPuesto = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        TF_ModTituloPuesto = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        JS_ModPromedioGraduacionPuesto = new javax.swing.JSpinner();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        TF_ModEnfermedadesPuesto = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        CB_ModExperienciaPuesto = new javax.swing.JComboBox<>();
        JS_ModAñosExperienciaPuesto = new javax.swing.JSpinner();
        jLabel167 = new javax.swing.JLabel();
        TF_ModHabilidadesPuesto = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        TF_ModAntecedentesPuesto = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        CB_ModServicioMilitarPuesto = new javax.swing.JComboBox<>();
        jLabel171 = new javax.swing.JLabel();
        jl_TelefonoCompania8 = new javax.swing.JLabel();
        JS_ModSueldoPuesto = new javax.swing.JSpinner();
        jLabel172 = new javax.swing.JLabel();
        CB_ModHorarioSueldo = new javax.swing.JComboBox<>();
        jLabel173 = new javax.swing.JLabel();
        CB_ModContratoPuesto = new javax.swing.JComboBox<>();
        jLabel206 = new javax.swing.JLabel();
        TF_ModTipodePuesto = new javax.swing.JTextField();
        JP_EliminarPuesto = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        JT_EliminarPuesto = new javax.swing.JTable();
        JB_ConfirmarEliminarPuesto = new javax.swing.JButton();
        JF_CrudSolicitudEmpleo = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        JB_CrearSolicitud = new javax.swing.JButton();
        JB_EliminarSolicitud = new javax.swing.JButton();
        JP_CrearSolicitud = new javax.swing.JPanel();
        TF_CrearSolicitudApellido = new javax.swing.JTextField();
        JB_ConfirmarCrearSolicitud = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        TF_CrearSolicitudNombre = new javax.swing.JTextField();
        jScrollPane25 = new javax.swing.JScrollPane();
        JT_ModEmpresa2 = new javax.swing.JTable();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        TF_CrearSolicitudDireccion = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        TF_CrearSolicitudNivelEdicacion = new javax.swing.JTextField();
        jLabel177 = new javax.swing.JLabel();
        TF_CrearSolicitudTitulo = new javax.swing.JTextField();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        TF_CrearSolicitudEnfermedades = new javax.swing.JTextField();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        TF_CrearSolicitudGenero = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        TF_CrearSolicitudContrato = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jl_TelefonoCompania9 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        TF_CrearSolicitudHabilidades = new javax.swing.JTextField();
        TF_CrearSolicitudExperiencia = new javax.swing.JTextField();
        TF_CrearSolicitudAniosExperiencia = new javax.swing.JTextField();
        TF_CrearSolicitudPromedioGraduacion = new javax.swing.JTextField();
        TF_CrearSolicitudAntecedentes = new javax.swing.JTextField();
        TF_CrearSolicitudServicioMilitar = new javax.swing.JTextField();
        TF_CrearSolicitudSueldo = new javax.swing.JTextField();
        TF_CrearSolicitudHorario = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TA_CrearSolicitudPuestoDeseado = new javax.swing.JTextArea();
        jLabel145 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TA_CrearSolicitudPuestoNoDeseado = new javax.swing.JTextArea();
        JP_EliminarSolicitud = new javax.swing.JPanel();
        JB_ConfirmarEliminarSolicitud = new javax.swing.JButton();
        TF_CodigoReferenciaSolicitudEliminar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JF_Persona = new javax.swing.JFrame();
        jPanel15 = new javax.swing.JPanel();
        JP_BusquedaDetallada = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        JT_ResultadosBusqueda = new javax.swing.JTable();
        TF_BarraBusquedaPersona = new javax.swing.JTextField();
        jLabel222 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        JB_Busqueda = new javax.swing.JButton();
        JP_PuestosDispiniblesPersona = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        JT_PropiedadesEnMercadoComprador = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        JB_PropiedadesEnMercadoComprador2 = new javax.swing.JButton();
        JP_MiSolicitudPersona = new javax.swing.JPanel();
        jLabel214 = new javax.swing.JLabel();
        TF_MiSolicitudEstadoSolicitudPersona = new javax.swing.JTextField();
        jLabel215 = new javax.swing.JLabel();
        TF_MiSolicitudCodigoReferenciaPersona = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        TF_MiSolicitudPuestoTrabajoaPersona = new javax.swing.JTextField();
        jLabel217 = new javax.swing.JLabel();
        TF_MiSolicitudNombreEmpresaPersona = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        JB_CerrarSesionPersona = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        JB_PuestosDisponiblesPersonas = new javax.swing.JButton();
        JB_BusquedaDetalladaPersonas = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        JB_MiSolicitudPersonas = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        JF_Empresa = new javax.swing.JFrame();
        jPanel30 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        JB_CerrarSesionEmpresa = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        JB_PuestosOfrecidos = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        JB_SolicitudesEmpleo = new javax.swing.JButton();
        JP_PuestosOfrecidosEmpresa = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        JT_PuestosOfrecidos = new javax.swing.JTable();
        JP_SolicitudesEmpresas = new javax.swing.JPanel();
        jLabel223 = new javax.swing.JLabel();
        TF_BarraBusquedaEmpresa = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        JB_Busqueda1 = new javax.swing.JButton();
        jScrollPane22 = new javax.swing.JScrollPane();
        JT_BuscarSolicitudesEmpresa = new javax.swing.JTable();
        JD_MasInfoPuesto = new javax.swing.JDialog();
        JP_MasInfoPuesto = new javax.swing.JPanel();
        TF_InfoPuestoNivelEducacion = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jl_TelefonoCompania7 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        TF_InfoPuestoTipoContrato = new javax.swing.JTextField();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        TF_InfoPuestoEnfermedades = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        TF_InfoPuestoTipoPuesto = new javax.swing.JTextField();
        jLabel213 = new javax.swing.JLabel();
        TF_InfoPuestoNombeEmpresa = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        TF_InfoPuestoDireccion = new javax.swing.JTextField();
        TF_InfoPuestoGenero = new javax.swing.JTextField();
        TF_InfoPuestoTitulo = new javax.swing.JTextField();
        TF_InfoPuestoPromedio = new javax.swing.JTextField();
        TF_InfoPuestoExperiencia = new javax.swing.JTextField();
        TF_InfoPuestoAniosExperiencia = new javax.swing.JTextField();
        TF_InfoPuestoHabilidades = new javax.swing.JTextField();
        TF_InfoPuestoAntecedentes = new javax.swing.JTextField();
        TF_InfoPuestoServicioMilitar = new javax.swing.JTextField();
        TF_InfoPuestoSueldo = new javax.swing.JTextField();
        TF_InfoPuestoHorario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TF_Password = new javax.swing.JPasswordField();
        TF_UserName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JB_LogIn = new javax.swing.JButton();
        ADMIN = new javax.swing.JButton();
        PERSONA = new javax.swing.JButton();
        EMPRESA = new javax.swing.JButton();

        jPanel2.setPreferredSize(new java.awt.Dimension(1941, 770));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(44, 65, 114));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 1000));

        JB_CrudAdmin.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        JB_CrudAdmin.setText("CRUD");
        JB_CrudAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrudAdminMouseClicked(evt);
            }
        });

        JB_CerrarSesionAdmin.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        JB_CerrarSesionAdmin.setText("Cerrar Sesion");
        JB_CerrarSesionAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CerrarSesionAdminMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bienvenido");

        jLabel16.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Administrador");

        JB_Contrataciones.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        JB_Contrataciones.setText("Contrataciones");
        JB_Contrataciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ContratacionesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel16))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_CerrarSesionAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_CrudAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_Contrataciones, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(JB_CrudAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(JB_Contrataciones, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(JB_CerrarSesionAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        JP_CRUD.setBackground(new java.awt.Color(255, 255, 255));
        JP_CRUD.setPreferredSize(new java.awt.Dimension(1200, 1000));

        JB_CRUDPersonas.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_CRUDPersonas.setText("Personas");
        JB_CRUDPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CRUDPersonasMouseClicked(evt);
            }
        });

        JB_CRUDEmpresas.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_CRUDEmpresas.setText("Empresas");
        JB_CRUDEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CRUDEmpresasMouseClicked(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(44, 65, 114));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(44, 65, 114));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        JB_CRUDSolicitudes.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_CRUDSolicitudes.setText("Solicitudes");
        JB_CRUDSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CRUDSolicitudesMouseClicked(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(44, 65, 114));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(44, 65, 114));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        JB_CRUDPuestos.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_CRUDPuestos.setText("Puestos");
        JB_CRUDPuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CRUDPuestosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_CRUDLayout = new javax.swing.GroupLayout(JP_CRUD);
        JP_CRUD.setLayout(JP_CRUDLayout);
        JP_CRUDLayout.setHorizontalGroup(
            JP_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CRUDLayout.createSequentialGroup()
                .addGroup(JP_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_CRUDLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_CRUDLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(JB_CRUDPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(JP_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_CRUDLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_CRUDLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(JB_CRUDEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(JB_CRUDSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(JB_CRUDPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        JP_CRUDLayout.setVerticalGroup(
            JP_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CRUDLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addGroup(JP_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_CRUDLayout.createSequentialGroup()
                        .addGroup(JP_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JP_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_CRUDSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_CRUDPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_CRUDEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JP_CRUDLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JB_CRUDPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(424, Short.MAX_VALUE))
        );

        jPanel2.add(JP_CRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1300, -1));

        JP_Contrataciones.setBackground(new java.awt.Color(255, 255, 255));

        JT_Solicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane10.setViewportView(JT_Solicitudes);

        jPanel21.setBackground(new java.awt.Color(44, 65, 114));

        jLabel48.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Vacancias");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel48)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Puesto", "Cantidad"
            }
        ));
        jScrollPane11.setViewportView(jTable1);

        jPanel22.setBackground(new java.awt.Color(44, 65, 114));

        jLabel55.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Solicitudes");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jLabel55)
                .addGap(105, 105, 105))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        JB_Contratar.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        JB_Contratar.setText("CONTRATAR");
        JB_Contratar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ContratarMouseClicked(evt);
            }
        });
        JB_Contratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ContratarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_ContratacionesLayout = new javax.swing.GroupLayout(JP_Contrataciones);
        JP_Contrataciones.setLayout(JP_ContratacionesLayout);
        JP_ContratacionesLayout.setHorizontalGroup(
            JP_ContratacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ContratacionesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(JB_Contratar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(JP_ContratacionesLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        JP_ContratacionesLayout.setVerticalGroup(
            JP_ContratacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ContratacionesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JP_ContratacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JP_ContratacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_ContratacionesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JP_ContratacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                            .addComponent(jScrollPane10))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_ContratacionesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JB_Contratar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348))))
        );

        jPanel2.add(JP_Contrataciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1300, 770));

        javax.swing.GroupLayout JF_AdminLayout = new javax.swing.GroupLayout(JF_Admin.getContentPane());
        JF_Admin.getContentPane().setLayout(JF_AdminLayout);
        JF_AdminLayout.setHorizontalGroup(
            JF_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 2320, Short.MAX_VALUE)
        );
        JF_AdminLayout.setVerticalGroup(
            JF_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(1941, 770));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(44, 65, 114));

        JB_CrearPersona.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_CrearPersona.setText("Crear");
        JB_CrearPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrearPersonaMouseClicked(evt);
            }
        });

        JB_ModificarPersona.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_ModificarPersona.setText("Modificar");
        JB_ModificarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ModificarPersonaMouseClicked(evt);
            }
        });

        JB_EliminarPersona.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_EliminarPersona.setText("Eliminar");
        JB_EliminarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_EliminarPersonaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(JB_CrearPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(JB_ModificarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(JB_EliminarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(750, 750, 750))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_ModificarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_CrearPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_EliminarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 110));

        JP_CrearPersonaPersonal.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearPersonaPersonal.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_CrearPersonaPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_CrearPersonaPersonal.add(TF_CrearUsuarioPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 300, 30));
        JP_CrearPersonaPersonal.add(TF_CrearPasswordPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 310, 30));

        JB_CrearSiguientePersonalPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_CrearSiguientePersonalPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_CrearSiguientePersonalPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_CrearSiguientePersonalPersona.setText("Siguiente");
        JB_CrearSiguientePersonalPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrearSiguientePersonalPersonaMouseClicked(evt);
            }
        });
        JP_CrearPersonaPersonal.add(JB_CrearSiguientePersonalPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel5.setText("Contrasena");
        JP_CrearPersonaPersonal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 129, 30));

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel11.setText("Usuario");
        JP_CrearPersonaPersonal.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 102, 30));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel62.setText("Nombre");
        JP_CrearPersonaPersonal.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 79, -1));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel63.setText("Direccion");
        JP_CrearPersonaPersonal.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 98, -1));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setText("Celular");
        JP_CrearPersonaPersonal.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, 92, -1));

        jl_TelefonoCompania.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania.setText("Correo Electronico");
        JP_CrearPersonaPersonal.add(jl_TelefonoCompania, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 320, 202, -1));
        JP_CrearPersonaPersonal.add(TF_DireccionCrearPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, 310, 30));
        JP_CrearPersonaPersonal.add(TF_CrearNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 310, 30));
        JP_CrearPersonaPersonal.add(TF_CrearCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 270, 310, 30));
        JP_CrearPersonaPersonal.add(TF_CrearCorreoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, 310, 30));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel79.setText("Apellido");
        JP_CrearPersonaPersonal.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 79, -1));
        JP_CrearPersonaPersonal.add(TF_CrearApellidoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 310, 30));

        jLabel14.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel14.setText("Fecha Nacimiento");
        JP_CrearPersonaPersonal.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 260, 30));
        JP_CrearPersonaPersonal.add(TF_CrearFechaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 310, 30));

        jLabel17.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel17.setText("Genero");
        JP_CrearPersonaPersonal.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 430, 102, 40));

        CB_CrearGeneroPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre", " " }));
        CB_CrearGeneroPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CrearGeneroPersonaActionPerformed(evt);
            }
        });
        JP_CrearPersonaPersonal.add(CB_CrearGeneroPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 430, 146, 39));

        jLabel65.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel65.setText("Id de Persona");
        JP_CrearPersonaPersonal.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 130, -1));
        JP_CrearPersonaPersonal.add(TF_CrearIdPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 310, 30));

        jPanel3.add(JP_CrearPersonaPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_CrearPersonaFamiliares_Sanitarios.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearPersonaFamiliares_Sanitarios.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_CrearPersonaFamiliares_Sanitarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_CrearConyugePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 310, 30));
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_Crear2HijoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 310, 30));

        CB_CrearGrupoSanguineoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        CB_CrearGrupoSanguineoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CrearGrupoSanguineoPersonaActionPerformed(evt);
            }
        });
        JP_CrearPersonaFamiliares_Sanitarios.add(CB_CrearGrupoSanguineoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 146, 39));

        JB_CrearSiguienteFamiliar_SanitariosPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_CrearSiguienteFamiliar_SanitariosPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_CrearSiguienteFamiliar_SanitariosPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_CrearSiguienteFamiliar_SanitariosPersona.setText("Siguiente");
        JB_CrearSiguienteFamiliar_SanitariosPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrearSiguienteFamiliar_SanitariosPersonaMouseClicked(evt);
            }
        });
        JP_CrearPersonaFamiliares_Sanitarios.add(JB_CrearSiguienteFamiliar_SanitariosPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel10.setText("Hijos");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 129, 30));

        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel12.setText("Dependientes");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 160, 30));

        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel13.setText("Conyuge");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 102, 30));

        jLabel72.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel72.setText("Datos Familiares");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, 25));
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_CrearDependiente2Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 310, 30));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel73.setText("Datos Sanitarios");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 160, -1));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel74.setText("Grupo Sanguineo");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, 190, -1));
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_CrearAlergiasPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 310, 30));

        jLabel76.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel76.setText("Enfermedades Cronicas");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 240, -1));
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_CrearEnfermedadesCronicasPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 210, 310, 30));

        jLabel80.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel80.setText("Estado Civil");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_CrearDependiente3Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 310, 30));
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_CrearDependiente1Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 310, 30));
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_Crear3HijoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 310, 30));
        JP_CrearPersonaFamiliares_Sanitarios.add(TF_Crear1HijoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 310, 30));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel81.setText("Alergias");
        JP_CrearPersonaFamiliares_Sanitarios.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 79, -1));

        CB_CrearEstadoCivilPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", " " }));
        CB_CrearEstadoCivilPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CrearEstadoCivilPersonaActionPerformed(evt);
            }
        });
        JP_CrearPersonaFamiliares_Sanitarios.add(CB_CrearEstadoCivilPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 146, 30));

        jPanel3.add(JP_CrearPersonaFamiliares_Sanitarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_CrearPersonaLegales_Academicos.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearPersonaLegales_Academicos.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_CrearPersonaLegales_Academicos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_CrearPersonaLegales_Academicos.add(TF_CrearAntecedentesPenalesPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 310, 30));

        CB_CrearNivelEducacionPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EGB", "BUP", "COU", " " }));
        CB_CrearNivelEducacionPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CrearNivelEducacionPersonaActionPerformed(evt);
            }
        });
        JP_CrearPersonaLegales_Academicos.add(CB_CrearNivelEducacionPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 190, 30));

        JB_CrearSiguienteLegales_AcademicosPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_CrearSiguienteLegales_AcademicosPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_CrearSiguienteLegales_AcademicosPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_CrearSiguienteLegales_AcademicosPersona.setText("Siguiente");
        JB_CrearSiguienteLegales_AcademicosPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrearSiguienteLegales_AcademicosPersonaMouseClicked(evt);
            }
        });
        JP_CrearPersonaLegales_Academicos.add(JB_CrearSiguienteLegales_AcademicosPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel19.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel19.setText("Antecedentes Penales");
        JP_CrearPersonaLegales_Academicos.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 210, 30));

        jLabel21.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel21.setText("Estado Legal");
        JP_CrearPersonaLegales_Academicos.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 150, 30));

        jLabel84.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel84.setText("Datos Legales");
        JP_CrearPersonaLegales_Academicos.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, 25));
        JP_CrearPersonaLegales_Academicos.add(TF_CrearDNIPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 310, 30));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel85.setText("Datos Academicos");
        JP_CrearPersonaLegales_Academicos.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 190, -1));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel86.setText("Titulos Obtenidos");
        JP_CrearPersonaLegales_Academicos.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, 170, -1));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel87.setText("Especializacion");
        JP_CrearPersonaLegales_Academicos.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 140, -1));

        jl_TelefonoCompania4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania4.setText("Promedio de Graduacion");
        JP_CrearPersonaLegales_Academicos.add(jl_TelefonoCompania4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 510, 230, -1));
        JP_CrearPersonaLegales_Academicos.add(TF_CrearTitulosObtenidos2Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, 310, 30));
        JP_CrearPersonaLegales_Academicos.add(TF_CrearEspecializacionPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, 310, 30));

        jLabel88.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel88.setText("Institucion Educativa");
        JP_CrearPersonaLegales_Academicos.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 200, -1));
        JP_CrearPersonaLegales_Academicos.add(TF_CrearInstitucionEducativaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 210, 310, 30));

        CB_CrearServicioMilitarPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", " " }));
        CB_CrearServicioMilitarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CrearServicioMilitarPersonaActionPerformed(evt);
            }
        });
        JP_CrearPersonaLegales_Academicos.add(CB_CrearServicioMilitarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 146, 30));
        JP_CrearPersonaLegales_Academicos.add(TF_CrearTitulosObtenidos3Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 380, 310, 30));
        JP_CrearPersonaLegales_Academicos.add(TF_CrearTitulosObtenidos1Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 310, 30));

        jLabel99.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel99.setText("DNI");
        JP_CrearPersonaLegales_Academicos.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));

        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel100.setText("Nivel de Educacion");
        JP_CrearPersonaLegales_Academicos.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 190, -1));
        JP_CrearPersonaLegales_Academicos.add(JS_CrearPromedioGraduacionPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 540, 90, 30));

        jLabel34.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel34.setText("Servicio Militar");
        JP_CrearPersonaLegales_Academicos.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 210, 30));

        CB_CrearEstadoLegalPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciudadano", "Residente Permanente", "Estudiante Internacional", "Trabajador con visado temporal", " " }));
        CB_CrearEstadoLegalPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CrearEstadoLegalPersonaActionPerformed(evt);
            }
        });
        JP_CrearPersonaLegales_Academicos.add(CB_CrearEstadoLegalPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 146, 30));

        jPanel3.add(JP_CrearPersonaLegales_Academicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_CrearPersonaProfesional_Laboral.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearPersonaProfesional_Laboral.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_CrearPersonaProfesional_Laboral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_CrearPersonaProfesional_Laboral.add(TF_CrearHabilidadesPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 300, 30));
        JP_CrearPersonaProfesional_Laboral.add(TF_CrearCertificaciones2Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 310, 30));

        CB_CrearExperienciaLaboralPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", " ", " " }));
        CB_CrearExperienciaLaboralPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CrearExperienciaLaboralPersonaActionPerformed(evt);
            }
        });
        JP_CrearPersonaProfesional_Laboral.add(CB_CrearExperienciaLaboralPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 146, 39));

        JB_CrearSiguienteProfesional_LaboralPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_CrearSiguienteProfesional_LaboralPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_CrearSiguienteProfesional_LaboralPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_CrearSiguienteProfesional_LaboralPersona.setText("Siguiente");
        JB_CrearSiguienteProfesional_LaboralPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrearSiguienteProfesional_LaboralPersonaMouseClicked(evt);
            }
        });
        JP_CrearPersonaProfesional_Laboral.add(JB_CrearSiguienteProfesional_LaboralPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel22.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel22.setText("Certificaciones");
        JP_CrearPersonaProfesional_Laboral.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 160, 30));

        jLabel24.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel24.setText("Habilidades");
        JP_CrearPersonaProfesional_Laboral.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 170, 30));

        jLabel89.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel89.setText("Datos Profesionales");
        JP_CrearPersonaProfesional_Laboral.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 25));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel90.setText("Datos Laborales");
        JP_CrearPersonaProfesional_Laboral.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 390, -1));
        JP_CrearPersonaProfesional_Laboral.add(TF_CrearCertificaciones3Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 310, 30));
        JP_CrearPersonaProfesional_Laboral.add(TF_CrearCertificaciones1Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 310, 30));

        TA_CrearHistorialEmpleoPersona.setColumns(20);
        TA_CrearHistorialEmpleoPersona.setRows(5);
        jScrollPane1.setViewportView(TA_CrearHistorialEmpleoPersona);

        JP_CrearPersonaProfesional_Laboral.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 380, 120));

        jLabel95.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel95.setText("Experiencia Laboral");
        JP_CrearPersonaProfesional_Laboral.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel96.setText("Historial de empleo (empresa, cargo, fecha)");
        JP_CrearPersonaProfesional_Laboral.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 390, -1));
        JP_CrearPersonaProfesional_Laboral.add(JS_CrearYearsExperienciaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 300, 170, 40));

        jLabel132.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel132.setText("Años de experiencia");
        JP_CrearPersonaProfesional_Laboral.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 390, -1));

        jPanel3.add(JP_CrearPersonaProfesional_Laboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_CrearPersonaRequisitos_Condiciones.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearPersonaRequisitos_Condiciones.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_CrearPersonaRequisitos_Condiciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JB_ConfirmarCrearPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarCrearPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarCrearPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarCrearPersona.setText("Crear");
        JB_ConfirmarCrearPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarCrearPersonaMouseClicked(evt);
            }
        });
        JP_CrearPersonaRequisitos_Condiciones.add(JB_ConfirmarCrearPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel94.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel94.setText("Requisitos de empleo");
        JP_CrearPersonaRequisitos_Condiciones.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 25));

        TA_CrearPuestosDeseadosPersona.setColumns(20);
        TA_CrearPuestosDeseadosPersona.setRows(5);
        jScrollPane2.setViewportView(TA_CrearPuestosDeseadosPersona);

        JP_CrearPersonaRequisitos_Condiciones.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 360, -1));

        jLabel102.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel102.setText("Puestos no deseados");
        JP_CrearPersonaRequisitos_Condiciones.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, 25));

        TA_CrearPuestosNoDeseadosPersona.setColumns(20);
        TA_CrearPuestosNoDeseadosPersona.setRows(5);
        jScrollPane3.setViewportView(TA_CrearPuestosNoDeseadosPersona);

        JP_CrearPersonaRequisitos_Condiciones.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 360, -1));

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel101.setText("Salario Deseado");
        JP_CrearPersonaRequisitos_Condiciones.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 140, -1));
        JP_CrearPersonaRequisitos_Condiciones.add(JS_CrearSalarioDeseadoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 340, 140, 30));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel91.setText("Requisitos de condiciones de empleo");
        JP_CrearPersonaRequisitos_Condiciones.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 350, -1));

        CB_CrearDisponibilidadHorariaPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM ", "AM-PM", " ", " " }));
        JP_CrearPersonaRequisitos_Condiciones.add(CB_CrearDisponibilidadHorariaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, 146, 39));

        CB_CrearTipoContratoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contrato Indefinido", "Contrato Temporal", "Contrato para la formacion", "Contrato en practicas", " " }));
        JP_CrearPersonaRequisitos_Condiciones.add(CB_CrearTipoContratoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, 146, 39));

        jLabel26.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel26.setText("Tipo de contrato");
        JP_CrearPersonaRequisitos_Condiciones.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 180, 30));

        jLabel103.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel103.setText("Puestos deseados");
        JP_CrearPersonaRequisitos_Condiciones.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel92.setText("AM y PM : Medio Tiempo / AM-PM : Tiempo Completo");
        JP_CrearPersonaRequisitos_Condiciones.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, 300, -1));

        jLabel142.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel142.setText("Disponibilidad Horaria");
        JP_CrearPersonaRequisitos_Condiciones.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 200, -1));

        jPanel3.add(JP_CrearPersonaRequisitos_Condiciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_ModPersonaPersonal.setBackground(new java.awt.Color(255, 255, 255));
        JP_ModPersonaPersonal.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_ModPersonaPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ModSiguientePersonaPersonal.setBackground(new java.awt.Color(44, 65, 114));
        ModSiguientePersonaPersonal.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        ModSiguientePersonaPersonal.setForeground(new java.awt.Color(255, 255, 255));
        ModSiguientePersonaPersonal.setText("Siguiente");
        ModSiguientePersonaPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModSiguientePersonaPersonalMouseClicked(evt);
            }
        });
        JP_ModPersonaPersonal.add(ModSiguientePersonaPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        JT_ModPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Personas"
            }
        ));
        JT_ModPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_ModPersonaMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(JT_ModPersona);

        JP_ModPersonaPersonal.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 357, 379));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel66.setText("Nombre");
        JP_ModPersonaPersonal.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 79, -1));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel82.setText("Apellido");
        JP_ModPersonaPersonal.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 79, -1));
        JP_ModPersonaPersonal.add(TF_ModNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 310, 30));
        JP_ModPersonaPersonal.add(TF_ModApellidoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 310, 30));
        JP_ModPersonaPersonal.add(TF_ModCorreoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 320, 310, 30));

        CB_ModGeneroPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre", " " }));
        CB_ModGeneroPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ModGeneroPersonaActionPerformed(evt);
            }
        });
        JP_ModPersonaPersonal.add(CB_ModGeneroPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 390, 146, 39));

        jLabel20.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel20.setText("Genero");
        JP_ModPersonaPersonal.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 390, 102, 40));

        jl_TelefonoCompania1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania1.setText("Correo Electronico");
        JP_ModPersonaPersonal.add(jl_TelefonoCompania1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 280, 202, -1));
        JP_ModPersonaPersonal.add(TF_ModCelularPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 230, 310, 30));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel83.setText("Celular");
        JP_ModPersonaPersonal.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, 92, -1));

        TF_ModDireccionPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_ModDireccionPersonaActionPerformed(evt);
            }
        });
        JP_ModPersonaPersonal.add(TF_ModDireccionPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 150, 310, 30));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel97.setText("Direccion");
        JP_ModPersonaPersonal.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 110, 98, -1));

        jLabel23.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel23.setText("Fecha Nacimiento");
        JP_ModPersonaPersonal.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 260, 30));
        JP_ModPersonaPersonal.add(TF_ModFechaNaciemientoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 310, 30));

        TF_ModIdPersona.setEditable(false);
        JP_ModPersonaPersonal.add(TF_ModIdPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 310, 30));

        jLabel75.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel75.setText("Id de Persona");
        JP_ModPersonaPersonal.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 130, -1));

        jPanel3.add(JP_ModPersonaPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 970));

        JP_ModPersonaFamiliares_Sanitarios.setBackground(new java.awt.Color(255, 255, 255));
        JP_ModPersonaFamiliares_Sanitarios.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_ModPersonaFamiliares_Sanitarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_ModPersonaFamiliares_Sanitarios.add(TF_ModConyugePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 310, 30));
        JP_ModPersonaFamiliares_Sanitarios.add(TF_Mod2HijoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 310, 30));

        CB_ModGrupoSanguineoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        CB_ModGrupoSanguineoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ModGrupoSanguineoPersonaActionPerformed(evt);
            }
        });
        JP_ModPersonaFamiliares_Sanitarios.add(CB_ModGrupoSanguineoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 146, 39));

        JB_ModSiguienteLegales_AcademicosPersonas.setBackground(new java.awt.Color(44, 65, 114));
        JB_ModSiguienteLegales_AcademicosPersonas.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ModSiguienteLegales_AcademicosPersonas.setForeground(new java.awt.Color(255, 255, 255));
        JB_ModSiguienteLegales_AcademicosPersonas.setText("Siguiente");
        JB_ModSiguienteLegales_AcademicosPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ModSiguienteLegales_AcademicosPersonasMouseClicked(evt);
            }
        });
        JP_ModPersonaFamiliares_Sanitarios.add(JB_ModSiguienteLegales_AcademicosPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel25.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel25.setText("Hijos");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 129, 30));

        jLabel27.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel27.setText("Dependientes");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 160, 30));

        jLabel28.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel28.setText("Conyuge");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 102, 30));

        jLabel98.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel98.setText("Datos Familiares");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, 25));
        JP_ModPersonaFamiliares_Sanitarios.add(TF_ModDependiente2Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 310, 30));

        jLabel104.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel104.setText("Datos Sanitarios");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 160, -1));

        jLabel105.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel105.setText("Grupo Sanguineo");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, 190, -1));
        JP_ModPersonaFamiliares_Sanitarios.add(TF_ModAlergiasPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 310, 30));

        jLabel106.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel106.setText("Enfermedades Cronicas");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 240, -1));
        JP_ModPersonaFamiliares_Sanitarios.add(TF_ModEnfermedadesCronicasPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 210, 310, 30));

        jLabel107.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel107.setText("Estado Civil");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));
        JP_ModPersonaFamiliares_Sanitarios.add(TF_ModDependiente3Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 310, 30));
        JP_ModPersonaFamiliares_Sanitarios.add(TF_ModDependiente1Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 310, 30));
        JP_ModPersonaFamiliares_Sanitarios.add(TF_Mod3HijoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 310, 30));
        JP_ModPersonaFamiliares_Sanitarios.add(TF_Mod1HijoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 310, 30));

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel108.setText("Alergias");
        JP_ModPersonaFamiliares_Sanitarios.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 79, -1));

        CB_ModEstadoCivilPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", " " }));
        CB_ModEstadoCivilPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ModEstadoCivilPersonaActionPerformed(evt);
            }
        });
        JP_ModPersonaFamiliares_Sanitarios.add(CB_ModEstadoCivilPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 146, 30));

        jPanel3.add(JP_ModPersonaFamiliares_Sanitarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_ModPersonaLegales_Academicos.setBackground(new java.awt.Color(255, 255, 255));
        JP_ModPersonaLegales_Academicos.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_ModPersonaLegales_Academicos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_ModPersonaLegales_Academicos.add(TF_ModAntecedentesPenalesPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 310, 30));

        CB_ModNivelEducacionPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EGB", "BUP", "COU", " " }));
        CB_ModNivelEducacionPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ModNivelEducacionPersonaActionPerformed(evt);
            }
        });
        JP_ModPersonaLegales_Academicos.add(CB_ModNivelEducacionPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 190, 30));

        JB_ModSiguienteProfecionales_LaboralesPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_ModSiguienteProfecionales_LaboralesPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ModSiguienteProfecionales_LaboralesPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_ModSiguienteProfecionales_LaboralesPersona.setText("Siguiente");
        JB_ModSiguienteProfecionales_LaboralesPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ModSiguienteProfecionales_LaboralesPersonaMouseClicked(evt);
            }
        });
        JP_ModPersonaLegales_Academicos.add(JB_ModSiguienteProfecionales_LaboralesPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel29.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel29.setText("Antecedentes Penales");
        JP_ModPersonaLegales_Academicos.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 210, 30));

        jLabel30.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel30.setText("Estado Legal");
        JP_ModPersonaLegales_Academicos.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 150, 30));

        jLabel109.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel109.setText("Datos Legales");
        JP_ModPersonaLegales_Academicos.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, 25));
        JP_ModPersonaLegales_Academicos.add(TF_ModDNIPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 310, 30));

        jLabel110.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel110.setText("Datos Academicos");
        JP_ModPersonaLegales_Academicos.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 190, -1));

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel111.setText("Titulos Obtenidos");
        JP_ModPersonaLegales_Academicos.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, 170, -1));

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel112.setText("Especializacion");
        JP_ModPersonaLegales_Academicos.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 140, -1));

        jl_TelefonoCompania5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania5.setText("Promedio de Graduacion");
        JP_ModPersonaLegales_Academicos.add(jl_TelefonoCompania5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 510, 230, -1));
        JP_ModPersonaLegales_Academicos.add(TF_ModTitulosObtenidos2Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, 310, 30));
        JP_ModPersonaLegales_Academicos.add(TF_ModEspecializacionPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, 310, 30));

        jLabel113.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel113.setText("Institucion Educativa");
        JP_ModPersonaLegales_Academicos.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 200, -1));
        JP_ModPersonaLegales_Academicos.add(TF_ModInstitucionEducativaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 210, 310, 30));

        CB_ModEstadoLegalPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciudadano", "Residente Permanente", "Estudiante Internacional", "Trabajador con visado temporal", " " }));
        CB_ModEstadoLegalPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ModEstadoLegalPersonaActionPerformed(evt);
            }
        });
        JP_ModPersonaLegales_Academicos.add(CB_ModEstadoLegalPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 146, 30));
        JP_ModPersonaLegales_Academicos.add(TF_ModTitulosObtenidos3Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 380, 310, 30));
        JP_ModPersonaLegales_Academicos.add(TF_ModrTitulosObtenidos1Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 310, 30));

        jLabel114.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel114.setText("DNI");
        JP_ModPersonaLegales_Academicos.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));

        jLabel115.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel115.setText("Nivel de Educacion");
        JP_ModPersonaLegales_Academicos.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 190, -1));
        JP_ModPersonaLegales_Academicos.add(JS_ModPromedioGraduacionPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 540, 90, 30));

        CB_ModServicioMilitarPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", " " }));
        CB_ModServicioMilitarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ModServicioMilitarPersonaActionPerformed(evt);
            }
        });
        JP_ModPersonaLegales_Academicos.add(CB_ModServicioMilitarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 146, 30));

        jLabel35.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel35.setText("Servicio Militar");
        JP_ModPersonaLegales_Academicos.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 210, 30));

        jPanel3.add(JP_ModPersonaLegales_Academicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_ModPersonaProfesional_Laboral.setBackground(new java.awt.Color(255, 255, 255));
        JP_ModPersonaProfesional_Laboral.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_ModPersonaProfesional_Laboral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_ModPersonaProfesional_Laboral.add(TF_ModHabilidadesPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 300, 30));
        JP_ModPersonaProfesional_Laboral.add(TF_ModCertificaciones2Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 310, 30));

        CB_ModExperienciaLaboralPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", " ", " " }));
        CB_ModExperienciaLaboralPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ModExperienciaLaboralPersonaActionPerformed(evt);
            }
        });
        JP_ModPersonaProfesional_Laboral.add(CB_ModExperienciaLaboralPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 146, 39));

        JB_ModSiguienteRequisitos_CondicionesPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_ModSiguienteRequisitos_CondicionesPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ModSiguienteRequisitos_CondicionesPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_ModSiguienteRequisitos_CondicionesPersona.setText("Siguiente");
        JB_ModSiguienteRequisitos_CondicionesPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ModSiguienteRequisitos_CondicionesPersonaMouseClicked(evt);
            }
        });
        JP_ModPersonaProfesional_Laboral.add(JB_ModSiguienteRequisitos_CondicionesPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel31.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel31.setText("Certificaciones");
        JP_ModPersonaProfesional_Laboral.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 160, 30));

        jLabel32.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel32.setText("Habilidades");
        JP_ModPersonaProfesional_Laboral.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 170, 30));

        jLabel116.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel116.setText("Datos Profesionales");
        JP_ModPersonaProfesional_Laboral.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 25));

        jLabel117.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel117.setText("Datos Laborales");
        JP_ModPersonaProfesional_Laboral.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 390, -1));

        jLabel118.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        JP_ModPersonaProfesional_Laboral.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 230, 43, -1));
        JP_ModPersonaProfesional_Laboral.add(TF_ModCertificaciones3Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 310, 30));
        JP_ModPersonaProfesional_Laboral.add(TF_ModCertificaciones1Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 310, 30));

        TA_ModHistorialEmpleoPersona.setColumns(20);
        TA_ModHistorialEmpleoPersona.setRows(5);
        jScrollPane4.setViewportView(TA_ModHistorialEmpleoPersona);

        JP_ModPersonaProfesional_Laboral.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 310, 100));

        jLabel119.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel119.setText("Experiencia Laboral");
        JP_ModPersonaProfesional_Laboral.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));

        jLabel120.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel120.setText("Años de experiencia");
        JP_ModPersonaProfesional_Laboral.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 230, 390, -1));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel131.setText("Historial de empleo (empresa, cargo, fecha)");
        JP_ModPersonaProfesional_Laboral.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 390, -1));
        JP_ModPersonaProfesional_Laboral.add(JS_CrearAñosExperienciaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 270, 170, 40));

        jPanel3.add(JP_ModPersonaProfesional_Laboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_ModPersonaRequisitos_Condiciones.setBackground(new java.awt.Color(255, 255, 255));
        JP_ModPersonaRequisitos_Condiciones.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_ModPersonaRequisitos_Condiciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JB_ConfirmarModPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarModPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarModPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarModPersona.setText("Modificar");
        JB_ConfirmarModPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarModPersonaMouseClicked(evt);
            }
        });
        JP_ModPersonaRequisitos_Condiciones.add(JB_ConfirmarModPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel121.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel121.setText("Requisitos de empleo");
        JP_ModPersonaRequisitos_Condiciones.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 25));

        TA_ModPuestosDeseadosPersona.setColumns(20);
        TA_ModPuestosDeseadosPersona.setRows(5);
        jScrollPane5.setViewportView(TA_ModPuestosDeseadosPersona);

        JP_ModPersonaRequisitos_Condiciones.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 360, -1));

        jLabel122.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel122.setText("Puestos no deseados");
        JP_ModPersonaRequisitos_Condiciones.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, 25));

        TA_ModPuestosNoDeseadosPersona.setColumns(20);
        TA_ModPuestosNoDeseadosPersona.setRows(5);
        jScrollPane6.setViewportView(TA_ModPuestosNoDeseadosPersona);

        JP_ModPersonaRequisitos_Condiciones.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 360, -1));

        jLabel123.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel123.setText("Salario Deseado");
        JP_ModPersonaRequisitos_Condiciones.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 140, -1));
        JP_ModPersonaRequisitos_Condiciones.add(JS_ModSalarioDeseadoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 340, 140, 30));

        jLabel124.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel124.setText("Requisitos de condiciones de empleo");
        JP_ModPersonaRequisitos_Condiciones.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 350, -1));

        CB_ModDisponibilidadHorariaPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche", " ", " " }));
        JP_ModPersonaRequisitos_Condiciones.add(CB_ModDisponibilidadHorariaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, 146, 39));

        CB_ModTipoContratoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contrato Indefinido", "Contrato Temporal", "Contrato para la formacion", "Contrato en practicas", " " }));
        JP_ModPersonaRequisitos_Condiciones.add(CB_ModTipoContratoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, 146, 39));

        jLabel33.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel33.setText("Tipo de contrato");
        JP_ModPersonaRequisitos_Condiciones.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 180, 30));

        jLabel125.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel125.setText("Puestos deseados");
        JP_ModPersonaRequisitos_Condiciones.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel126.setText("Disponibilidad Horaria");
        JP_ModPersonaRequisitos_Condiciones.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 200, -1));

        jPanel3.add(JP_ModPersonaRequisitos_Condiciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_EliminarPersona.setBackground(new java.awt.Color(255, 255, 255));
        JP_EliminarPersona.setPreferredSize(new java.awt.Dimension(1920, 1080));

        JT_EliminarPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Persona"
            }
        ));
        jScrollPane16.setViewportView(JT_EliminarPersona);

        JB_ConfirmarEliminarPersona.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarEliminarPersona.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarEliminarPersona.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarEliminarPersona.setText("Eliminar");
        JB_ConfirmarEliminarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarEliminarPersonaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EliminarPersonaLayout = new javax.swing.GroupLayout(JP_EliminarPersona);
        JP_EliminarPersona.setLayout(JP_EliminarPersonaLayout);
        JP_EliminarPersonaLayout.setHorizontalGroup(
            JP_EliminarPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_EliminarPersonaLayout.createSequentialGroup()
                .addGroup(JP_EliminarPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_EliminarPersonaLayout.createSequentialGroup()
                        .addGap(654, 654, 654)
                        .addComponent(JB_ConfirmarEliminarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_EliminarPersonaLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(829, Short.MAX_VALUE))
        );
        JP_EliminarPersonaLayout.setVerticalGroup(
            JP_EliminarPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_EliminarPersonaLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(JB_ConfirmarEliminarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
        );

        jPanel3.add(JP_EliminarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        javax.swing.GroupLayout JF_CrudPersonasLayout = new javax.swing.GroupLayout(JF_CrudPersonas.getContentPane());
        JF_CrudPersonas.getContentPane().setLayout(JF_CrudPersonasLayout);
        JF_CrudPersonasLayout.setHorizontalGroup(
            JF_CrudPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 2320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JF_CrudPersonasLayout.setVerticalGroup(
            JF_CrudPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );

        jPanel6.setPreferredSize(new java.awt.Dimension(1941, 770));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel26.setBackground(new java.awt.Color(44, 65, 114));

        JB_CrearEmpresa.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_CrearEmpresa.setText("Crear");
        JB_CrearEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrearEmpresaMouseClicked(evt);
            }
        });

        JB_ModificarEmpresa.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_ModificarEmpresa.setText("Modificar");
        JB_ModificarEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ModificarEmpresaMouseClicked(evt);
            }
        });

        JB_EliminarEmpresa.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_EliminarEmpresa.setText("Eliminar");
        JB_EliminarEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_EliminarEmpresaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(JB_CrearEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(JB_ModificarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(JB_EliminarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(750, 750, 750))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_ModificarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_CrearEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_EliminarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 110));

        JP_CrearEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearEmpresa.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_CrearEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_CrearEmpresa.add(TF_CrearUsuarioEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 310, 30));
        JP_CrearEmpresa.add(TF_CrearContrasenaEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 310, 30));

        JB_ConfirmarCrearEmpresa.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarCrearEmpresa.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarCrearEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarCrearEmpresa.setText("Crear");
        JB_ConfirmarCrearEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarCrearEmpresaMouseClicked(evt);
            }
        });
        JP_CrearEmpresa.add(JB_ConfirmarCrearEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel6.setText("Contrasena");
        JP_CrearEmpresa.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 129, 30));

        jLabel36.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel36.setText("Usuario");
        JP_CrearEmpresa.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 102, 30));

        jLabel61.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel61.setText("Id de Empresa");
        JP_CrearEmpresa.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, 25));
        JP_CrearEmpresa.add(TF_CrearIdEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 310, 30));

        jLabel127.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel127.setText("Nombre de Empresa");
        JP_CrearEmpresa.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 190, -1));

        jLabel128.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel128.setText("Direccion");
        JP_CrearEmpresa.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, 98, -1));

        jLabel129.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel129.setText("Correo Electronico");
        JP_CrearEmpresa.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 180, -1));

        jl_TelefonoCompania2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania2.setText("Telefono ");
        JP_CrearEmpresa.add(jl_TelefonoCompania2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 360, 202, -1));
        JP_CrearEmpresa.add(TF_CrearDireccionEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 310, 30));
        JP_CrearEmpresa.add(TF_CrearNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 310, 30));
        JP_CrearEmpresa.add(TF_CrearCorreoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 480, 310, 30));
        JP_CrearEmpresa.add(TF_CrearTelefonoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 390, 310, 30));

        jLabel130.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel130.setText("CIF");
        JP_CrearEmpresa.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 43, -1));
        JP_CrearEmpresa.add(TF_CrearCIFEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 210, 310, 30));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel133.setText("Sector de Actividad");
        JP_CrearEmpresa.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 190, -1));
        JP_CrearEmpresa.add(TF_CrearSectorActividadEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 310, 30));

        jPanel6.add(JP_CrearEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_ModEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        JP_ModEmpresa.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_ModEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JB_ConfirmarModEmpresa.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarModEmpresa.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarModEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarModEmpresa.setText("Modificar");
        JB_ConfirmarModEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarModEmpresaMouseClicked(evt);
            }
        });
        JP_ModEmpresa.add(JB_ConfirmarModEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        JT_ModEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Empresas"
            }
        ));
        JT_ModEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_ModEmpresaMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(JT_ModEmpresa);

        JP_ModEmpresa.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 357, 379));

        jLabel67.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel67.setText("Id de Empresa");
        JP_ModEmpresa.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, 25));

        TF_ModIdEmpresa.setEditable(false);
        JP_ModEmpresa.add(TF_ModIdEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 310, 30));

        jLabel134.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel134.setText("Sector de Actividad");
        JP_ModEmpresa.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 190, -1));
        JP_ModEmpresa.add(TF_ModSectorActividadEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 310, 30));
        JP_ModEmpresa.add(TF_ModNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 310, 30));
        JP_ModEmpresa.add(TF_ModCIFEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 310, 30));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel135.setText("Nombre de Empresa");
        JP_ModEmpresa.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 190, -1));

        jLabel136.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel136.setText("CIF");
        JP_ModEmpresa.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 43, -1));
        JP_ModEmpresa.add(TF_ModDireccionEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 120, 310, 30));

        jLabel137.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel137.setText("Direccion");
        JP_ModEmpresa.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 98, -1));

        jl_TelefonoCompania6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania6.setText("Telefono ");
        JP_ModEmpresa.add(jl_TelefonoCompania6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 180, 202, -1));
        JP_ModEmpresa.add(TF_ModCorreoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 300, 310, 30));
        JP_ModEmpresa.add(TF_ModTelefonoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 210, 310, 30));

        jLabel138.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel138.setText("Correo Electronico");
        JP_ModEmpresa.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 270, 180, -1));

        jPanel6.add(JP_ModEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 970));

        JP_EliminarEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        JP_EliminarEmpresa.setPreferredSize(new java.awt.Dimension(1920, 1080));

        JT_EliminarEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Empresa"
            }
        ));
        jScrollPane18.setViewportView(JT_EliminarEmpresa);

        JB_ConfirmarEliminarEmpresa.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarEliminarEmpresa.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarEliminarEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarEliminarEmpresa.setText("Eliminar");
        JB_ConfirmarEliminarEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarEliminarEmpresaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EliminarEmpresaLayout = new javax.swing.GroupLayout(JP_EliminarEmpresa);
        JP_EliminarEmpresa.setLayout(JP_EliminarEmpresaLayout);
        JP_EliminarEmpresaLayout.setHorizontalGroup(
            JP_EliminarEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_EliminarEmpresaLayout.createSequentialGroup()
                .addGroup(JP_EliminarEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_EliminarEmpresaLayout.createSequentialGroup()
                        .addGap(654, 654, 654)
                        .addComponent(JB_ConfirmarEliminarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_EliminarEmpresaLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(829, Short.MAX_VALUE))
        );
        JP_EliminarEmpresaLayout.setVerticalGroup(
            JP_EliminarEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_EliminarEmpresaLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(JB_ConfirmarEliminarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
        );

        jPanel6.add(JP_EliminarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        javax.swing.GroupLayout JF_CrudEmpresaLayout = new javax.swing.GroupLayout(JF_CrudEmpresa.getContentPane());
        JF_CrudEmpresa.getContentPane().setLayout(JF_CrudEmpresaLayout);
        JF_CrudEmpresaLayout.setHorizontalGroup(
            JF_CrudEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 2320, Short.MAX_VALUE)
        );
        JF_CrudEmpresaLayout.setVerticalGroup(
            JF_CrudEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );

        jPanel7.setPreferredSize(new java.awt.Dimension(1941, 770));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel27.setBackground(new java.awt.Color(44, 65, 114));

        JB_CrearPuesto.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_CrearPuesto.setText("Crear");
        JB_CrearPuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrearPuestoMouseClicked(evt);
            }
        });

        JB_ModificarPuesto.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_ModificarPuesto.setText("Modificar");
        JB_ModificarPuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ModificarPuestoMouseClicked(evt);
            }
        });
        JB_ModificarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ModificarPuestoActionPerformed(evt);
            }
        });

        JB_EliminarPuesto.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_EliminarPuesto.setText("Eliminar");
        JB_EliminarPuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_EliminarPuestoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(JB_CrearPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(JB_ModificarPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(JB_EliminarPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(750, 750, 750))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_ModificarPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_CrearPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_EliminarPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 110));

        JP_CrearPuesto.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearPuesto.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_CrearPuesto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JP_CrearPuesto.add(TF_CrearNivelEducacionPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 310, 30));

        JB_ConfirmarCrearPuesto.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarCrearPuesto.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarCrearPuesto.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarCrearPuesto.setText("Crear");
        JB_ConfirmarCrearPuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarCrearPuestoMouseClicked(evt);
            }
        });
        JP_CrearPuesto.add(JB_ConfirmarCrearPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        jLabel18.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel18.setText("Nivel de Educacion");
        JP_CrearPuesto.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 200, 30));

        jLabel37.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel37.setText("Genero");
        JP_CrearPuesto.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 102, 30));

        jLabel68.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(44, 65, 114));
        jLabel68.setText("Academicos");
        JP_CrearPuesto.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, 25));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel139.setText("Experiencia");
        JP_CrearPuesto.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 190, -1));

        jLabel140.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel140.setText("Habilidades");
        JP_CrearPuesto.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 130, -1));

        jLabel141.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel141.setText("Tipo Contrato");
        JP_CrearPuesto.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 430, 180, -1));

        jl_TelefonoCompania3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania3.setText("Sueldo");
        JP_CrearPuesto.add(jl_TelefonoCompania3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 290, 202, -1));
        JP_CrearPuesto.add(TF_CrearHabilidadesPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 310, 30));

        jLabel143.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel143.setText("Titulo");
        JP_CrearPuesto.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 190, -1));
        JP_CrearPuesto.add(TF_CrearTituloPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 310, 30));

        jLabel70.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel70.setText("Tipo de Puesto");
        JP_CrearPuesto.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, 25));

        jLabel71.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(44, 65, 114));
        jLabel71.setText("Personales");
        JP_CrearPuesto.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, 25));
        JP_CrearPuesto.add(TF_CrearTipodePuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 310, 30));

        jLabel149.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel149.setText("Promedio de Graduacion");
        JP_CrearPuesto.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 230, -1));

        CB_CrearGeneroPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre" }));
        JP_CrearPuesto.add(CB_CrearGeneroPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 120, 30));
        JP_CrearPuesto.add(JS_CrearPromedioGraduacionPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 90, 30));

        jLabel93.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(44, 65, 114));
        jLabel93.setText("Condiciones");
        JP_CrearPuesto.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 260, -1, 25));

        jLabel150.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(44, 65, 114));
        jLabel150.setText("Requisitos");
        JP_CrearPuesto.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, 40));
        JP_CrearPuesto.add(TF_CrearEnfermedadesPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 310, 30));

        jLabel151.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(44, 65, 114));
        jLabel151.setText("Legales");
        JP_CrearPuesto.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 90, -1, 25));

        jLabel152.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel152.setText("Antecedentes");
        JP_CrearPuesto.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, -1, 25));
        JP_CrearPuesto.add(TF_CrearAntecedentesPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 150, 310, 30));

        jLabel38.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel38.setText("Servicio Militar");
        JP_CrearPuesto.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 190, 160, 30));

        CB_CrearExperienciaPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        JP_CrearPuesto.add(CB_CrearExperienciaPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 120, 30));

        jLabel153.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(44, 65, 114));
        jLabel153.setText("Sanitarios");
        JP_CrearPuesto.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, -1, 25));

        CB_CrearHorarioSueldo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM", "AM-PM" }));
        JP_CrearPuesto.add(CB_CrearHorarioSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 390, 120, 30));

        jLabel154.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel154.setText("Años de Experiencia");
        JP_CrearPuesto.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 370, 190, -1));
        JP_CrearPuesto.add(JS_CrearSueldoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 320, 90, 30));

        jLabel155.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(44, 65, 114));
        jLabel155.setText("Profesionales");
        JP_CrearPuesto.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, 25));
        JP_CrearPuesto.add(JS_CrearAñosExperienciaPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, 90, 30));

        CB_CrearServicioMilitarPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        JP_CrearPuesto.add(CB_CrearServicioMilitarPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 220, 120, 30));

        CB_CrearContratoPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contrato Indefinido", "Contrato Temporal", "Contrato para la formacion", "Contrato en practicas", " " }));
        JP_CrearPuesto.add(CB_CrearContratoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 460, 146, 39));

        jLabel157.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel157.setText("Horario");
        JP_CrearPuesto.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 360, 180, -1));

        jLabel158.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel158.setText("Enfermedades");
        JP_CrearPuesto.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, -1, 25));

        JT_CrearPuestroDeTrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Empresa"
            }
        ));
        JT_CrearPuestroDeTrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_CrearPuestroDeTrabajoMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(JT_CrearPuestroDeTrabajo);

        JP_CrearPuesto.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 330));
        JP_CrearPuesto.add(TF_CrearDireccionPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 310, 30));

        jLabel205.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel205.setText("Direccion/Ubicacion");
        JP_CrearPuesto.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, 25));

        jPanel7.add(JP_CrearPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_ModPuesto.setBackground(new java.awt.Color(255, 255, 255));
        JP_ModPuesto.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_ModPuesto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JB_ConfirmarModEmpresa1.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarModEmpresa1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarModEmpresa1.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarModEmpresa1.setText("Modificar");
        JB_ConfirmarModEmpresa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarModEmpresa1MouseClicked(evt);
            }
        });
        JP_ModPuesto.add(JB_ConfirmarModEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 198, 58));

        JT_ModPuestroDeTrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Puesto de Trabajo"
            }
        ));
        JT_ModPuestroDeTrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_ModPuestroDeTrabajoMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(JT_ModPuestroDeTrabajo);

        JP_ModPuesto.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 340, 330));

        jLabel156.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel156.setText("Direccion/Ubicacion");
        JP_ModPuesto.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, 25));

        jLabel159.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(44, 65, 114));
        jLabel159.setText("Personales");
        JP_ModPuesto.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, 25));
        JP_ModPuesto.add(TF_ModDireccionPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 310, 30));

        jLabel39.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel39.setText("Genero");
        JP_ModPuesto.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 102, 30));

        CB_ModGeneroPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre" }));
        JP_ModPuesto.add(CB_ModGeneroPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 30));

        jLabel160.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(44, 65, 114));
        jLabel160.setText("Academicos");
        JP_ModPuesto.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, 25));

        jLabel40.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel40.setText("Nivel de Educacion");
        JP_ModPuesto.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 200, 30));
        JP_ModPuesto.add(TF_ModNivelEducacionPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 310, 30));

        jLabel161.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel161.setText("Titulo");
        JP_ModPuesto.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 190, -1));
        JP_ModPuesto.add(TF_ModTituloPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 310, 30));

        jLabel162.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel162.setText("Promedio de Graduacion");
        JP_ModPuesto.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 230, -1));
        JP_ModPuesto.add(JS_ModPromedioGraduacionPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 90, 30));

        jLabel163.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(44, 65, 114));
        jLabel163.setText("Sanitarios");
        JP_ModPuesto.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, -1, 25));

        jLabel164.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel164.setText("Enfermedades");
        JP_ModPuesto.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, -1, 25));
        JP_ModPuesto.add(TF_ModEnfermedadesPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 310, 30));

        jLabel165.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(44, 65, 114));
        jLabel165.setText("Profesionales");
        JP_ModPuesto.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, -1, 25));

        jLabel166.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel166.setText("Experiencia");
        JP_ModPuesto.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 190, -1));

        CB_ModExperienciaPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        JP_ModPuesto.add(CB_ModExperienciaPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 120, 30));
        JP_ModPuesto.add(JS_ModAñosExperienciaPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 90, 30));

        jLabel167.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel167.setText("Años de Experiencia");
        JP_ModPuesto.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 190, -1));
        JP_ModPuesto.add(TF_ModHabilidadesPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 310, 30));

        jLabel168.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel168.setText("Habilidades");
        JP_ModPuesto.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 130, -1));

        jLabel169.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(44, 65, 114));
        jLabel169.setText("Legales");
        JP_ModPuesto.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 90, -1, 25));

        jLabel170.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel170.setText("Antecedentes");
        JP_ModPuesto.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 120, -1, 25));
        JP_ModPuesto.add(TF_ModAntecedentesPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 150, 310, 30));

        jLabel41.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel41.setText("Servicio Militar");
        JP_ModPuesto.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 190, 160, 30));

        CB_ModServicioMilitarPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        JP_ModPuesto.add(CB_ModServicioMilitarPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 220, 120, 30));

        jLabel171.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(44, 65, 114));
        jLabel171.setText("Condiciones");
        JP_ModPuesto.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 260, -1, 25));

        jl_TelefonoCompania8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania8.setText("Sueldo");
        JP_ModPuesto.add(jl_TelefonoCompania8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 290, 202, -1));
        JP_ModPuesto.add(JS_ModSueldoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 320, 90, 30));

        jLabel172.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel172.setText("Horario");
        JP_ModPuesto.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 360, 180, -1));

        CB_ModHorarioSueldo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM", "AM-PM" }));
        JP_ModPuesto.add(CB_ModHorarioSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 390, 120, 30));

        jLabel173.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel173.setText("Tipo Contrato");
        JP_ModPuesto.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 430, 180, -1));

        CB_ModContratoPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contrato Indefinido", "Contrato Temporal", "Contrato para la formacion", "Contrato en practicas", " " }));
        JP_ModPuesto.add(CB_ModContratoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 460, 146, 39));

        jLabel206.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel206.setText("Tipo de Puesto");
        JP_ModPuesto.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, 30));
        JP_ModPuesto.add(TF_ModTipodePuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 310, 30));

        jPanel7.add(JP_ModPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 970));

        JP_EliminarPuesto.setBackground(new java.awt.Color(255, 255, 255));
        JP_EliminarPuesto.setPreferredSize(new java.awt.Dimension(1920, 1080));

        JT_EliminarPuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Puesto de Trabajo"
            }
        ));
        jScrollPane20.setViewportView(JT_EliminarPuesto);

        JB_ConfirmarEliminarPuesto.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarEliminarPuesto.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarEliminarPuesto.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarEliminarPuesto.setText("Eliminar");
        JB_ConfirmarEliminarPuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarEliminarPuestoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JP_EliminarPuestoLayout = new javax.swing.GroupLayout(JP_EliminarPuesto);
        JP_EliminarPuesto.setLayout(JP_EliminarPuestoLayout);
        JP_EliminarPuestoLayout.setHorizontalGroup(
            JP_EliminarPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_EliminarPuestoLayout.createSequentialGroup()
                .addGroup(JP_EliminarPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_EliminarPuestoLayout.createSequentialGroup()
                        .addGap(654, 654, 654)
                        .addComponent(JB_ConfirmarEliminarPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_EliminarPuestoLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(829, Short.MAX_VALUE))
        );
        JP_EliminarPuestoLayout.setVerticalGroup(
            JP_EliminarPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_EliminarPuestoLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(JB_ConfirmarEliminarPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
        );

        jPanel7.add(JP_EliminarPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        javax.swing.GroupLayout JF_CrudPuestoDeTrabajoLayout = new javax.swing.GroupLayout(JF_CrudPuestoDeTrabajo.getContentPane());
        JF_CrudPuestoDeTrabajo.getContentPane().setLayout(JF_CrudPuestoDeTrabajoLayout);
        JF_CrudPuestoDeTrabajoLayout.setHorizontalGroup(
            JF_CrudPuestoDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 2320, Short.MAX_VALUE)
        );
        JF_CrudPuestoDeTrabajoLayout.setVerticalGroup(
            JF_CrudPuestoDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );

        jPanel10.setPreferredSize(new java.awt.Dimension(1941, 770));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(44, 65, 114));

        JB_CrearSolicitud.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_CrearSolicitud.setText("Crear");
        JB_CrearSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CrearSolicitudMouseClicked(evt);
            }
        });

        JB_EliminarSolicitud.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JB_EliminarSolicitud.setText("Eliminar");
        JB_EliminarSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_EliminarSolicitudMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(JB_CrearSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(478, 478, 478)
                .addComponent(JB_EliminarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(750, 750, 750))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_CrearSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_EliminarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 110));

        JP_CrearSolicitud.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_CrearSolicitud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TF_CrearSolicitudApellido.setEditable(false);
        TF_CrearSolicitudApellido.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 310, 30));

        JB_ConfirmarCrearSolicitud.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarCrearSolicitud.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarCrearSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarCrearSolicitud.setText("Crear");
        JB_ConfirmarCrearSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarCrearSolicitudMouseClicked(evt);
            }
        });
        JP_CrearSolicitud.add(JB_ConfirmarCrearSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 590, 198, 58));

        jLabel49.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel49.setText("Apellido");
        JP_CrearSolicitud.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 102, 30));

        jLabel201.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel201.setText("Nombre");
        JP_CrearSolicitud.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, 25));

        TF_CrearSolicitudNombre.setEditable(false);
        TF_CrearSolicitudNombre.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 310, 30));

        JT_ModEmpresa2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Personas"
            }
        ));
        JT_ModEmpresa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_ModEmpresa2MouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(JT_ModEmpresa2);

        JP_CrearSolicitud.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 357, 379));

        jLabel174.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(44, 65, 114));
        jLabel174.setText("Personales");
        JP_CrearSolicitud.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, 25));

        jLabel175.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel175.setText("Direccion/Ubicacion");
        JP_CrearSolicitud.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, 25));

        TF_CrearSolicitudDireccion.setEditable(false);
        TF_CrearSolicitudDireccion.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 310, 30));

        jLabel42.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel42.setText("Genero");
        JP_CrearSolicitud.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 102, 30));

        jLabel176.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(44, 65, 114));
        jLabel176.setText("Academicos");
        JP_CrearSolicitud.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, 25));

        jLabel43.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel43.setText("Nivel de Educacion");
        JP_CrearSolicitud.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 200, 30));

        TF_CrearSolicitudNivelEdicacion.setEditable(false);
        TF_CrearSolicitudNivelEdicacion.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudNivelEdicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 310, 30));

        jLabel177.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel177.setText("Titulo");
        JP_CrearSolicitud.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 190, -1));

        TF_CrearSolicitudTitulo.setEditable(false);
        TF_CrearSolicitudTitulo.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 310, 30));

        jLabel178.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel178.setText("Promedio de Graduacion");
        JP_CrearSolicitud.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 230, -1));

        jLabel179.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(44, 65, 114));
        jLabel179.setText("Sanitarios");
        JP_CrearSolicitud.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, 25));

        jLabel180.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel180.setText("Enfermedades");
        JP_CrearSolicitud.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, 25));

        TF_CrearSolicitudEnfermedades.setEditable(false);
        TF_CrearSolicitudEnfermedades.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudEnfermedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 310, 30));

        jLabel181.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(44, 65, 114));
        jLabel181.setText("Profesionales");
        JP_CrearSolicitud.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, -1, 25));

        jLabel182.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel182.setText("Experiencia");
        JP_CrearSolicitud.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, 190, -1));

        jLabel183.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel183.setText("Años de Experiencia");
        JP_CrearSolicitud.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 190, -1));

        jLabel184.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel184.setText("Habilidades");
        JP_CrearSolicitud.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 130, -1));

        TF_CrearSolicitudGenero.setEditable(false);
        TF_CrearSolicitudGenero.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 310, 30));

        jLabel185.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel185.setText("Antecedentes");
        JP_CrearSolicitud.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, 25));

        jLabel186.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(44, 65, 114));
        jLabel186.setText("Legales");
        JP_CrearSolicitud.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, 25));

        TF_CrearSolicitudContrato.setEditable(false);
        TF_CrearSolicitudContrato.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 530, 310, 30));

        jLabel44.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel44.setText("Servicio Militar");
        JP_CrearSolicitud.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, 160, 30));

        jLabel187.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(44, 65, 114));
        jLabel187.setText("Condiciones");
        JP_CrearSolicitud.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 50, -1, 25));

        jl_TelefonoCompania9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania9.setText("Sueldo");
        JP_CrearSolicitud.add(jl_TelefonoCompania9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 350, 202, -1));

        jLabel188.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel188.setText("Horario");
        JP_CrearSolicitud.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 420, 180, -1));

        jLabel189.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel189.setText("Tipo Contrato");
        JP_CrearSolicitud.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 500, 180, -1));

        TF_CrearSolicitudHabilidades.setEditable(false);
        TF_CrearSolicitudHabilidades.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudHabilidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 530, 310, 30));

        TF_CrearSolicitudExperiencia.setEditable(false);
        TF_CrearSolicitudExperiencia.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudExperiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, 310, 30));

        TF_CrearSolicitudAniosExperiencia.setEditable(false);
        TF_CrearSolicitudAniosExperiencia.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudAniosExperiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, 310, 30));

        TF_CrearSolicitudPromedioGraduacion.setEditable(false);
        TF_CrearSolicitudPromedioGraduacion.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudPromedioGraduacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 310, 30));

        TF_CrearSolicitudAntecedentes.setEditable(false);
        TF_CrearSolicitudAntecedentes.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudAntecedentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 310, 30));

        TF_CrearSolicitudServicioMilitar.setEditable(false);
        TF_CrearSolicitudServicioMilitar.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudServicioMilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 310, 30));

        TF_CrearSolicitudSueldo.setEditable(false);
        TF_CrearSolicitudSueldo.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 380, 310, 30));

        TF_CrearSolicitudHorario.setEditable(false);
        TF_CrearSolicitudHorario.setBackground(new java.awt.Color(255, 255, 255));
        JP_CrearSolicitud.add(TF_CrearSolicitudHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 460, 310, 30));

        jLabel144.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel144.setText("Puestos deseados");
        JP_CrearSolicitud.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 70, -1, 25));

        TA_CrearSolicitudPuestoDeseado.setColumns(20);
        TA_CrearSolicitudPuestoDeseado.setRows(5);
        jScrollPane7.setViewportView(TA_CrearSolicitudPuestoDeseado);

        JP_CrearSolicitud.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 100, 310, -1));

        jLabel145.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel145.setText("Puestos no deseados");
        JP_CrearSolicitud.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 200, -1, 25));

        TA_CrearSolicitudPuestoNoDeseado.setColumns(20);
        TA_CrearSolicitudPuestoNoDeseado.setRows(5);
        jScrollPane8.setViewportView(TA_CrearSolicitudPuestoNoDeseado);

        JP_CrearSolicitud.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 230, 310, -1));

        jPanel10.add(JP_CrearSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        JP_EliminarSolicitud.setBackground(new java.awt.Color(255, 255, 255));
        JP_EliminarSolicitud.setPreferredSize(new java.awt.Dimension(1920, 1080));

        JB_ConfirmarEliminarSolicitud.setBackground(new java.awt.Color(44, 65, 114));
        JB_ConfirmarEliminarSolicitud.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_ConfirmarEliminarSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        JB_ConfirmarEliminarSolicitud.setText("Eliminar");
        JB_ConfirmarEliminarSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_ConfirmarEliminarSolicitudMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Codigo de referencia de solicitud:");

        javax.swing.GroupLayout JP_EliminarSolicitudLayout = new javax.swing.GroupLayout(JP_EliminarSolicitud);
        JP_EliminarSolicitud.setLayout(JP_EliminarSolicitudLayout);
        JP_EliminarSolicitudLayout.setHorizontalGroup(
            JP_EliminarSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_EliminarSolicitudLayout.createSequentialGroup()
                .addGroup(JP_EliminarSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_EliminarSolicitudLayout.createSequentialGroup()
                        .addGap(651, 651, 651)
                        .addComponent(JB_ConfirmarEliminarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_EliminarSolicitudLayout.createSequentialGroup()
                        .addGap(543, 543, 543)
                        .addGroup(JP_EliminarSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF_CodigoReferenciaSolicitudEliminar)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))))
                .addContainerGap(962, Short.MAX_VALUE))
        );
        JP_EliminarSolicitudLayout.setVerticalGroup(
            JP_EliminarSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_EliminarSolicitudLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addComponent(TF_CodigoReferenciaSolicitudEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188)
                .addComponent(JB_ConfirmarEliminarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(402, 402, 402))
        );

        jPanel10.add(JP_EliminarSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1920, 900));

        javax.swing.GroupLayout JF_CrudSolicitudEmpleoLayout = new javax.swing.GroupLayout(JF_CrudSolicitudEmpleo.getContentPane());
        JF_CrudSolicitudEmpleo.getContentPane().setLayout(JF_CrudSolicitudEmpleoLayout);
        JF_CrudSolicitudEmpleoLayout.setHorizontalGroup(
            JF_CrudSolicitudEmpleoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 2320, Short.MAX_VALUE)
        );
        JF_CrudSolicitudEmpleoLayout.setVerticalGroup(
            JF_CrudSolicitudEmpleoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );

        JF_Persona.setMinimumSize(new java.awt.Dimension(1920, 1080));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setOpaque(false);
        jPanel15.setPreferredSize(new java.awt.Dimension(1926, 924));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JP_BusquedaDetallada.setBackground(new java.awt.Color(228, 249, 249));

        JT_ResultadosBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Empresa", "Puesto", "Ubicacion", "Sueldo"
            }
        ));
        jScrollPane12.setViewportView(JT_ResultadosBusqueda);

        TF_BarraBusquedaPersona.setEditable(false);
        TF_BarraBusquedaPersona.setBackground(new java.awt.Color(255, 255, 255));

        jLabel222.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel222.setText("Introduce palabra clave");

        jPanel23.setBackground(new java.awt.Color(44, 65, 114));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JB_Busqueda.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_Busqueda.setText("Buscar");
        JB_Busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_BusquedaMouseClicked(evt);
            }
        });
        jPanel23.add(JB_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 230, 62));

        javax.swing.GroupLayout JP_BusquedaDetalladaLayout = new javax.swing.GroupLayout(JP_BusquedaDetallada);
        JP_BusquedaDetallada.setLayout(JP_BusquedaDetalladaLayout);
        JP_BusquedaDetalladaLayout.setHorizontalGroup(
            JP_BusquedaDetalladaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_BusquedaDetalladaLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(JP_BusquedaDetalladaLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(JP_BusquedaDetalladaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_BarraBusquedaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_BusquedaDetalladaLayout.setVerticalGroup(
            JP_BusquedaDetalladaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_BusquedaDetalladaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(JP_BusquedaDetalladaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_BusquedaDetalladaLayout.createSequentialGroup()
                        .addComponent(jLabel222)
                        .addGap(18, 18, 18)
                        .addComponent(TF_BarraBusquedaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jPanel15.add(JP_BusquedaDetallada, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 1300, 730));

        JP_PuestosDispiniblesPersona.setBackground(new java.awt.Color(228, 249, 249));

        JT_PropiedadesEnMercadoComprador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Empresa", "Nombre de Puesto", "Tipo Contrato", "Sueldo", "Ubicacion"
            }
        ));
        JT_PropiedadesEnMercadoComprador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_PropiedadesEnMercadoCompradorMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(JT_PropiedadesEnMercadoComprador);

        jPanel19.setBackground(new java.awt.Color(44, 65, 114));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JB_PropiedadesEnMercadoComprador2.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_PropiedadesEnMercadoComprador2.setText("Ver detalles");
        JB_PropiedadesEnMercadoComprador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_PropiedadesEnMercadoComprador2MouseClicked(evt);
            }
        });
        jPanel19.add(JB_PropiedadesEnMercadoComprador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 52));

        javax.swing.GroupLayout JP_PuestosDispiniblesPersonaLayout = new javax.swing.GroupLayout(JP_PuestosDispiniblesPersona);
        JP_PuestosDispiniblesPersona.setLayout(JP_PuestosDispiniblesPersonaLayout);
        JP_PuestosDispiniblesPersonaLayout.setHorizontalGroup(
            JP_PuestosDispiniblesPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PuestosDispiniblesPersonaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        JP_PuestosDispiniblesPersonaLayout.setVerticalGroup(
            JP_PuestosDispiniblesPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PuestosDispiniblesPersonaLayout.createSequentialGroup()
                .addGroup(JP_PuestosDispiniblesPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_PuestosDispiniblesPersonaLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_PuestosDispiniblesPersonaLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jPanel15.add(JP_PuestosDispiniblesPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 1290, 730));

        JP_MiSolicitudPersona.setBackground(new java.awt.Color(228, 249, 249));
        JP_MiSolicitudPersona.setPreferredSize(new java.awt.Dimension(1290, 730));

        jLabel214.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel214.setText("Codigo de Referencia");

        TF_MiSolicitudEstadoSolicitudPersona.setEditable(false);
        TF_MiSolicitudEstadoSolicitudPersona.setBackground(new java.awt.Color(255, 255, 255));

        jLabel215.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel215.setText("Estado");

        TF_MiSolicitudCodigoReferenciaPersona.setEditable(false);
        TF_MiSolicitudCodigoReferenciaPersona.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(44, 65, 114));
        jPanel12.setForeground(new java.awt.Color(44, 65, 114));
        jPanel12.setPreferredSize(new java.awt.Dimension(5, 100));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jLabel54.setBackground(new java.awt.Color(44, 65, 114));
        jLabel54.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(44, 65, 114));
        jLabel54.setText("Detalles sobre el puesto de trabajo");

        jLabel216.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel216.setText("Puesto de Trabajo");

        TF_MiSolicitudPuestoTrabajoaPersona.setEditable(false);
        TF_MiSolicitudPuestoTrabajoaPersona.setBackground(new java.awt.Color(255, 255, 255));

        jLabel217.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel217.setText("Nombre de Empresa");

        TF_MiSolicitudNombreEmpresaPersona.setEditable(false);
        TF_MiSolicitudNombreEmpresaPersona.setBackground(new java.awt.Color(255, 255, 255));
        TF_MiSolicitudNombreEmpresaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_MiSolicitudNombreEmpresaPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_MiSolicitudPersonaLayout = new javax.swing.GroupLayout(JP_MiSolicitudPersona);
        JP_MiSolicitudPersona.setLayout(JP_MiSolicitudPersonaLayout);
        JP_MiSolicitudPersonaLayout.setHorizontalGroup(
            JP_MiSolicitudPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_MiSolicitudPersonaLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(JP_MiSolicitudPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel215)
                    .addComponent(TF_MiSolicitudCodigoReferenciaPersona)
                    .addComponent(jLabel214, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF_MiSolicitudEstadoSolicitudPersona))
                .addGap(194, 194, 194)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178)
                .addGroup(JP_MiSolicitudPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_MiSolicitudPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel217, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TF_MiSolicitudPuestoTrabajoaPersona)
                        .addComponent(jLabel216, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(TF_MiSolicitudNombreEmpresaPersona, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_MiSolicitudPersonaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addGap(210, 210, 210))
        );
        JP_MiSolicitudPersonaLayout.setVerticalGroup(
            JP_MiSolicitudPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_MiSolicitudPersonaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel54)
                .addGroup(JP_MiSolicitudPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_MiSolicitudPersonaLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel214)
                        .addGap(37, 37, 37)
                        .addComponent(TF_MiSolicitudCodigoReferenciaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel215)
                        .addGap(18, 18, 18)
                        .addComponent(TF_MiSolicitudEstadoSolicitudPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_MiSolicitudPersonaLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel216)
                        .addGap(39, 39, 39)
                        .addComponent(TF_MiSolicitudPuestoTrabajoaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel217)
                        .addGap(26, 26, 26)
                        .addComponent(TF_MiSolicitudNombreEmpresaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_MiSolicitudPersonaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jPanel15.add(JP_MiSolicitudPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 1290, 730));

        jPanel17.setBackground(new java.awt.Color(44, 65, 114));
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(1926, 150));

        JB_CerrarSesionPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CerrarSesionPersonaMouseClicked(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel45.setText("Cerrar Sesion");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JB_CerrarSesionPersonaLayout = new javax.swing.GroupLayout(JB_CerrarSesionPersona);
        JB_CerrarSesionPersona.setLayout(JB_CerrarSesionPersonaLayout);
        JB_CerrarSesionPersonaLayout.setHorizontalGroup(
            JB_CerrarSesionPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JB_CerrarSesionPersonaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel45)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        JB_CerrarSesionPersonaLayout.setVerticalGroup(
            JB_CerrarSesionPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JB_CerrarSesionPersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel46.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Bienvedido, has iniciado sesion ");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel46)
                .addGap(482, 482, 482)
                .addComponent(JB_CerrarSesionPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(JB_CerrarSesionPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 150));

        jPanel18.setBackground(new java.awt.Color(44, 65, 114));

        JB_PuestosDisponiblesPersonas.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_PuestosDisponiblesPersonas.setText("Puestos Disponibles");
        JB_PuestosDisponiblesPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_PuestosDisponiblesPersonasMouseClicked(evt);
            }
        });

        JB_BusquedaDetalladaPersonas.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_BusquedaDetalladaPersonas.setText("Busqueda Detallada");
        JB_BusquedaDetalladaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_BusquedaDetalladaPersonasMouseClicked(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Opciones");

        JB_MiSolicitudPersonas.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_MiSolicitudPersonas.setText("Mi Solicitud");
        JB_MiSolicitudPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_MiSolicitudPersonasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_PuestosDisponiblesPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_BusquedaDetalladaPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_MiSolicitudPersonas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addGap(65, 65, 65))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel47)
                .addGap(90, 90, 90)
                .addComponent(JB_PuestosDisponiblesPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(JB_BusquedaDetalladaPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(JB_MiSolicitudPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 490));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 880));

        javax.swing.GroupLayout JF_PersonaLayout = new javax.swing.GroupLayout(JF_Persona.getContentPane());
        JF_Persona.getContentPane().setLayout(JF_PersonaLayout);
        JF_PersonaLayout.setHorizontalGroup(
            JF_PersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JF_PersonaLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JF_PersonaLayout.setVerticalGroup(
            JF_PersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JF_PersonaLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(44, 65, 114));
        jPanel24.setForeground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(1926, 150));

        jLabel57.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Bienvenido, has iniciado sesion como empresa");

        JB_CerrarSesionEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_CerrarSesionEmpresaMouseClicked(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel56.setText("Cerrar Sesion");
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JB_CerrarSesionEmpresaLayout = new javax.swing.GroupLayout(JB_CerrarSesionEmpresa);
        JB_CerrarSesionEmpresa.setLayout(JB_CerrarSesionEmpresaLayout);
        JB_CerrarSesionEmpresaLayout.setHorizontalGroup(
            JB_CerrarSesionEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JB_CerrarSesionEmpresaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel56)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        JB_CerrarSesionEmpresaLayout.setVerticalGroup(
            JB_CerrarSesionEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JB_CerrarSesionEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(JB_CerrarSesionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_CerrarSesionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel30.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, -1));

        jPanel31.setBackground(new java.awt.Color(44, 65, 114));

        JB_PuestosOfrecidos.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_PuestosOfrecidos.setText("Puestos Ofrecidos");
        JB_PuestosOfrecidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_PuestosOfrecidosMouseClicked(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Opciones");

        JB_SolicitudesEmpleo.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_SolicitudesEmpleo.setText("Solicitudes");
        JB_SolicitudesEmpleo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_SolicitudesEmpleoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(JB_PuestosOfrecidos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58)
                .addGap(45, 45, 45))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JB_SolicitudesEmpleo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel58)
                .addGap(42, 42, 42)
                .addComponent(JB_PuestosOfrecidos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(JB_SolicitudesEmpleo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, -1));

        JP_PuestosOfrecidosEmpresa.setBackground(new java.awt.Color(228, 249, 249));
        JP_PuestosOfrecidosEmpresa.setPreferredSize(new java.awt.Dimension(1290, 730));

        JT_PuestosOfrecidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Puesto", "Salario"
            }
        ));
        jScrollPane13.setViewportView(JT_PuestosOfrecidos);

        javax.swing.GroupLayout JP_PuestosOfrecidosEmpresaLayout = new javax.swing.GroupLayout(JP_PuestosOfrecidosEmpresa);
        JP_PuestosOfrecidosEmpresa.setLayout(JP_PuestosOfrecidosEmpresaLayout);
        JP_PuestosOfrecidosEmpresaLayout.setHorizontalGroup(
            JP_PuestosOfrecidosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PuestosOfrecidosEmpresaLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        JP_PuestosOfrecidosEmpresaLayout.setVerticalGroup(
            JP_PuestosOfrecidosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PuestosOfrecidosEmpresaLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jPanel30.add(JP_PuestosOfrecidosEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 1290, 730));

        JP_SolicitudesEmpresas.setBackground(new java.awt.Color(228, 249, 249));
        JP_SolicitudesEmpresas.setPreferredSize(new java.awt.Dimension(1290, 730));

        jLabel223.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel223.setText("Introduce el puesto ");

        TF_BarraBusquedaEmpresa.setEditable(false);
        TF_BarraBusquedaEmpresa.setBackground(new java.awt.Color(255, 255, 255));

        jPanel28.setBackground(new java.awt.Color(44, 65, 114));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JB_Busqueda1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JB_Busqueda1.setText("Buscar");
        JB_Busqueda1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_Busqueda1MouseClicked(evt);
            }
        });
        jPanel28.add(JB_Busqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 230, 62));

        JT_BuscarSolicitudesEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo Referencia", "Nombre", "Apellido", "Puesto"
            }
        ));
        jScrollPane22.setViewportView(JT_BuscarSolicitudesEmpresa);

        javax.swing.GroupLayout JP_SolicitudesEmpresasLayout = new javax.swing.GroupLayout(JP_SolicitudesEmpresas);
        JP_SolicitudesEmpresas.setLayout(JP_SolicitudesEmpresasLayout);
        JP_SolicitudesEmpresasLayout.setHorizontalGroup(
            JP_SolicitudesEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_SolicitudesEmpresasLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(JP_SolicitudesEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JP_SolicitudesEmpresasLayout.createSequentialGroup()
                        .addGroup(JP_SolicitudesEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_BarraBusquedaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        JP_SolicitudesEmpresasLayout.setVerticalGroup(
            JP_SolicitudesEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_SolicitudesEmpresasLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(JP_SolicitudesEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_SolicitudesEmpresasLayout.createSequentialGroup()
                        .addComponent(jLabel223)
                        .addGap(29, 29, 29)
                        .addComponent(TF_BarraBusquedaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jPanel30.add(JP_SolicitudesEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 1290, 730));

        javax.swing.GroupLayout JF_EmpresaLayout = new javax.swing.GroupLayout(JF_Empresa.getContentPane());
        JF_Empresa.getContentPane().setLayout(JF_EmpresaLayout);
        JF_EmpresaLayout.setHorizontalGroup(
            JF_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JF_EmpresaLayout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JF_EmpresaLayout.setVerticalGroup(
            JF_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JP_MasInfoPuesto.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JP_MasInfoPuesto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TF_InfoPuestoNivelEducacion.setEditable(false);
        TF_InfoPuestoNivelEducacion.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoNivelEducacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 310, 30));

        jLabel50.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel50.setText("Nivel de Educacion");
        JP_MasInfoPuesto.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 200, 30));

        jLabel51.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel51.setText("Genero");
        JP_MasInfoPuesto.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 102, 30));

        jLabel69.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(44, 65, 114));
        jLabel69.setText("Academicos");
        JP_MasInfoPuesto.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, 25));

        jLabel146.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel146.setText("Experiencia");
        JP_MasInfoPuesto.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 190, -1));

        jLabel147.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel147.setText("Habilidades");
        JP_MasInfoPuesto.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 560, 130, -1));

        jLabel148.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel148.setText("Tipo Contrato");
        JP_MasInfoPuesto.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 570, 180, -1));

        jl_TelefonoCompania7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_TelefonoCompania7.setText("Sueldo");
        JP_MasInfoPuesto.add(jl_TelefonoCompania7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 410, 202, -1));

        jLabel190.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel190.setText("Titulo");
        JP_MasInfoPuesto.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 190, -1));

        jLabel191.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel191.setText("Direccion/Ubicacion");
        JP_MasInfoPuesto.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, 25));

        jLabel192.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(44, 65, 114));
        jLabel192.setText("Personales");
        JP_MasInfoPuesto.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, 25));

        TF_InfoPuestoTipoContrato.setEditable(false);
        TF_InfoPuestoTipoContrato.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoTipoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 600, 310, 30));

        jLabel193.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel193.setText("Promedio de Graduacion");
        JP_MasInfoPuesto.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, 230, -1));

        jLabel194.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(44, 65, 114));
        jLabel194.setText("Condiciones");
        JP_MasInfoPuesto.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 380, -1, 25));

        jLabel195.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(44, 65, 114));
        jLabel195.setText("Requisitos");
        JP_MasInfoPuesto.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, -1, 40));

        TF_InfoPuestoEnfermedades.setEditable(false);
        TF_InfoPuestoEnfermedades.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoEnfermedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 310, 30));

        jLabel196.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(44, 65, 114));
        jLabel196.setText("Legales");
        JP_MasInfoPuesto.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 210, -1, 25));

        jLabel197.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel197.setText("Antecedentes");
        JP_MasInfoPuesto.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 240, -1, 25));

        jLabel52.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel52.setText("Servicio Militar");
        JP_MasInfoPuesto.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 310, 160, 30));

        jLabel198.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(44, 65, 114));
        jLabel198.setText("Sanitarios");
        JP_MasInfoPuesto.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, -1, 25));

        jLabel199.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel199.setText("Años de Experiencia");
        JP_MasInfoPuesto.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 190, -1));

        jLabel200.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(44, 65, 114));
        jLabel200.setText("Profesionales");
        JP_MasInfoPuesto.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, -1, 25));

        jLabel202.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel202.setText("Horario");
        JP_MasInfoPuesto.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 480, 180, -1));

        jLabel203.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel203.setText("Enfermedades");
        JP_MasInfoPuesto.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, -1, 25));

        jLabel204.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel204.setText("Tipo de Puesto");
        JP_MasInfoPuesto.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, 25));

        TF_InfoPuestoTipoPuesto.setEditable(false);
        JP_MasInfoPuesto.add(TF_InfoPuestoTipoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 310, 30));

        jLabel213.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel213.setText("Nombre Empresa");
        JP_MasInfoPuesto.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 25));

        TF_InfoPuestoNombeEmpresa.setEditable(false);
        JP_MasInfoPuesto.add(TF_InfoPuestoNombeEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 310, 30));

        jPanel9.setBackground(new java.awt.Color(44, 65, 114));
        jPanel9.setForeground(new java.awt.Color(44, 65, 114));
        jPanel9.setPreferredSize(new java.awt.Dimension(5, 100));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        JP_MasInfoPuesto.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 10, 690));

        jPanel20.setBackground(new java.awt.Color(44, 65, 114));
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(1926, 150));

        jLabel53.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Detalles sobre el puesto de trabajo");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(jLabel53)
                .addContainerGap(776, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel53)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        JP_MasInfoPuesto.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 130));

        TF_InfoPuestoDireccion.setEditable(false);
        TF_InfoPuestoDireccion.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 310, 30));

        TF_InfoPuestoGenero.setEditable(false);
        TF_InfoPuestoGenero.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 310, 30));

        TF_InfoPuestoTitulo.setEditable(false);
        TF_InfoPuestoTitulo.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 310, 30));

        TF_InfoPuestoPromedio.setEditable(false);
        TF_InfoPuestoPromedio.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 310, 30));

        TF_InfoPuestoExperiencia.setEditable(false);
        TF_InfoPuestoExperiencia.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoExperiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 310, 30));

        TF_InfoPuestoAniosExperiencia.setEditable(false);
        TF_InfoPuestoAniosExperiencia.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoAniosExperiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 520, 310, 30));

        TF_InfoPuestoHabilidades.setEditable(false);
        TF_InfoPuestoHabilidades.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoHabilidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 600, 310, 30));

        TF_InfoPuestoAntecedentes.setEditable(false);
        TF_InfoPuestoAntecedentes.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoAntecedentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 270, 310, 30));

        TF_InfoPuestoServicioMilitar.setEditable(false);
        TF_InfoPuestoServicioMilitar.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoServicioMilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 340, 310, 30));

        TF_InfoPuestoSueldo.setEditable(false);
        TF_InfoPuestoSueldo.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 440, 310, 30));

        TF_InfoPuestoHorario.setEditable(false);
        TF_InfoPuestoHorario.setBackground(new java.awt.Color(255, 255, 255));
        JP_MasInfoPuesto.add(TF_InfoPuestoHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 520, 310, 30));

        javax.swing.GroupLayout JD_MasInfoPuestoLayout = new javax.swing.GroupLayout(JD_MasInfoPuesto.getContentPane());
        JD_MasInfoPuesto.getContentPane().setLayout(JD_MasInfoPuestoLayout);
        JD_MasInfoPuestoLayout.setHorizontalGroup(
            JD_MasInfoPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
            .addGroup(JD_MasInfoPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JD_MasInfoPuestoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JP_MasInfoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        JD_MasInfoPuestoLayout.setVerticalGroup(
            JD_MasInfoPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(JD_MasInfoPuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JD_MasInfoPuestoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JP_MasInfoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1941, 770));

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel7.setText("USERNAME:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel8.setText("PASSWORD:");

        jPanel4.setBackground(new java.awt.Color(44, 65, 114));
        jPanel4.setPreferredSize(new java.awt.Dimension(314, 924));

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("WELCOME BACK!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(407, Short.MAX_VALUE))
        );

        JB_LogIn.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        JB_LogIn.setText("Log in");
        JB_LogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_LogInMouseClicked(evt);
            }
        });

        ADMIN.setText("ADMIN");
        ADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADMINMouseClicked(evt);
            }
        });

        PERSONA.setText("PERSONA");
        PERSONA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PERSONAMouseClicked(evt);
            }
        });

        EMPRESA.setText("EMPRESA");
        EMPRESA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EMPRESAMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(JB_LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ADMIN)
                            .addComponent(PERSONA)
                            .addComponent(EMPRESA))
                        .addGap(198, 198, 198)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(792, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TF_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADMIN))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(PERSONA))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(TF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(EMPRESA)))
                .addGap(63, 63, 63)
                .addComponent(JB_LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_LogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_LogInMouseClicked
        String username = TF_UserName.getText();
        String password = TF_Password.getText();

    }//GEN-LAST:event_JB_LogInMouseClicked

    private void JB_CrudAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrudAdminMouseClicked
        JP_CRUD.setVisible(true);
        JP_Contrataciones.setVisible(false);
    }//GEN-LAST:event_JB_CrudAdminMouseClicked

    private void JB_CerrarSesionAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CerrarSesionAdminMouseClicked
        JF_Admin.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_JB_CerrarSesionAdminMouseClicked

    private void JB_CrearPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrearPersonaMouseClicked
        JP_EliminarPersona.setVisible(false);
        JP_ModPersonaPersonal.setVisible(false);
        JP_CrearPersonaPersonal.setVisible(true);
    }//GEN-LAST:event_JB_CrearPersonaMouseClicked

    private void JB_ModificarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ModificarPersonaMouseClicked
        JP_CrearPersonaPersonal.setVisible(false);
        JP_EliminarPersona.setVisible(false);
        JP_ModPersonaPersonal.setVisible(true);
    }//GEN-LAST:event_JB_ModificarPersonaMouseClicked

    private void JB_EliminarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_EliminarPersonaMouseClicked
        JP_CrearPersonaPersonal.setVisible(false);
        JP_EliminarPersona.setVisible(true);
        JP_ModPersonaPersonal.setVisible(false);
    }//GEN-LAST:event_JB_EliminarPersonaMouseClicked

    private void JB_ConfirmarEliminarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarEliminarPersonaMouseClicked
        JOptionPane.showMessageDialog(this, "La persona se ha eliminado exitosamente");
        JP_EliminarEmpresa.setVisible(false);

        JF_CrudPersonas.setVisible(false);
        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);
    }//GEN-LAST:event_JB_ConfirmarEliminarPersonaMouseClicked

    private void ModSiguientePersonaPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModSiguientePersonaPersonalMouseClicked
        JP_ModPersonaPersonal.setVisible(false);
        JP_ModPersonaFamiliares_Sanitarios.setVisible(true);

    }//GEN-LAST:event_ModSiguientePersonaPersonalMouseClicked

    private void JT_ModPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_ModPersonaMouseClicked


    }//GEN-LAST:event_JT_ModPersonaMouseClicked

    private void JB_CrearSiguientePersonalPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrearSiguientePersonalPersonaMouseClicked
        JP_CrearPersonaPersonal.setVisible(false);
        String id = TF_CrearIdPersona.getText();
        String nombre = TF_CrearNombrePersona.getText();
        String apellido = TF_CrearApellidoPersona.getText();
        String direccion = TF_DireccionCrearPersona.getText();
        String email = TF_CrearCorreoPersona.getText();
        String telefono = TF_CrearCelular.getText();
        String usuario = TF_CrearUsuarioPersona.getText();
        String contrasena = TF_CrearPasswordPersona.getText();
        String fechaNacimiento = TF_CrearFechaPersona.getText();
        String genero = CB_CrearGeneroPersona.getSelectedItem().toString();
        JP_CrearPersonaFamiliares_Sanitarios.setVisible(true);
    }//GEN-LAST:event_JB_CrearSiguientePersonalPersonaMouseClicked

    private void CB_CrearGrupoSanguineoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CrearGrupoSanguineoPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_CrearGrupoSanguineoPersonaActionPerformed

    private void JB_CrearSiguienteFamiliar_SanitariosPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrearSiguienteFamiliar_SanitariosPersonaMouseClicked
        JP_CrearPersonaFamiliares_Sanitarios.setVisible(false);
        String EstadoCivil = CB_CrearEstadoCivilPersona.getSelectedItem().toString();
        String conyuge = TF_CrearConyugePersona.getText();
        String hijo1 = TF_Crear1HijoPersona.getText();
        String hijo2 = TF_Crear2HijoPersona.getText();
        String hijo3 = TF_Crear3HijoPersona.getText();
        String dependiente1 = TF_CrearDependiente1Persona.getText();
        String dependiente2 = TF_CrearDependiente2Persona.getText();
        String dependiente3 = TF_CrearDependiente3Persona.getText();
        String alergias = TF_CrearAlergiasPersona.getText();
        String enfermedades = TF_CrearEnfermedadesCronicasPersona.getText();
        String sangre = CB_CrearGrupoSanguineoPersona.getSelectedItem().toString();
        JP_CrearPersonaLegales_Academicos.setVisible(true);
    }//GEN-LAST:event_JB_CrearSiguienteFamiliar_SanitariosPersonaMouseClicked

    private void CB_CrearNivelEducacionPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CrearNivelEducacionPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_CrearNivelEducacionPersonaActionPerformed

    private void JB_CrearSiguienteLegales_AcademicosPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrearSiguienteLegales_AcademicosPersonaMouseClicked
        JP_CrearPersonaLegales_Academicos.setVisible(false);
        String dni = TF_CrearDNIPersona.getText();
        String estadoLegal = CB_CrearEstadoLegalPersona.getSelectedItem().toString();
        String antecedentes = TF_CrearAntecedentesPenalesPersona.getText();
        String servicioMilitar = CB_CrearServicioMilitarPersona.getSelectedItem().toString();
        String nivelEducativo = CB_CrearNivelEducacionPersona.getSelectedItem().toString();
        String institucion = TF_CrearInstitucionEducativaPersona.getText();
        String titulo1 = TF_CrearTitulosObtenidos1Persona.getText();
        String titulo2 = TF_CrearTitulosObtenidos2Persona.getText();
        String titulo3 = TF_CrearTitulosObtenidos3Persona.getText();
        String especializacion = TF_CrearEspecializacionPersona.getText();
        int promedio = (Integer) JS_CrearPromedioGraduacionPersona.getValue();
        JP_CrearPersonaProfesional_Laboral.setVisible(true);
    }//GEN-LAST:event_JB_CrearSiguienteLegales_AcademicosPersonaMouseClicked

    private void CB_CrearExperienciaLaboralPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CrearExperienciaLaboralPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_CrearExperienciaLaboralPersonaActionPerformed

    private void JB_CrearSiguienteProfesional_LaboralPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrearSiguienteProfesional_LaboralPersonaMouseClicked
        JP_CrearPersonaProfesional_Laboral.setVisible(false);
        String experiencia = CB_CrearExperienciaLaboralPersona.getSelectedItem().toString();
        String habilidades = TF_CrearHabilidadesPersona.getText();
        String certificacion1 = TF_CrearCertificaciones1Persona.getText();
        String certificacion2 = TF_CrearCertificaciones2Persona.getText();
        String certificacion3 = TF_CrearCertificaciones3Persona.getText();
        String historial = TA_CrearHistorialEmpleoPersona.getText();
        int yearsExperiencia = (Integer) JS_CrearYearsExperienciaPersona.getValue();
        JP_CrearPersonaRequisitos_Condiciones.setVisible(true);
    }//GEN-LAST:event_JB_CrearSiguienteProfesional_LaboralPersonaMouseClicked

    private void JB_ConfirmarCrearPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarCrearPersonaMouseClicked
        String puestosDeseados = TA_CrearPuestosDeseadosPersona.getText();
        String puestosNoDeseados = TA_CrearPuestosNoDeseadosPersona.getText();
        String horario = CB_CrearDisponibilidadHorariaPersona.getSelectedItem().toString();
        String contrato = CB_CrearTipoContratoPersona.getSelectedItem().toString();
        Double salario = (Double) JS_CrearSalarioDeseadoPersona.getValue();
        
        JOptionPane.showMessageDialog(this, "La persona se ha creado exitosamente");
        JP_CrearPersonaRequisitos_Condiciones.setVisible(false);
        
        TF_CrearIdPersona.setText("");
        TF_CrearUsuarioPersona.setText("");
        TF_CrearPasswordPersona.setText("");
        TF_CrearNombrePersona.setText("");
        TF_CrearApellidoPersona.setText("");
        TF_CrearFechaPersona.setText("");
        TF_DireccionCrearPersona.setText("");
        TF_CrearCelular.setText("");
        TF_CrearCorreoPersona.setText("");
        TF_CrearConyugePersona.setText("");
        TF_Crear1HijoPersona.setText("");
        TF_Crear2HijoPersona.setText("");
        TF_Crear3HijoPersona.setText("");
        TF_CrearDependiente1Persona.setText("");
        TF_CrearDependiente2Persona.setText("");
        TF_CrearDependiente3Persona.setText("");
        TF_CrearAlergiasPersona.setText("");
        TF_CrearEnfermedadesCronicasPersona.setText("");
        TF_CrearDNIPersona.setText("");
        TF_CrearAntecedentesPenalesPersona.setText("");
        TF_CrearInstitucionEducativaPersona.setText("");
        TF_CrearTitulosObtenidos1Persona.setText("");
        TF_CrearTitulosObtenidos2Persona.setText("");
        TF_CrearTitulosObtenidos3Persona.setText("");
        TF_CrearEspecializacionPersona.setText("");
        TF_CrearHabilidadesPersona.setText("");
        TF_CrearCertificaciones1Persona.setText("");
        TF_CrearCertificaciones2Persona.setText("");
        TF_CrearCertificaciones3Persona.setText("");
        TA_CrearHistorialEmpleoPersona.setText("");
        TA_CrearPuestosDeseadosPersona.setText("");
        TA_CrearPuestosNoDeseadosPersona.setText("");

        JF_CrudPersonas.setVisible(false);

        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);
    }//GEN-LAST:event_JB_ConfirmarCrearPersonaMouseClicked

    private void CB_CrearGeneroPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CrearGeneroPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_CrearGeneroPersonaActionPerformed

    private void CB_CrearEstadoCivilPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CrearEstadoCivilPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_CrearEstadoCivilPersonaActionPerformed

    private void CB_CrearServicioMilitarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CrearServicioMilitarPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_CrearServicioMilitarPersonaActionPerformed

    private void CB_ModGeneroPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ModGeneroPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_ModGeneroPersonaActionPerformed

    private void CB_ModGrupoSanguineoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ModGrupoSanguineoPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_ModGrupoSanguineoPersonaActionPerformed

    private void JB_ModSiguienteLegales_AcademicosPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ModSiguienteLegales_AcademicosPersonasMouseClicked
        JP_ModPersonaFamiliares_Sanitarios.setVisible(false);
        JP_ModPersonaLegales_Academicos.setVisible(true);
    }//GEN-LAST:event_JB_ModSiguienteLegales_AcademicosPersonasMouseClicked

    private void CB_ModEstadoCivilPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ModEstadoCivilPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_ModEstadoCivilPersonaActionPerformed

    private void CB_ModNivelEducacionPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ModNivelEducacionPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_ModNivelEducacionPersonaActionPerformed

    private void JB_ModSiguienteProfecionales_LaboralesPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ModSiguienteProfecionales_LaboralesPersonaMouseClicked
        JP_ModPersonaLegales_Academicos.setVisible(false);
        JP_ModPersonaProfesional_Laboral.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_JB_ModSiguienteProfecionales_LaboralesPersonaMouseClicked

    private void CB_ModEstadoLegalPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ModEstadoLegalPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_ModEstadoLegalPersonaActionPerformed

    private void JB_ConfirmarModPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarModPersonaMouseClicked
        JOptionPane.showMessageDialog(this, "La persona se ha modificado exitosamente");
        JP_ModPersonaRequisitos_Condiciones.setVisible(false);

        TF_ModIdPersona.setText("");
        TF_ModNombrePersona.setText("");
        TF_ModApellidoPersona.setText("");
        TF_ModFechaNaciemientoPersona.setText("");
        TF_ModDireccionPersona.setText("");
        TF_ModCelularPersona.setText("");
        TF_ModCorreoPersona.setText("");
        TF_ModConyugePersona.setText("");
        TF_Mod1HijoPersona.setText("");
        TF_Mod2HijoPersona.setText("");
        TF_Mod3HijoPersona.setText("");
        TF_ModDependiente1Persona.setText("");
        TF_ModDependiente2Persona.setText("");
        TF_ModDependiente3Persona.setText("");
        TF_ModAlergiasPersona.setText("");
        TF_ModEnfermedadesCronicasPersona.setText("");
        TF_ModDNIPersona.setText("");
        TF_ModAntecedentesPenalesPersona.setText("");
        TF_ModInstitucionEducativaPersona.setText("");
        TF_ModrTitulosObtenidos1Persona.setText("");
        TF_ModTitulosObtenidos2Persona.setText("");
        TF_ModTitulosObtenidos3Persona.setText("");
        TF_ModEspecializacionPersona.setText("");
        TF_ModHabilidadesPersona.setText("");
        TF_ModCertificaciones1Persona.setText("");
        TF_ModCertificaciones2Persona.setText("");
        TF_ModCertificaciones3Persona.setText("");
        TA_ModHistorialEmpleoPersona.setText("");
        TA_ModPuestosDeseadosPersona.setText("");
        TA_ModPuestosNoDeseadosPersona.setText("");

        JF_CrudPersonas.setVisible(false);

        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);
    }//GEN-LAST:event_JB_ConfirmarModPersonaMouseClicked

    private void TF_ModDireccionPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_ModDireccionPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_ModDireccionPersonaActionPerformed

    private void CB_CrearEstadoLegalPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CrearEstadoLegalPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_CrearEstadoLegalPersonaActionPerformed

    private void CB_ModServicioMilitarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ModServicioMilitarPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_ModServicioMilitarPersonaActionPerformed

    private void JB_ModSiguienteRequisitos_CondicionesPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ModSiguienteRequisitos_CondicionesPersonaMouseClicked
        JP_CrearPersonaProfesional_Laboral.setVisible(false);
        JP_CrearPersonaRequisitos_Condiciones.setVisible(true);
    }//GEN-LAST:event_JB_ModSiguienteRequisitos_CondicionesPersonaMouseClicked

    private void CB_ModExperienciaLaboralPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ModExperienciaLaboralPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_ModExperienciaLaboralPersonaActionPerformed

    private void JB_CrearEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrearEmpresaMouseClicked
        JP_EliminarEmpresa.setVisible(false);
        JP_ModEmpresa.setVisible(false);
        JP_CrearEmpresa.setVisible(true);
    }//GEN-LAST:event_JB_CrearEmpresaMouseClicked

    private void JB_ModificarEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ModificarEmpresaMouseClicked
        JP_CrearEmpresa.setVisible(false);
        JP_EliminarEmpresa.setVisible(false);
        JP_ModEmpresa.setVisible(true);
    }//GEN-LAST:event_JB_ModificarEmpresaMouseClicked

    private void JB_EliminarEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_EliminarEmpresaMouseClicked
        JP_CrearEmpresa.setVisible(false);
        JP_EliminarEmpresa.setVisible(true);
        JP_ModEmpresa.setVisible(false);
    }//GEN-LAST:event_JB_EliminarEmpresaMouseClicked

    private void JB_ConfirmarModEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarModEmpresaMouseClicked
        JP_ModEmpresa.setVisible(false);
        JOptionPane.showMessageDialog(this, "La empresa se ha modificado exitosamente");

        TF_ModIdEmpresa.setText("");
        TF_ModSectorActividadEmpresa.setText("");
        TF_ModNombreEmpresa.setText("");
        TF_ModCIFEmpresa.setText("");
        TF_ModDireccionEmpresa.setText("");
        TF_ModTelefonoEmpresa.setText("");
        TF_ModCorreoEmpresa.setText("");

        JF_CrudEmpresa.setVisible(false);

        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);

    }//GEN-LAST:event_JB_ConfirmarModEmpresaMouseClicked

    private void JT_ModEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_ModEmpresaMouseClicked
        JP_ModEmpresa.setVisible(false);
        JOptionPane.showMessageDialog(this, "La empresa se ha modificado exitosamente");
        JF_CrudEmpresa.setVisible(false);

        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);

    }//GEN-LAST:event_JT_ModEmpresaMouseClicked

    private void JB_ConfirmarEliminarEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarEliminarEmpresaMouseClicked

        JP_EliminarEmpresa.setVisible(false);
        JOptionPane.showMessageDialog(this, "La empresa se ha eliminado exitosamente");
        JF_CrudEmpresa.setVisible(false);

        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);
    }//GEN-LAST:event_JB_ConfirmarEliminarEmpresaMouseClicked

    private void JB_ConfirmarCrearEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarCrearEmpresaMouseClicked
        JP_CrearEmpresa.setVisible(false);
        String id = TF_CrearIdEmpresa.getText();
        String usuario = TF_CrearUsuarioEmpresa.getText();
        String contrasena = TF_CrearContrasenaEmpresa.getText();
        String sector = TF_CrearSectorActividadEmpresa.getText();
        String nombre = TF_CrearNombreEmpresa.getText();
        String CIF = TF_CrearCIFEmpresa.getText();
        String direccion = TF_CrearDireccionEmpresa.getText();
        String telefono = TF_CrearTelefonoEmpresa.getText();
        String email = TF_CrearCorreoEmpresa.getText();
        JOptionPane.showMessageDialog(this, "La empresa se ha creado exitosamente");
        
        TF_CrearIdEmpresa.setText("");
        TF_CrearUsuarioEmpresa.setText("");
        TF_CrearContrasenaEmpresa.setText("");
        TF_CrearSectorActividadEmpresa.setText("");
        TF_CrearNombreEmpresa.setText("");
        TF_CrearCIFEmpresa.setText("");
        TF_CrearDireccionEmpresa.setText("");
        TF_CrearTelefonoEmpresa.setText("");
        TF_CrearCorreoEmpresa.setText("");

        JF_CrudEmpresa.setVisible(false);

        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);


    }//GEN-LAST:event_JB_ConfirmarCrearEmpresaMouseClicked

    private void JB_CrearPuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrearPuestoMouseClicked
        JP_CrearPuesto.setVisible(true);
        JP_ModPuesto.setVisible(false);
        JP_EliminarPuesto.setVisible(false);
    }//GEN-LAST:event_JB_CrearPuestoMouseClicked

    private void JB_ModificarPuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ModificarPuestoMouseClicked
        JP_ModPuesto.setVisible(true);
        JP_EliminarPuesto.setVisible(false);
        JP_CrearPuesto.setVisible(false);
    }//GEN-LAST:event_JB_ModificarPuestoMouseClicked

    private void JB_EliminarPuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_EliminarPuestoMouseClicked
        JP_EliminarPuesto.setVisible(true);
        JP_CrearPuesto.setVisible(false);
        JP_ModPuesto.setVisible(false);
    }//GEN-LAST:event_JB_EliminarPuestoMouseClicked

    private void JB_ConfirmarCrearPuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarCrearPuestoMouseClicked
        JP_CrearPuesto.setVisible(false);
        JOptionPane.showMessageDialog(this, "El puesto de trabajo se ha creado exitosamente");

        TF_CrearDireccionPuesto.setText("");
        TF_CrearTipodePuesto.setText("");
        TF_CrearNivelEducacionPuesto.setText("");
        TF_CrearTituloPuesto.setText("");
        TF_CrearEnfermedadesPuesto.setText("");
        TF_CrearHabilidadesPuesto.setText("");
        TF_CrearAntecedentesPuesto.setText("");

        JF_CrudPuestoDeTrabajo.setVisible(false);
        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);

    }//GEN-LAST:event_JB_ConfirmarCrearPuestoMouseClicked

    private void JB_ConfirmarEliminarPuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarEliminarPuestoMouseClicked
        JP_EliminarPuesto.setVisible(false);
        JOptionPane.showMessageDialog(this, "El puesto de trabajo se ha eliminado exitosamente");

        JF_CrudPuestoDeTrabajo.setVisible(false);
        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);
    }//GEN-LAST:event_JB_ConfirmarEliminarPuestoMouseClicked

    private void JT_ModPuestroDeTrabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_ModPuestroDeTrabajoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_ModPuestroDeTrabajoMouseClicked

    private void JB_ConfirmarModEmpresa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarModEmpresa1MouseClicked
        JP_ModPuesto.setVisible(false);
        JOptionPane.showMessageDialog(this, "El puesto de trabajo se ha modificado exitosamente");

        TF_ModDireccionPuesto.setText("");
        TF_ModTipodePuesto.setText("");
        TF_ModNivelEducacionPuesto.setText("");
        TF_ModTituloPuesto.setText("");
        TF_ModEnfermedadesPuesto.setText("");
        TF_ModHabilidadesPuesto.setText("");
        TF_ModAntecedentesPuesto.setText("");

        JF_CrudPuestoDeTrabajo.setVisible(false);
        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);
    }//GEN-LAST:event_JB_ConfirmarModEmpresa1MouseClicked

    private void JB_CrearSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CrearSolicitudMouseClicked

        JP_EliminarSolicitud.setVisible(false);
        JP_CrearSolicitud.setVisible(true);

    }//GEN-LAST:event_JB_CrearSolicitudMouseClicked

    private void JB_EliminarSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_EliminarSolicitudMouseClicked

        JP_EliminarSolicitud.setVisible(true);
        JP_CrearSolicitud.setVisible(false);

    }//GEN-LAST:event_JB_EliminarSolicitudMouseClicked

    private void JB_ConfirmarCrearSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarCrearSolicitudMouseClicked
        JP_CrearSolicitud.setVisible(false);
        JOptionPane.showMessageDialog(this, "La solicitud se ha creado exitosamente");
        TF_CrearSolicitudAniosExperiencia.setText("");
        TF_CrearSolicitudAntecedentes.setText("");
        TF_CrearSolicitudApellido.setText("");
        TF_CrearSolicitudContrato.setText("");
        TF_CrearSolicitudDireccion.setText("");
        TF_CrearSolicitudEnfermedades.setText("");
        TF_CrearSolicitudExperiencia.setText("");
        TF_CrearSolicitudGenero.setText("");
        TF_CrearSolicitudHabilidades.setText("");
        TF_CrearSolicitudHorario.setText("");
        TF_CrearSolicitudNivelEdicacion.setText("");
        TF_CrearSolicitudNombre.setText("");
        TF_CrearSolicitudPromedioGraduacion.setText("");
        TF_CrearSolicitudServicioMilitar.setText("");
        TF_CrearSolicitudSueldo.setText("");
        TF_CrearSolicitudTitulo.setText("");
        TA_CrearSolicitudPuestoDeseado.setText("");
        TA_CrearSolicitudPuestoNoDeseado.setText("");

        JF_CrudSolicitudEmpleo.setVisible(false);

        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);
    }//GEN-LAST:event_JB_ConfirmarCrearSolicitudMouseClicked

    private void JT_ModEmpresa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_ModEmpresa2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_ModEmpresa2MouseClicked

    private void JB_ModificarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ModificarPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_ModificarPuestoActionPerformed

    private void JT_CrearPuestroDeTrabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_CrearPuestroDeTrabajoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_CrearPuestroDeTrabajoMouseClicked

    private void JB_CerrarSesionPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CerrarSesionPersonaMouseClicked
        JF_Persona.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_JB_CerrarSesionPersonaMouseClicked

    private void JB_PuestosDisponiblesPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_PuestosDisponiblesPersonasMouseClicked
        JP_PuestosDispiniblesPersona.setVisible(true);
        JP_BusquedaDetallada.setVisible(false);
        JP_MiSolicitudPersona.setVisible(false);
    }//GEN-LAST:event_JB_PuestosDisponiblesPersonasMouseClicked

    private void JB_BusquedaDetalladaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_BusquedaDetalladaPersonasMouseClicked
        JP_PuestosDispiniblesPersona.setVisible(false);
        JP_BusquedaDetallada.setVisible(true);
        JP_MiSolicitudPersona.setVisible(false);
    }//GEN-LAST:event_JB_BusquedaDetalladaPersonasMouseClicked

    private void JT_PropiedadesEnMercadoCompradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_PropiedadesEnMercadoCompradorMouseClicked

    }//GEN-LAST:event_JT_PropiedadesEnMercadoCompradorMouseClicked

    private void JB_PropiedadesEnMercadoComprador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_PropiedadesEnMercadoComprador2MouseClicked
        JD_MasInfoPuesto.setVisible(true);

        JD_MasInfoPuesto.pack();
        JD_MasInfoPuesto.setLocationRelativeTo(this);
        JD_MasInfoPuesto.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_JB_PropiedadesEnMercadoComprador2MouseClicked

    private void JB_MiSolicitudPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_MiSolicitudPersonasMouseClicked
        JP_PuestosDispiniblesPersona.setVisible(false);
        JP_BusquedaDetallada.setVisible(false);
        JP_MiSolicitudPersona.setVisible(true);
    }//GEN-LAST:event_JB_MiSolicitudPersonasMouseClicked

    private void TF_MiSolicitudNombreEmpresaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_MiSolicitudNombreEmpresaPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_MiSolicitudNombreEmpresaPersonaActionPerformed

    private void JB_ContratacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ContratacionesMouseClicked
        JP_CRUD.setVisible(false);
        JP_Contrataciones.setVisible(true);
    }//GEN-LAST:event_JB_ContratacionesMouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked

    }//GEN-LAST:event_jLabel45MouseClicked

    private void JB_CRUDPuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CRUDPuestosMouseClicked
        JF_Admin.setVisible(false);
        JF_CrudPuestoDeTrabajo.pack();
        JF_CrudPuestoDeTrabajo.setLocationRelativeTo(this);
        JF_CrudPuestoDeTrabajo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_CrudPuestoDeTrabajo.setVisible(true);
    }//GEN-LAST:event_JB_CRUDPuestosMouseClicked

    private void JB_CRUDSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CRUDSolicitudesMouseClicked
        JF_Admin.setVisible(false);

        JF_CrudSolicitudEmpleo.pack();
        JF_CrudSolicitudEmpleo.setLocationRelativeTo(this);
        JF_CrudSolicitudEmpleo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_CrudSolicitudEmpleo.setVisible(true);
    }//GEN-LAST:event_JB_CRUDSolicitudesMouseClicked

    private void JB_CRUDEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CRUDEmpresasMouseClicked
        JF_Admin.setVisible(false);
        JF_CrudEmpresa.pack();
        JF_CrudEmpresa.setLocationRelativeTo(this);
        JF_CrudEmpresa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_CrudEmpresa.setVisible(true);
    }//GEN-LAST:event_JB_CRUDEmpresasMouseClicked

    private void JB_CRUDPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CRUDPersonasMouseClicked
        JF_Admin.setVisible(false);
        JF_CrudPersonas.pack();
        JF_CrudPersonas.setLocationRelativeTo(this);
        JF_CrudPersonas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JF_CrudPersonas.setVisible(true);
    }//GEN-LAST:event_JB_CRUDPersonasMouseClicked

    private void JB_ContratarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ContratarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_ContratarMouseClicked

    private void JB_ContratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ContratarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_ContratarActionPerformed

    private void JB_BusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_BusquedaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_BusquedaMouseClicked

    private void JB_PuestosOfrecidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_PuestosOfrecidosMouseClicked
        JP_PuestosOfrecidosEmpresa.setVisible(true);
        JP_SolicitudesEmpresas.setVisible(false);
    }//GEN-LAST:event_JB_PuestosOfrecidosMouseClicked

    private void JB_SolicitudesEmpleoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_SolicitudesEmpleoMouseClicked
        JP_PuestosOfrecidosEmpresa.setVisible(false);
        JP_SolicitudesEmpresas.setVisible(true);
    }//GEN-LAST:event_JB_SolicitudesEmpleoMouseClicked

    private void JB_ConfirmarEliminarSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_ConfirmarEliminarSolicitudMouseClicked
        JP_EliminarSolicitud.setVisible(false);
        JOptionPane.showMessageDialog(this, "La solicitud se ha eliminado correctamente");
        TF_CodigoReferenciaSolicitudEliminar.setText("");
        JF_CrudSolicitudEmpleo.setVisible(false);

        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);

    }//GEN-LAST:event_JB_ConfirmarEliminarSolicitudMouseClicked

    private void JB_Busqueda1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_Busqueda1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_Busqueda1MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel56MouseClicked

    private void JB_CerrarSesionEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_CerrarSesionEmpresaMouseClicked
        JF_Empresa.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_JB_CerrarSesionEmpresaMouseClicked

    private void ADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMINMouseClicked
        this.setVisible(false);
        JF_Admin.pack();
        JF_Admin.setLocationRelativeTo(this);
        JF_Admin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Admin.setVisible(true);
    }//GEN-LAST:event_ADMINMouseClicked

    private void PERSONAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PERSONAMouseClicked
        this.setVisible(false);
        JF_Persona.pack();
        JF_Persona.setLocationRelativeTo(this);
        JF_Persona.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Persona.setVisible(true);
    }//GEN-LAST:event_PERSONAMouseClicked

    private void EMPRESAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMPRESAMouseClicked
        this.setVisible(false);
        JF_Empresa.pack();
        JF_Empresa.setLocationRelativeTo(this);
        JF_Empresa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF_Empresa.setVisible(true);
    }//GEN-LAST:event_EMPRESAMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
////        System.out.println("Initializing main");

            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADMIN;
    private javax.swing.JComboBox<String> CB_CrearContratoPuesto;
    private javax.swing.JComboBox<String> CB_CrearDisponibilidadHorariaPersona;
    private javax.swing.JComboBox<String> CB_CrearEstadoCivilPersona;
    private javax.swing.JComboBox<String> CB_CrearEstadoLegalPersona;
    private javax.swing.JComboBox<String> CB_CrearExperienciaLaboralPersona;
    private javax.swing.JComboBox<String> CB_CrearExperienciaPuesto;
    private javax.swing.JComboBox<String> CB_CrearGeneroPersona;
    private javax.swing.JComboBox<String> CB_CrearGeneroPuesto;
    private javax.swing.JComboBox<String> CB_CrearGrupoSanguineoPersona;
    private javax.swing.JComboBox<String> CB_CrearHorarioSueldo;
    private javax.swing.JComboBox<String> CB_CrearNivelEducacionPersona;
    private javax.swing.JComboBox<String> CB_CrearServicioMilitarPersona;
    private javax.swing.JComboBox<String> CB_CrearServicioMilitarPuesto;
    private javax.swing.JComboBox<String> CB_CrearTipoContratoPersona;
    private javax.swing.JComboBox<String> CB_ModContratoPuesto;
    private javax.swing.JComboBox<String> CB_ModDisponibilidadHorariaPersona;
    private javax.swing.JComboBox<String> CB_ModEstadoCivilPersona;
    private javax.swing.JComboBox<String> CB_ModEstadoLegalPersona;
    private javax.swing.JComboBox<String> CB_ModExperienciaLaboralPersona;
    private javax.swing.JComboBox<String> CB_ModExperienciaPuesto;
    private javax.swing.JComboBox<String> CB_ModGeneroPersona;
    private javax.swing.JComboBox<String> CB_ModGeneroPuesto;
    private javax.swing.JComboBox<String> CB_ModGrupoSanguineoPersona;
    private javax.swing.JComboBox<String> CB_ModHorarioSueldo;
    private javax.swing.JComboBox<String> CB_ModNivelEducacionPersona;
    private javax.swing.JComboBox<String> CB_ModServicioMilitarPersona;
    private javax.swing.JComboBox<String> CB_ModServicioMilitarPuesto;
    private javax.swing.JComboBox<String> CB_ModTipoContratoPersona;
    private javax.swing.JButton EMPRESA;
    private javax.swing.JButton JB_Busqueda;
    private javax.swing.JButton JB_Busqueda1;
    private javax.swing.JButton JB_BusquedaDetalladaPersonas;
    private javax.swing.JButton JB_CRUDEmpresas;
    private javax.swing.JButton JB_CRUDPersonas;
    private javax.swing.JButton JB_CRUDPuestos;
    private javax.swing.JButton JB_CRUDSolicitudes;
    private javax.swing.JButton JB_CerrarSesionAdmin;
    private javax.swing.JPanel JB_CerrarSesionEmpresa;
    private javax.swing.JPanel JB_CerrarSesionPersona;
    private javax.swing.JButton JB_ConfirmarCrearEmpresa;
    private javax.swing.JButton JB_ConfirmarCrearPersona;
    private javax.swing.JButton JB_ConfirmarCrearPuesto;
    private javax.swing.JButton JB_ConfirmarCrearSolicitud;
    private javax.swing.JButton JB_ConfirmarEliminarEmpresa;
    private javax.swing.JButton JB_ConfirmarEliminarPersona;
    private javax.swing.JButton JB_ConfirmarEliminarPuesto;
    private javax.swing.JButton JB_ConfirmarEliminarSolicitud;
    private javax.swing.JButton JB_ConfirmarModEmpresa;
    private javax.swing.JButton JB_ConfirmarModEmpresa1;
    private javax.swing.JButton JB_ConfirmarModPersona;
    private javax.swing.JButton JB_Contrataciones;
    private javax.swing.JButton JB_Contratar;
    private javax.swing.JButton JB_CrearEmpresa;
    private javax.swing.JButton JB_CrearPersona;
    private javax.swing.JButton JB_CrearPuesto;
    private javax.swing.JButton JB_CrearSiguienteFamiliar_SanitariosPersona;
    private javax.swing.JButton JB_CrearSiguienteLegales_AcademicosPersona;
    private javax.swing.JButton JB_CrearSiguientePersonalPersona;
    private javax.swing.JButton JB_CrearSiguienteProfesional_LaboralPersona;
    private javax.swing.JButton JB_CrearSolicitud;
    private javax.swing.JButton JB_CrudAdmin;
    private javax.swing.JButton JB_EliminarEmpresa;
    private javax.swing.JButton JB_EliminarPersona;
    private javax.swing.JButton JB_EliminarPuesto;
    private javax.swing.JButton JB_EliminarSolicitud;
    private javax.swing.JButton JB_LogIn;
    private javax.swing.JButton JB_MiSolicitudPersonas;
    private javax.swing.JButton JB_ModSiguienteLegales_AcademicosPersonas;
    private javax.swing.JButton JB_ModSiguienteProfecionales_LaboralesPersona;
    private javax.swing.JButton JB_ModSiguienteRequisitos_CondicionesPersona;
    private javax.swing.JButton JB_ModificarEmpresa;
    private javax.swing.JButton JB_ModificarPersona;
    private javax.swing.JButton JB_ModificarPuesto;
    private javax.swing.JButton JB_PropiedadesEnMercadoComprador2;
    private javax.swing.JButton JB_PuestosDisponiblesPersonas;
    private javax.swing.JButton JB_PuestosOfrecidos;
    private javax.swing.JButton JB_SolicitudesEmpleo;
    private javax.swing.JDialog JD_MasInfoPuesto;
    private javax.swing.JFrame JF_Admin;
    private javax.swing.JFrame JF_CrudEmpresa;
    private javax.swing.JFrame JF_CrudPersonas;
    private javax.swing.JFrame JF_CrudPuestoDeTrabajo;
    private javax.swing.JFrame JF_CrudSolicitudEmpleo;
    private javax.swing.JFrame JF_Empresa;
    private javax.swing.JFrame JF_Persona;
    private javax.swing.JPanel JP_BusquedaDetallada;
    private javax.swing.JPanel JP_CRUD;
    private javax.swing.JPanel JP_Contrataciones;
    private javax.swing.JPanel JP_CrearEmpresa;
    private javax.swing.JPanel JP_CrearPersonaFamiliares_Sanitarios;
    private javax.swing.JPanel JP_CrearPersonaLegales_Academicos;
    private javax.swing.JPanel JP_CrearPersonaPersonal;
    private javax.swing.JPanel JP_CrearPersonaProfesional_Laboral;
    private javax.swing.JPanel JP_CrearPersonaRequisitos_Condiciones;
    private javax.swing.JPanel JP_CrearPuesto;
    private javax.swing.JPanel JP_CrearSolicitud;
    private javax.swing.JPanel JP_EliminarEmpresa;
    private javax.swing.JPanel JP_EliminarPersona;
    private javax.swing.JPanel JP_EliminarPuesto;
    private javax.swing.JPanel JP_EliminarSolicitud;
    private javax.swing.JPanel JP_MasInfoPuesto;
    private javax.swing.JPanel JP_MiSolicitudPersona;
    private javax.swing.JPanel JP_ModEmpresa;
    private javax.swing.JPanel JP_ModPersonaFamiliares_Sanitarios;
    private javax.swing.JPanel JP_ModPersonaLegales_Academicos;
    private javax.swing.JPanel JP_ModPersonaPersonal;
    private javax.swing.JPanel JP_ModPersonaProfesional_Laboral;
    private javax.swing.JPanel JP_ModPersonaRequisitos_Condiciones;
    private javax.swing.JPanel JP_ModPuesto;
    private javax.swing.JPanel JP_PuestosDispiniblesPersona;
    private javax.swing.JPanel JP_PuestosOfrecidosEmpresa;
    private javax.swing.JPanel JP_SolicitudesEmpresas;
    private javax.swing.JSpinner JS_CrearAñosExperienciaPersona;
    private javax.swing.JSpinner JS_CrearAñosExperienciaPuesto;
    private javax.swing.JSpinner JS_CrearPromedioGraduacionPersona;
    private javax.swing.JSpinner JS_CrearPromedioGraduacionPuesto;
    private javax.swing.JSpinner JS_CrearSalarioDeseadoPersona;
    private javax.swing.JSpinner JS_CrearSueldoPuesto;
    private javax.swing.JSpinner JS_CrearYearsExperienciaPersona;
    private javax.swing.JSpinner JS_ModAñosExperienciaPuesto;
    private javax.swing.JSpinner JS_ModPromedioGraduacionPersona;
    private javax.swing.JSpinner JS_ModPromedioGraduacionPuesto;
    private javax.swing.JSpinner JS_ModSalarioDeseadoPersona;
    private javax.swing.JSpinner JS_ModSueldoPuesto;
    private javax.swing.JTable JT_BuscarSolicitudesEmpresa;
    private javax.swing.JTable JT_CrearPuestroDeTrabajo;
    private javax.swing.JTable JT_EliminarEmpresa;
    private javax.swing.JTable JT_EliminarPersona;
    private javax.swing.JTable JT_EliminarPuesto;
    private javax.swing.JTable JT_ModEmpresa;
    private javax.swing.JTable JT_ModEmpresa2;
    private javax.swing.JTable JT_ModPersona;
    private javax.swing.JTable JT_ModPuestroDeTrabajo;
    private javax.swing.JTable JT_PropiedadesEnMercadoComprador;
    private javax.swing.JTable JT_PuestosOfrecidos;
    private javax.swing.JTable JT_ResultadosBusqueda;
    private javax.swing.JTable JT_Solicitudes;
    private javax.swing.JButton ModSiguientePersonaPersonal;
    private javax.swing.JButton PERSONA;
    private javax.swing.JTextArea TA_CrearHistorialEmpleoPersona;
    private javax.swing.JTextArea TA_CrearPuestosDeseadosPersona;
    private javax.swing.JTextArea TA_CrearPuestosNoDeseadosPersona;
    private javax.swing.JTextArea TA_CrearSolicitudPuestoDeseado;
    private javax.swing.JTextArea TA_CrearSolicitudPuestoNoDeseado;
    private javax.swing.JTextArea TA_ModHistorialEmpleoPersona;
    private javax.swing.JTextArea TA_ModPuestosDeseadosPersona;
    private javax.swing.JTextArea TA_ModPuestosNoDeseadosPersona;
    private javax.swing.JTextField TF_BarraBusquedaEmpresa;
    private javax.swing.JTextField TF_BarraBusquedaPersona;
    private javax.swing.JTextField TF_CodigoReferenciaSolicitudEliminar;
    private javax.swing.JTextField TF_Crear1HijoPersona;
    private javax.swing.JTextField TF_Crear2HijoPersona;
    private javax.swing.JTextField TF_Crear3HijoPersona;
    private javax.swing.JTextField TF_CrearAlergiasPersona;
    private javax.swing.JTextField TF_CrearAntecedentesPenalesPersona;
    private javax.swing.JTextField TF_CrearAntecedentesPuesto;
    private javax.swing.JTextField TF_CrearApellidoPersona;
    private javax.swing.JTextField TF_CrearCIFEmpresa;
    private javax.swing.JTextField TF_CrearCelular;
    private javax.swing.JTextField TF_CrearCertificaciones1Persona;
    private javax.swing.JTextField TF_CrearCertificaciones2Persona;
    private javax.swing.JTextField TF_CrearCertificaciones3Persona;
    private javax.swing.JTextField TF_CrearContrasenaEmpresa;
    private javax.swing.JTextField TF_CrearConyugePersona;
    private javax.swing.JTextField TF_CrearCorreoEmpresa;
    private javax.swing.JTextField TF_CrearCorreoPersona;
    private javax.swing.JTextField TF_CrearDNIPersona;
    private javax.swing.JTextField TF_CrearDependiente1Persona;
    private javax.swing.JTextField TF_CrearDependiente2Persona;
    private javax.swing.JTextField TF_CrearDependiente3Persona;
    private javax.swing.JTextField TF_CrearDireccionEmpresa;
    private javax.swing.JTextField TF_CrearDireccionPuesto;
    private javax.swing.JTextField TF_CrearEnfermedadesCronicasPersona;
    private javax.swing.JTextField TF_CrearEnfermedadesPuesto;
    private javax.swing.JTextField TF_CrearEspecializacionPersona;
    private javax.swing.JTextField TF_CrearFechaPersona;
    private javax.swing.JTextField TF_CrearHabilidadesPersona;
    private javax.swing.JTextField TF_CrearHabilidadesPuesto;
    private javax.swing.JTextField TF_CrearIdEmpresa;
    private javax.swing.JTextField TF_CrearIdPersona;
    private javax.swing.JTextField TF_CrearInstitucionEducativaPersona;
    private javax.swing.JTextField TF_CrearNivelEducacionPuesto;
    private javax.swing.JTextField TF_CrearNombreEmpresa;
    private javax.swing.JTextField TF_CrearNombrePersona;
    private javax.swing.JTextField TF_CrearPasswordPersona;
    private javax.swing.JTextField TF_CrearSectorActividadEmpresa;
    private javax.swing.JTextField TF_CrearSolicitudAniosExperiencia;
    private javax.swing.JTextField TF_CrearSolicitudAntecedentes;
    private javax.swing.JTextField TF_CrearSolicitudApellido;
    private javax.swing.JTextField TF_CrearSolicitudContrato;
    private javax.swing.JTextField TF_CrearSolicitudDireccion;
    private javax.swing.JTextField TF_CrearSolicitudEnfermedades;
    private javax.swing.JTextField TF_CrearSolicitudExperiencia;
    private javax.swing.JTextField TF_CrearSolicitudGenero;
    private javax.swing.JTextField TF_CrearSolicitudHabilidades;
    private javax.swing.JTextField TF_CrearSolicitudHorario;
    private javax.swing.JTextField TF_CrearSolicitudNivelEdicacion;
    private javax.swing.JTextField TF_CrearSolicitudNombre;
    private javax.swing.JTextField TF_CrearSolicitudPromedioGraduacion;
    private javax.swing.JTextField TF_CrearSolicitudServicioMilitar;
    private javax.swing.JTextField TF_CrearSolicitudSueldo;
    private javax.swing.JTextField TF_CrearSolicitudTitulo;
    private javax.swing.JTextField TF_CrearTelefonoEmpresa;
    private javax.swing.JTextField TF_CrearTipodePuesto;
    private javax.swing.JTextField TF_CrearTituloPuesto;
    private javax.swing.JTextField TF_CrearTitulosObtenidos1Persona;
    private javax.swing.JTextField TF_CrearTitulosObtenidos2Persona;
    private javax.swing.JTextField TF_CrearTitulosObtenidos3Persona;
    private javax.swing.JTextField TF_CrearUsuarioEmpresa;
    private javax.swing.JTextField TF_CrearUsuarioPersona;
    private javax.swing.JTextField TF_DireccionCrearPersona;
    private javax.swing.JTextField TF_InfoPuestoAniosExperiencia;
    private javax.swing.JTextField TF_InfoPuestoAntecedentes;
    private javax.swing.JTextField TF_InfoPuestoDireccion;
    private javax.swing.JTextField TF_InfoPuestoEnfermedades;
    private javax.swing.JTextField TF_InfoPuestoExperiencia;
    private javax.swing.JTextField TF_InfoPuestoGenero;
    private javax.swing.JTextField TF_InfoPuestoHabilidades;
    private javax.swing.JTextField TF_InfoPuestoHorario;
    private javax.swing.JTextField TF_InfoPuestoNivelEducacion;
    private javax.swing.JTextField TF_InfoPuestoNombeEmpresa;
    private javax.swing.JTextField TF_InfoPuestoPromedio;
    private javax.swing.JTextField TF_InfoPuestoServicioMilitar;
    private javax.swing.JTextField TF_InfoPuestoSueldo;
    private javax.swing.JTextField TF_InfoPuestoTipoContrato;
    private javax.swing.JTextField TF_InfoPuestoTipoPuesto;
    private javax.swing.JTextField TF_InfoPuestoTitulo;
    private javax.swing.JTextField TF_MiSolicitudCodigoReferenciaPersona;
    private javax.swing.JTextField TF_MiSolicitudEstadoSolicitudPersona;
    private javax.swing.JTextField TF_MiSolicitudNombreEmpresaPersona;
    private javax.swing.JTextField TF_MiSolicitudPuestoTrabajoaPersona;
    private javax.swing.JTextField TF_Mod1HijoPersona;
    private javax.swing.JTextField TF_Mod2HijoPersona;
    private javax.swing.JTextField TF_Mod3HijoPersona;
    private javax.swing.JTextField TF_ModAlergiasPersona;
    private javax.swing.JTextField TF_ModAntecedentesPenalesPersona;
    private javax.swing.JTextField TF_ModAntecedentesPuesto;
    private javax.swing.JTextField TF_ModApellidoPersona;
    private javax.swing.JTextField TF_ModCIFEmpresa;
    private javax.swing.JTextField TF_ModCelularPersona;
    private javax.swing.JTextField TF_ModCertificaciones1Persona;
    private javax.swing.JTextField TF_ModCertificaciones2Persona;
    private javax.swing.JTextField TF_ModCertificaciones3Persona;
    private javax.swing.JTextField TF_ModConyugePersona;
    private javax.swing.JTextField TF_ModCorreoEmpresa;
    private javax.swing.JTextField TF_ModCorreoPersona;
    private javax.swing.JTextField TF_ModDNIPersona;
    private javax.swing.JTextField TF_ModDependiente1Persona;
    private javax.swing.JTextField TF_ModDependiente2Persona;
    private javax.swing.JTextField TF_ModDependiente3Persona;
    private javax.swing.JTextField TF_ModDireccionEmpresa;
    private javax.swing.JTextField TF_ModDireccionPersona;
    private javax.swing.JTextField TF_ModDireccionPuesto;
    private javax.swing.JTextField TF_ModEnfermedadesCronicasPersona;
    private javax.swing.JTextField TF_ModEnfermedadesPuesto;
    private javax.swing.JTextField TF_ModEspecializacionPersona;
    private javax.swing.JTextField TF_ModFechaNaciemientoPersona;
    private javax.swing.JTextField TF_ModHabilidadesPersona;
    private javax.swing.JTextField TF_ModHabilidadesPuesto;
    private javax.swing.JTextField TF_ModIdEmpresa;
    private javax.swing.JTextField TF_ModIdPersona;
    private javax.swing.JTextField TF_ModInstitucionEducativaPersona;
    private javax.swing.JTextField TF_ModNivelEducacionPuesto;
    private javax.swing.JTextField TF_ModNombreEmpresa;
    private javax.swing.JTextField TF_ModNombrePersona;
    private javax.swing.JTextField TF_ModSectorActividadEmpresa;
    private javax.swing.JTextField TF_ModTelefonoEmpresa;
    private javax.swing.JTextField TF_ModTipodePuesto;
    private javax.swing.JTextField TF_ModTituloPuesto;
    private javax.swing.JTextField TF_ModTitulosObtenidos2Persona;
    private javax.swing.JTextField TF_ModTitulosObtenidos3Persona;
    private javax.swing.JTextField TF_ModrTitulosObtenidos1Persona;
    private javax.swing.JPasswordField TF_Password;
    private javax.swing.JTextField TF_UserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jl_TelefonoCompania;
    private javax.swing.JLabel jl_TelefonoCompania1;
    private javax.swing.JLabel jl_TelefonoCompania2;
    private javax.swing.JLabel jl_TelefonoCompania3;
    private javax.swing.JLabel jl_TelefonoCompania4;
    private javax.swing.JLabel jl_TelefonoCompania5;
    private javax.swing.JLabel jl_TelefonoCompania6;
    private javax.swing.JLabel jl_TelefonoCompania7;
    private javax.swing.JLabel jl_TelefonoCompania8;
    private javax.swing.JLabel jl_TelefonoCompania9;
    // End of variables declaration//GEN-END:variables

}
