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
public class Persona implements Serializable {
    private int idpersona;
    private String nombrepersona;
    private String apellidopersona;
    private String email;
    private String telf;
    
    public Persona() {
    }
    
    public Persona(int idpersona, String nombrepersona, String apellidopersona, String email, String telf) {
        this.idpersona = idpersona;
        this.nombrepersona = nombrepersona;
        this.apellidopersona = apellidopersona;
        this.email = email;
        this.telf = telf;
    }

    public Persona(String nombrepersona, String apellidopersona, String email, String telf) {
        this.nombrepersona = nombrepersona;
        this.apellidopersona = apellidopersona;
        this.email = email;
        this.telf = telf;
    }

    public Persona(int idpersona) {
        this.idpersona = idpersona;
    }
    
    
    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
    

    public String getNombrepersona() {
        return nombrepersona;
    }

    public void setNombrepersona(String nombrepersona) {
        this.nombrepersona = nombrepersona;
    }

    public String getApellidopersona() {
        return apellidopersona;
    }

    public void setApellidopersona(String apellidopersona) {
        this.apellidopersona = apellidopersona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }
    
    

    

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", nombrepersona=" + nombrepersona + ", apellidopersona=" + apellidopersona + ", email=" + email + ", telf=" + telf + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idpersona;
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
        final Persona other = (Persona) obj;
        if (this.idpersona != other.idpersona) {
            return false;
        }
        return true;
    }
    
    
    
    
}
