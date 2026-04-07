import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection() {
        try {
            // Load properties file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("db.properties");
            props.load(fis);

            // Get values
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to MySQL!");
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}