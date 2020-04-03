package com.qa.rest.client;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author tanvig
 * 
 *         implements GET,POST,PUT calls
 *
 */
public class RestClient {

	// GET Method
	public Response get(String baseURL, String serviceURL) {

		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(serviceURL);
		return response;

	}

	// POST Method
	public Response POST(String baseURL, String serviceURL, Object postData, HashMap<String, String> headerMap) {

		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();

		// setting the payload in request
		httpRequest.body(postData);

		// setting the header
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpRequest.header(entry.getKey(), entry.getValue());
		}

		// calling the post method
		Response response = httpRequest.post(serviceURL);

		// System.out.println("response--" + response.asString());
		return response;

	}

	// PUT Method
	public Response PUT(String baseURL, String serviceURL, String id, Object postData,
			HashMap<String, String> headerMap) {

		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();

		// setting the payload in request
		httpRequest.body(postData);

		System.out.println("request data--" + postData.toString());

		// setting the header
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpRequest.header(entry.getKey(), entry.getValue());
		}

		// calling the post method

		Response response = httpRequest.put(serviceURL);
		return response;

	}
}
