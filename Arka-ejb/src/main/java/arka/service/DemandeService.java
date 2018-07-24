package arka.service;

import arka.domain.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class DemandeService
 */
@Stateless
@LocalBean
public class DemandeService implements DemandeServiceRemote, DemandeServiceLocal {
	@PersistenceContext
	private EntityManager entityManager; 
    /**
     * Default constructor. 
     */
    public DemandeService() {
    	
    }
    
    public List<Demand> getDemands()
    {
    	return entityManager.createQuery("SELECT d FROM Demand d ",Demand.class).getResultList();
    }
    @Override
    public void getNotifs(Demand demande)
    {
    	entityManager.persist(demande); 	
    }
    
    @Override
    public void addDemand(Demand demande)
    {
    	entityManager.persist(demande);
    }

	@Override
	public void updateDemand(Demand demand) {
		
	}

	@Override
	public void deleteDemand(Demand demande) {
		entityManager.remove(entityManager.merge(demande));
		
	}

	@Override
	public Demand getDemandById(int id) {
		return entityManager.createQuery("Select d from Demand d where d.idDemand=?1", Demand.class)
				.setParameter(1,id).getSingleResult();
		
	}

	@Override
	public boolean affecterDemande(Agent agent, List<Demand> demandes) {
		agent.setDemandes(demandes);
		entityManager.persist(agent);
		return true;
	}

}
