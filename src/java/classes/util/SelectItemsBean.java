/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.util;

import classes.parametros;
import com.requisiciones.entidades.entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import session.SelectedItemsBeanFacade;

/**
 *
 * @author hector
 */
@ManagedBean
@ViewScoped
public class SelectItemsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // 3 different forms of the defining data to which SelectItems can bind.
    private List<SelectItem> proveedores;

    private String proveedor;
    
    parametros p;
    
    @EJB
    private session.SelectedItemsBeanFacade ejbFacade;

    @PostConstruct
    public void init() {
        proveedores = getProveedores();
        p = new parametros();
        //proveedores = getFacade().getProveedores();
        /*proveedores = new ArrayList<>();
        proveedores.add(new proveedores(1,"Hector"));
        proveedores.add(new proveedores(2,"Felix"));*/

    }
    
    private SelectedItemsBeanFacade getFacade(){
        return ejbFacade;
    }
    
    public List<SelectItem> getProveedores() {
        if(proveedores == null){
            proveedores = new ArrayList<SelectItem>();
            List<entidades> e = getFacade().getProveedores();
            for(entidades p : e){
                proveedores.add(new SelectItem(p.getEntidadId(),p.getNombre()));
            }
        }
        return proveedores;
    }

    public void setProveedores(List<SelectItem> proveedores) {
        this.proveedores = proveedores;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        p.setEntidadId(Integer.parseInt(proveedor));
        this.proveedor = proveedor;
    }
    
}
