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
import Controlers.FieldsChecker;
import static Controlers.FieldsChecker.formatoEmailCorrecto;
import static Controlers.FieldsChecker.formatoFechaCorrecto;
import static Controlers.FieldsChecker.formatoNombresCorrecto;
import static Controlers.FieldsChecker.parseableInt;
import javax.swing.JTextField;
import javax.swing.UIManager;
/**
 *
 * @author Breixo
 */
public class Controler{
    private ViewCRUD view;
    private Model model;
    private Persona persona;
    private int claveModificable = -1;
   
    
    public Controler(Model model, ViewCRUD view){
        this.view = view;
        this.model = model;
        startView();
    }
    
    
    private void startView(){
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        initEvents();
        
        
    }
    
    private void initEvents(){
        view.btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertFromView();
            }
        });   
        
        view.btnUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFromView();
            }
        }); 
        
        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFromView();
            }
        }); 
        
        view.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flushFields();
            }
        });
        
        view.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFromView();
            }
        }); 
    }
    
    private void insertFromView(){
        if(FieldsChecker.camposReady(view)){
            persona = new Persona(view.tfNombreShow.getText(),
                    view.tfDomicilioShow.getText(),
                    view.tfcorreoEShow.getText(),
                    view.jcSelector.getSelectedItem().toString(),
                    view.tfFechaNacimiento.getText(),
                    Integer.parseInt(view.tfClaveShow.getText()),
                    Integer.parseInt(view.tfCelularShow.getText()));
            
            model.insert(persona);
            flushFields();
            
        }else{
            
        }
        persona = null;   
    }
    
    private void searchFromView(){
        if(!view.tfSearchClave.getText().isEmpty() && FieldsChecker.parseableInt(view.tfSearchClave.getText())){
            persona = new Persona(Integer.parseInt(view.tfSearchClave.getText()));
            persona = model.search(persona);
            if(persona!=null){
            personaToFields(persona);
            }
            
        }else{
            System.out.println("Faltan Clave");
        }
        persona = null;
    }
    
    private void updateFromView(){
        if(claveModificable!=-1){
            persona = new Persona(view.tfNombreShow.getText(),
                    view.tfDomicilioShow.getText(),
                    view.tfcorreoEShow.getText(),
                    view.jcSelector.getSelectedItem().toString(),
                    view.tfFechaNacimiento.getText(),
                    Integer.parseInt(view.tfClaveShow.getText()),
                    Integer.parseInt(view.tfCelularShow.getText()));
            model.update(persona,claveModificable);
            flushFields();
            
        }else
           System.out.println("Necesitas buscar primero"); 

        persona = null;
    }
    
    
    private void deleteFromView(){
        if(!view.tfSearchClave.getText().isEmpty() && FieldsChecker.parseableInt(view.tfSearchClave.getText())){
            persona = new Persona(Integer.parseInt(view.tfSearchClave.getText()));
            model.delete(persona);
            flushFields();
            
        }else{
            System.out.println("Falta clave");
        }
        persona = null;
    }
    
    private void flushFields(){
        System.out.println("Limpiar");
        for(JComponent e : view.arrayFields){
            if(e instanceof JTextField){
                ((JTextField) e).setText("");
            }
            if(e instanceof JComboBox){

                ((JComboBox) e).setSelectedIndex(0);
                
            }
        }
        claveModificable = -1;
    }
    
    private void personaToFields(Persona persona){
        view.tfNombreShow.setText(persona.getNombre());
        view.tfDomicilioShow.setText(persona.getDomicilio());
        view.tfcorreoEShow.setText(persona.getEmail());
        view.jcSelector.setSelectedItem(persona.getGenero());
        view.tfFechaNacimiento.setText(persona.getFecNacimiento());
        view.tfClaveShow.setText(String.valueOf(persona.getClave()));
        view.tfCelularShow.setText(String.valueOf(persona.getCelular()));
        view.tfIdShow.setText(String.valueOf(persona.getId()));
        claveModificable = persona.getClave();
    }

   
    
    
    
    
   
}
