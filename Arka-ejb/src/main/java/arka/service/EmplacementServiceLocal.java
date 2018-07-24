package arka.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Location;

@Local
public interface EmplacementServiceLocal {
public void ajouter_emplacement(Location location);
public void merge_emplacement(Location location);
public List<Location> afficher_emplacement();
public void remplir_emplacement(Location location);
public void vider_emplacement(Location location);
public List<Location> rechercher_emplacement_carton(int codecarton,int id_client,Date date_entree,String matricule_agent);
public void supprimer_emplacement(Location location);
}
