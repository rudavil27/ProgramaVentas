/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author blood
 */
public class CLogin {
    
    public void validaUsuario(JTextField usuario, JPasswordField contrasenia){
    
        try {
            ResultSet rs=null;           
            PreparedStatement ps= null;
            
            Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
            
            String consulta="select * from Usuarios where Usuarios.ingresoUsuario =(?) and Usuarios.ingresoContrasenia=(?);";
            ps=objetoConexion.estableceConexion().prepareStatement(consulta);
            
            String contra = String.valueOf(contrasenia.getPassword());
            
            ps.setString(1, usuario.getText());
            ps.setString(2,contra);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                JOptionPane.showMessageDialog(null,"El Usuario es Correcto");
                Formulario.MenuPrincipal objetoMenu = new Formulario.MenuPrincipal();
                objetoMenu.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"El Usuario es INCORRECTO, VUELVA A INTENTAR");
            }
            
      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR: "+e.toString());
        }
    }
    
}
