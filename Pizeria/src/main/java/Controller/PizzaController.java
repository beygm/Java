/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import java.util.ArrayList;

/**
 *
 * @author jdeav
 */
public class PizzaController {

    public Object resultado[][] = null;
    public ArrayList<Pizza> regPedi = new ArrayList();
    public PedidoDao pedidoDAO = new PedidoDao();
    public PizzaDao pizzaDAO = new PizzaDao();

    public PizzaController() {

    }

    public Object[][] loadDataforTableModel() {
        ArrayList<Pizza> responsable = pizzaDAO.select();
        Object[][] content = pizzaDAO.selectV(responsable);
        return content;
    }
//     public Register select(Register register){
//        pizzaDAO = new PizzaDAO();
//        Register reg = pizzaDAO.selectUs(register);
//        return reg;
//    }

    public int insert(Pizza pizza) {
        pizzaDAO = new PizzaDao();
        int reg = pizzaDAO.insert(pizza);
        return reg;
    }

    public int edit(Pizza pizza) {
        pizzaDAO = new PizzaDao();
        int reg = pizzaDAO.edit(pizza);
        return reg;
    }

    public int delete(Pizza pizza) {
        pizzaDAO = new PizzaDao();
        int reg = pizzaDAO.delete(pizza);
        return reg;
    }

    public ArrayList<Pizza> agregarLista(Pizza pizza) {
        //System.out.println(pertenencias.toString());
        regPedi.add(pizza);
        return regPedi;
    }

    public Object[][] agregarListaV(ArrayList<Pizza> pizza) {

        //System.out.println("responsable array = " + registers.toString());
        resultado = new Object[pizza.size()][7];

        for (int i = 0; i < pizza.size(); i++) {

            resultado[i][0] = pizza.get(i).getId_piza();
            resultado[i][1] = pizza.get(i).getNombre();
            resultado[i][2] = pizza.get(i).getCantidad();
            resultado[i][3] = pizza.get(i).getPrecio();
            resultado[i][4] = (pizza.get(i).getPrecio() * pizza.get(i).getCantidad());

        }
//        System.out.println("responsable array = " + resultado.toString());
        return resultado;
    }

}
