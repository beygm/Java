package Model;

import java.sql.*;

public class LoginDao {

    public static final String SQL_SELECT = "SELECT * FROM usuarios WHERE tident = ? AND numeroId = ? AND contraseña = ? AND rol = ?";

    public Login select(Login login) {
        Login l = new Login();
        Connection con = null;
        PreparedStatement ps = null;
        //int registro = 0;
        ResultSet rs;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_SELECT);
            ps.setString(1, login.getTi());
            ps.setString(2, login.getNumeroId());
            ps.setString(3, login.getContraseña());
            ps.setString(4, login.getRol());

            rs = ps.executeQuery();
            if (rs.next()) {
                l.setIdUser(rs.getInt("idUser"));
                l.setTi(rs.getString("tident"));
                l.setNumeroId(rs.getString("numeroId"));
                l.setNombre(rs.getString("nombres"));
                l.setContraseña(rs.getString("contraseña"));
                l.setRol(rs.getString("rol"));

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        try {
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return l;
    }

}
