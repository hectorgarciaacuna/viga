/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import com.requisiciones.entidades.entidades;
import com.requisiciones.entidades.proveedores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hector
 */
@Stateless
public class SelectedItemsBeanFacade extends AbstractFacade<entidades>{
    @PersistenceContext(unitName = "webServerVigaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public SelectedItemsBeanFacade(){
        super(entidades.class);
    }
    
}
