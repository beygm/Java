/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Register {
    
    private int idUser;
    private String tipoID;
    private String numeroID;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String correo;
    private String contraseña;
    private String rol;
    
    

    public Register() {
    }

    public Register(String ti, String numeroId, String nombres, String apellidos, String telefono, String direccion, String correo, String contraseña, String rol) {
        this.tipoID = ti;
        this.numeroID = numeroId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
       
        
    }
    

    public Register(int idUser, String ti, String numeroId, String nombres, String apellidos, String telefono, String direccion, String correo, String contraseña, String rol) {
        this.idUser = idUser;
        this.tipoID = ti;
        this.numeroID = numeroId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        
    }

    public Register(String ti, String numeroId) {
        this.tipoID = ti;
        this.numeroID = numeroId;
    }

   
    

    public Register(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTi() {
        return tipoID;
    }

    public void setTi(String ti) {
        this.tipoID = ti;
    }

    public String getNumeroId() {
        return numeroID;
    }

    public void setNumeroId(String numeroId) {
        this.numeroID = numeroId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
