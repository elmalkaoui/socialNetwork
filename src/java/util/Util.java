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
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import entities.UserEntity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author THINKPAD T450
 */
public class Util {
    
    
    public static int getPosition(List<UserEntity> list, long userId){
        for (UserEntity user : list) {
            if(user.getId() == userId)
                return list.indexOf(user);
        }
        return -1;
    }
    
    public static String  uploadFile(File file){
        AmazonS3 s3Client;
        s3Client = AmazonS3ClientBuilder.defaultClient();
        
        String fileName = Time.valueOf(LocalTime.MIN).toString()+"-"+file.getName();
        PutObjectResult result = s3Client.putObject("https://s3.console.aws.amazon.com/s3/buckets/projectaaw", fileName, file);
        
        return "https://s3.console.aws.amazon.com/s3/buckets/projectaaw/"+fileName;
    }
    
    public static List<UserEntity> externJoin(List<UserEntity> list1, List<UserEntity> list2){
        List<UserEntity> result = new ArrayList<UserEntity>();
        boolean in = false;
        for (UserEntity user1 : list1) {
            for (UserEntity user2 : list2) {
                   if(user1.getId().equals(user2.getId()))
                       in = true;
            }
            if (in == false )
                result.add(user1);
        }
        return result;
    }
    
    public static  String  uploadFile(CommonsMultipartFile file) throws FileNotFoundException, IOException{ 
        AmazonClient s3client = new AmazonClient();
        AmazonS3 s3Client = awsS3Client();
        String contentType = file.getContentType();
        InputStream is = file.getInputStream();
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(is.available());
        String fileName = System.currentTimeMillis()/1000+"-"+file.getOriginalFilename();
        String bucketURL = "projectaaw";
        PutObjectRequest request = new PutObjectRequest(bucketURL, fileName, is, meta).withCannedAcl(CannedAccessControlList.PublicRead);
        s3Client.putObject(request);
        return bucketURL+"/"+fileName;
        
    }
    
    public static AmazonS3 awsS3Client() {
        String awsKeyId = "AKIAJ2LCNBVMGMQHV5PQ";
        String accessKey = "kyycOJZQXPGY12j6rihNIgVolO3u2CKjS1jzHgv/";
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsKeyId, accessKey);
        return AmazonS3ClientBuilder.standard().withRegion(Regions.EU_WEST_3)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    }
}
