/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Order_item;
import Model.*;
import java.util.ArrayList;

/**
 *
 * @author jdeav
 */
public class OrderController {
    
    Order_itemDao ordrerDao = new Order_itemDao();
     public int insert(Order_item order){
        
        int reg = ordrerDao.insert(order);
        return reg;
    }
     
      public Object[][] loadDataforTableModel(Order_item order) {
        ArrayList<Order_item> responsable = ordrerDao.select(order);
        Object[][] content = ordrerDao.selectV(responsable);
        return content;
    }
     
   
      
    
}
