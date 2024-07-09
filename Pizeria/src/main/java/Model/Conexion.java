package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    //  public static final String URL = "jdbc:mysql://localhost:3306/itsm_fundamentals?useSSL=false&allowPublicKeyRetrieval=true";

    public static final String URL = "jdbc:mysql://localhost:3306/TallerPizza?useSSL=false&allowPublicKeyRetrieval=true";
    public static final String USER = "root";
    public static final String PASSWD = "123456";

    public void Connection() {

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement st) throws SQLException {
        st.close();
    }

    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void close(Connection con) throws SQLException {
        con.close();
    }

}
