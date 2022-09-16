package com.nsc.tsui.model;

import java.util.Date;

public class NetworkInfos {
	
	
	private int toScprofilNetworkInfoId;
    private String exchangeNetworkTypeCode;
    private int toScprofilId;
    private String supportedFileTypes;
    private int priorityLevel;
    private String ficeCode; 
    private String networkCode;
    private String status;         
    private Date createdTimestamp;
    private Date timestamp;
	public int getToScprofilNetworkInfoId() {
		return toScprofilNetworkInfoId;
	}
	public void setToScprofilNetworkInfoId(int toScprofilNetworkInfoId) {
		this.toScprofilNetworkInfoId = toScprofilNetworkInfoId;
	}
	public String getExchangeNetworkTypeCode() {
		return exchangeNetworkTypeCode;
	}
	public void setExchangeNetworkTypeCode(String exchangeNetworkTypeCode) {
		this.exchangeNetworkTypeCode = exchangeNetworkTypeCode;
	}
	public int getToScprofilId() {
		return toScprofilId;
	}
	public void setToScprofilId(int toScprofilId) {
		this.toScprofilId = toScprofilId;
	}
	public String getSupportedFileTypes() {
		return supportedFileTypes;
	}
	public void setSupportedFileTypes(String supportedFileTypes) {
		this.supportedFileTypes = supportedFileTypes;
	}
	public int getPriorityLevel() {
		return priorityLevel;
	}
	public void setPriorityLevel(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}
	public String getFiceCode() {
		return ficeCode;
	}
	public void setFiceCode(String ficeCode) {
		this.ficeCode = ficeCode;
	}
	public String getNetworkCode() {
		return networkCode;
	}
	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
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
