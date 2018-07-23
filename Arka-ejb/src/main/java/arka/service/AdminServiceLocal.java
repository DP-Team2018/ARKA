package arka.service;

import java.util.List;

import javax.ejb.Local;

import arka.domain.Admin;

@Local
public interface AdminServiceLocal {
	public List<Admin> getAllAdmin();
	public Admin getAdminById(int id);
	public void addAdmin(Admin a);
}
