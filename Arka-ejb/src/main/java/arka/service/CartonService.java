package arka.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import arka.domain.Carton;
import arka.domain.Client;
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
	public boolean affectercarton_au_emplacement(Carton carton,Location location) {
		carton.setLocale(location);
		location.setCarton(carton);
		location.setEmpty(false);
		return true;
	}
	@Override
	public List<Carton> afficher_carton() {
		return em.createQuery("SELECT i FROM Carton i ",Carton.class).getResultList();
		
	}
	@Override
	public boolean detruire_carton(Carton carton) {
		em.remove(em.merge(carton));
		return true;
		
	}
	@Override
	public boolean affectercarton_au_client(Carton carton, Client client) {
		List <Carton> cartons=new ArrayList<>();
		carton.setClient(client);
		client.setCartons(cartons);
		return true;
	}
	@Override
	public Carton rechercher_carton_avec_id(int id) {
		return em.createQuery("SELECT b FROM Carton b where b.idCarton=?1", Carton.class)
				.setParameter(1, id).getSingleResult();
		
	}
	@Override
	public Client rechercher_client_avec_id(int id) {
		return em.createQuery("SELECT b FROM Client b where b.idClient=?1", Client.class)
				.setParameter(1, id).getSingleResult();
	}

	

}
