<<<<<<< HEAD
////package arka.service;
//
//import java.sql.Date;
//import java.util.List;
//
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//
//import arka.domain.Agent;
//import arka.domain.Carton;
//import arka.domain.Report;
//
///**
// * Session Bean implementation class ReportService
// */
//@Stateless
//@LocalBean
//public class ReportService implements ReportServiceRemote, ReportServiceLocal {
//
//    /**
//     * Default constructor. 
//     */
//    public ReportService() {
//        // TODO Auto-generated constructor stub
//    }
//
//	@Override
//	public Report findReportById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Report> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteReportById(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void addReport(Report r) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Report> getReportByDate(Date date) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Report> getReportByCarton(Carton car) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Report> getReportByAgent(Agent agent) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
=======
package arka.service;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import arka.domain.Admin;
import arka.domain.Agent;
import arka.domain.Carton;
import arka.domain.Demand;
import arka.domain.Report;
import arka.domain.ReportType;

/**
 * Session Bean implementation class ReportService
 */
@Stateless
@LocalBean
public class ReportService implements ReportServiceRemote, ReportServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
    EntityManager em;
	
    public ReportService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Report findReportById(int id) {
		Report report=  em.find(Report.class, id);
	 	  
	 	   return report;

	}

	@Override
	public List<Report> findAll() {
		 List<Report> reports=  em.createQuery("from Report").getResultList();
	 	   return reports;
	}

	@Override
	public void deleteReportById(int id) {
	em.remove(em.find(Report.class, id));
		
	}
	
	@Override
	public void deleteReport(Report report) {
	em.remove(report);
	em.flush();
		
	}

	@Override
	public void addReport(Report r) {
		em.merge(r);
		em.flush();
		
	}

	@Override
	public List<Report> getReportByDate(Date date) {
		
		Query q = em.createQuery("select r from Report r where r.> :today ");
		q.setParameter("today", new java.util.Date(), TemporalType.DATE);
		List<Report> reports=q.getResultList();		
		return reports;
	}

	@Override
	public List<Report> getReportByCarton(int idCarton) {
		 Carton carton = em.find(Carton.class,idCarton);
		 return carton.getReports();
	
		
		
	}

	@Override
	public List<Report> getReportByAgent(int idAgent) {
		Agent agent = em.find(Agent.class,idAgent);
		return agent.getReports();
	}

	@Override
	public void addReport(int idCarton, int idAgent, int idDemand, ReportType reportType) {
	 Carton carton = em.find(Carton.class, idCarton);
	 Agent agent = em .find(Agent.class, idAgent);
	 Demand demand  = em.find(Demand.class, idDemand);
	 
	 Report report= new Report(reportType,carton,agent,demand);
	 em.merge(report);
	 em.flush();
		
	}

}
>>>>>>> branch 'master' of https://github.com/DP-Team2018/ARKA.git
