package com.helloworld;
import java.util.logging.Logger;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
public class Constants {
    // private constructor to avoid instantiation
    private Constants(){}
    
    private static String ACCESS_KEY = "";
    private static String SECERET_KEY = "";
    private static String dbport="3000";
    private static String dbusername="root";
    private static String dbpassword="sk_live_454kjkj4545FD3434Srere7878";
    private static Constants Constants = null;
    static AWSCredentials aac;
    static AmazonDynamoDB ddb;
    public synchronized static Constants getInstance() {
        if (Constants == null) {
            Constants = new Constants();
            try {
                aac = new BasicAWSCredentials(ACCESS_KEY, SECERET_KEY);

                ddb= AmazonDynamoDBClientBuilder
                    .standard()
            .withRegion("us-west-2")
            .withCredentials(new AWSStaticCredentialsProvider(aac) )
            .build();
            System.out.println("Repo instance created");
            } catch (final Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Hiding the exception");
            }
            
        }
        return Constants;
    }
}