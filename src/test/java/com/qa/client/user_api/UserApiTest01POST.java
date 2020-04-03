package com.qa.client.user_api;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.data.AddressData;
import com.qa.data.UsersData;
import com.qa.rest.client.RestClient;

import io.restassured.response.Response;

/**
 * @author tanvig
 *
 *         calling POST METHOD for User API and verifying its results.
 */
public class UserApiTest01POST extends TestBase {

	RestClient restclient;
	String baseUrl;
	String serviceUrl;
	Response response;

	/**
	 * fetching data from properties file and calling POST method of RestClient
	 */
	@BeforeTest
	public void createPosts() {

		System.out.println("create posts");

		baseUrl = propconfig.getProperty("URL");
		serviceUrl = propconfig.getProperty("usersServiceURL");

		restclient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		Map<String, String> geoDetails = new HashMap<String, String>();
		geoDetails.put("latitude", propData.getProperty("latitude"));
		geoDetails.put("longitude", propData.getProperty("longitude"));

		Map<String, String> companyDetails = new HashMap<String, String>();
		companyDetails.put("name", propData.getProperty("companyName"));
		companyDetails.put("catchPhrase", propData.getProperty("catchPhrase"));
		companyDetails.put("bs", propData.getProperty("bs"));

		AddressData addressData = new AddressData();
		addressData.setStreet(propData.getProperty("street"));
		addressData.setSuite(propData.getProperty("suite"));
		addressData.setCity(propData.getProperty("city"));
		addressData.setZipCode(propData.getProperty("zipCode"));
		addressData.setGeo(geoDetails);

		UsersData userData = new UsersData();
		userData.setName(propData.getProperty("name"));
		userData.setUserName(propData.getProperty("userName"));
		userData.setEmail(propData.getProperty("email"));
		userData.setPhone(propData.getProperty("phone"));
		userData.setWebsite(propData.getProperty("website"));
		userData.setCompany(companyDetails);
		userData.setAddressData(addressData);

		System.out.println("User api post data---" + userData.toString());

		response = restclient.POST(baseUrl, serviceUrl, userData, headerMap);
		System.out.println("Generated Id :" + response.jsonPath().get("id"));
	}

	@Test
	public void checkResponseBodyForPostAPI() {

		// verifying data in response
		Assert.assertEquals(response.jsonPath().get("username"), propData.getProperty("username"));
		Assert.assertEquals(response.jsonPath().get("name"), propData.getProperty("name"));
		Assert.assertEquals(response.jsonPath().get("website"), propData.getProperty("website"));

	}

	@Test
	public void checkstatusCodeForPostAPI() {

		// verifying status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

	}

}
