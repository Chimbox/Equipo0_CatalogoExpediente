/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import equipo0_dominio.Paciente;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import negocios.FactoryNegocios;
import negocios.INegociosExp;

/**
 * REST Web Service
 *
 * @author Alfonso Felix
 */
@Path("exp")
public class ExpedientesResource {

    private final INegociosExp negocios;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ExpedientesResource
     */
    public ExpedientesResource() {
        negocios=FactoryNegocios.getFachadaExpedientes();
    
    }
    
    @POST
    @Path("/consultaexpediente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postConsultaExpediente(String json){
        
        Gson gson=new GsonBuilder().create();
        
        Paciente paciente=gson.fromJson(json, Paciente.class);
        json=gson.toJson(negocios.consultarExpediente(paciente.getId()));
        return json;
    }
}
