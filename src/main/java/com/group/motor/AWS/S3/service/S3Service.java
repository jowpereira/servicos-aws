package com.group.motor.AWS.S3.service;

import java.util.List;

import com.amazonaws.services.s3.model.S3ObjectSummary;

public interface S3Service {
	void initS3(String awsId, String awsKey, String region);
	List<S3ObjectSummary> listObj(String bucketName);
	String copyObj(String bucketName, String Key);
	
}
