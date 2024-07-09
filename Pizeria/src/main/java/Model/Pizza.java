/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jdeav
 */
public class Pizza {

    private int id_piza;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private String vegetarian;
    private String vegan;
    private String available;

    public Pizza() {
    }

    public Pizza(int id_piza, String nombre, double precio, int cantidad) {
        this.id_piza = id_piza;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Pizza(int id_piza, String nombre, String descripcion, double precio, int cantidad, String vegetarian, String vegan, String available) {
        this.id_piza = id_piza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.available = available;
    }

    public Pizza(String nombre, String descripcion, double precio, int cantidad, String vegetarian, String vegan, String available) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.available = available;
    }

    public Pizza(int id_piza) {
        this.id_piza = id_piza;
    }

    public int getId_piza() {
        return id_piza;
    }

    public void setId_piza(int id_piza) {
        this.id_piza = id_piza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

}
