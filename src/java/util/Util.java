/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectResult;
import entities.UserEntity;
import java.io.File;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    
}
