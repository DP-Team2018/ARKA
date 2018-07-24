package arka.service;

import java.util.List;

import javax.ejb.Remote;

import arka.domain.Agent;
import arka.domain.Demand;

@Remote
public interface DemandeServiceRemote {

	List<Demand> getDemands();
	void addDemand(Demand demande);
	void updateDemand(Demand demande);
	void deleteDemand(Demand demande);
	Demand getDemandById(int id);
	boolean affecterDemande(Agent agent, List<Demand> demandes);
}
