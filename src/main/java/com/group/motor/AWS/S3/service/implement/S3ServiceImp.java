package com.group.motor.AWS.S3.service.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.group.motor.AWS.S3.service.S3Service;

@Service
public class S3ServiceImp implements S3Service {
	
	@Autowired
	private AmazonS3 s3Client;
	
	public S3ServiceImp() {
		
	}
	public List<S3ObjectSummary> listObj(String bucketName) {

		final AmazonS3 s3 = this.s3Client;
		ListObjectsV2Result result = s3.listObjectsV2(bucketName);
		List<S3ObjectSummary> objects = result.getObjectSummaries();

		return objects;
	}

	public String copyObj(String bucketName, String Key) {

		final AmazonS3 s3 = this.s3Client;
		S3Object o = s3.getObject(bucketName, Key);
        S3ObjectInputStream s3is = o.getObjectContent();
        String s3Return = new BufferedReader(new InputStreamReader(s3is)).lines().collect(Collectors.joining("\n"));
        
        return s3Return;
	}
	@Override
	public void initS3(String awsId, String awsKey, String region) {
		// TODO Auto-generated method stub
		
	}

}
