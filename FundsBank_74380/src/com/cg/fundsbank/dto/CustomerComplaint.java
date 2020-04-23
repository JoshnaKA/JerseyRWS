package com.cg.fundsbank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "complaint")
public class CustomerComplaint {

	@Id
	@Column(name = "complaintid")
	@SequenceGenerator(name = "seq1", sequenceName = "hibernate_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private int complaintId;

	@Column(name = "accountid")
	// @DecimalMax(value = "10")
	@NotNull(message = "Account Id should not be empty")
	private long accountId;

	@Column(name = "branchcode")
	@NotEmpty(message = "branch code should not empty")
	private String branchCode;

	@Column(name = "emailid")
	@Email
	@NotEmpty(message = "email id should not empty")
	private String emailId;

	@Column(name = "category")
	@NotEmpty(message = "category should not empty")
	private String category;

	@Column(name = "description")
	@NotEmpty(message = "description should not empty")
	private String description;

	private String priority;

	private String status;

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {

		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerComplaint [complaintId=" + complaintId + ", accountId="
				+ accountId + ", branchCode=" + branchCode + ", emailId="
				+ emailId + ", category=" + category + ", description="
				+ description + ", priority=" + priority + ", status=" + status
				+ "]";
	}

}
