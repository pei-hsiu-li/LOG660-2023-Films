package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSingleton {

    private static JdbcSingleton jdbc_instance = null;
    private static Connection connection = null;
    private JdbcSingleton(){}

    public static JdbcSingleton getInstance(){
        if (jdbc_instance == null){
            jdbc_instance = new JdbcSingleton();
        }
        return jdbc_instance;
    }


    public Connection getConnection() throws SQLException {

        // Check for previous connection
        if (connection != null){
            deconnection();
        }

        // Connect
        String url = "jdbc:oracle:thin:EQUIPE112/BXmmDXlK@log660ora12c.logti.etsmtl.ca:1521:LOG660";
        connection = DriverManager.getConnection(url);

        // Confirm connection
        if (connection != null) {
//            System.out.println("Connexion à la BD réussie !");
            connection.setAutoCommit(false);
        }

        return connection;
    }

    public void deconnection() throws SQLException {
        connection.close();
    }
}
