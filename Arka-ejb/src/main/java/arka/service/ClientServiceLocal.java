package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Client;;

@Local
public interface ClientServiceLocal {
	public List<Client> getAllClient();
	public void deleteClient(int id);
	public void addClient(Client client);

}
