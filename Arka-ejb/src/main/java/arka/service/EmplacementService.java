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
import arka.domain.Site;

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

	/*@Override
	public boolean ajouter_emplacement(Location location,Site s) {
		 em.persist(location);
		 List <Location> locations=new ArrayList<>();
			location.setSite(s);
			locations.add(location);
			s.setLocations(locations);
			em.merge(location);
			em.merge(s);
		return true;
		
	}*/

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
	public List<Location> rechercher_emplacement_carton(int id,int codecarton, int id_client, Date date_entree) {
		List lst=new ArrayList<Location>();
		for(Location d: afficher_emplacement())
		{
			if(d.getCarton() !=null&&d.getSite().getIdSite()==id)
			{
			System.out.println("------------------------------------------"+d.getLine()+"---------------------------");
			System.out.println("??????????????????????????????????????????"+d.getCarton().getIdCarton()+"???????????????????????????");
			
			if(d.getCarton().getIdCarton()==codecarton && d.getCarton().getClient().getIdClient()==id_client&&d.getCarton().getArrivalDate().equals(date_entree))
			{
				lst.add(d);
			}
			}
		}
		return lst;
	}

	@Override
	public boolean supprimer_emplacement(Location location) {
		em.remove(em.merge(location));
	    return true;
	}

	@Override
	public Location rechercher_emplacement_avec_id(int id) {
		return em.createQuery("SELECT b FROM Location b where b.idLocation=?1", Location.class)
				.setParameter(1, id).getSingleResult();
		
	}

	@Override
	public List<Location> rechercher_emplacement_vide() {
		return em.createQuery("SELECT b FROM Location b where b.empty=?1", Location.class)
				.setParameter(1, true).getResultList();
	}

	@Override
	public List<Location> rechercher_emplacement_avecsite(int id) {
		return em.createQuery("SELECT b FROM Location b where b.site.idSite=?1", Location.class)
				.setParameter(1, id).getResultList();
	}

	@Override
	public List<Location> rechercher_emplacement_avecsite_allee(int id,int allee) {
		return em.createQuery("SELECT b FROM Location b where b.site.idSite=?1 And b.line=?2", Location.class)
				.setParameter(1, id).setParameter(2, allee).getResultList();
	}

	@Override
	public List<Location> rechercher_emplacement_carton_aveccodecarton(int id, int codecarton) {
		List lst=new ArrayList<Location>();
		for(Location d: afficher_emplacement())
		{
			if(d.getCarton() !=null&&d.getSite().getIdSite()==id)
			{
			System.out.println("------------------------------------------"+d.getLine()+"---------------------------");
			System.out.println("??????????????????????????????????????????"+d.getCarton().getIdCarton()+"???????????????????????????");
			
			if(d.getCarton().getIdCartonClient()==codecarton)
			{
				lst.add(d);
			}
			}
		}
		return lst;
	}

	@Override
	public List<Location> rechercher_emplacement_carton_avecidclient(int id, int id_client) {
		List lst=new ArrayList<Location>();
		for(Location d: afficher_emplacement())
		{
			if(d.getCarton() !=null&&d.getSite().getIdSite()==id)
			{
			System.out.println("------------------------------------------"+d.getLine()+"---------------------------");
			System.out.println("??????????????????????????????????????????"+d.getCarton().getIdCarton()+"???????????????????????????");
			
			if( d.getCarton().getClient().getCodeClient()==id_client)
			{
				lst.add(d);
			}
			}
		}
		return lst;
	}

	@Override
	public List<Location> rechercher_emplacement_carton_avecdate(int id,Date date_entree) {
		List lst=new ArrayList<Location>();
		for(Location d: afficher_emplacement())
		{
			if(d.getCarton() !=null&&d.getSite().getIdSite()==id)
			{
			System.out.println("------------------------------------------"+d.getLine()+"---------------------------");
			System.out.println("??????????????????????????????????????????"+d.getCarton().getIdCarton()+"???????????????????????????");
			
			if(d.getCarton().getArrivalDate().equals(date_entree))
			{
				lst.add(d);
			}
			}
		}
		return lst;
	}

	@Override
	public boolean ajouter_emplacement(Location location, Site s) {
		 
		 List <Location> locations=new ArrayList<>();
			location.setSite(s);
			locations.add(location);
			s.setLocations(locations);
			em.persist(location);
			em.merge(s);
		return true;
		
	}
	
	

}
