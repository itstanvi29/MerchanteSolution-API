package com.qa.client.post_api;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.rest.client.RestClient;
import io.restassured.response.Response;

/**
 * @author tanvig
 *
 *         calling GET METHOD for POST API and verifying its results.
 */
public class PostsApiTest02GET extends TestBase {

	RestClient restclient;
	String baseUrl;
	String serviceUrl;
	Response response;

	/**
	 * fetching data from properties file and calling GET method of RestClient
	 */
	@BeforeTest
	public void getCallForPostAPI_Success() {

		baseUrl = propconfig.getProperty("URL");
		serviceUrl = propconfig.getProperty("postServiceURL");

		restclient = new RestClient();
		response = restclient.get(baseUrl, serviceUrl);

	}

	@Test(priority = 1)
	public void checkStatusCodeForPostAPI() {

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

	@Test(priority = 2)
	public void checkResponseBodyForPostAPI() {

		Assert.assertTrue(response.getBody() != null);
		System.out.println(response.getBody().asString());

	}

	@Test(priority = 3)
	public void checkResponseTimeForPostAPI() {

		System.out.println(response.getTime());
		Assert.assertTrue(response.getTime() < 1500);

	}

	@Test(priority = 4)
	public void getCallForPostAPI_fail() {
		restclient = new RestClient();
		Response response = restclient.get(baseUrl, serviceUrl + "01");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 404);
	}

}
