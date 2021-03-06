/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import com.requisiciones.entidades.Requisiciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hector
 */
@Stateless
public class RequisicionesFacade extends AbstractFacade<Requisiciones> {
    @PersistenceContext(unitName = "webServerVigaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequisicionesFacade() {
        super(Requisiciones.class);
    }
    
}
