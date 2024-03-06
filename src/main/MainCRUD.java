/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import views.ViewCRUD;
import javax.swing.UIManager;
import models.Model;
import Controlers.Controler;

/**
 *
 * @author Breixo
 */
public class MainCRUD {
    private static final String lookAndFeelTexture = "com.jtattoo.plaf.texture.TextureLookAndFeel";
    private static final String lookAndFeelAcryl = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
  
     public static void main(String args[]) {
         
       try{
        UIManager.setLookAndFeel(lookAndFeelTexture);
        }catch(Exception e){
            System.out.println("Bad Look and feel reference");
        }
         
       Model model = new Model();
       ViewCRUD view = new ViewCRUD();
       Controler controler = new Controler(model, view);
    
    }
    
}
