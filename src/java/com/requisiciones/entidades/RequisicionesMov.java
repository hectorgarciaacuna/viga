/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @Column(name = "transaccionId")
    private Integer transaccionId;
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

    public RequisicionesMov() {
    }

    public RequisicionesMov(Integer transaccionId) {
        this.transaccionId = transaccionId;
    }

    public RequisicionesMov(Integer transaccionId, int productoId, int umId, float cantidad) {
        this.transaccionId = transaccionId;
        this.productoId = productoId;
        this.umId = umId;
        this.cantidad = cantidad;
    }

    public Integer getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(Integer transaccionId) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionId != null ? transaccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisicionesMov)) {
            return false;
        }
        RequisicionesMov other = (RequisicionesMov) object;
        if ((this.transaccionId == null && other.transaccionId != null) || (this.transaccionId != null && !this.transaccionId.equals(other.transaccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.requisiciones.entidades.RequisicionesMov[ transaccionId=" + transaccionId + " ]";
    }
    
}
