/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hector
 */
@Entity
@Table(name = "requisiciones")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Requisiciones.findAll", query = "SELECT r FROM Requisiciones r"),
    @NamedQuery(name = "Requisiciones.findByTransaccionId", query = "SELECT r FROM Requisiciones r WHERE r.transaccionId = :transaccionId"),
    @NamedQuery(name = "Requisiciones.findByFolio", query = "SELECT r FROM Requisiciones r WHERE r.folio = :folio"),
    @NamedQuery(name = "Requisiciones.findByFecha", query = "SELECT r FROM Requisiciones r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Requisiciones.findByProyectoId", query = "SELECT r FROM Requisiciones r WHERE r.proyectoId = :proyectoId"),
    @NamedQuery(name = "Requisiciones.findByUsuarioId", query = "SELECT r FROM Requisiciones r WHERE r.usuarioId = :usuarioId"),
    @NamedQuery(name = "Requisiciones.findByComentario", query = "SELECT r FROM Requisiciones r WHERE r.comentario = :comentario")})
public class Requisiciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transaccionId")
    @XmlAttribute(required=true)
    private Integer transaccionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "folio")
    @XmlAttribute(required=true)
    private String folio;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(required=true)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectoId")
    @XmlAttribute(required=true)
    private int proyectoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioId")
    @XmlAttribute(required=true)
    private int usuarioId;
    @Size(max = 500)
    @Column(name = "comentario")
    @XmlAttribute(required=true)
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entidadId")
    @XmlAttribute(required=true)
    private int entidadId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisicion")
    private List<RequisicionesMov> detalle;

    public List<RequisicionesMov> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<RequisicionesMov> detalle) {
        this.detalle = detalle;
    }

    public Requisiciones() {
    }

    public Requisiciones(Integer transaccionId) {
        this.transaccionId = transaccionId;
    }

    public Requisiciones(Integer transaccionId, String folio, int proyectoId, int usuarioId) {
        this.transaccionId = transaccionId;
        this.folio = folio;
        this.proyectoId = proyectoId;
        this.usuarioId = usuarioId;
    }

    public Integer getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(Integer transaccionId) {
        this.transaccionId = transaccionId;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(int entidadId) {
        this.entidadId = entidadId;
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
        if (!(object instanceof Requisiciones)) {
            return false;
        }
        Requisiciones other = (Requisiciones) object;
        if ((this.transaccionId == null && other.transaccionId != null) || (this.transaccionId != null && !this.transaccionId.equals(other.transaccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.requisiciones.entidades.Requisiciones[ transaccionId=" + transaccionId + " ]";
    }
    
}
