import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertHealthData {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();

            // Sample health values
            int patientId = 1;
            int heartRate = 130;         // abnormal
            String bloodPressure = "150/100";
            float temperature = 39.0f;   // abnormal

            // Insert into health_data table
            String query = "INSERT INTO health_data (patient_id, heart_rate, blood_pressure, temperature) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, patientId);
            ps.setInt(2, heartRate);
            ps.setString(3, bloodPressure);
            ps.setFloat(4, temperature);

            ps.executeUpdate();
            System.out.println("Health data inserted successfully!");

            // 🚨 Alert logic
            if (heartRate > 120 || heartRate < 60 || temperature > 38) {

                String alertMsg = "Critical Condition Detected!";

                String alertQuery = "INSERT INTO alerts (patient_id, alert_message) VALUES (?, ?)";
                PreparedStatement alertStmt = conn.prepareStatement(alertQuery);

                alertStmt.setInt(1, patientId);
                alertStmt.setString(2, alertMsg);

                alertStmt.executeUpdate();

                System.out.println("🚨 ALERT GENERATED: " + alertMsg);
            } else {
                System.out.println("Patient condition normal.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}