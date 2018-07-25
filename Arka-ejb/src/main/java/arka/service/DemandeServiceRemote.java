package arka.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Client;
import arka.domain.Demand;
import arka.domain.DemandState;
import arka.domain.DemandType;

@Remote
public interface DemandeServiceRemote {


	List<Demand> getDemands();//ok 
	//void getNotifs(Demand demande);
	void addDemand(Demand demande);//ok
	void updateDemand(Demand demande);
	void deleteDemand(Demand demande);//ok
	Demand getDemandById(int id);//ok
	boolean affecterDemande(Agent agent, List<Demand> demandes);//ok
	void affecterCartonDemand(Carton carton,Demand demand);//ok
	List<Demand> getDemandsByCLient(int idClient);//ok
	List<Demand> getDemandsByCLient(Client client);//ok
	List<Demand> getDemandsByDate(Date date);
	List<Demand> getDemandsByType(DemandType demanType);
	List<Demand> getDemandsByState(DemandState demandState);
}
