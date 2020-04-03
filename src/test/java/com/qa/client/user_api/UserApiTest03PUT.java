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
 *         calling PUT METHOD for User API and verifying its results.
 */
public class UserApiTest03PUT extends TestBase {

	RestClient restclient;
	String baseUrl;
	String serviceUrl;
	Response response;
	String id = "423453453764";

	/**
	 * fetching data from properties file and calling OT method of RestClient
	 */
	@BeforeTest
	public void updatePosts() {

		baseUrl = propconfig.getProperty("URL");
		serviceUrl = propconfig.getProperty("usersServiceURL") + "/" + id;

		// System.out.println("setUp base url" +baseUrl);

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

		/*
		 * AddressData addressData = new AddressData(propData.getProperty("street"),
		 * propData.getProperty("suite"), propData.getProperty("city"),
		 * propData.getProperty("zipCode"), geoDetails);
		 */

		/*
		 * UsersData userData = new UsersData(propData.getProperty("name"),
		 * propData.getProperty("userName"), propData.getProperty("email"),
		 * propData.getProperty("phone"), propData.getProperty("website"),
		 * companyDetails, addressData);
		 */

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
		response = restclient.PUT(baseUrl, serviceUrl, id, userData, headerMap);

		System.out.println("response-- " + response.getBody().asString());
		System.out.println("Generated Id :" + response.jsonPath().get("id"));
	}

	@Test
	public void checkResponseBodyForUserAPI() {

		// verifying data in response
		Assert.assertTrue(response.jsonPath().get("id").toString().contains(id));
		Assert.assertEquals(response.jsonPath().get("username"), propData.getProperty("username"));
		Assert.assertEquals(response.jsonPath().get("name"), propData.getProperty("name"));
		Assert.assertEquals(response.jsonPath().get("website"), propData.getProperty("website"));

	}

	@Test
	public void checkstatusCodeForUserAPI() {

		// verifying status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

}
