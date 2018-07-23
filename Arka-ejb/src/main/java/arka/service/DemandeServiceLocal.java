package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Agent;
import arka.domain.Demand;

@Local
public interface DemandeServiceLocal {

	List<Demand> getNotif(Demand demande);
	void addDemand(Demand demande);
	void updateDemand(Demand demande);
	void deleteDemand(Demand demande);
	void getDemandById(String id);
	boolean affecterDemande(Agent agent);
	
	

}
