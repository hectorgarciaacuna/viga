/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades;

import java.io.Serializable;

/**
 *
 * @author hector
 */
public class proveedores implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    
    public proveedores(){}
    
    public proveedores(long id, String value) {
        this.id = id;
        this.nombre = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String value) {
        this.nombre = value;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof proveedores)) {
            return false;
        }
        proveedores other = (proveedores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? (this.getClass().hashCode() + this.id.hashCode()): super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("proveedores[%d, %s]", id, nombre);
    }
    
}
