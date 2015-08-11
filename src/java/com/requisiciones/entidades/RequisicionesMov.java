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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hector
 */
@Entity
@Table(name = "requisiciones_mov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisicionesMov.findAll", query = "SELECT r FROM RequisicionesMov r"),
    @NamedQuery(name = "RequisicionesMov.findByTransaccionId", query = "SELECT r FROM RequisicionesMov r WHERE r.transaccionId = :transaccionId"),
    @NamedQuery(name = "RequisicionesMov.findByProductoId", query = "SELECT r FROM RequisicionesMov r WHERE r.productoId = :productoId"),
    @NamedQuery(name = "RequisicionesMov.findByUmId", query = "SELECT r FROM RequisicionesMov r WHERE r.umId = :umId"),
    @NamedQuery(name = "RequisicionesMov.findByCantidad", query = "SELECT r FROM RequisicionesMov r WHERE r.cantidad = :cantidad")})
public class RequisicionesMov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idr")
    private Integer idr;
    @Basic(optional = false)
    @Column(name = "transaccionId")
    private int transaccionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productoId")
    private int productoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "umId")
    private int umId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entidadId")
    private int entidadId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entidadNombre")
    private String entidadNombre;
    
    @JoinColumn(name = "transaccionId", referencedColumnName = "transaccionId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisiciones requisicion;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "requisicionesMov")
    private entidades entidad;

    public entidades getEntidad() {
        return entidad;
    }

    public void setEntidad(entidades entidad) {
        this.entidad = entidad;
    }
    

    public Requisiciones getRequisicion() {
        return requisicion;
    }

    public void setRequisicion(Requisiciones requisicion) {
        this.requisicion = requisicion;
    }

    public RequisicionesMov() {
    }

    public RequisicionesMov(Integer transaccionId) {
        this.transaccionId = transaccionId;
    }

    public RequisicionesMov(Integer idr,int transaccionId, int productoId, int umId, float cantidad, int entidadId) {
        this.idr = idr;
        this.transaccionId = transaccionId;
        this.productoId = productoId;
        this.umId = umId;
        this.cantidad = cantidad;
        this.entidadId = entidadId;
    }
    
    public Integer getIdr() {
        return idr;
    }

    public void setIdr(Integer idr) {
        this.idr = idr;
    }

    public int getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(int transaccionId) {
        this.transaccionId = transaccionId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getUmId() {
        return umId;
    }

    public void setUmId(int umId) {
        this.umId = umId;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getEntidadId(){
        return entidadId;
    }
    
    public void setEntidadId(int entidadId){
        this.entidadId = entidadId;
    }
    
    public String getEntidadNombre() {
        return entidadNombre;
    }

    public void setEntidadNombre(String entidadNombre) {
        this.entidadNombre = entidadNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idr != null ? idr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisicionesMov)) {
            return false;
        }
        RequisicionesMov other = (RequisicionesMov) object;
        if ((this.idr == null && other.idr != null) || (this.idr != null && !this.idr.equals(other.idr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.requisiciones.entidades.RequisicionesMov[ transaccionId=" + transaccionId + " ]";
    }
    
}
