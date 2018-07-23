package restWs;

import java.util.ArrayList;
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
import javax.ws.rs.core.Response;



import javax.ws.rs.core.Response.Status;

import arka.domain.Admin;
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
public Response addCamp(Admin a){
	adminService.addAdmin(a);
	return Response.ok().build();
}




 
 
}
