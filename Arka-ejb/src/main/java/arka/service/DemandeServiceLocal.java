package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Agent;
import arka.domain.Demand;

@Local
public interface DemandeServiceLocal {

	List<Demand> getDemands();
	void getNotifs(Demand demande);
	void addDemand(Demand demande);
	void updateDemand(Demand demande);
	void deleteDemand(Demand demande);
	Demand getDemandById(int id);
	boolean affecterDemande(Agent agent, List<Demand> demandes);
	
	

}
