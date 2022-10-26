/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author Alumno Mañana
 */
public class Usuario implements Serializable {
    private int idusuario;
    private String nombreusuario;
    private String contrasenya;

    public Usuario() {
    }

    public Usuario(int idusuario, String nombreusuario, String contrasenya) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.contrasenya = contrasenya;
    }

    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String nombreusuario, String contrasenya) {
        this.nombreusuario = nombreusuario;
        this.contrasenya = contrasenya;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", nombreusuario=" + nombreusuario + ", contrasenya=" + contrasenya + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idusuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        return true;
    }
    
    
    
}
