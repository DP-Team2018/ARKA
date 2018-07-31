package restWs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	EmplacementService emplacementservice;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayLocation()
	{
		locations=emplacementservice.afficher_emplacement();
		if(locations!=null)
		{
			return Response.status(Status.OK).entity(locations).build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@GET
	@Path("/{codecarton}/{id_client}/{date_entree}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetLocation_by_(@PathParam("codecarton") int codecarton,@PathParam("id_client") int id_client,@PathParam("date_entree") String date_entree) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(date_entree);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		locations=emplacementservice.rechercher_emplacement_carton(codecarton, id_client, parsed);
		if(locations!=null)
		{
			return Response.status(Status.OK).entity(locations).build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@POST
	@Path("/{line}/{row}/{driveway}/{empty}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add_Location(@PathParam("line") int line,@PathParam("row") int row,@PathParam("driveway") int driveway,@PathParam("empty") boolean empty)
	{
		Location location=new Location();
		location.setLine(line);
		location.setRow(row);
		location.setDriveway(driveway);
		location.setEmpty(empty);
		if(emplacementservice.ajouter_emplacement(location)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete_emplacement(@PathParam("id") int id)
	{
		Location location=emplacementservice.rechercher_emplacement_avec_id(id);
		if(emplacementservice.supprimer_emplacement(location)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NOT_FOUND).build();
		
		}
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLocation(Location location)
	{
		
		if(emplacementservice.ajouter_emplacement(location)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
}
