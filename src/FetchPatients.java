import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchPatients {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM patients";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Patient Records:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("patient_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("gender") + " | " +
                    rs.getString("contact")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}