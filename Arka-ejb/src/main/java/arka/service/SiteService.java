package arka.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Location;
import arka.domain.Site;

/**
 * Session Bean implementation class SiteService
 */
@Stateless
@LocalBean
public class SiteService implements SiteServiceRemote, SiteServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public SiteService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addSite(Site s) {
		em.persist(s);
		return true;
	}

	@Override
	public List<Site> getAllSite() {
		return em.createQuery("Select s from Site s",Site.class).getResultList();
	}

	@Override
	public void updateSite(Site s) {
		em.merge(s);
		
	}

	@Override
	public Site Rechercher_site_avec_id(int id) {
		return em.createQuery("SELECT b FROM Site b where b.idSite=?1", Site.class)
				.setParameter(1, id).getSingleResult();
		
	}

	@Override
	public boolean supprimer_site(Site s) {
		em.remove(em.merge(s));
		return true;
	}

	@Override
	public void mergeSite(Site s) {
		em.merge(s);
		
	}

	@Override
	public boolean Affecter_emplacement_ausite(Site s, Location location) {
		List <Location> locations=new ArrayList<>();
		location.setSite(s);
		locations.add(location);
		s.setLocations(locations);
		em.merge(location);
		em.merge(s);
		return true;
	}

	@Override
	public List<Site> Rechercher_site_avec_nom(String nom) {
		return em.createQuery("SELECT b FROM Site b where b.name=?1", Site.class)
				.setParameter(1, nom).getResultList();
	}

}
