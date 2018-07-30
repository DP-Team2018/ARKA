package restWs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
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
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import utilities.SendMail;

import javax.ws.rs.core.Response.Status;

import arka.domain.Agent;
import arka.domain.Demand;
import arka.domain.DemandState;
import arka.domain.DemandType;
import arka.service.DemandeService;


@Stateless
@Path("/demandes")

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class DemandeResource {

	private static List<Demand> demandes = new ArrayList<Demand>();
	private final String KEY_B64 = Base64.getEncoder().encodeToString("secret".getBytes());
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
			return Response.status(Status.OK).entity(demande).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	
	
	@GET
	@Path("type/{Type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayByType(@PathParam("Type") DemandType demandType){
		List<Demand> demandes = ds.getDemandsByType(demandType); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("date/{Date}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayByDate(@PathParam("Date") String date) throws ParseException{
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date parsed = format.parse(date);
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		List<Demand> demandes = ds.getDemandsByDate(parsed); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	
//	Jws<Claims> jws = null;
//	jws = Jwts.parser().setSigningKey(Base64.getDecoder().decode(KEY_B64)).parseClaimsJws(token);
//	int iduser = Integer.parseInt(jws.getBody().get("id").toString());
   
	@GET
	@Path("/changeDemandState/{state}/{idDemand}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DisplayByDate(@PathParam("Date") Date date){
		List<Demand> demandes = ds.getDemandsByDate(date); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("{State}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DisplayByState(@PathParam("State") DemandState state){
		List<Demand> demandes = ds.getDemandsByState(state); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("{Agent}/{Demand}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response AffectDemande(@PathParam("Agent") int idAgent, @PathParam("Demand") int idDemande){
		Demand demandeAffecte = ds.affecterDemande(idAgent, idDemande); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity("agent affecté à la demande" + demandeAffecte).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("{Client}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DisplayByClient(@PathParam("Client") int idClient){
		List<Demand> demandes = ds.getDemandsByCLient(idClient); 
		if(demandes!=null)
		{
			return Response.status(Status.OK).entity(demandes).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
//	@GET
//	@Path("{Demand}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response DeleteDemand(@PathParam("Demand") int idDemand){
//		List<Demand> demandes = ds.deleteDemand(idDemand);
//		if(demandes!=null)
//		{
//			return Response.status(Status.OK).entity(demandes).build();
//		}
//		return Response.status(Status.NO_CONTENT).build();
//	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response AddDemand(Demand demande) 
	{
		if( demande == null){
			return Response.status(Status.NO_CONTENT).build();
		}
		ds.addDemand(demande);
		return Response.status(Status.OK).entity(demande).build();
	}
	
	
}
	

