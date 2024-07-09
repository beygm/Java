/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;

/**
 *
 * @author jdeav
 */
public class LoginController {

    public LoginDao loginDAO;

    public Login select(Login login) {
        loginDAO = new LoginDao();
        Login reg = loginDAO.select(login);
        return reg;
    }
}
