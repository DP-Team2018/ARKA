package arka.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Location;
import arka.domain.Report;

/**
 * Session Bean implementation class EmplacementService
 */
@Stateless
@LocalBean
public class EmplacementService implements EmplacementServiceRemote, EmplacementServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
    EntityManager em;
    public EmplacementService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouter_emplacement(Location location) {
		em.persist(location);
		
	}

	@Override
	public void merge_emplacement(Location location) {
		em.merge(location);
		
	}

	@Override
	public List<Location> afficher_emplacement() {
		return em.createQuery("SELECT i FROM Location i ",Location.class).getResultList();
		
	}

	@Override
	public void remplir_emplacement(Location location) {
		location.setEmpty(false);
		
	}

	@Override
	public void vider_emplacement(Location location) {
		location.setEmpty(true);
		
	}

	@Override
	public List<Location> rechercher_emplacement_carton(int codecarton, int id_client, Date date_entree,
			String matricule_agent) {
		List lst=new ArrayList<Location>();
		for(Location d: afficher_emplacement())
		{
			if(d.getCarton().getIdCarton()==codecarton||d.getCarton().getClient().getIdClient()==id_client||d.getCarton().getArrivalDate().equals(date_entree))
			{
				lst.add(d);
			}
		}
		return lst;
	}

	@Override
	public void supprimer_emplacement(Location location) {
		em.remove(em.merge(location));
		
	}

	@Override
	public Agent get_agent(Carton carton) {
		List<Report> reports=carton.getReports();
		for(Report r:reports)
		{
			
		}
		return null;
	}

}
