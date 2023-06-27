package com;
import com.utils.JdbcSingleton;
import com.hibernate.FilmEntity;
import com.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class test {

    public static void main(String [] args) throws SQLException {
        disableLogging();

        Connection conn = JdbcSingleton.getInstance().getConnection();

        int idPersonne = 0;
        String sqlGetID = "SELECT MAX(idPersonne) FROM Personne";
        PreparedStatement statementGet = null;
        ResultSet resultSet = null;
        try {
            statementGet = conn.prepareStatement(sqlGetID);
            resultSet = statementGet.executeQuery();
            if (resultSet.next()) {
                idPersonne = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statementGet.close();
            resultSet.close();
        }
        System.out.println(idPersonne);
    }

    public static void disableLogging() {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE); //could be Level.OFF
    }
}
