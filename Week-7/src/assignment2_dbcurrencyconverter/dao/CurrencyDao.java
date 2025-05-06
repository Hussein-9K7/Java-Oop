package assignment2_dbcurrencyconverter.dao;

import assignment2_dbcurrencyconverter.datasource.MariaDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDao {
    public double getRateByAbbreviation(String abbreviation) {
        double rate = -1;
        String sql = "SELECT rate_to_usd FROM currency WHERE abbreviation = ?";

        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, abbreviation);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rate = rs.getDouble("rate_to_usd");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return rate;
    }
}
