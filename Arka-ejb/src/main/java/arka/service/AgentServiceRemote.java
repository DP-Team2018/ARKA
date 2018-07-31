package arka.service;

import java.util.List;

import javax.ejb.Remote;

import arka.domain.Agent;

@Remote
public interface AgentServiceRemote {
	public List<Agent> getAllAgent();
	public void deleteAgent(String matricule);
	public void updateAgent(Agent agent);
	public Agent getAgentbyMat(String matricule);
	public void addagent(Agent a);
}
