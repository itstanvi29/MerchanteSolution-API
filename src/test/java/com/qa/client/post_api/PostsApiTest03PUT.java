package com.qa.client.post_api;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.data.PostData;
import com.qa.rest.client.RestClient;

import io.restassured.response.Response;

/**
 * @author tanvig
 *
 *         calling PUT METHOD for Post API and verifying its results.
 */
public class PostsApiTest03PUT extends TestBase {

	RestClient restclient;
	String baseUrl;
	String serviceUrl;
	Response response;
	PostData postData;
	String id = "rJQcR2VwU";

	/**
	 * fetching data from properties file and calling PUT method of RestClient
	 */
	@BeforeTest
	public void updatePosts() {

		baseUrl = propconfig.getProperty("URL");
		serviceUrl = propconfig.getProperty("postServiceURL") + "/" + id;

		// System.out.println("setUp base url" +baseUrl);

		restclient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		/*
		 * PostData postData = new PostData(propData.getProperty("userId"),
		 * propData.getProperty("title"), propData.getProperty("body"));
		 */

		postData = new PostData();
		postData.setUserId(propData.getProperty("userId"));
		postData.setTitle(propData.getProperty("title"));
		postData.setBody(propData.getProperty("body"));

		System.out.println("User api post data---" + postData.toString());

		response = restclient.PUT(baseUrl, serviceUrl, id, postData, headerMap);

		System.out.println("response-- " + response.getBody().asString());
		System.out.println("Generated Id :" + response.jsonPath().get("id"));
	}

	@Test
	public void checkResponseBodyForPostAPI() {

		// verifying data in response
		Assert.assertEquals(response.jsonPath().get("id"), id);
		Assert.assertEquals(response.jsonPath().get("userId"), propData.getProperty("userId"));
		Assert.assertEquals(response.jsonPath().get("title"), propData.getProperty("title"));
		Assert.assertEquals(response.jsonPath().get("body"), propData.getProperty("body"));
	}

	@Test
	public void checkstatusCodeForPostAPI() {

		// verifying status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

}
