package com.mycompany.proyectodb2;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionMongo {
    private static final String HOST = "localhost";
    private static final int PUERTO = 27017;
    private static final String NOMBRE_BASE_DATOS = "empresa_db";

    private MongoClient cliente;
    private MongoDatabase baseDatos;

    public ConexionMongo() {
        conectar();
    }

    private void conectar() {
        try {
            ConnectionString connectionString = new ConnectionString("mongodb://" + HOST + ":" + PUERTO);
            cliente = MongoClients.create(connectionString);
            baseDatos = cliente.getDatabase(NOMBRE_BASE_DATOS);
            System.out.println("Conexión a MongoDB establecida");
        } catch (Exception e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
        }
    }

    public MongoDatabase obtenerBaseDatos() {
        return baseDatos;
    }

    public void cerrarConexion() {
        if (cliente != null) {
            cliente.close();
            System.out.println("Conexión a MongoDB cerrada");
        }
    }
}
