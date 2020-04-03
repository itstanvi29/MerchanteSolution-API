package com.qa.data;

import java.util.Map;

/**
 * @author tanvig
 *
 */
public class AddressData {


	public AddressData() {

	}

	/*
	 * public AddressData ( String street, String suite, String city, String zipCode
	 * , Map<String, String> geo) {
	 * 
	 * this.street=street; this.suite=suite; this.city=city; this.zipCode=zipCode;
	 * this.geo=geo; }
	 */

	public String toString() {
		return "Address details----  " + this.street +" "+  this.suite +"  "+  this.city + " " +
				this.zipCode ;
	}

	public Map<String, String> getGeo() {
		return geo;
	}
	public void setGeo(Map<String, String> geo) {
		this.geo = geo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	private Map<String, String> geo;
	private String street;
	private String suite;
	private String city;
	private String zipCode;

}
