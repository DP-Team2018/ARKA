package arka.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import arka.domain.Agent;
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
	public void addSite(Site s) {
		em.persist(s);
		
	}

	@Override
	public List<Site> getAllSite() {
		return em.createQuery("Select s from Site s",Site.class).getResultList();
	}

	@Override
	public void updateSite(Site s) {
		em.merge(s);
		
	}

}
