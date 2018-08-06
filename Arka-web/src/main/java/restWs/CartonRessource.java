package restWs;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import arka.domain.Carton;
import arka.domain.Client;
import arka.domain.Location;
import arka.service.CartonService;
import arka.service.EmplacementService;

@SessionScoped
@Path("carton")
public class CartonRessource {

	private static List<Carton> cartons = new ArrayList<Carton>();
	@EJB
	CartonService cartonservice;
	@EJB
	EmplacementService emplacementservice;
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
	@Path("/{idCartonClient}/{arrivalDate}/{destructionDate}/{duration}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add_Carton(@PathParam("idCartonClient") int idCartonClient,@PathParam("arrivalDate") String arrivalDate,@PathParam("destructionDate") String destructionDate,@PathParam("duration") long duration) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed =  (Date) format.parse(arrivalDate);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        
        SimpleDateFormat formt = new SimpleDateFormat("yyyy-MM-dd");
        Date pars =  (Date) formt.parse(destructionDate);
        java.sql.Date sql_date = new java.sql.Date(pars.getTime());
        
		Carton carton=new Carton();
		carton.setIdCartonClient(idCartonClient);
		carton.setArrivalDate(sql);
		carton.setDestructionDate(sql_date);
		carton.setDuration(duration);
		if(cartonservice.detruire_carton(carton)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@POST
	@Path("/{idcarton}/{idlocation}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response affect_Carton_to_Location(@PathParam("idcarton") int idcarton,@PathParam("idlocation") int idlocation)
	{
		Carton carton =new Carton();
		carton=cartonservice.rechercher_carton_avec_id(idcarton);
		Location location=new Location();
		location=emplacementservice.rechercher_emplacement_avec_id(idlocation);
		if(cartonservice.affectercarton_au_emplacement(carton, location)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@POST
	@Path("/{idcarton}/{idclient}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response affect_Carton_to_Client(@PathParam("idcarton") int idcarton,@PathParam("idclient") int idclient)
	{
		Carton carton =new Carton();
		carton=cartonservice.rechercher_carton_avec_id(idcarton);
		Client client=new Client();
		client=cartonservice.rechercher_client_avec_id(idclient);
		if(cartonservice.affectercarton_au_client(carton, client)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete_carton(@PathParam("id") int id)
	{
		Carton carton=cartonservice.rechercher_carton_avec_id(id);
		if(cartonservice.detruire_carton(carton)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NOT_FOUND).build();
		
		}
}
