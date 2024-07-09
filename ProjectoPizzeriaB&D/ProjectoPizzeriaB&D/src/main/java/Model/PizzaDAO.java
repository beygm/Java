/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dylan Molina
 */
import Data.Pizza;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {
    private Connection connection;

    public PizzaDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPizza(Pizza pizza) throws SQLException {
        String query = "INSERT INTO pizza (name, description, price, vegetarian, vegan, available) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, pizza.getName());
            stmt.setString(2, pizza.getDescription());
            stmt.setBigDecimal(3, pizza.getPrice());
            stmt.setBoolean(4, pizza.isVegetarian());
            stmt.setBoolean(5, pizza.isVegan());
            stmt.setBoolean(6, pizza.isAvailable());
            stmt.executeUpdate();
        }
    }

    public void updatePizza(Pizza pizza) throws SQLException {
        String query = "UPDATE pizza SET name = ?, description = ?, price = ?, vegetarian = ?, vegan = ?, available = ? WHERE id_pizza = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, pizza.getName());
            stmt.setString(2, pizza.getDescription());
            stmt.setBigDecimal(3, pizza.getPrice());
            stmt.setBoolean(4, pizza.isVegetarian());
            stmt.setBoolean(5, pizza.isVegan());
            stmt.setBoolean(6, pizza.isAvailable());
            stmt.setInt(7, pizza.getIdPizza());
            stmt.executeUpdate();
        }
    }

    public void deletePizza(int idPizza) throws SQLException {
        String query = "DELETE FROM pizza WHERE id_pizza = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPizza);
            stmt.executeUpdate();
        }
    }

    public Pizza getPizza(int idPizza) throws SQLException {
        String query = "SELECT * FROM pizza WHERE id_pizza = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPizza);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pizza(
                    rs.getInt("idPizza"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getBoolean("vegetarian"),
                    rs.getBoolean("vegan"),
                    rs.getBoolean("available")
                );
            }
        }
        return null;
    }

    public List<Pizza> getAllPizzas() throws SQLException {
        List<Pizza> pizzas = new ArrayList<>();
        String query = "SELECT * FROM pizza";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                pizzas.add(new Pizza(
                    rs.getInt("idPizza"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getBoolean("vegetarian"),
                    rs.getBoolean("vegan"),
                    rs.getBoolean("available")
                ));
            }
        }
        return pizzas;
    }
}
