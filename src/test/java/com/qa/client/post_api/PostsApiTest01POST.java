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
 *         calling POST METHOD for POST API and verifying its results.
 */
public class PostsApiTest01POST extends TestBase {

	RestClient restclient;
	String baseUrl;
	String serviceUrl;
	Response response;
	PostData postData;

	/**
	 * fetching data from properties file and calling POST method of RestClient
	 */
	@BeforeTest
	public void createPosts() {

		System.out.println("create posts");

		baseUrl = propconfig.getProperty("URL");
		serviceUrl = propconfig.getProperty("postServiceURL");

		restclient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		postData = new PostData();
		postData.setUserId(propData.getProperty("userId"));
		postData.setTitle(propData.getProperty("title"));
		postData.setBody(propData.getProperty("body"));

		response = restclient.POST(baseUrl, serviceUrl, postData, headerMap);
		System.out.println("Generated Id :" + response.jsonPath().get("id"));
	}

	@Test
	public void checkResponseBodyForPostAPI() {

		// verifying data in response
		Assert.assertEquals(response.jsonPath().get("userId"), propData.getProperty("userId"));
		Assert.assertEquals(response.jsonPath().get("title"), propData.getProperty("title"));
		Assert.assertEquals(response.jsonPath().get("body"), propData.getProperty("body"));

	}

	@Test
	public void checkstatusCodeForPostAPI() {

		// verifying status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

	}

}
