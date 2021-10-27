package com.melon.CucumberAPITestingFramework.cuke.base;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {
	
	public static Properties config= new Properties();
	public static FileInputStream fis;
	public static String client_id;
	public static String secret;
	
	public static Response response;
	
	public static void init() {
	
		try {
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
	    } catch (Exception e) {System.out.println(e);}
		try {
			config.load(fis);
		} catch (Exception e) {System.out.println(e);}
		
		RestAssured.baseURI=config.getProperty("baseURI");
		
        client_id = config.getProperty("paypalClientID");
        System.out.println("Client ID is :"+client_id);
        secret = config.getProperty("paypalSecret");
        System.out.println("PAYPAL secret is  :"+secret);
}
	
	
}
