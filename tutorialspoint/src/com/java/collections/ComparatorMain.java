package com.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

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
		
		Collections.sort(listOfCounties, new CountrySortByIdComparator());
		
		System.out.println("After Sort by id : ");
		for(int i=0; i<listOfCounties.size(); i++) {
			Country c = listOfCounties.get(i);
			System.out.println("Country id : " + c.getCountryId() + 
					"  Country Name : " + c.getCountryName());
		}
		
		//Sort by Country name
		Collections.sort(listOfCounties, new Comparator<Country> () {
			@Override
			public int compare(Country country1, Country country2) {
				return country1.getCountryName().compareTo(country2.getCountryName());
			}
		});
		
		System.out.println("After Sort By Name: ");
		for(int i=0; i<listOfCounties.size(); i++) {
			Country c = listOfCounties.get(i);
			System.out.println("Country id : " + c.getCountryId() + 
					"  Country Name : " + c.getCountryName());
		}
	}

}

class CountrySortByIdComparator implements Comparator<Country> {
	
	public int compare(Country country1, Country country2) {

		return (country1.getCountryId() < country2.getCountryId() ? -1 : (country1.getCountryId() > country2.getCountryId() ? 1 : 0));
	}
}
