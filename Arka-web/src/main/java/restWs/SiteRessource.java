package restWs;

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
import arka.domain.Site;
import arka.service.CartonService;
import arka.service.EmplacementService;
import arka.service.SiteService;

@SessionScoped
@Path("site")
public class SiteRessource {
	private static List<Site> sites = new ArrayList<Site>();
	
	@EJB
	SiteService siteservice;
	@EJB
	EmplacementService emplacementservice;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displaySite()
	{
		sites=siteservice.getAllSite();
		if(sites!=null)
		{
			return Response.status(Status.OK).entity(sites).build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@GET
	@Path("/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchSite(@PathParam("nom") String nom)
	{
		sites=siteservice.Rechercher_site_avec_nom(nom);
		if(sites!=null)
		{
			return Response.status(Status.OK).entity(sites).build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@POST
	@Path("/{nom}/{addresse}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add_Site(@PathParam("nom") String nom,@PathParam("addresse") String addresse) throws ParseException
	{
		
        Site site=new Site();
        site.setName(nom);
        site.setAddress(addresse);
		
		if(siteservice.addSite(site)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@POST
	@Path("/affect/{idlocation}/{idsite}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response affect_location_to_site(@PathParam("idlocation") int idlocation,@PathParam("idsite") int idsite)
	{
		Location location =new Location();
		location=emplacementservice.rechercher_emplacement_avec_id(idlocation);
		Site site=new Site();
		site=siteservice.Rechercher_site_avec_id(idsite);
		if(siteservice.Affecter_emplacement_ausite(site, location)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
	}
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete_site(@PathParam("id") int id)
	{
		Site site=siteservice.Rechercher_site_avec_id(id);
		if(siteservice.supprimer_site(site)==true)
		{
			return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NOT_FOUND).build();
		
		}
}
