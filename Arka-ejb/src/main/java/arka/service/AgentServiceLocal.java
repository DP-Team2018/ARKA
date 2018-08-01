package arka.service;

import java.util.List;

import javax.ejb.Local;
import arka.domain.Agent;
@Local
public interface AgentServiceLocal {
	public List<Agent> getAllAgent();
	public void deleteAgent(String matricule);
	public void updateAgent(Agent agent);
	public Agent getAgentbyMat(String matricule);
	public void addagent(Agent a);
}
