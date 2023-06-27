package com.utils;

import java.sql.*;

public class Recommendation {

    private Connection conn = null;

    public Recommendation() throws SQLException {
        this.conn = JdbcSingleton.getInstance().getConnection();
    }

    public double getCote(int filmid) throws SQLException {
        double cote = 0;

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "Select avg_cote FROM MA_VUE_MOYENNE WHERE idfilm LIKE " + filmid;

            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                cote = resultSet.getDouble("avg_cote");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            resultSet.close();
        }

        return cote;
    }

    public String[] getRecommendation(int filmid) throws SQLException {
        String[] recommendation = new String[3];
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT titre FROM FILM WHERE idfilm in (" +
                    "Select idfilm2 from MA_VUE_CORRELATIONS WHERE idfilm1 LIKE " + filmid +
                    " ORDER BY CORR_INDEX DESC FETCH FIRST 3 ROWS ONLY)";


            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            int index = 0;
            while(resultSet.next()){
                recommendation[index] = resultSet.getString("titre");
                index++;
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            resultSet.close();
        }
        return recommendation;
    }

}
