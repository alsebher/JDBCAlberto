/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class PersonaDao {
    private static final String SQL_SELECT = "SELECT * FROM tpersona";
    private static final String SQL_INSERT = "INSERT INTO tpersona (nombrepersona,apellidopersona,email,telf) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tpersona SET nombrepersona = ?,apellidopersona = ?,email = ?,telf = ?  WHERE idpersona=?";
    private static final String SQL_DELETE = "DELETE FROM tpersona WHERE idpersona=?";
    
    //método que nos lista todas las personas de nuestro sistema
    public List<Persona> seleccionar() throws SQLException{
        //Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            int idPersona = rs.getInt("idpersona");
            String nombre = rs.getString("nombrepersona");
            String apellidos = rs.getString("apellidopersona");
            String correo = rs.getString("email");
            String telefono = rs.getString("telf");
            //Instancio un nuevo objeto
            personas.add(new Persona(idPersona,nombre,apellidos,correo,telefono));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        
        return personas;
    }
    
    //método que inserta una persona en mi sistema
    public int insertar(Persona persona){
        //Declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            //1 Establecemos la conexion
            conn = getConnection();
            //2 Preparo mi instrucción para ejecutarla en la BD
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores de los ? de la consulta
            stmt.setString(1, persona.getNombrepersona());
            stmt.setString(2, persona.getApellidopersona());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelf());
            //3 Ejecuto mi query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
    
    //método que actualiza una persona ya existente en mi sistema
    public int actualizar(Persona persona){
        //Declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            //1 Establecemos la conexion
            conn = getConnection();
            //2 Preparo mi instrucción para ejecutarla en la BD
            stmt = conn.prepareStatement(SQL_UPDATE);
            //Asignar los valores de los ? de la consulta
            stmt.setString(1, persona.getNombrepersona());
            stmt.setString(2, persona.getApellidopersona());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelf());
            stmt.setInt(5,persona.getIdpersona());
            //3 Ejecuto mi query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
    
    //método que actualiza una persona ya existente en mi sistema
    public int eliminar(Persona persona){
        //Declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            //1 Establecemos la conexion
            conn = getConnection();
            //2 Preparo mi instrucción para ejecutarla en la BD
            stmt = conn.prepareStatement(SQL_DELETE);
            //Asignar los valores de los ? de la consulta
            stmt.setInt(1,persona.getIdpersona());
            //3 Ejecuto mi query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
}
