package restWs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import arka.domain.Admin;
import arka.domain.Report;
import arka.service.ReportService;
import arka.service.ReportServiceLocal;

@Stateless
@Path("/Report")

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ReportWS {
    @EJB
    ReportServiceLocal reportServiceLocal;
    
    
    @GET
    public  Response listall(){
    	List<Report> ls=reportServiceLocal.findAll();
    	 //System.out.print(b);
    	if(ls!= null)
    	{	
    	return Response.status(Status.OK).entity(ls).build();
    	}
    	return Response.serverError().build();
    }
}
