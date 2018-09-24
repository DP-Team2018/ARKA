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
import arka.domain.Agent;
import arka.service.AdminServiceLocal;

@Stateless
@Path("/admin")

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class AdminWS {
 @EJB
    AdminServiceLocal adminService;

public AdminWS()  {
	super();
}
 
@GET
public  Response listall(){
	List<Admin> ls=adminService.getAllAdmin();
	 //System.out.print(b);
	if(!ls.isEmpty())
	{	
	return Response.status(Status.OK).entity(ls).build();
	}
	return Response.serverError().build();
}

@GET
@Path("/{id}")
public Response getCamp(@PathParam("id")int id){
	Admin admin=adminService.getAdminById(id);
	if (admin!=null) {
		 return Response.status(Status.FOUND).entity(admin).build();
	}
	return Response.serverError().build();
}

@POST
@Path("/addAdmin/{matricule}/{nom}/{password}/{email}/{adress}/{numTel}")
@Consumes({ MediaType.APPLICATION_JSON })
public Response addCamp(@PathParam("matricule") String matricule,@PathParam("nom") String nom,@PathParam("password") String password,@PathParam("email") String email,@PathParam("adress") String adress,@PathParam("numTel")String numTel){
	
	 Admin a =new Admin();
	    a.setMatricule(matricule);
		a.setNom(nom);
		a.setPassword(password);
		a.setEmail(email);
		a.setAdress(adress);
		a.setNumTel(numTel);
		if(a!=null)
		{
	   adminService.addAdmin(a);
	   return Response.status(Status.OK).entity("ok").build();
		}
			
		return Response.status(Status.NO_CONTENT).build();
		}
/*
 * @PUT
	@Path("/update/{matricule}/{nom}/{email}/{adress}/{numTel}")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAgt(@PathParam("matricule") String matricule,@PathParam("nom") String nom,@PathParam("email") String email,@PathParam("adress") String adress,@PathParam("numTel")String numTel){
		agentservice.updateAgent(matricule, nom, email, adress, numTel);
	  	return Response.ok().build();
	}
 */
@PUT
@Path("/updateadmmin/{id}/{matricule}/{nom}/{email}/{prenom}/{numTel}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response updateAdm(@PathParam("id")int id,@PathParam("matricule") String matricule,@PathParam("nom") String nom,@PathParam("email") String email,@PathParam("prenom") String prenom,@PathParam("numTel")String numTel){
   adminService.updateAdmin(id,matricule, nom, email,prenom, numTel);
  	return Response.ok().build();
}

@DELETE
@Produces({MediaType.APPLICATION_JSON})
@Path("/{id}")
public Response deleteAdm(@PathParam("id") int id){
	  adminService.deleteAdmin(id);
	  return Response.status(Status.OK).entity("ok").build();
}




 
}
