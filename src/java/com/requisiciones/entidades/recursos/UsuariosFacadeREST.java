/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.requisiciones.entidades.recursos;

import com.requisiciones.entidades.Usuarios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
@Path("usuarios")
public class UsuariosFacadeREST extends AbstractFacade<Usuarios> {
    @PersistenceContext(unitName = "webServerVigaPU")
    private EntityManager em;
    
    @Resource(name = "conexionDB")
    private DataSource conexionDB;

    public UsuariosFacadeREST() {
        super(Usuarios.class);
    }
    
    private Connection getConexion(){
        
        Connection con= null;
        try{
            con = conexionDB.getConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    return con;
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Usuarios entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuarios entity) {
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
    public Usuarios find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Usuarios> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Usuarios> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("log/{usuarioLogin}/{contrasena}")
    @Produces("application/xml")
    public String getusuarioLogin(@PathParam("usuarioLogin") String usuarioLogin,@PathParam("contrasena") String contrasena) {
        
        Connection c = null;
        String resultado = "0";
        try{
            c = getConexion();
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM usuarios WHERE usuarioLogin = '"+usuarioLogin+"' AND usuarioPassword = '"+contrasena+"'");
            
            while(res.next()){
                if(res.isFirst()){
                    resultado = res.getString("usuarioNombre");
                }
            }
            res.close();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "<usuarios><resultado login = \""+resultado+"\" /></usuarios>";
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
