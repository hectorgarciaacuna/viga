package classes;

import com.requisiciones.entidades.Requisiciones;
import classes.util.JsfUtil;
import classes.util.JsfUtil.PersistAction;
import classes.util.comboboxEntidades;
import com.requisiciones.entidades.RequisicionesMov;
import com.requisiciones.entidades.entidades;
import session.RequisicionesFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import session.RequisicionesMovFacade;
import session.comboboxEntidadesFacade;

@ManagedBean(name = "requisicionesController")
@SessionScoped
public class RequisicionesController implements Serializable {

    @EJB
    private session.RequisicionesFacade ejbFacade;
    @EJB
    private session.RequisicionesMovFacade ejbFacadeMov;
    @EJB
    private session.comboboxEntidadesFacade ejbFacadeEntidades;
    
    private List<Requisiciones> items = null;
    public List<RequisicionesMov> itemsMov = null;
    public List<entidades> entidades = null;
    private RequisicionesMov selectedMov;
    private Requisiciones selected;
    private entidades entidad;
    public SelectItem[] selectItems;
    parametros p = new parametros();

    public RequisicionesController() {
    }

    public Requisiciones getSelected() {
        return selected;
    }

    public void setSelected(Requisiciones selected) {
        p.setSeleccion(selected.getTransaccionId());
        //selectItems = getSelectItems();s si
        this.selected = selected;
    }
    
    public entidades getEntidad() {
        return entidad;
    }

    public void setEntidad(entidades entidad) {
        this.entidad = entidad;
    }
    
    public List<entidades> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<entidades> entidades) {
        this.entidades = entidades;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RequisicionesFacade getFacade() {
        return ejbFacade;
    }
    
    private RequisicionesMovFacade getFacadeMov(){
        return ejbFacadeMov;
    }
    
    private comboboxEntidadesFacade getFacadeEntidades(){
        return ejbFacadeEntidades;
    }

    public Requisiciones prepareCreate() {
        selected = new Requisiciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RequisicionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        selected.setEntidadId(p.getEntidadId());
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RequisicionesUpdated"));
        for(int i = 0; i < itemsMov.size(); i++){
            selectedMov = new RequisicionesMov(itemsMov.get(i).getIdr()
                                                ,itemsMov.get(i).getTransaccionId()
                                                ,itemsMov.get(i).getProductoId()
                                                ,itemsMov.get(i).getUmId()
                                                ,itemsMov.get(i).getCantidad()
                                                ,itemsMov.get(i).getEntidadId());
            getFacadeMov().edit(selectedMov);
            //System.out.println("COMBO: "+entidades.get(i).getEntidadId());
        }
        //System.out.println("COMBO: "+p.getEntidadId());
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RequisicionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Requisiciones> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    
    public List<RequisicionesMov> getItemsMov(){
        if (itemsMov == null) {
            //items = getFacade().findAll();
            
            itemsMov = getFacadeMov().findByTransaccionId(String.valueOf(p.getSeleccion()));
        }else{
            itemsMov = getFacadeMov().findByTransaccionId(String.valueOf(p.getSeleccion()));
        }
        return itemsMov;
    }
    
    public List<entidades> getItemsEntidades(){
        if (entidades == null) {
            //items = getFacade().findAll();
            
            entidades = getFacadeEntidades().getProveedores();
        }else{
            entidades = getFacadeEntidades().getProveedores();
        }
        return entidades;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                    //getFacade().modificar(selected, p.getMovimiento().get(0).toString());
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Requisiciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Requisiciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Requisiciones.class)
    public static class RequisicionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RequisicionesController controller = (RequisicionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "requisicionesController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Requisiciones) {
                Requisiciones o = (Requisiciones) object;
                return getStringKey(o.getTransaccionId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Requisiciones.class.getName()});
                return null;
            }
        }

    }

}
