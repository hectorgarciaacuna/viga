/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.Table;

/**
 *
 * @author hector
 */
@Entity
@Table(name = "entidades")
public class entidades implements Serializable {
    @Id
    @NotNull
    @Basic(optional = false)
    @Column(name = "entidadId")
    private Integer entidadId;
    @Column(name = "rfc")
    private String rfc;
    @Column(name = "nombreCompleto")
    private String nombre;
    @Column(name = "activo")
    private boolean activo;
    
    @JoinColumn(name = "entidadId", referencedColumnName = "entidadId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RequisicionesMov requisicionesMov;

    public Integer getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Integer entidadId) {
        this.entidadId = entidadId;
    }

    public RequisicionesMov getRequisicionMov() {
        return requisicionesMov;
    }

    public void setRequisicionMov(RequisicionesMov requisicionesMov) {
        this.requisicionesMov = requisicionesMov;
    }
    
    public entidades(){}
    
    public entidades(int entidadId,String rfc,String nombre,boolean activo){
        this.entidadId = entidadId;
        this.rfc = rfc;
        this.nombre = nombre;
        this.activo = activo;
    }

    public void setEntidadId(int entidadId) {
        this.entidadId = entidadId;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entidadId != null ? entidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof entidades)) {
            return false;
        }
        entidades other = (entidades) object;
        if ((this.entidadId == null && other.entidadId != null) || (this.entidadId != null && !this.entidadId.equals(other.entidadId))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return String.valueOf(entidadId);
        //return String.format("entidades[%d, %s]", entidadId, nombre);
        //return "com.requisiciones.entidades.entidades[ entidadId=" + entidadId + " ]";
    }
    
    
}
