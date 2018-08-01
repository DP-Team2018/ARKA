package arka.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public void deleteAgent(String matricule) {
		Agent a = em.find(Agent.class, matricule);
		  em.remove(a);
	    
	}

	@Override
	public void updateAgent(Agent agent) {
		em.merge(agent);
		
	}

	@Override
	public Agent getAgentbyMat(String matricule) {
		  Agent agent=  em.find(Agent.class, matricule);
	 	   return agent;
	}

	@Override
	public void addagent(Agent a) {
		em.persist(a);
		
	}

}
