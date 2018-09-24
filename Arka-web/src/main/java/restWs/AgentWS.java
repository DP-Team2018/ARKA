package restWs;

import java.util.List;

import javax.ejb.EJB;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.json.*;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import javax.ws.rs.core.Response.Status;


import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Location;
import arka.service.AgentServiceLocal;
@Stateless
@Path("/user")

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class AgentWS {
	  @EJB
	  AgentServiceLocal agentservice;
	      
	  public AgentWS(){
		  super();
		  }
	  
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public  Response listallAgent(){
	  	List<Agent> ls = agentservice.getAllAgent();
	  	if (ls!= null){
	  		return Response.status(Status.OK).entity(ls).build();
	  	}
	  	return Response.status(Status.NO_CONTENT).build();
	  }

	  @POST
	  @Path("/add/{matricule}/{nom}/{password}/{email}/{prenom}/{numTel}")
	  @Consumes({ MediaType.APPLICATION_JSON })
	  public Response addCamp(@PathParam("matricule") String matricule,@PathParam("nom") String nom,@PathParam("password") String password,@PathParam("email") String email,@PathParam("prenom") String prenom,@PathParam("numTel")String numTel){
		  Agent agent =new Agent();
		  agent.setMatricule(matricule);
			agent.setNom(nom);
			agent.setPassword(password);
			agent.setEmail(email);
			agent.setPrenom(prenom);
			agent.setNumTel(numTel);
		agentservice.addagent(agent);
				return Response.status(Status.OK).entity("ok").build();
			
		}
		  	
	  	
	 
	 
	  @DELETE
	  @Produces({MediaType.APPLICATION_JSON})
	  @Path("/delete/{id}")
	  public Response deleteAgt(@PathParam("id") int idAgent){
		  agentservice.deleteAgent( idAgent);
	  	//return Response.ok().build();
		  return Response.status(Status.OK).entity("ok").build();
	  }

	@GET
	@Path("/{idAgent}")
	public Response getagent(@PathParam("idAgent")int idAgent){
			Agent agent=agentservice.getAgentbyMat(idAgent);
			if (agent!=null) {
				 return Response.status(Status.FOUND).entity(agent).build();
			}
			return Response.serverError().build();
		}

	@PUT
	@Path("/update/{id}/{matricule}/{nom}/{email}/{adress}/{numTel}")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAgt(@PathParam("id")int id,@PathParam("matricule") String matricule,@PathParam("nom") String nom,@PathParam("email") String email,@PathParam("adress") String adress,@PathParam("numTel")String numTel){
		agentservice.updateAgent(id,matricule, nom, email, adress, numTel);
	  	return Response.ok().build();
	}
}
