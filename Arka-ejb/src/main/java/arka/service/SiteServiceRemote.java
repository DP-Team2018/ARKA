package arka.service;

import java.util.List;

import javax.ejb.Remote;

import arka.domain.Site;

@Remote
public interface SiteServiceRemote {
	public boolean addSite(Site s);
	public List<Site> getAllSite();
	public void updateSite(Site s);


}
