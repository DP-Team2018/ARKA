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
import arka.domain.Client;
import arka.service.AdminServiceLocal;
import arka.service.CartonServiceLocal;
import arka.service.ClientServiceLocal;


@Stateless
@Path("/client")

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ClientWS {
@EJB
	    ClientServiceLocal CS;
	public ClientWS() {
		super();
	}
	@GET
	
	
	public  Response listallclient(){
		List<Client> ls=CS.getAllClient();
		 //System.out.print(b);
		if(!ls.isEmpty())
		{	
		return Response.status(Status.OK).entity(ls).build();
		}
		return Response.serverError().build();
	}
	
	

   @POST
   @Path("/addCLient/{code}/{nom}/{password}/{email}/{nomresp}/{numTel}")
   @Consumes({ MediaType.APPLICATION_JSON })
     public Response addc(@PathParam("code") String code,@PathParam("nom") String nom,@PathParam("password") String password,@PathParam("email") String email,@PathParam("nomresp") String nomresp,@PathParam("numTel")String numTel){
	
	Client client =new Client();
	client.setCodeClient(code);
	client.setNom(nom);
	client.setPassword(password);
	client.setEmail(email);
	client.setNomResp(nomresp);
	client.setNumTel(numTel);
		if(client!=null)
		{
	   CS.addClient(client);
	   return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
		}


   @DELETE
   @Produces({MediaType.APPLICATION_JSON})
   @Path("/{idclient}")
   public Response deleteC(@PathParam("idclient") int idclient){
	  CS.deleteClient(idclient);
	return Response.ok().build();
	//return Response.status(Status.NO_CONTENT).build();
}
}
