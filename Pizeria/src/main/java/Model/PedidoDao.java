/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

//import static Model.Order_itemDao.SQL_SEL;
import static Model.PizzaDao.SQL_UPDATE;
import static Model.RegisterDao.SQL_SELECTA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jdeav
 */
public class PedidoDao {
    //Object resultado[][] = null;

    ArrayList<Pedido> register = null;
    ArrayList<Pedido> ingresos = null;
    Object resultado[][] = null;
    public static final String SQL_INSERT = "INSERT INTO pizza_order(idUser,total,method,additional_notes,estado)VALUES(?,?,?,?,?)";
    public static final String SQL_SEL = "SELECT * FROM pizza_order WHERE id_order = (SELECT MAX(id_order) FROM pizza_order)AND idUser = ? AND estado = 'Activo' ";
    public static final String SQL_SELECT = "SELECT * FROM pizza_order WHERE idUser = ? AND (SELECT MAX(id_order) FROM pizza_order) AND estado = 'Activo' ";
    public static final String SQL_SELECTA = "SELECT * FROM pizza_order ";

    public static final String SQL_UPDATE = "UPDATE pizza_order SET estado = ? WHERE id_order = ?";
    public int insert(Pedido pedido) {
        Connection con = null;
        PreparedStatement ps = null;
        int registro = 0;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, pedido.getId_customer());
            ps.setDouble(2, pedido.getTotal());
            ps.setString(3, pedido.getMethod());
            ps.setString(4, pedido.getAdditional_notes());
            ps.setString(5, pedido.getEstado());

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

    public int select(Pedido pedido) {
        int id = 0;
        Connection con = null;
        PreparedStatement ps = null;
        Statement st = null;

        //int registro = 0;
        ResultSet rs;

        try {
            con = Conexion.getConnection();
//            st = con.createStatement();
//            rs = st.executeQuery(SQL_SEL);
//
//

            ps = con.prepareStatement(SQL_SEL);
            ps.setInt(1, pedido.getId_customer());
            rs = ps.executeQuery();

//         ps = con.prepareStatement(SQL_SEL);
//
//
//         rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_order");

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        try {
            //ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return id;
    }
    
    
    
        public ArrayList<Pedido> select() {
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
                int idOrder = rs.getInt("id_order");
                int idUser = rs.getInt("idUser");
                double total = rs.getDouble("total");
                String method = rs.getString("method");
                String additional_notes = rs.getString("additional_notes");
                String estado = rs.getString("estado");

             
                register.add(new Pedido(idOrder, idUser, total, method, additional_notes, estado));
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

        
        
            public Object[][] selectV(ArrayList<Pedido> pedido) {

        //System.out.println("responsable array = " + registers.toString());
        resultado = new Object[pedido.size()][8];
        for (int i = 0; i < pedido.size(); i++) {

            resultado[i][0] = pedido.get(i).getId_order();
            resultado[i][1] = pedido.get(i).getId_customer();
            resultado[i][2] = pedido.get(i).getTotal();
            resultado[i][3] = pedido.get(i).getMethod();
            resultado[i][4] = pedido.get(i).getAdditional_notes();
            resultado[i][5] = pedido.get(i).getEstado();
            

        }
//        System.out.println("responsable array = " + resultado.toString());
        return resultado;
    }
            
            
            public int edit(Pedido pedido) {
        Connection con = null;
        PreparedStatement ps = null;
        int registro = 0;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, pedido.getEstado());
            ps.setInt(2, pedido.getId_order());
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


}
