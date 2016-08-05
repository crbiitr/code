package com.java.chetan.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Country india = new Country(1, "India");
		Country china = new Country(4, "China");
		Country nepal = new Country(3, "Nepal");
		Country bhutan = new Country(2, "Bhutan");
		
		List<Country> listOfCounties = new ArrayList<Country>();
		listOfCounties.add(india);
		listOfCounties.add(china);
		listOfCounties.add(nepal);
		listOfCounties.add(bhutan);
		
		System.out.println("Before Sort : ");
		for(int i=0; i<listOfCounties.size(); i++) {
			Country c = listOfCounties.get(i);
			System.out.println("Country id : " + c.getCountryId() + 
					"  Country Name : " + c.getCountryName());
		}
		
		Collections.sort(listOfCounties);
		
		System.out.println("After Sort : ");
		for(int i=0; i<listOfCounties.size(); i++) {
			Country c = listOfCounties.get(i);
			System.out.println("Country id : " + c.getCountryId() + 
					"  Country Name : " + c.getCountryName());
		}
	}

	
}

class Country implements Comparable<Country> {
	
	private int countryId;
	private String countryName;
	/**
	 * @return the countryId
	 */
	int getCountryId() {
		return countryId;
	}
	/**
	 * @param countryId the countryId to set
	 */
	void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	/**
	 * @return the countryName
	 */
	String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public Country(int id, String name) {
		super();
		countryId = id;
		countryName = name;
	}
	
	@Override
	public int compareTo(Country country) {
		
		return (this.countryId < country.countryId ? -1 : (this.countryId > country.countryId ? 1 : 0));
	}
	
}