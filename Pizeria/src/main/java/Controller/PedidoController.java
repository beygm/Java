/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Order_item;
import Model.Order_itemDao;
import Model.Pedido;
import Model.PedidoDao;
import Model.Pizza;
import Model.PizzaDao;
import java.util.ArrayList;

/**
 *
 * @author jdeav
 */
public class PedidoController {
    public Object resultado[][] = null;
    public ArrayList<Pizza> regPedi = new ArrayList();
    public PedidoDao pedidoDAO = new PedidoDao();
    public Order_itemDao ordenDao = new Order_itemDao();
//    
//      public Object[][] loadDataforTableModel(){
//        ArrayList<Pedido> responsable = pedidoDAO.select();
//        Object[][] content = pedidoDAO.selectV(responsable);
//        return content;
//    }
//     public Register select(Register register){
//        pizzaDAO = new PizzaDAO();
//        Register reg = pizzaDAO.selectUs(register);
//        return reg;
//    }
    
     public Object[][] loadDataforTableModel() {
        ArrayList<Pedido> responsable = pedidoDAO.select();
        Object[][] content = pedidoDAO.selectV(responsable);
        return content;
    }
     
     
  
     
    
    public int insert(Pedido pedido){
        
        int reg = pedidoDAO.insert(pedido);
        return reg;
    }
    
        public int select(Pedido pedido){
        pedidoDAO = new PedidoDao();
        int reg = pedidoDAO.select(pedido);
        return reg;
    }
        
         public int edit(Pedido pedido) {
        pedidoDAO = new PedidoDao();
        int reg = pedidoDAO.edit(pedido);
        return reg;
    }
    
//    public int edit(Pedido pedido){
//      
//        int reg = pedidoDAO.edit(pedido);
//        return reg;
//    }
//    
//    
//    public int delete(Pedido pedido){
//         
//        int reg = pedidoDAO.delete(pedido);
//        return reg;
//    }
    
}
