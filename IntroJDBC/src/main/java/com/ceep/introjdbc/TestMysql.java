/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.introjdbc;

import dominio.Persona;
import dominio.PersonaDao;
import dominio.Usuario;
import dominio.UsuarioDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class TestMysql {
    public static void main(String[] args) {
        //defino la URL de conex a nuestra BD y sus parámetros
        PersonaDao personaDao = new PersonaDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        Persona p1 = new Persona(8,"Gonzalo","Morato","gonzalo@gmail.com","612442002");
        Persona p2 = new Persona(1,"Alberto","Sebastián","sebasalberto@gmail.com","612442800");
        Usuario u1 = new Usuario("alsebher","2345");
        Usuario u2 = new Usuario(3,"alsebher","1265");
        Usuario u3 = new Usuario("hugodt","6789");
        Usuario u4 = new Usuario(1);
        
        try {        
            
            //personaDao.insertar(p1);
            /*personaDao.actualizar(p2);
            personaDao.eliminar(p1);
            List<Persona> personas = personaDao.seleccionar();
            for(Persona p:personas){
                System.out.println(p.toString());
            }*/
            /*usuarioDao.insertar(u1);
            usuarioDao.insertar(u3);*/
            usuarioDao.actualizar(u2);
            //usuarioDao.eliminar(u4);
            List<Usuario> usuarios = usuarioDao.seleccionar();
            for(Usuario u:usuarios){
                System.out.println(u.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }   
    }
    
}
