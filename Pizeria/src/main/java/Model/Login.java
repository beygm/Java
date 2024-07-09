/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Login {
    
    private int idUser;
    private String ti;
    private String numeroId;
    private String nombre;
    private String contraseña;
    private String rol;
   

    public Login() {
    }

    public Login(int idUser, String ti, String numeroId, String nombre, String contraseña, String rol) {
        this.idUser = idUser;
        this.ti = ti;
        this.numeroId = numeroId;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rol = rol;
        
    }

    
    public Login(String ti, String numeroId, String contraseña, String rol) {
        this.ti = ti;
        this.numeroId = numeroId;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    
    
    public Login(String ti, String numeroId,String nombre, String contraseña, String rol) {
        this.ti = ti;
        this.numeroId = numeroId;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rol = rol;
        
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
    public String getTi() {
        return ti;
    }

    public void setTi(String ti) {
        this.ti = ti;
    }

    public String getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    
    
   

   
   
    


   
    
    
}
