/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class PizzaDao {

    public static final String SQL_INSERT = "INSERT INTO pizza(nombre,descripcion,precio,cantidad,vegetarian,vegan,available)Values(?,?,?,?,?,?,?)";
    public static final String SQL_SELECTA = "SELECT * FROM pizza";
    public static final String SQL_UPDATE = "UPDATE pizza SET nombre = ?,descripcion=?,precio=?,cantidad=?,vegetarian=?,vegan=?,available=? WHERE id_piza = ?";
    public static final String SQL_DELETE = "DELETE FROM pizza WHERE id_piza = ?";
    public static final String SQL_SELECT = "SELECT * FROM pizza WHERE id_piza = ?";

    ArrayList<Pizza> pizza = null;
    Object resultado[][] = null;

    public int insert(Pizza pizza) {
        Connection con = null;
        PreparedStatement ps = null;
        int registro = 0;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, pizza.getNombre());
            ps.setString(2, pizza.getDescripcion());
            ps.setDouble(3, pizza.getPrecio());
            ps.setInt(4, pizza.getCantidad());
            ps.setString(5, pizza.getVegetarian());
            ps.setString(6, pizza.getVegan());
            ps.setString(7, pizza.getAvailable());
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

    public ArrayList<Pizza> select() {
        pizza = new ArrayList();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
//          0st = con.createStatement();
            st = con.createStatement();
            rs = st.executeQuery(SQL_SELECTA);
            while (rs.next()) {

                int id_piza = rs.getInt("id_piza");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                String vegetarian = rs.getString("vegetarian");
                String vegan = rs.getString("vegan");
                String available = rs.getString("available");

                pizza.add(new Pizza(id_piza, nombre, descripcion, precio, cantidad, vegetarian, vegan, available));
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
        return pizza;
    }

    public Object[][] selectV(ArrayList<Pizza> pizza) {

        //System.out.println("responsable array = " + registers.toString());
        resultado = new Object[pizza.size()][8];
        for (int i = 0; i < pizza.size(); i++) {

            resultado[i][0] = pizza.get(i).getId_piza();
            resultado[i][1] = pizza.get(i).getNombre();
            resultado[i][2] = pizza.get(i).getDescripcion();
            resultado[i][3] = pizza.get(i).getPrecio();
            resultado[i][4] = pizza.get(i).getCantidad();
            resultado[i][5] = pizza.get(i).getVegetarian();
            resultado[i][6] = pizza.get(i).getVegan();
            resultado[i][7] = pizza.get(i).getAvailable();

        }
//        System.out.println("responsable array = " + resultado.toString());
        return resultado;
    }

    //Editar responsable en la BD
    public int edit(Pizza pizza) {
        Connection con = null;
        PreparedStatement ps = null;
        int registro = 0;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, pizza.getNombre());
            ps.setString(2, pizza.getDescripcion());
            ps.setDouble(3, pizza.getPrecio());
            ps.setInt(4, pizza.getCantidad());
            ps.setString(5, String.valueOf(pizza.getVegetarian()));
            ps.setString(6, String.valueOf(pizza.getVegan()));
            ps.setString(7, String.valueOf(pizza.getAvailable()));

            ps.setInt(8, pizza.getId_piza());
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

//Borrar responsable en la BD
    public int delete(Pizza pizza) {
        Connection con = null;
        PreparedStatement ps = null;
        int registro = 0;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, pizza.getId_piza());
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
