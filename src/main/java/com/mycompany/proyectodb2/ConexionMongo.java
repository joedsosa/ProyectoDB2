package com.mycompany.proyectodb2;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionMongo {
    private MongoClient cliente;
    private MongoDatabase baseDatos;

    public ConexionMongo(String host, int puerto, String nombreBaseDatos) {
        conectar(host, puerto, nombreBaseDatos);
    }

    private void conectar(String host, int puerto, String nombreBaseDatos) {
        try {
            ConnectionString connectionString = new ConnectionString("mongodb://" + host + ":" + puerto);
            cliente = MongoClients.create(connectionString);
            baseDatos = cliente.getDatabase(nombreBaseDatos);
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