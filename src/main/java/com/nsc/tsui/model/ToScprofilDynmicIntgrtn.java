package com.nsc.tsui.model;

import java.util.Date;

public class ToScprofilDynmicIntgrtn {
	
	private int toScprofilDynmicIntgrtnId;
    private int toScprofilId;
    private String integrationProvider;
    private String  rootUrl;
    private String status;         
    private Date createdTimestamp;
    public int getToScprofilDynmicIntgrtnId() {
		return toScprofilDynmicIntgrtnId;
	}
	public void setToScprofilDynmicIntgrtnId(int toScprofilDynmicIntgrtnId) {
		this.toScprofilDynmicIntgrtnId = toScprofilDynmicIntgrtnId;
	}
	public int getToScprofilId() {
		return toScprofilId;
	}
	public void setToScprofilId(int toScprofilId) {
		this.toScprofilId = toScprofilId;
	}
	public String getIntegrationProvider() {
		return integrationProvider;
	}
	public void setIntegrationProvider(String integrationProvider) {
		this.integrationProvider = integrationProvider;
	}
	public String getRootUrl() {
		return rootUrl;
	}
	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
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
