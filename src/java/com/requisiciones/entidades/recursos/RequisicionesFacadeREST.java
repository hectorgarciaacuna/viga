/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades.recursos;

import com.requisiciones.entidades.Requisiciones;
import java.sql.Date;
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
@Path("requisiciones")
public class RequisicionesFacadeREST extends AbstractFacade<Requisiciones> {
    @PersistenceContext(unitName = "webServerVigaPU")
    private EntityManager em;
    private Requisiciones req;

    public RequisicionesFacadeREST() {
        super(Requisiciones.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Requisiciones entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Requisiciones entity) {
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
    public Requisiciones find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Requisiciones> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Requisiciones> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Requisiciones crearRequisicion(MultivaluedMap<String,String> params){
        req = new Requisiciones();
        
        String transaccionId = params.getFirst("transaccionId");
        String folio = params.getFirst("folio");
        String fecha = params.getFirst("fecha");
        String proyectoId = params.getFirst("proyectoId");
        String usuarioId = params.getFirst("usuarioId");
        String comentario = params.getFirst("comentarios");
        
        req.setTransaccionId(Integer.parseInt(transaccionId));
        req.setFolio(folio);
        //req.setFecha(Date.valueOf(fecha));
        req.setProyectoId(Integer.parseInt(proyectoId));
        req.setUsuarioId(Integer.parseInt(usuarioId));
        req.setComentario(comentario);
        create(req);
        
        return req;
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
