/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.util;

import classes.RequisicionesMovController;
import com.requisiciones.entidades.entidades;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import session.AbstractFacade;
import session.RequisicionesMovFacade;
import session.comboboxEntidadesFacade;

/**
 *
 * @author hector
 */
@ManagedBean
public class comboboxEntidades {
    
    private entidades entidad;
    private List<entidades> proveedores;
    @EJB
    private session.comboboxEntidadesFacade ejbFacade;
        
    @PostConstruct
    public void init(){
        proveedores = getFacade().getProveedores();
    }

    public List<entidades> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<entidades> proveedores) {
        this.proveedores = proveedores;
    }

    public entidades getEntidad() {
        return entidad;
    }

    public void setEntidad(entidades entidad) {
        this.entidad = entidad;
    }
    
    private comboboxEntidadesFacade getFacade() {
        return ejbFacade;
    }
    
}
