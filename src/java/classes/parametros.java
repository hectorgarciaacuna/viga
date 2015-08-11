/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.requisiciones.entidades.RequisicionesMov;
import java.util.List;

/**
 *
 * @author hector
 */
public class parametros {
    public static int seleccion;
    public static int entidadId;
    
    public void setSeleccion(int s){
        seleccion = s;
    }
    public int getSeleccion(){
        return seleccion;
    }

    public static int getEntidadId() {
        return entidadId;
    }

    public static void setEntidadId(int e) {
        entidadId = e;
    }
    
    
    
    
}
