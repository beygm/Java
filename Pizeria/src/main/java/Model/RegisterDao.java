package Model;

//import static Model.LoginDAO.SQL_SELECT;
import java.sql.*;
import java.util.ArrayList;
import Model.Conexion.*;
//import static Model.LoginDAO.SQL_SELECT;

public class RegisterDao {

    Object resultado[][] = null;

    public static final String SQL_INSERT = "INSERT INTO usuarios(tident,numeroId,nombres,apellidos,telefono,direccion,correo,contraseña,rol)VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String SQL_SELECTA = "SELECT * FROM usuarios";
    // public static final String SQL_UPDATE = "UPDATE usuarios SET tident = ?,numeroId = ?,nombres = ?,apellidos = ?,telefono = ?,direccion = ?,correo = ?,contraseña = ?,rol = ?,ficha = ?,centFormacion = ?,coordinacion = ?,empresa = ? WHERE idUser = ?";
    // public static final String SQL_DELETE = "DELETE FROM usuarios WHERE idUser = ?";
    public static final String SQL_SELECT = "SELECT * FROM usuarios WHERE idUser = ?";
    public static final String SQL_SELECTUS = "SELECT idUser,tident,numeroId FROM usuarios WHERE tident = ? AND numeroId = ?";
    ArrayList<Register> register = null;

    public int insert(Register register) {
        Connection con = null;
        PreparedStatement ps = null;
        int registro = 0;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, register.getTi());
            ps.setString(2, register.getNumeroId());
            ps.setString(3, register.getNombres());
            ps.setString(4, register.getApellidos());
            ps.setString(5, register.getTelefono());
            ps.setString(6, register.getDireccion());
            ps.setString(7, register.getCorreo());
            ps.setString(8, register.getContraseña());
            ps.setString(9, register.getRol());

            registro = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        try {
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return registro;
    }

    public ArrayList<Register> select() {
        register = new ArrayList();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
//          0st = con.createStatement();
            st = con.createStatement();
            rs = st.executeQuery(SQL_SELECTA);
            while (rs.next()) {

                // responsables.add(new Responsable(id,fName,lName,eMail,rol));
                int idUser = rs.getInt("idUser");
                String Ti = rs.getString("tident");
                String NumeroId = rs.getString("numeroId");
                String Nombres = rs.getString("nombres");
                String Apellidos = rs.getString("apellidos");
                String Telefono = rs.getString("telefono");
                String Direccion = rs.getString("direccion");
                String Correo = rs.getString("correo");
                String Contraseña = rs.getString("contraseña");

                String Rol = rs.getString("rol");

                register.add(new Register(idUser, Ti, NumeroId, Nombres, Apellidos, Telefono, Direccion, Correo, Contraseña, Rol));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        try {
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return register;
    }

    public Object[][] selectV(ArrayList<Register> registers) {

        //System.out.println("responsable array = " + registers.toString());
        resultado = new Object[registers.size()][10];
        for (int i = 0; i < register.size(); i++) {

            resultado[i][0] = registers.get(i).getIdUser();
            resultado[i][1] = registers.get(i).getTi();
            resultado[i][2] = registers.get(i).getNumeroId();
            resultado[i][3] = registers.get(i).getNombres();
            resultado[i][4] = registers.get(i).getApellidos();
            resultado[i][5] = registers.get(i).getTelefono();
            resultado[i][6] = registers.get(i).getDireccion();
            resultado[i][7] = registers.get(i).getCorreo();
            resultado[i][8] = registers.get(i).getContraseña();
            resultado[i][9] = registers.get(i).getRol();

        }
//        System.out.println("responsable array = " + resultado.toString());
        return resultado;
    }

//    //Editar responsable en la BD
//    public int edit (Register register){
//     Connection con = null;
//     PreparedStatement ps = null;
//     int registro = 0;
//
//     try{
//         con = Conexion.getConnection();
//         ps = con.prepareStatement(SQL_UPDATE);
//
//         ps.setString(1,register.getTi());
//         ps.setString(2,register.getNumeroId());
//         ps.setString(3,register.getNombres());
//         ps.setString(4,register.getApellidos());
//         ps.setString(5, register.getTelefono());
//         ps.setString(6, register.getDireccion());
//         ps.setString(7, register.getCorreo());
//         ps.setString(8, register.getContraseña());
//         ps.setString(9, register.getRol());
//
//         ps.setInt(15, register.getIdUser());
//         registro = ps.executeUpdate();
//     }catch(SQLException e){
//         e.printStackTrace(System.out);
//     }
//     try{
//         ps.close();
//         con.close();
//     }catch(SQLException e){
//         e.printStackTrace(System.out);
//     }
//     return registro;
//    }
//
////Borrar responsable en la BD
//    public int delete (Register register){
//     Connection con = null;
//     PreparedStatement ps = null;
//     int registro = 0;
//
//     try{
//         con = Conexion.getConnection();
//         ps = con.prepareStatement(SQL_DELETE);
//         ps.setInt(1, register.getIdUser());
//         registro = ps.executeUpdate();
//     }catch(SQLException e){
//         e.printStackTrace(System.out);
//     }
//     try{
//         ps.close();
//         con.close();
//     }catch(SQLException e){
//         e.printStackTrace(System.out);
//     }
//     return registro;
//    }
//
    public Register selectUs(Register register) {
        Register r = new Register();
        Connection con = null;
        PreparedStatement ps = null;
        //int registro = 0;
        ResultSet rs;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_SELECTUS);
            ps.setString(1, register.getTi());
            ps.setString(2, register.getNumeroId());

            rs = ps.executeQuery();
            if (rs.next()) {
                r.setIdUser(rs.getInt("idUser"));
                r.setTi(rs.getString("tident"));
                r.setNumeroId(rs.getString("numeroId"));

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
        return r;
    }

}
