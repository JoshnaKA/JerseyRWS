package com.cg.fundsbank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fundsbank.dao.ICustomerDAO;
import com.cg.fundsbank.dto.CustomerComplaint;
import com.cg.fundsbank.exceptions.FundsComplaintException;

@Service("customerservice")
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerDAO customerdao;

	// to process the raise complaint request

	@Override
	public void raiseComplaint(CustomerComplaint complaint)
			throws FundsComplaintException {
		// TODO Auto-generated method stub
		customerdao.raiseComplaint(complaint);
	}

	// to check status when customer enters complaintId

	@Override
	public List<CustomerComplaint> checkStatus(CustomerComplaint complaint)
			throws FundsComplaintException {
		// TODO Auto-generated method stub
		return customerdao.checkStatus(complaint);
	}

	// to find priority when customer enters category

	@Override
	public String getPriorityByCatgry(String category) {
		String priority = null;
		if (category.equals("Internet Banking")) {
			priority = "High";
		} else if (category.equals("General Banking")) {
			priority = "Medium";
		} else if (category.equals("Others")) {
			priority = "Low";
		}
		return priority;
	}

	// to check complaint details based on complaintId

	@Override
	public CustomerComplaint getComplaintDetails(int complaintId)
			throws FundsComplaintException {

		return customerdao.getComplaintDetails(complaintId);
	}
}
