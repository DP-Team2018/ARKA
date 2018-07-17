package arka.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import arka.domain.Admin;

/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService implements AdminServiceRemote, AdminServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
    EntityManager em;
    public AdminService() {
        
    	
    	
    }
    
   public List<Admin> getAllAdmin(){
	   
	   List<Admin> admins=  em.createQuery("from Admin").getResultList();;
	      
    	return admins;
    	
    }

}
