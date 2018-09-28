package arka.service;

import java.util.List;

import javax.ejb.Remote;

import arka.domain.Agent;

@Remote
public interface AgentServiceRemote {
	public List<Agent> getAllAgent();
	public void deleteAgent(int idAgent);
	public void updateAgent(int id,String matricule,String nom,String email,String prenom,String numTel) ;
	public Agent getAgentbyMat(int idAgent);
	public void addagent(Agent a);
}
