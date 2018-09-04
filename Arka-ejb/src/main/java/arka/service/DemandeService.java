package arka.service;

import arka.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    public void addDemand(ArrayList<Demand> demande)
    {
    	entityManager.persist(demande);
    }

	@Override
	public void updateDemand(Demand demand) {
		
	}

	@Override
	public void deleteDemand(int idDemand) {
		Demand demande = getDemandById(idDemand);
		entityManager.remove(entityManager.merge(demande));
		
	}

	@Override
	public Demand getDemandById(int id) {
		return entityManager.createQuery("Select d from Demand d where d.idDemand=?1", Demand.class)
				.setParameter(1,id).getSingleResult();
		
	}
	
	@Override
	public Agent getAgentById(String id) {
		return entityManager.createQuery("Select d from Agent d where d.matricule=?1", Agent.class)
				.setParameter(1,id).getSingleResult();
		
	}

	@Override
	public Demand affecterDemande(String idAgent, int idDemand) {
		Demand demande = getDemandById(idDemand);
		Agent agent = getAgentById(idAgent);
		demande.setAgent(agent);
		entityManager.persist(agent);
		return demande;
	}


	@Override
	public void affecterCartonDemand(List<Carton> carton, Demand demand) {
		demand.setCartons(carton);
		entityManager.merge(demand);
		
	}

	@Override
	public List<Demand> getDemandsByCLient(int idClient) {
		Client client= entityManager.find(Client.class, idClient);
		List<Demand> demands = client.getDemands();
		return demands;
	}

	@Override
	public List<Demand> getDemandsByDate(Date date) {
		List<Demand> demands = entityManager.createQuery("Select d from Demand d where d.date=?1", Demand.class)
				.setParameter(1,date).getResultList();
		return demands;
		
	}

	

	@Override
	public List<Demand> getDemandsByType(DemandType demandType) {
		List<Demand> demands = entityManager.createQuery("Select d from Demand d where d.demandType=?1", Demand.class)
				.setParameter(1,demandType).getResultList();
		return demands;
	}

	@Override
	public List<Demand> getDemandsByState(DemandState demandState) {
		List<Demand> demands = entityManager.createQuery("Select d from Demand d where d.demandState=?1", Demand.class)
				.setParameter(1,demandState).getResultList();
		return demands;
	}
	@Override
	public void deleteDemand(Demand demande) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean affecterDemande(Agent agent, List<Demand> demandes) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Demand> getDemandsByCLient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void ChangerStateDemand(DemandState demandState, int Demandid) {
		Demand demand= entityManager.find(Demand.class,Demandid);
		demand.setDemandState(demandState);
		entityManager.merge(demand);
		entityManager.flush();
		
	}
	@Override
	public List<Demand> getDemandsAgnet(String idAgnet) {
		System.out.println("Ageeeeent"+entityManager.find(Agent.class, idAgnet).toString());
		List<Demand> demands = entityManager.createQuery("Select d from Demand d where d.agent=?1", Demand.class)
				.setParameter(1,entityManager.find(Agent.class, idAgnet)).getResultList();
	   for (Demand demand : demands) {
		System.out.println(demand.getDate()+"+++++");
	}
		return demands;
	}
	@Override
	public List<Demand> getDemandsByCLient(String client) {
		List<Demand> demands = entityManager.createQuery("Select d from Demand d where d.client.nom LIKE '%"+client+"%'", Demand.class)
				.getResultList();
	   for (Demand demand : demands) {
		System.out.println(demand.getDate()+"+++++");
	}
		return demands;
	}
	

}
