package arka.service;

import arka.domain.*;

import java.util.ArrayList;
import java.util.Date;
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
    @Override
    public List<Demand> getDemands()
    {
    	return entityManager.createQuery("SELECT d FROM Demand d ",Demand.class).getResultList();
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
		return entityManager.find(Demand.class, id);
		
	}

	@Override
	public boolean affecterDemande(Agent agent, List<Demand> demandes) {
		agent.setDemandes(demandes);
		entityManager.persist(agent);
		return true;
	}


	@Override
	public void affecterCartonDemand(Carton carton, Demand demand) {
		demand.setCarton(carton);
		entityManager.merge(demand);
		
	}

	@Override
	public List<Demand> getDemandsByCLient(int idClient) {
		Client client= entityManager.find(Client.class, idClient);
		List<Demand> demands = client.getDemands();
		return demands;
	}

	@Override
	public List<Demand> getDemandsByCLient(Client client) {
		List<Demand> demands = client.getDemands();
		return demands;
	}

	@Override
	public List<Demand> getDemandsByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Demand> getDemandsByEtat(DemandType demanType) {
		
		return null;
	}

	@Override
	public List<Demand> getDemandsByState(DemandState demandState) {

		List<Demand> demandes = entityManager.createQuery("SELECT d FROM Demand d WHERE d.demandState=?1",Demand.class)
				.setParameter(1,demandState)
				.getResultList(); 
		
		return demandes;
	}

}
