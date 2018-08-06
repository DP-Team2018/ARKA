package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Carton;
import arka.domain.Client;
import arka.domain.Location;

@Local
public interface CartonServiceLocal {
public boolean ajoutercarton(Carton carton);
public void mergecarton(Carton carton);
public boolean affectercarton_au_emplacement(Carton carton,Location location);
public boolean affectercarton_au_client(Carton carton,Client client);
public List<Carton> afficher_carton();
public Carton rechercher_carton_avec_id(int id);
public Client rechercher_client_avec_id(int id);
public boolean detruire_carton(Carton carton);

}
