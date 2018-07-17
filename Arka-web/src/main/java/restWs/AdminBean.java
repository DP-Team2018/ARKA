package restWs;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;


import arka.domain.Admin;
import arka.service.AdminService;

@ManagedBean
@RequestScoped
public class AdminBean {
		
	@EJB
	AdminService adminService;
	List<Admin>admins;
	
	 @PostConstruct
		private void init(){
		 admins= adminService.getAllAdmin(); 
		 for (Admin admin : admins) {
			System.out.println("yeeeeeeeeeeeeeeeeeeeeeeeeeeeeeees");
		}
	 }

	public List<Admin> getAdmins() {
		return adminService.getAllAdmin();
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	 
	 
	 
	 
	 
}
