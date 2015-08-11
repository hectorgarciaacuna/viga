/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.util;

import com.requisiciones.entidades.Requisiciones;
import com.requisiciones.entidades.entidades;
import com.requisiciones.entidades.proveedores;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author hector
 */
@FacesConverter("comboboxConverter")
public class comboboxConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null){
            try {
                return value;
            } catch (Exception e) {
                throw new ConverterException(e);
            }
        }else{
            return null;
        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            try {
                //entidades e = (entidades)value;
                //e.setEntidadId(Integer.valueOf(value.toString()));
                //return String.valueOf(e.getEntidadId());
                Integer id = (value instanceof Requisiciones) ? ((Requisiciones) value).getEntidadId() : null;
                return (id != null) ? id.toString() : null;
                //return value.toString();
            } catch (Exception e) {
                throw new ConverterException(e);
            }
        }
        else {
            return null;
        }
    }
    
}
