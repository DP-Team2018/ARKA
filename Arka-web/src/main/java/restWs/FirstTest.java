//package restWs;
//
//
//import java.util.List;
//
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.ws.rs.ApplicationPath;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.Application;
//
//import arka.domain.Admin;
//import arka.service.AdminService;
//import arka.service.AdminServiceLocal;
//import arka.service.AdminServiceRemote;
//@Stateless
//@ApplicationPath("/test")
//@Path("/myService")
//public class FirstTest extends Application {
//     /*
//      * path /localhost:18080/Arka-web/test/myService/sayHello
//      * */
//	
//	@EJB
//	AdminService adminService;
//	
//	@GET
//	@Path("/sayHello")
//	public String getHelloMessage(){
//		adminService = new AdminService();

//		 return ("empty");
//	}
//}
