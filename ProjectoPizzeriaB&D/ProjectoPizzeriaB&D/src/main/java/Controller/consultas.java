package Controller;





import Conexion.ConexionDB;
import View.ViewAdmin;
import View.ViewOrdenes;
import static com.mysql.cj.conf.PropertyKey.PASSWORD;
import static com.mysql.cj.conf.PropertyKey.USER;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class consultas {
    //
        private static final String URL = "jdbc:mysql://localhost:3306/proyecto_pizza";
        private static final String USER = "root";
        private static final String PASSWORD = "123456";
    
    //
//    Guardar los datos del usuario para el login y registro
    public void guardarUsuario(String idCustomer, String name, String address, String email, String phone, String username, String password) {
        if (password.length() > 8) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede tener más de 8 caracteres");
            return;
        }

        ConexionDB db = new ConexionDB();
        String sql = "INSERT INTO customer (id_customer, name, address, email, phone_number) VALUES (?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO customer_register (username, contraseña) VALUES (?, ?)";
        
        try (Connection conexion = db.conectar();
             PreparedStatement pst = conexion.prepareStatement(sql);
             PreparedStatement pst2 = conexion.prepareStatement(sql2)) {
            
            pst.setString(1, idCustomer);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, email);
            pst.setString(5, phone);
            
            pst2.setString(1, username);
            pst2.setString(2, password);
            
            pst.executeUpdate();
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }
    
    public void consultarUsuario(String username, String pass) {
        ConexionDB db = new ConexionDB();
        
        try (Connection cn = db.conectar();
             PreparedStatement pst = cn.prepareStatement("SELECT username, contraseña FROM customer_register WHERE username = ?")) {
            
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String usuarioCorrecto = rs.getString("username");
                String passCorrecto = rs.getString("contraseña");
                
                if (username.equals("admin") && pass.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Login correcto como Admin. Bienvenido " + username);
                    ViewAdmin adminView = new ViewAdmin();
                    adminView.setVisible(true);
                } else if (username.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
                    JOptionPane.showMessageDialog(null, "Login correcto. Bienvenido " + username);
                    ViewOrdenes ordenesView = new ViewOrdenes();
                    ordenesView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    // mostrar los datos en la tabla 
   
        public DefaultTableModel obtenerDatosPizza(int usuarioId) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id_item");
        modelo.addColumn("id_order");
        modelo.addColumn("id_pizza");
        modelo.addColumn("quiantity");
        modelo.addColumn("price");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ingreso WHERE username = ?");
        ) {
            stmt.setInt(1, usuarioId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                String id_item = rs.getString("id_item");
                String id_order = rs.getString("id_order");
                String id_pizza = rs.getString("id_pizza");
                String quiantity = rs.getString("quiantity");
                String price = rs.getString("price");
                modelo.addRow(new Object[]{id_item, id_order, id_pizza, quiantity,price});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return modelo;
    }
         public void agregarOrden(String id_item, String id_order, String id_pizza, String quiantity, Int price) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO order_item (id_item, id_order, id_pizza, quiantity, price) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, id_item);
                stmt.setString(2, id_order);
                stmt.setString(3, id_pizza);
                stmt.setString(4, quiantity);
                stmt.setInt(5, price);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AgregarPizza(String id_Pizza, String name, String descripcion, String vegetariana, Int price,String vegana,String available) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO pizza (id_Pizza, name, descripcion, vegetariana,vegana, price,available) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, id_Pizza);
                stmt.setString(2, name);
                stmt.setString(3, vegetariana);
                stmt.setString(4, vegana);
                stmt.setInt(5, price);
                stmt.setString(6, available);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}