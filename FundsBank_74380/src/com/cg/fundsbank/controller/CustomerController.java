package com.cg.fundsbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.fundsbank.dto.CustomerComplaint;
import com.cg.fundsbank.exceptions.FundsComplaintException;
import com.cg.fundsbank.service.ICustomerService;

@Controller
public class CustomerController {
	@Autowired
	ICustomerService customerservice;

	// Initializing the model and bean
	@RequestMapping(value = "/getcomplaint", method = RequestMethod.GET)
	public String getraiseComplaints(
			@ModelAttribute("mycomplaint") CustomerComplaint complaint,
			Map<String, Object> model) {
		ArrayList<String> categories = new ArrayList<String>();
		categories.add("Internet Banking");
		categories.add("General Banking");
		categories.add("Others");

		model.put("categories", categories);
		return "CustomerComplaint";
	}

	// Retrieving the details and adding to database
	@RequestMapping(value = "/addcomplaint", method = RequestMethod.POST)
	public String raiseComplaints(
			@ModelAttribute("mycomplaint") @Valid CustomerComplaint complaint,
			BindingResult result, Map<String, Object> model)
			throws FundsComplaintException {
		if (result.hasErrors()) {

			List<String> categories = new ArrayList<String>();
			categories.add("Internet Banking");
			categories.add("General Banking");
			categories.add("Others");

			model.put("categories", categories);

			return "CustomerComplaint";
		}
		complaint.setStatus("Open");
		try {
			customerservice.getPriorityByCatgry(complaint.getCategory());
			customerservice.raiseComplaint(complaint);

		} catch (FundsComplaintException e) {
			throw new FundsComplaintException(
					"Complaint is not raised due to technical problem");
		}

		model.put("complaintId", complaint.getComplaintId());
		return "Success";

	}

	// When check status is clicked, initializing the bean
	@RequestMapping(value = "/checkstatus", method = RequestMethod.GET)
	public String checkStatuss(
			@ModelAttribute("complaintdetails") CustomerComplaint complaint) {

		return "CheckStatus";

	}

	// processing of check status request
	@RequestMapping(value = "/getcheckstatus", method = RequestMethod.POST)
	public ModelAndView getComplaintStatus(
			@ModelAttribute("complaintdetails") CustomerComplaint complaint,
			Model model) throws FundsComplaintException {

		List<CustomerComplaint> complaintObjList = null;
		try {
			CustomerComplaint complaintObj = customerservice
					.getComplaintDetails(complaint.getComplaintId());
			System.out.println(complaintObj);
			complaintObjList = customerservice.checkStatus(complaintObj);
		} catch (FundsComplaintException e) {
			throw new FundsComplaintException(
					"Complaint details are not retrieved");
		}

		return new ModelAndView("CheckStatus", "complaintObjList",
				complaintObjList);
	}
}
