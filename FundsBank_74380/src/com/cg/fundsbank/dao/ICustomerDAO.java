package com.cg.fundsbank.dao;

import java.util.List;

import com.cg.fundsbank.dto.CustomerComplaint;
import com.cg.fundsbank.exceptions.FundsComplaintException;

public interface ICustomerDAO {

	public void raiseComplaint(CustomerComplaint complaint)
			throws FundsComplaintException;

	public List<CustomerComplaint> checkStatus(CustomerComplaint complaint)
			throws FundsComplaintException;

	public CustomerComplaint getComplaintDetails(int complaintId)
			throws FundsComplaintException;
}
