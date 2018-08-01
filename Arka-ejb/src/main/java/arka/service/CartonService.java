package arka.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import arka.domain.Carton;
import arka.domain.Location;

/**
 * Session Bean implementation class CartonService
 */
@Stateless
@LocalBean
public class CartonService implements CartonServiceRemote, CartonServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
    EntityManager em;
    public CartonService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean ajoutercarton(Carton carton) {
		em.persist(carton);
		return true;
	}
	@Override
	public void mergecarton(Carton carton) {
		em.merge(carton);
		
	}
	@Override
	public void affectercarton_au_emplacement(Carton carton,Location location) {
		carton.setLocale(location);
		location.setCarton(carton);
		location.setEmpty(false);
	}
	@Override
	public List<Carton> afficher_carton() {
		return em.createQuery("SELECT i FROM Carton i ",Carton.class).getResultList();
		
	}
	@Override
	public void detruire_carton(Carton carton) {
		em.remove(em.merge(carton));
		
	}

	

}
