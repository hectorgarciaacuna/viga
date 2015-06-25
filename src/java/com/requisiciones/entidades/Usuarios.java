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
@Table(name = "usuarios")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuarioId", query = "SELECT u FROM Usuarios u WHERE u.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuarios.findByUsuarioNombre", query = "SELECT u FROM Usuarios u WHERE u.usuarioNombre = :usuarioNombre"),
    @NamedQuery(name = "Usuarios.findByUsuarioCorreo", query = "SELECT u FROM Usuarios u WHERE u.usuarioCorreo = :usuarioCorreo"),
    @NamedQuery(name = "Usuarios.findByUsuarioLogin", query = "SELECT u FROM Usuarios u WHERE u.usuarioLogin = :usuarioLogin AND u.usuarioPassword = :usuarioPassword"),
    @NamedQuery(name = "Usuarios.findByUsuarioPassword", query = "SELECT u FROM Usuarios u WHERE u.usuarioPassword = :usuarioPassword"),
    @NamedQuery(name = "Usuarios.findByPerfilId", query = "SELECT u FROM Usuarios u WHERE u.perfilId = :perfilId"),
    @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuarioId")
    @XmlAttribute(required=true)
    private Integer usuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "usuarioNombre")
    @XmlAttribute(required=true)
    private String usuarioNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "usuarioCorreo")
    @XmlAttribute(required=true)
    private String usuarioCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "usuarioLogin")
    @XmlAttribute(required=true)
    private String usuarioLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "usuarioPassword")
    @XmlAttribute(required=true)
    private String usuarioPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "perfilId")
    @XmlAttribute(required=true)
    private int perfilId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    @XmlAttribute(required=true)
    private boolean activo;
    public static String INICIAR_SESION = "SELECT id FROM usuarios";

    public Usuarios() {
    }

    public Usuarios(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuarios(Integer usuarioId, String usuarioNombre, String usuarioCorreo, String usuarioLogin, String usuarioPassword, int perfilId, boolean activo) {
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.usuarioCorreo = usuarioCorreo;
        this.usuarioLogin = usuarioLogin;
        this.usuarioPassword = usuarioPassword;
        this.perfilId = perfilId;
        this.activo = activo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public int getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.requisiciones.entidades.Usuarios[ usuarioId=" + usuarioId + " ]";
    }
    
}
