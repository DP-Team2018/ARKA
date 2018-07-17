package restWs;

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import arka.domain.Admin;

@ApplicationPath("/Admin")
@Path("/AdminService")
public class AdminWS  extends Application{
	@GET
   @Path("/sayHello")
	
public String getHelloMessage(){
		
        AdminBean adminBean= new AdminBean();

		return ("empty"); 
}
}
