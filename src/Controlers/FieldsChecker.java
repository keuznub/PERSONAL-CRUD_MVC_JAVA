/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import views.ViewCRUD;
import models.Model;
import Controlers.Controler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
/**
 *
 * @author breix
 */
public class FieldsChecker {
    
    public static boolean camposReady(ViewCRUD view){ 
        for(JComponent e : view.arrayFieldsNeeded){
            if(e instanceof JTextField){
                if(((JTextField) e).getText().isEmpty()){
                    
                    System.out.println("Rellena todos los campos");
                    return false;
                }
                
            }
            if(e instanceof JComboBox){
                if(((JComboBox) e).getSelectedItem().equals("Seleccionar")){
                    System.out.println("JComboBox Falta");
                    return false;
                } 
                       
            }
            if(!(parseableInt(view.tfClaveShow.getText()) && formatoCelularCorrecto(view.tfCelularShow.getText()) && formatoEmailCorrecto(view.tfcorreoEShow.getText()) 
                    && formatoNombresCorrecto(view.tfDomicilioShow.getText()) && formatoNombresCorrecto(view.tfNombreShow.getText())
                    && formatoNombresCorrecto(view.jcSelector.getSelectedItem().toString()) && formatoFechaCorrecto(view.tfFechaNacimiento.getText()))){
                return false;
            }
        }
        return true;    
    }
    
    public static boolean parseableInt(String text){
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            System.out.println("No parseable a Int");
            return false;
        }
    }
    
    
    public static boolean formatoFechaCorrecto(String text){
        String regex = "\\d{4}[-]\\d{2}[-]\\d{2}";
        Pattern pattern = Pattern.compile(regex);
       //Matcher matcher = pattern.matcher(text);
        if(text.matches(regex))
            return true;
        else{
            System.out.println("Fallo formato Fecha");
            return false;
        }
    }
    
    public static boolean formatoCelularCorrecto(String text){
        String regex = "\\d{9}";
        Pattern pattern = Pattern.compile(regex);
       //Matcher matcher = pattern.matcher(text);
        if(text.matches(regex))
            return true;
        else{
            System.out.println("Fallo formato Teléfono");
            return false;
        }
    }
    
    public static boolean formatoNombresCorrecto(String text){
        String regex = "[A-Z]{0,1}[a-z]{0,19}";
        Pattern pattern = Pattern.compile(regex);
       //Matcher matcher = pattern.matcher(text);
        if(text.matches(regex))
            return true;
        else{
            
            System.out.println("Fallo formato nombres");
            return false;
        }
    }
    
    public static boolean formatoEmailCorrecto(String text){
        String regex = "[A-Za-z]{0,15}[@][A-Za-z]{0,10}[.][A-Za-z]{0,3}";
        Pattern pattern = Pattern.compile(regex);
       //Matcher matcher = pattern.matcher(text);
        if(text.matches(regex))
            return true;
        else{
            System.out.println("Fallo formato Email");
            return false;
        }
    }
    
    
}
