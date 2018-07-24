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

import arka.domain.Location;
import arka.service.EmplacementService;

@SessionScoped
@Path("location")
public class Emplacement {
	private static List<Location> locations = new ArrayList<Location>();
	@EJB
	EmplacementService emp;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayLocation()
	{
		locations=emp.afficher_emplacement();
		if(locations!=null)
		{
			return Response.status(Status.OK).entity(locations).build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLocation(Location location)
	{
		
		if(emp.ajouter_emplacement(location)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
}
