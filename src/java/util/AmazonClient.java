/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.sql.Time;
import java.time.LocalTime;


/**
 *
 * @author THINKPAD T450
 */
public class AmazonClient {
//    private String accessKey = "AKIAJS3BAJL7KLTXXFXQ";
//    private String secretKey = "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";
    
    public  String  uploadFile(File file){ 
        AmazonS3 s3Client = this.awsS3Client();
        String fileName = Time.valueOf(LocalTime.MIN).toString()+"-"+file.getName();
        String bucketURL = "projectaaw";
        PutObjectRequest request = new PutObjectRequest(bucketURL, fileName, file);
        s3Client.putObject(request);
        return bucketURL+"/"+fileName;
        
    }
    
    public  AmazonS3 awsS3Client() {
        String awsKeyId = "AKIAJ2LCNBVMGMQHV5PQ";
        String accessKey = "kyycOJZQXPGY12j6rihNIgVolO3u2CKjS1jzHgv/";
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsKeyId, accessKey);
        return AmazonS3ClientBuilder.standard().withRegion(Regions.EU_WEST_3)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    }
    
}
