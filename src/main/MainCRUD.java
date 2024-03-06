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

  
     public static void main(String args[]) {
       Model model = new Model();
       ViewCRUD view = new ViewCRUD();
       Controler controler = new Controler(model, view);
    
    }
    
}
