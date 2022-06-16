package com.helloworld;
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
    public static final String PROD_CODE = "010";
    private static Constants Constants = null;
    static AWSCredentials ac;
    static AmazonDynamoDB dynamodb;
    public synchronized static Constants getInstance() {
        if (Constants == null) {
            Constants = new Constants();

            ac = new BasicAWSCredentials(ACCESS_KEY, SECERET_KEY);

            dynamodb = AmazonDynamoDBClientBuilder
                    .standard()
            .withRegion("us-west-2")
            .withCredentials(new AWSStaticCredentialsProvider(ac) )
            .build();
            System.out.println("Repo instance created");
        }
        return Constants;
    }
}