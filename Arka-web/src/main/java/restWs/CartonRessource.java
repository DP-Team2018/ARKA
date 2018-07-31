package restWs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import arka.domain.Carton;
import arka.domain.Location;
import arka.service.CartonService;
import arka.service.EmplacementService;

@SessionScoped
@Path("carton")
public class CartonRessource {

	private static List<Carton> cartons = new ArrayList<Carton>();
	@EJB
	CartonService cartonservice;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayCarton()
	{
		cartons=cartonservice.afficher_carton();
		if(cartons!=null)
		{
			return Response.status(Status.OK).entity(cartons).build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLocation(Carton carton)
	{
		
		if(cartonservice.ajoutercarton(carton)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
}
