package restWs;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonValue;

import arka.domain.Admin;
import arka.domain.Agent;
import arka.service.AuthServiceLocal;

@Stateless
@Path("/auth")

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class auth {
@EJB 
AuthServiceLocal authservice;
	public auth() {
		super();
	}

	@POST
	@Path("{e}/{p}")
	@Produces({MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON })
	
	public Response log(@PathParam("e") String e,@PathParam("p") String p){
	
		String R=authservice.verif(e, p);
	
			return Response.status(Status.OK).entity(R ).build();
		
	
		
	}
	
	
}
