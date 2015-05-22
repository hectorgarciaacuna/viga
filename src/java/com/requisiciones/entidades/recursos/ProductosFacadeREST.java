/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades.recursos;

import com.requisiciones.entidades.Productos;
import java.sql.Connection;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author hector
 */
@Stateless
@Path("productos")
public class ProductosFacadeREST extends AbstractFacade<Productos> {
    @PersistenceContext(unitName = "webServerVigaPU")
    private EntityManager em;
    

    public ProductosFacadeREST() {
        super(Productos.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Productos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Productos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    /*@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Productos find(@PathParam("id") Integer id) {
        return super.find(id);
    }*/

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Productos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Productos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("{descripcion}")
    @Produces({"application/xml", "application/json"})
    public List<Productos> buscarProducto(@PathParam("descripcion") String d) {
        return super.buscarPorDescripcion(d);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
