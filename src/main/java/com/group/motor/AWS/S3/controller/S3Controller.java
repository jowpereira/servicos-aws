package com.group.motor.AWS.S3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.group.motor.AWS.S3.service.implement.S3ServiceImp;

@Controller
public class S3Controller {

	@Value("${s3.bucket}")
	private String bucketName;

	@Autowired
	private S3ServiceImp s3Service;
	
	public S3Controller() {
	}
	
	public List<S3ObjectSummary> listObeject() {
		return this.s3Service.listObj(bucketName);
	}
	
	public String copyObj(String Key) {
		return this.s3Service.copyObj(bucketName, Key);
	}
}
