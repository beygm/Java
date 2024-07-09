/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Login;
import Model.LoginDao;
import Model.Register;
import Model.RegisterDao;
import java.util.ArrayList;
import View.RegisterView;

public class RegisterController {

    public RegisterDao registerDAO = new RegisterDao();

    public RegisterController() {
    }

    /* Lanzar formulario Customers */
//    public void init(){
////        RegisterView responsableTable = new RegisterView();
////        responsableTable.setResizable(false);
////        responsableTable.setLocationRelativeTo(null);
////        responsableTable.setVisible(true);
//    }
    public Object[][] loadDataforTableModel() {
        ArrayList<Register> responsable = registerDAO.select();
        Object[][] content = registerDAO.selectV(responsable);
        return content;
    }

    public Register select(Register register) {
        registerDAO = new RegisterDao();
        Register reg = registerDAO.selectUs(register);
        return reg;
    }

    public int insert(Register register) {
        registerDAO = new RegisterDao();
        int reg = registerDAO.insert(register);
        return reg;
    }

//    public int edit(Register register){
//       registerDAO = new RegisterDao();
//        int reg = registerDAO.edit(register);
//        return reg;
//    }
//
//
//    public int delete(Register register){
//         registerDAO = new RegisterDao();
//        int reg = registerDAO.delete(register);
//        return reg;
//    }
//    public Object[][] searchResponsableById(int responsableID){
//        ResponsableDAO responsableDAO = new ResponsableDAO();
//        Object[][] reg = responsableDAO.searchResponsableById(responsableID);
//        return reg;
//    }
}
