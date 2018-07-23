package arka.service;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Report;



@Remote
public interface ReportServiceRemote {
	  public Report findReportById(int id);
	     public List<Report> findAll();
	     public void deleteReportById(int id);
	     public void addReport(Report r);
	     public List<Report> getReportByDate(Date date); 
	     public List<Report> getReportByCarton(Carton car);
	     public List<Report> getReportByAgent(Agent agent);

}