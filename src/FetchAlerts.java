import java.sql.*;

public class FetchAlerts {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM alerts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Alerts:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("alert_id") + " | " +
                    rs.getInt("patient_id") + " | " +
                    rs.getString("alert_message") + " | " +
                    rs.getTimestamp("alert_time")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}