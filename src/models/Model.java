/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.protocol.Resultset;
import externals.PersonaCRUDable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Breixo
 */
public class Model implements PersonaCRUDable{
    private final String username = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/crudjava"; 
    private final String driver = "com.mysql.cj.jdbc.Driver";
         
    private Connection getConnection(Connection con){
        try {
            Class.forName(driver);
            con =  DriverManager.getConnection(url, username, password);
            System.out.println("Conexion Exitosa");
            
        } catch (Exception e) {
            System.out.println("Conexion Fallida");
            con = null;
        }  
        return con;
    }

    @Override
    public void insert(Persona persona) {
        Connection con = null;
        con = getConnection(con);
        if(con!=null){
            try {
                int result;
                System.out.println(persona);
                PreparedStatement ps = con.prepareStatement("insert into personas(clave,nombre,domicilio,celular,correoElectronico,fechaNacimiento,genero) values(?,?,?,?,?,?,?)");
                ps.setInt(1, persona.getClave());
                ps.setString(2, persona.getNombre());
                ps.setString(3, persona.getDomicilio());
                ps.setInt(4,persona.getCelular());
                ps.setString(5, persona.getEmail());
                ps.setDate(6,  Date.valueOf(persona.getFecNacimiento()));
                ps.setString(7, persona.getGenero());
                result = ps.executeUpdate();
                
                
                if(result>0)
                System.out.println("Insert Exitoso");
                else
                System.out.println("Insert Fallido"); 
                con.close();
                
            } catch (Exception e) {
                System.out.println("Insert Fallido excepcion");
                e.printStackTrace();
            }
       
        }else{
            System.out.println("conexion es null");
        }
        
    }

    @Override
    public void update(Persona persona) {
        Connection con = null;
        con = getConnection(con);
        if(con!=null){
            try {
                int result;
                PreparedStatement ps = con.prepareStatement("update personas set clave=?,nombre=?,domicilio=?,celular=?,correoElectronico=?,fechaNacimiento=?,genero=? where clave=?");
                ps.setInt(1, persona.getClave());
                ps.setString(2, persona.getNombre());
                ps.setString(3, persona.getDomicilio());
                ps.setInt(4,persona.getCelular());
                ps.setString(5, persona.getEmail());
                ps.setDate(6,  Date.valueOf(persona.getFecNacimiento()));
                ps.setString(7, persona.getGenero());
                ps.setInt(8, persona.getClave());
                result = ps.executeUpdate();
                
                
                if(result>0)
                System.out.println("Update Exitoso");
                else
                System.out.println("Update Fallido"); 
                con.close();
                
            } catch (SQLException e) {
                System.out.println("Update Fallido"); 
            }
       
        }
        
    }
    
    @Override
    public Persona search(Persona persona) {
        Connection con = null;
        con = getConnection(con);
        if(con!=null){
            try {
                PreparedStatement ps = con.prepareStatement("select * from personas where clave=? ");
                ps.setInt(1, persona.getClave());
                ResultSet result = ps.executeQuery();
                
                if(result.next()){
                    persona.setId(result.getInt("id"));
                    persona.setNombre(result.getString("nombre"));
                    persona.setDomicilio(result.getString("domicilio"));
                    persona.setCelular(result.getInt("celular"));
                    persona.setEmail(result.getString("correoElectronico"));
                    persona.setFecNacimiento(result.getString("fechaNacimiento"));
                    persona.setGenero(result.getString("genero"));
                    
                    System.out.println("Busqueda exitosa");
                    return persona;
                }else
                System.out.println("No se ha encontrado");
                
                con.close();
            } catch (Exception e) {
                System.out.println("Busqueda no exitosa"); 
            }
       
        }
        return null;
        
    }

    @Override
    public void delete(Persona persona) {
        Connection con = null;
        con = getConnection(con);
        if(con!=null){
            try {
                persona = search(persona);   
                if(persona!=null){
                    PreparedStatement ps = con.prepareStatement(" delete from persona where id=?");
                    ps.setInt(1, persona.getId());
                    int result = ps.executeUpdate();
                    if(result>0)
                        System.out.println("Eliminacion exitosa");
                    else    
                        System.out.println("Eliminacion no exitosa");
                    
                }
                con.close();
            } catch (Exception e) {
                System.out.println("Eliminacion no exitosa"); 
            }  
        }     
    }
    
    
    
}
