/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenglobalzoologico;

import examenglobalzoologico.Controller.Controladora;
import examenglobalzoologico.Model.Ave;
import examenglobalzoologico.View.MainMenu;


/**
 *
 * @author MFARFAN
 */
public class ExamenGlobalZoologico {
    
    public static void main(String[] args) {
        Controladora controladora = new Controladora();
//       
        
        MainMenu mainMenu = new MainMenu(controladora);
        mainMenu.setVisible(true);
    }
    
}
