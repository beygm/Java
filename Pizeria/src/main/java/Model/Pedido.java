/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jdeav
 */
public class Pedido {

    private int id_order;
    private int id_customer;
    private double total;
    private String method;
    private String additional_notes;
    private String estado;

    public Pedido() {
    }

    public Pedido(int id_customer) {
        this.id_customer = id_customer;
    }

    public Pedido(int id_customer, double total, String method, String additional_notes, String estado) {
        this.id_customer = id_customer;
        this.total = total;
        this.method = method;
        this.additional_notes = additional_notes;
        this.estado = estado;
    }

    public Pedido(int id_order, int id_customer, double total, String method, String additional_notes, String estado) {
        this.id_order = id_order;
        this.id_customer = id_customer;
        this.total = total;
        this.method = method;
        this.additional_notes = additional_notes;
        this.estado = estado;
    }
    

    public Pedido(int id_order, String estado) {
        this.id_order = id_order;
        this.estado = estado;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAdditional_notes() {
        return additional_notes;
    }

    public void setAdditional_notes(String additional_notes) {
        this.additional_notes = additional_notes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
