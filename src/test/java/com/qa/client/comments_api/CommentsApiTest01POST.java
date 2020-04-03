package com.qa.client.comments_api;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.data.CommentsData;
import com.qa.rest.client.RestClient;
import io.restassured.response.Response;

/**
 * @author tanvig
 *
 *         calling POST METHOD for Comments API and verifying its results.
 */
public class CommentsApiTest01POST extends TestBase {

	RestClient restclient;
	String baseUrl;
	String serviceUrl;
	Response response;
	CommentsData commentsData;

	/**
	 * fetching data from properties file and calling POST method of RestClient
	 */
	@BeforeTest
	public void createPosts() {

		System.out.println("create posts");

		baseUrl = propconfig.getProperty("URL");
		serviceUrl = propconfig.getProperty("commentsServiceURL");

		restclient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		commentsData = new CommentsData();
		commentsData.setpostId(propData.getProperty("postId"));
		commentsData.setName(propData.getProperty("name"));
		commentsData.setEmail(propData.getProperty("email"));
		commentsData.setBody(propData.getProperty("body"));

		// calling the POST method
		response = restclient.POST(baseUrl, serviceUrl, commentsData, headerMap);
		System.out.println("Generated Id :" + response.jsonPath().get("id"));
	}

	@Test
	public void checkResponseBodyForPostAPI() {

		// verifying data in response
		Assert.assertEquals(response.jsonPath().get("postId"), propData.getProperty("postId"));
		Assert.assertEquals(response.jsonPath().get("name"), propData.getProperty("name"));
		Assert.assertEquals(response.jsonPath().get("email"), propData.getProperty("email"));
		Assert.assertEquals(response.jsonPath().get("body"), propData.getProperty("body"));

	}

	@Test
	public void checkstatusCodeForPostAPI() {

		// verifying status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

	}

}
