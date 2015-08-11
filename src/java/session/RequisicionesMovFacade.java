/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import com.requisiciones.entidades.RequisicionesMov;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hector
 */
@Stateless
public class RequisicionesMovFacade extends AbstractFacade<RequisicionesMov> {
    @PersistenceContext(unitName = "webServerVigaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequisicionesMovFacade() {
        super(RequisicionesMov.class);
    }
    
}
