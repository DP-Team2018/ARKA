package arka.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import arka.domain.Agent;
import arka.domain.Client;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class ClientService implements ClientServiceRemote, ClientServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public ClientService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Client> getAllClient() {
		 return  em.createQuery("SELECT c FROM Client c",Client.class).getResultList();
	}

	@Override
	public void deleteClient(int id) {
	Client c = em.find(Client.class, id);
		  em.remove(c);
		
	}

	@Override
	public void addClient(Client client) {
		em.merge(client);
		
	}

}
