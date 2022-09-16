package com.nsc.tsui.model;

import java.util.Date;

public class DeliveryMethods {

	private int deliveryMethodId;
	private int toScprofilId;
	private double fee;
	private String displayWithFee;
	private String helpText;
	private int xmitCodeId;
	private String display;
	private String status;
	private Date timeStamp;
	private Date createdTimeStamp;
	private double printVendorFee;
	private double handleFee;
	private String isPrint;
	private String emailHelpText;
	public int getDeliveryMethodId() {
		return deliveryMethodId;
	}
	public void setDeliveryMethodId(int deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}
	public int getToScprofilId() {
		return toScprofilId;
	}
	public void setToScprofilId(int toScprofilId) {
		this.toScprofilId = toScprofilId;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getDisplayWithFee() {
		return displayWithFee;
	}
	public void setDisplayWithFee(String displayWithFee) {
		this.displayWithFee = displayWithFee;
	}
	public String getHelpText() {
		return helpText;
	}
	public void setHelpText(String helpText) {
		this.helpText = helpText;
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
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public double getPrintVendorFee() {
		return printVendorFee;
	}
	public void setPrintVendorFee(double printVendorFee) {
		this.printVendorFee = printVendorFee;
	}
	public double getHandleFee() {
		return handleFee;
	}
	public void setHandleFee(double handleFee) {
		this.handleFee = handleFee;
	}
	public String getIsPrint() {
		return isPrint;
	}
	public void setIsPrint(String isPrint) {
		this.isPrint = isPrint;
	}
	public String getEmailHelpText() {
		return emailHelpText;
	}
	public void setEmailHelpText(String emailHelpText) {
		this.emailHelpText = emailHelpText;
	}
	
	
   
}
