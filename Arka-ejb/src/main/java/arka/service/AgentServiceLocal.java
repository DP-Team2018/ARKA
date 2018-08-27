package arka.service;

import java.util.List;

import arka.domain.Agent;

public interface AgentServiceLocal {

	List<Agent> getAllAgent();

	void deleteAgent(String matricule);

	void updateAgent(Agent agent);

	Agent getAgentbyMat(String matricule);

	void addagent(Agent a);

}
