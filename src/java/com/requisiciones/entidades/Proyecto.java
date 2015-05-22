/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "proyecto")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByProyectoId", query = "SELECT p FROM Proyecto p WHERE p.proyectoId = :proyectoId"),
    @NamedQuery(name = "Proyecto.findByCodigoPostal", query = "SELECT p FROM Proyecto p WHERE p.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Proyecto.findByCodigoProyecto", query = "SELECT p FROM Proyecto p WHERE p.codigoProyecto = :codigoProyecto"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByDireccion", query = "SELECT p FROM Proyecto p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proyecto.findByColonia", query = "SELECT p FROM Proyecto p WHERE p.colonia = :colonia"),
    @NamedQuery(name = "Proyecto.findByDelegacion", query = "SELECT p FROM Proyecto p WHERE p.delegacion = :delegacion"),
    @NamedQuery(name = "Proyecto.findByEstado", query = "SELECT p FROM Proyecto p WHERE p.estado = :estado"),
    @NamedQuery(name = "Proyecto.findByTipoProyecto", query = "SELECT p FROM Proyecto p WHERE p.tipoProyecto = :tipoProyecto"),
    @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Proyecto.findByFechaFin", query = "SELECT p FROM Proyecto p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Proyecto.findByUsuarioId", query = "SELECT p FROM Proyecto p WHERE p.usuarioId = :usuarioId")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proyectoId")
    @XmlAttribute(required=true)
    private Integer proyectoId;
    @Size(max = 50)
    @Column(name = "codigoPostal")
    @XmlAttribute(required=true)
    private String codigoPostal;
    @Size(max = 200)
    @Column(name = "codigoProyecto")
    @XmlAttribute(required=true)
    private String codigoProyecto;
    @Size(max = 1000)
    @Column(name = "nombre")
    @XmlAttribute(required=true)
    private String nombre;
    @Size(max = 1000)
    @Column(name = "direccion")
    @XmlAttribute(required=true)
    private String direccion;
    @Size(max = 500)
    @Column(name = "colonia")
    @XmlAttribute(required=true)
    private String colonia;
    @Size(max = 500)
    @Column(name = "delegacion")
    @XmlAttribute(required=true)
    private String delegacion;
    @Size(max = 200)
    @Column(name = "estado")
    @XmlAttribute(required=true)
    private String estado;
    @Size(max = 200)
    @Column(name = "tipoProyecto")
    @XmlAttribute(required=true)
    private String tipoProyecto;
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(required=true)
    private Date fechaInicio;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(required=true)
    private Date fechaFin;
    @Column(name = "usuarioId")
    @XmlAttribute(required=true)
    private Integer usuarioId;

    public Proyecto() {
    }

    public Proyecto(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoId != null ? proyectoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proyectoId == null && other.proyectoId != null) || (this.proyectoId != null && !this.proyectoId.equals(other.proyectoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.requisiciones.entidades.Proyecto[ proyectoId=" + proyectoId + " ]";
    }
    
}
