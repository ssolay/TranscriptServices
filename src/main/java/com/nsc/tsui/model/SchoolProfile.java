package com.nsc.tsui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolProfile {

	@JsonView({Views.Nsc.class, Views.WebApp.class})
	private Integer ScProfileId;
	@JsonView({Views.Nsc.class, Views.WebApp.class})
	private String ficeCode;
	@JsonView({Views.Nsc.class, Views.WebApp.class})
	private String name;
	@JsonView({Views.Nsc.class, Views.WebApp.class})
	private String city;
	@JsonView({Views.Nsc.class, Views.WebApp.class})
	private String state;
	@JsonView({Views.Nsc.class, Views.WebApp.class})
	private Integer studentPopulation;
	@JsonView({Views.Nsc.class, Views.WebApp.class})
	private String status;

	@JsonCreator
	public SchoolProfile(@JsonProperty("toScprofilId") Integer scProfileId,
				  @JsonProperty("ficeCode") String ficeCode,
				  @JsonProperty("schlName") String name,
				  @JsonProperty("city") String city,
						 @JsonProperty("state") String state,
						 @JsonProperty("studentPopulation") Integer studentPopulation,
						 @JsonProperty("status") String status){
		this.ScProfileId = scProfileId;
		this.ficeCode = ficeCode;
		this.name = name;
		this.city = city;
		this.state = state;
		this.studentPopulation = studentPopulation;
		this.status = status;
	}
//	private List<DeliveryMethods> deliveryMethods;
//	private List<ProcessingOptions> processingOptions;
//	private List<Quantities> quantities;
//	private List<TranscriptPurposes> transcriptPurposes;
//	private List<TranscriptTypes> transcriptTypes;
//	private List<DeptProcessingOptionInfos> deptProcessingOptionInfos;
//	private List<NetworkInfos> networkInfos;
//	private List<ScCampus> scCampus;
//	private List<ToScprofilDynmicIntgrtn> toScprofilDynmicIntgrtn;
//
//	public List<ToScprofilDynmicIntgrtn> getToScprofilDynmicIntgrtn() {
//		return toScprofilDynmicIntgrtn;
//	}
//	public void setToScprofilDynmicIntgrtn(List<ToScprofilDynmicIntgrtn> toScprofilDynmicIntgrtn) {
//		this.toScprofilDynmicIntgrtn = toScprofilDynmicIntgrtn;
//	}
//	public List<ScCampus> getScCampus() {
//		return scCampus;
//	}
//	public void setScCampus(List<ScCampus> scCampus) {
//		this.scCampus = scCampus;
//	}
//	public List<TranscriptTypes> getTranscriptTypes() {
//		return transcriptTypes;
//	}
//	public List<NetworkInfos> getNetworkInfos() {
//		return networkInfos;
//	}
//	public void setNetworkInfos(List<NetworkInfos> networkInfos) {
//		this.networkInfos = networkInfos;
//	}
//	public List<DeptProcessingOptionInfos> getDeptProcessingOptionInfos() {
//		return deptProcessingOptionInfos;
//	}
//	public void setDeptProcessingOptionInfos(List<DeptProcessingOptionInfos> deptProcessingOptionInfos) {
//		this.deptProcessingOptionInfos = deptProcessingOptionInfos;
//	}
//	public void setTranscriptTypes(List<TranscriptTypes> transcriptTypes) {
//		this.transcriptTypes = transcriptTypes;
//	}
//	public List<DeliveryMethods> getDeliveryMethods() {
//		return deliveryMethods;
//	}
//	public void setDeliveryMethods(List<DeliveryMethods> deliveryMethods) {
//		this.deliveryMethods = deliveryMethods;
//	}
//	public List<ProcessingOptions> getProcessingOptions() {
//		return processingOptions;
//	}
//	public void setProcessingOptions(List<ProcessingOptions> processingOptions) {
//		this.processingOptions = processingOptions;
//	}
//	public List<Quantities> getQuantities() {
//		return quantities;
//	}
//	public void setQuantities(List<Quantities> quantities) {
//		this.quantities = quantities;
//	}
//	public List<TranscriptPurposes> getTranscriptPurposes() {
//		return transcriptPurposes;
//	}
//	public void setTranscriptPurposes(List<TranscriptPurposes> transcriptPurposes) {
//		this.transcriptPurposes = transcriptPurposes;
//	}
	
 }
