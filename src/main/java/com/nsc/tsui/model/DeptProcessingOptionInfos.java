package com.nsc.tsui.model;

import java.util.Date;

public class DeptProcessingOptionInfos {

	private int toScprofilDeptProcessingOptionInfoId;
    private String ficeCode;
    private String deptProcessingOption;
    private int toScprofilId;
    private String  status;       
    private Date createdTimestamp;
    private Date timestamp;
	public int getToScprofilDeptProcessingOptionInfoId() {
		return toScprofilDeptProcessingOptionInfoId;
	}
	public void setToScprofilDeptProcessingOptionInfoId(int toScprofilDeptProcessingOptionInfoId) {
		this.toScprofilDeptProcessingOptionInfoId = toScprofilDeptProcessingOptionInfoId;
	}
	public String getFiceCode() {
		return ficeCode;
	}
	public void setFiceCode(String ficeCode) {
		this.ficeCode = ficeCode;
	}
	public String getDeptProcessingOption() {
		return deptProcessingOption;
	}
	public void setDeptProcessingOption(String deptProcessingOption) {
		this.deptProcessingOption = deptProcessingOption;
	}
	public int getToScprofilId() {
		return toScprofilId;
	}
	public void setToScprofilId(int toScprofilId) {
		this.toScprofilId = toScprofilId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}     

}
