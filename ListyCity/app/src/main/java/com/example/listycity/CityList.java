package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>(); // List to hold City Objects

    /**
     * This adds a city to the list if the city doesn't exist
     * @param city
     *  This is a candidate city to add
     */
    public void add(City city) {
        // If the city is already inside the list, throws an exception.
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *  Return the sorted list
     */
    public List<City> getCities() {
        List<City>list = cities;
        // Collections error
        Collections.sort(list);
        return list;
    }

    /**
     * When given a city, checks if city is in the list or not
     * @param city
     *  This is a candidate city to check.
     * @return
     *  Returns "True" if city in list, "False" if not
     */
    public boolean hasCity(City city) {
        if (cities.contains(city)) {
            return true;
        }
        return false;
    }

    /**
     * Check if a city is in the list. If yes, removes it from the list.
     * Else, throws an exception
     * @param city
     *  This is a candidate city to check.
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("Can't delete a city not in the list");
        }
        cities.remove(city);
    }

    /**
     * Given a list of cities, returns how many are in list
     * @return
     *  Returns the number of cities in list
     */
    public int countCities() {
        return cities.size();
    }


}
