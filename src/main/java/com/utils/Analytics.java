package com.utils;

import java.sql.*;
import java.time.LocalDate;

public class Analytics {

    private Connection conn = null;

    public Analytics() throws SQLException {
        this.conn = JdbcSingleton.getInstance().getConnection();
    }

    /**
     Ex:
         SELECT count(*)
         FROM location_tp4 l
         INNER JOIN client_tp4 c ON l.idClient = c.idClient
         INNER JOIN dateLocation_tp4 d ON l.idDate = d.idDate
         WHERE
         c.groupeagetranche5ans = '20-25'
         AND
         c.adresseprovince = 'quebec'
         AND
         d.datejoursemaine = 'lundi'
         AND
         d.datemois = 'janvier';

         @return number of location for parameters
     */
    public int get(String trancheAge , String province, String day, String month) throws SQLException {

        // Prepare statement variables
        int nbLocations = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Build query
            String sql = "SELECT COUNT(*) FROM location_tp4 l"
                    + " INNER JOIN client_tp4 c ON l.idClient = c.idClient"
                    + " INNER JOIN dateLocation_tp4 d ON l.idDate = d.idDate"
                    + getWhereClause(trancheAge, province, day, month);

            // Execute query
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            // Check results
            if (resultSet.next()) {
                nbLocations = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement.close();
            resultSet.close();
        }

        return nbLocations;
    }

    private String getWhereClause(String trancheAge , String province, String day, String month) {
        // Utilise un where generic pour normaliser les autres statements
        String clause = " WHERE 1=1";

        if (trancheAge != "tous"){
            clause += " AND c.groupeagetranche5ans = '"+trancheAge+"'";
        }

        if (province != "tous"){
            clause += " AND c.adresseprovince = '"+province+"'";
        }

        if (day != "tous"){
            clause += " AND d.datejoursemaine = '"+day+"'";
        }

        if (month != "tous"){
            clause += " AND d.datemois = '"+month+"'";
        }

        return clause;
    }
}
