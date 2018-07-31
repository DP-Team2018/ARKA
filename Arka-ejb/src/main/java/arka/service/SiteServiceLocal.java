package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Site;

@Local
public interface SiteServiceLocal {
public void addSite(Site s);
public List<Site> getAllSite();
public void updateSite(Site s);


}
