package com.nsc.tsui.model;

import java.util.Date;

public class ProcessingOptions {
	
	private int processingOptionId;
	private int toScprofilId;
	private String code;
	private String status;
	private String description;
	private Date createdTimeStamp;
	private Date timeStamp;
	public int getProcessingOptionId() {
		return processingOptionId;
	}
	public void setProcessingOptionId(int processingOptionId) {
		this.processingOptionId = processingOptionId;
	}
	public int getToScprofilId() {
		return toScprofilId;
	}
	public void setToScprofilId(int toScprofilId) {
		this.toScprofilId = toScprofilId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
