/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades.recursos;

import com.requisiciones.entidades.RequisicionesMov;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author hector
 */
@Stateless
@Path("requisicionesmov")
public class RequisicionesMovFacadeREST extends AbstractFacade<RequisicionesMov> {
    @PersistenceContext(unitName = "webServerVigaPU")
    private EntityManager em;
    public RequisicionesMov reqm;

    public RequisicionesMovFacadeREST() {
        super(RequisicionesMov.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(RequisicionesMov entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, RequisicionesMov entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public RequisicionesMov find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<RequisicionesMov> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<RequisicionesMov> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public RequisicionesMov crearDetalleRequisicion(MultivaluedMap<String,String> params){
        reqm = new RequisicionesMov();
        String transaccionId = params.getFirst("transaccionId");
        String productoId = params.getFirst("productoId");
        String umId = params.getFirst("umId");
        String cantidad = params.getFirst("cantidad");
        
        reqm.setTransaccionId(Integer.valueOf(transaccionId));
        reqm.setProductoId(Integer.valueOf(productoId));
        reqm.setUmId(Integer.valueOf(umId));
        reqm.setCantidad(Float.valueOf(cantidad));
        create(reqm);
            
        return reqm;
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
