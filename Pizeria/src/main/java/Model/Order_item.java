/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jdeav
 */
public class Order_item {

    private int id_item;
    private int id_order;
    private int id_pizza;
    private double quantity;
    private double price;

    public Order_item() {
    }

    public Order_item(int id_order) {
        this.id_order = id_order;
    }
    
    

    public Order_item(int id_item, int id_order, int id_pizza, double quantity, double price) {
        this.id_item = id_item;
        this.id_order = id_order;
        this.id_pizza = id_pizza;
        this.quantity = quantity;
        this.price = price;
    }

    public Order_item(int id_order, int id_pizza, double quantity, double price) {
        this.id_order = id_order;
        this.id_pizza = id_pizza;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
