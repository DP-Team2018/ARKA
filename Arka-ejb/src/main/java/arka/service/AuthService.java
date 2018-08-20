package arka.service;

import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class AuthService
 */
import arka.domain.Agent;
import arka.domain.Admin;
@Stateless
@LocalBean
public class AuthService implements AuthServiceRemote, AuthServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public AuthService() {
        // TODO Auto-generated constructor stub
    }
   @Override
    public Agent  verifAgent(String e,String a){
	   return  em.createQuery("Select a FROM Agent a  WHERE a.email=?3 and a.password=?6",Agent.class).setParameter(3,e ).setParameter(6,a).getSingleResult();	
}
    @Override
     public Admin  verifAdmin(String e,String a){
	    return  em.createQuery("Select a from Admin a WHERE a.email=?3 and a.password=?6" ,Admin.class).setParameter(3,e ).setParameter(6,a).getSingleResult();
		
	
    }
    @Override
    public String verif (String e , String a){
    	//Agent ag= em.createQuery("Select a FROM Agent a  WHERE a.email=?3 and a.password=?6",Agent.class).setParameter(3,e ).setParameter(6,a).getSingleResult();	
       //Admin ad= verifAdmin(e, a);
    	String R="";
   
    	List<Agent> list = em.createQuery("Select a FROM Agent a  WHERE a.email=?3 and a.password=?6",Agent.class).setParameter(3,e ).setParameter(6,a).getResultList();
        if (list.isEmpty()) {
        	Admin ad= em.createQuery("Select a from Admin a WHERE a.email=?3 and a.password=?6" ,Admin.class).setParameter(3,e ).setParameter(6,a).getSingleResult();
    		if(ad!=null){R="true admin";
        			
        		}
        }
        
    		
    	else {
    		R="true agent";}
    	
    	
    	return R;
    }
}
