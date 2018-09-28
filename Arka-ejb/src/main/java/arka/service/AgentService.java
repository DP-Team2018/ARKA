package arka.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;

import arka.domain.Admin;
import arka.domain.Agent;

/**
 * Session Bean implementation class AgentService
 */
@Stateless
@LocalBean
public class AgentService implements AgentServiceRemote, AgentServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
    EntityManager em;
    public AgentService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Agent> getAllAgent() {
		 return  em.createQuery("SELECT a FROM Agent a",Agent.class).getResultList();
		
	}

	@Override
	public void deleteAgent(int idAgent) {
		Agent a = em.find(Agent.class, idAgent);
		  em.remove(a);
	    
	}

	@Override
	public void updateAgent(int id,String matricule,String nom,String email,String prenom,String numTel) {
		Agent a = em.find(Agent.class, id);
		a.setMatricule(matricule);
		a.setNom(nom);
		a.setEmail(email);
		a.setPrenom(prenom);
		a.setNumTel(numTel);
		em.merge(a);
		
	}

	@Override
	public Agent getAgentbyMat(int idAgent) {
		  Agent agent=  em.find(Agent.class, idAgent);
	 	   return agent;
	}

	@Override
	public void addagent(Agent a) {
		em.merge(a);
	
		
	}

}
