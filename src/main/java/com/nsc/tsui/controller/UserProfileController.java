package com.nsc.tsui.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nsc.tsui.util.CommonUtil;
import com.nsc.tsui.util.MockUtil;

@RestController
public class UserProfileController {

	@GetMapping("/userprofile/{accesscode}")
	public String getUserProfileByAccessCode(@PathVariable("accesscode") String accesscode){
		return MockUtil.USER_PROFILE_BY_ACCESS_CODE;
	}

	@PostMapping("/attachment")
    public String uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {
		String fileName = uploadfile.getName();
		String fileExtenstion = uploadfile.getOriginalFilename();
       return "{\"status\":\"string\",\"fileName\":\""+fileName+"\",\"fileExtension\":\""+fileExtenstion+"\"}";
    }

}
