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
	public boolean ajoutercarton(Carton carton,Client client) {
		List <Carton> cartons=new ArrayList<>();
		carton.setClient(client);
		client.setCartons(cartons);
		em.merge(client);
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
		em.merge(carton);
		em.merge(location);
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
		em.merge(carton);
		em.merge(client);
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
	@Override
	public List<Client> afficher_client() {
		return em.createQuery("SELECT i FROM Client i ",Client.class).getResultList();
	}
	@Override
	public Carton rechercher_carton_avec_codecartonclient(int codecartonclient) {
		return em.createQuery("SELECT b FROM Carton b where b.idCartonClient=?1", Carton.class)
				.setParameter(1, codecartonclient).getSingleResult();
	}
	@Override
	public List<Carton> rechercher_carton_avec_nomclient(String nomclient) {
		List lst=new ArrayList<Carton>();
		for(Carton d: afficher_carton())
		{
			if(d.getClient().getNom().equals(nomclient))
			{
			    lst.add(d);
				
			
			}
		}
		return lst;
	}
	@Override
	public Carton rechercher_carton_avec_codeetnom_client(int codecartonclient, String nomclient) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
