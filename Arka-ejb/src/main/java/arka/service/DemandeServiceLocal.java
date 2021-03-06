package arka.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Client;
import arka.domain.Demand;
import arka.domain.DemandState;
import arka.domain.DemandType;

@Local
public interface DemandeServiceLocal {


	List<Demand> getDemands();//ok 
	void addDemand(ArrayList<Demand> demande);//ok
	void updateDemand(Demand demande);
	void deleteDemand(int idDemand);
	Demand getDemandById(int id);//ok
	void affecterCartonDemand(List<Carton> carton,Demand demand);//ok
	List<Demand> getDemandsByCLient(int idClient);//ok
	List<Demand> getDemandsByCLient(String client);//ok
	List<Demand> getDemandsAgnet(String idAgnet);//ok
	List<Demand> getDemandsByDate(Date date);
	List<Demand> getDemandsByType(DemandType demanType);
	List<Demand> getDemandsByState(DemandState demandState);
	Agent getAgentById(String id);
	Demand affecterDemande(String idAgent, int idDemand);
	void ChangerStateDemand(DemandState demandState,int idDemand);
	
	

}
