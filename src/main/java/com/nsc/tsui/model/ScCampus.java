package com.nsc.tsui.model;

import java.util.Date;

public class ScCampus {
	
	private String campusName;
    private String operatorId;
    private String state;
    private String toScCampusId;
    private int toScprofilId;
    private String status;         
    private Date createdTimestamp;
    public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getToScCampusId() {
		return toScCampusId;
	}
	public void setToScCampusId(String toScCampusId) {
		this.toScCampusId = toScCampusId;
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
	private Date timestamp;     

	
	
}
