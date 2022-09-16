package com.nsc.tsui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsc.tsui.util.MockUtil;

@RestController
public class OrganizationController {

	@GetMapping(path = "/recipient-organizations")
	public String  getReceipientOrganization(){
		return MockUtil.RECEIPIENT_ORG;
	}


}
