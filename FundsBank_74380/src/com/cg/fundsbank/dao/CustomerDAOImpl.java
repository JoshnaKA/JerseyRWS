package com.cg.fundsbank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.fundsbank.dto.CustomerComplaint;
import com.cg.fundsbank.exceptions.FundsComplaintException;

@Repository("customerdao")
public class CustomerDAOImpl implements ICustomerDAO {
	@PersistenceContext
	private EntityManager entityManager;

	// to process the raise complaint request
	@Override
	public void raiseComplaint(CustomerComplaint complaint)
			throws FundsComplaintException {

		entityManager.persist(complaint);
		entityManager.flush();

	}

	// to check status when customer enters complaintId
	@Override
	public List<CustomerComplaint> checkStatus(CustomerComplaint complaint)
			throws FundsComplaintException {

		Query queryOne = entityManager
				.createQuery("FROM CustomerComplaint where complaintId=:complaintid");
		queryOne.setParameter("complaintid", complaint.getComplaintId());
		List<CustomerComplaint> complaintList = queryOne.getResultList();

		return complaintList;
	}

	// to check complaint details based on complaintId
	@Override
	public CustomerComplaint getComplaintDetails(int complaintId)
			throws FundsComplaintException {

		CustomerComplaint complaint = entityManager.find(
				CustomerComplaint.class, complaintId);
		return complaint;
	}

}
