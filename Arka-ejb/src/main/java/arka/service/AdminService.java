package arka.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import arka.domain.Admin;
import arka.domain.Agent;

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
 	   return  em.createQuery("SELECT a FROM Admin a",Admin.class).getResultList();
 	  
    }
    
    public Admin getAdminById(int id){
 	   Admin admin=  em.find(Admin.class, id);
 	  
 	   return admin;

  
 	      }
    
    public void addAdmin(Admin a){
 	 em.merge(a);
 	  em.flush();
 	  
  
 	      }

	@Override
	public void updateAdmin(int id,String matricule,String nom,String email,String prenom,String numTel) {
		Admin a = em.find(Admin.class, id);
		a.setMatricule(matricule);
		a.setNom(nom);
		a.setEmail(email);
		a.setAdress(prenom);
		a.setNumTel(numTel);
		em.merge(a); 
		
	}
	public void updateAgent(String matricule,String nom,String email,String prenom,String numTel) {
		Agent a = em.find(Agent.class, matricule);
		a.setNom(nom);
		a.setEmail(email);
		a.setPrenom(prenom);
		a.setNumTel(numTel);
		em.merge(a);
		
	}

	@Override
	public void deleteAdmin(int id) {
		Admin a = em.find(Admin.class, id);
		//emt.getTransaction().begin();
		  em.remove(a);
	    // emt.getTransaction().commit();
		
	}

}
