package com.nsc.tsui.service;

import java.util.List;

import com.nsc.tsui.model.Config;
import com.nsc.tsui.model.School;

public interface ScService {

	public List<School> getToSCProfile();
	public Config getToSCProfileByIDAndFiceCode(String to_scprofile_id,String fice_code);
}
