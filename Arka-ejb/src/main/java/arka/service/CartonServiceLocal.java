package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Carton;
import arka.domain.Location;

@Local
public interface CartonServiceLocal {
public boolean ajoutercarton(Carton carton);
public void mergecarton(Carton carton);
public void affectercarton_au_emplacement(Carton carton,Location location);
public List<Carton> afficher_carton();
public void detruire_carton(Carton carton);

}
