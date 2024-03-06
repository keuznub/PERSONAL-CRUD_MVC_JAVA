/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import views.ViewCRUD;
import models.Model;
import models.Persona;
/**
 *
 * @author Breixo
 */
public class Controler{
    private ViewCRUD view;
    private Model model;
    private Persona persona;
    
    public Controler(Model model, ViewCRUD view){
        this.view = view;
        this.model = model;
        startView();
    }
    
    
    private void startView(){
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        
        
    }
    
    private void initEvents(){
        view.btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.insert(persona);
            }
        });        
    }
    
    private void insertFromView(){
        if(camposReady()){
            persona = new Persona(view.tfNombreShow.getText(), view.tfDomicilioShow.getText(),
                    view.tfcorreoEShow.getText(), view.jcSelector.getSelectedItem().toString(),view.tfFechaNacimiento.getText(),
                    Integer.parseInt(view.tfIdShow.getText()), Integer.parseInt(view.tfClaveShow.getText()), Integer.parseInt(view.tfCelularShow.getText()));
            
            model.insert(persona);
        }else{
            System.out.println("Faltan campos");
        }
            
    }
    
    private void searchFromView(){
        if(!view.tfSearchClave.getText().isEmpty()){
            persona = new Persona(Integer.parseInt(view.tfSearchClave.getText()));
            persona = model.search(persona);
        }else{
            System.out.println("Faltan Clave");
        }
        persona = null;
    }
    
    private void deleteFromView(){
        if(!view.tfSearchClave.getText().isEmpty()){
            persona = new Persona(Integer.parseInt(view.tfSearchClave.getText()));
            model.delete(persona);
        }else{
            System.out.println("Faltan campos");
        }
        persona = null;
    }
    
   
    
    private boolean camposReady(){ 
        for(JComponent e : view.arrayFields){
            if(e instanceof JTextArea){
                if(((JTextArea) e).getText().isEmpty()){
                    System.out.println(e.getClass().getName() + "Fallo");
                    return false;
                }
                
            }
            if(e instanceof JComboBox){
                if(((JComboBox) e).getSelectedItem().equals("Seleccionar")){
                    System.out.println("JComboBox Falta");
                    return false;
                } 
                       
            }
            
        }
        return true;    
    }
   
}
