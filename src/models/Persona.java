/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Breixo
 */
public class Persona {
    private String nombre, domicilio, email, genero, fecNacimiento;
    private int id,clave,celular;
    
    public Persona(int clave){
        this.clave = clave;
    }
    
    public Persona(String nombre, String domicilio, String email, String genero, String fecNacimiento, int clave, int celular) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.genero = genero;
        this.fecNacimiento = fecNacimiento;
        this.clave = clave;
        this.celular = celular;
        
    }
    
    public Persona(String nombre, String domicilio, String email, String genero, String fecNacimiento, int id, int clave, int celular) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.genero = genero;
        this.fecNacimiento = fecNacimiento;
        this.id = id;
        this.clave = clave;
        this.celular = celular;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(String fecNacimiento) {
        String regularExpresion = "\\d{2}[-]\\d{2}[-]\\d{4}";
        Pattern fechaPatron = Pattern.compile(regularExpresion); 
        Matcher matcher = fechaPatron.matcher(fecNacimiento);
        this.fecNacimiento = fecNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", domicilio=" + domicilio + ", email=" + email + ", genero=" + genero + ", fecNacimiento=" + fecNacimiento + ", id=" + id + ", clave=" + clave + ", celular=" + celular + '}';
    }
    

}
