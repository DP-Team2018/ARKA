package restWs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import javax.ws.rs.core.Response.Status;

import arka.domain.Demand;
import arka.domain.DemandType;
import arka.service.DemandeService;


@Stateless
@Path("/demandes")

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class DemandeResource {

	private static List<Demand> demandes = new ArrayList<Demand>();
	
	@EJB
	DemandeService ds ;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showDemandes(){
		demandes = ds.getDemands(); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showById(@PathParam("id") int id){
		Demand demande = ds.getDemandById(id); 
		if(demande!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	
	
	@GET
	@Path("{Type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DisplayByType(@PathParam("Type") DemandType demandType){
		List<Demand> demandes = ds.getDemandsByType(demandType); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("{Date}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DisplayByType(@PathParam("Date") Date date){
		List<Demand> demandes = ds.getDemandsByDate(date); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	
	
}
	

