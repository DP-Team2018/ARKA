package restWs;

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

import arka.domain.Admin;
import arka.domain.Site;
import arka.service.SiteServiceLocal;
@Stateless
@Path("/site")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class SiteWS {
@EJB
 SiteServiceLocal site;
	public SiteWS() {
		super();
	}
	
@GET
@Produces({MediaType.APPLICATION_JSON})
public Response listeallsite(){
	List<Site> ls=site.getAllSite();
	if(!ls.isEmpty())
	{	
	return Response.status(Status.OK).entity(ls).build();
	}
	return Response.serverError().build();
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response addSite(Site s){
	site.addSite(s);
	return Response.ok().build();
	
}

@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updat(Site s){
	site.updateSite(s);
  	return Response.ok().build();
}

}
