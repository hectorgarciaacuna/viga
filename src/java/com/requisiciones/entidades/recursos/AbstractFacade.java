/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades.recursos;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author hector
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    javax.persistence.criteria.CriteriaQuery con;
    javax.persistence.Query consulta;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<T> buscarPorDescripcion(String d){
        String sql = "SELECT p FROM Productos p WHERE p.descripcion LIKE :desc OR p.codigo LIKE :desc";
        consulta = getEntityManager().createQuery(sql);
        consulta.setParameter("desc", "%"+d+"%");
        return consulta.getResultList();
    }
    
    public List<T> usuarioLogin(String d,String p){
        String sql = "SELECT u FROM Usuarios u WHERE u.usuarioLogin = :user AND u.usuarioPassword = :pass";
        consulta = getEntityManager().createQuery(sql);
        consulta.setParameter("user", d);
        consulta.setParameter("pass", p);
        return consulta.getResultList();
    }
    
}
