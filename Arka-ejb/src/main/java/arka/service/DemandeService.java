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
    
    @Override
    public List<Demand> getNotif(Demand demande)
    {
    	ArrayList<Demand> listDemandes = new ArrayList<Demand>();
		return listDemandes; 
    	
    }
    
    @Override
    public void addDemand(Demand demande)
    {
    	entityManager.persist(demande);
    }

	@Override
	public void updateDemand(Demand demande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDemand(Demand demande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDemandById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean affecterDemande(Agent agent) {
		// TODO Auto-generated method stub
		return false;
	}

}
