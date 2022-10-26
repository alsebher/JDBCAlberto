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
public class UsuarioDao {
    private static final String SQL_SELECT = "SELECT * FROM tusuario";
    private static final String SQL_INSERT = "INSERT INTO tusuario (nombreusuario,contrasenya) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE tusuario SET nombreusuario = ?,contrasenya = ? WHERE idusuario=?";
    private static final String SQL_DELETE = "DELETE FROM tusuario WHERE idusuario=?";
    
    //método que nos lista todos los usuarios de nuestro sistema
    public List<Usuario> seleccionar() throws SQLException{
        //Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            int idUsuario = rs.getInt("idusuario");
            String username = rs.getString("nombreusuario");
            String contra = rs.getString("contrasenya");
            //Instancio un nuevo objeto
            usuarios.add(new Usuario(idUsuario,username,contra));
        }
        
        close(rs);
        close(stmt);
        close(conn);
        
        return usuarios;
    }
    
    //método que inserta un usuario en mi sistema
    public int insertar(Usuario usuario){
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
            stmt.setString(1, usuario.getNombreusuario());
            stmt.setString(2, usuario.getContrasenya());
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
    
    //método que actualiza un usuario ya existente en mi sistema
    public int actualizar(Usuario usuario){
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
            stmt.setString(1, usuario.getNombreusuario());
            stmt.setString(2,usuario.getContrasenya());
            stmt.setInt(3,usuario.getIdusuario());
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
    
    //método que elimina un usuario del sistema
    public int eliminar(Usuario usuario){
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
            stmt.setInt(1,usuario.getIdusuario());
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
