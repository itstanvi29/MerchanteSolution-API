package com.qa.data;

import java.util.Map;

/**
 * @author tanvig
 *
 */
public class UsersData {

	public UsersData() {

	}

	/*
	 * public UsersData (String name,String userName ,String email, String phone,
	 * String website ,Map<String,String> company, AddressData addressData ) {
	 * 
	 * this.name=name; this.userName=userName; this.email=email; this.phone=phone;
	 * this.website=website; this.company=company; this.addressData=addressData;
	 * 
	 * }
	 */

	public String toString() {
		return "Users details are :" + this.name + " " + this.userName + "  " + this.email + " " + this.phone + " "
				+ this.website + " " + this.company + " " + addressData.toString();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Map<String, String> getCompany() {
		return company;
	}

	public void setCompany(Map<String, String> company) {
		this.company = company;
	}

	public AddressData getAddressData() {
		return addressData;
	}

	public void setAddressData(AddressData addressData) {
		this.addressData = addressData;
	}

	private String name;
	private String userName;
	private String email;
	private String phone;
	private String website;
	private AddressData addressData;
	private Map<String, String> company;

}
