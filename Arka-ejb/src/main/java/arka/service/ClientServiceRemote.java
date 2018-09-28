package arka.service;

import java.util.List;

import javax.ejb.Remote;

import arka.domain.Client;

@Remote
public interface ClientServiceRemote {
	public List<Client> getAllClient();
	public void deleteClient(int id);
	public void addClient(Client client);
}
