/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.LoginDao.SQL_SELECT;
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
public class Order_itemDao {
    //Object resultado[][] = null;

    ArrayList<Order_item> register = null;
 
   
    ArrayList<Order_item> ingresos = null;
    Object resultado[][] = null;
    public static final String SQL_INSERT = "INSERT INTO order_item(id_order,id_piza,cantidad,precio)VALUES(?,?,?,?)";

    public static final String SQL_SELECTA = "SELECT * FROM order_item WHERE id_order = ?";

    public int insert(Order_item order) {
        Connection con = null;
        PreparedStatement ps = null;
        int registro = 0;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, order.getId_order());
            ps.setInt(2, order.getId_pizza());
            ps.setDouble(3, order.getQuantity());
            ps.setDouble(4, order.getPrice());

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
    
    
        
        public ArrayList<Order_item> select(Order_item order) {
        register = new ArrayList();
        Connection con = null;
        
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_SELECTA);
            ps.setInt(1, order.getId_order());
            rs = ps.executeQuery();
            while (rs.next()) {

                // responsables.add(new Responsable(id,fName,lName,eMail,rol));
                int id_item = rs.getInt("id_item");
                int idOrder = rs.getInt("id_order");
                
                int id_piza = rs.getInt("id_piza");
                double cantidad = rs.getDouble("cantidad");
                double precio = rs.getDouble("precio");
                

             
                register.add(new Order_item(id_item, idOrder, id_piza, cantidad, precio));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        try {
            rs.close();
           
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return register;
    }

        
        
            public Object[][] selectV(ArrayList<Order_item> order_items) {

        //System.out.println("responsable array = " + registers.toString());
        resultado = new Object[order_items.size()][8];
        for (int i = 0; i < order_items.size(); i++) {

            resultado[i][0] = order_items.get(i).getId_item();
            resultado[i][1] = order_items.get(i).getId_order();
            resultado[i][2] = order_items.get(i).getId_pizza();
            resultado[i][3] = order_items.get(i).getQuantity();
            resultado[i][4] = order_items.get(i).getPrice();
            
            

        }
//        System.out.println("responsable array = " + resultado.toString());
        return resultado;
    }

}


