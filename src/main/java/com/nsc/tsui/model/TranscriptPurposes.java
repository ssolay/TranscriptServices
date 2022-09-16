package com.nsc.tsui.model;

import java.util.Date;

public class TranscriptPurposes {
	
	private int xcriptPurposeId;
	private int toScprofilId;
	private int xmitCodeId;
	private String display;
	private String status;
	private Date createdTimeStamp;
	private Date timeStamp;
	public int getXcriptPurposeId() {
		return xcriptPurposeId;
	}
	public void setXcriptPurposeId(int xcriptPurposeId) {
		this.xcriptPurposeId = xcriptPurposeId;
	}
	public int getToScprofilId() {
		return toScprofilId;
	}
	public void setToScprofilId(int toScprofilId) {
		this.toScprofilId = toScprofilId;
	}
	public int getXmitCodeId() {
		return xmitCodeId;
	}
	public void setXmitCodeId(int xmitCodeId) {
		this.xmitCodeId = xmitCodeId;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
