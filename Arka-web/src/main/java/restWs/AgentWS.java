package restWs;

import java.util.List;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.json.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import javax.ws.rs.core.Response.Status;


import arka.domain.Agent;
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
	  @Consumes({ MediaType.APPLICATION_JSON })
	  public Response addCamp(Agent  a){
		  agentservice.addagent(a);
	  	return Response.ok().build();
	  }
	 
	  @DELETE
	  @Produces({MediaType.APPLICATION_JSON})
	  @Path("{id}")
	 
	  public Response deleteAgt(@PathParam("id") String matricule){
		 agentservice.getAgentbyMat(matricule);
		  agentservice.deleteAgent(matricule);
	  	//return Response.ok().build();
	  	return Response.status(Status.NO_CONTENT).build();
	  }

	@GET
	@Path("/{matricule}")
	public Response getagent(@PathParam("matricule")String matricule){
			Agent agent=agentservice.getAgentbyMat(matricule);
			if (agent!=null) {
				 return Response.status(Status.FOUND).entity(agent).build();
			}
			return Response.serverError().build();
		}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAgt(Agent a){
		
		agentservice.updateAgent(a);
	  	return Response.ok().build();
	}
}
