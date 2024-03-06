/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package externals;

import models.Persona;

/**
 *
 * @author Breixo
 */
public interface PersonaCRUDable {
    
    public void insert(Persona persona);
    
    public void update(Persona persona);
    
    public Persona search(Persona persona);
    
    public void delete(Persona persona);
          
}
