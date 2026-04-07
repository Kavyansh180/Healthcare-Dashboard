import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertPatient {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO patients (name, age, gender, contact) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, "Amit Verma");
            ps.setInt(2, 40);
            ps.setString(3, "Male");
            ps.setString(4, "9999999999");

            ps.executeUpdate();

            System.out.println("Patient inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}