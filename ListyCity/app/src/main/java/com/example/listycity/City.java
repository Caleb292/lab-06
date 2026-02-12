package com.example.listycity;

/**
 * This is a class that defines a city.
 */
public class City implements Comparable {
    public String city;
    public String province;

    /**
     * Creates a new city object, with specified city name and province
     * @param city
     * @param province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of the city.
     * @return
     */
    public String getCityName() {
        return city;
    }

    /**
     * Returns the name of the province.
     * @return
     */
    public String getProvinceName() {
        return province;
    }

    /**
     * Cities are
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        // this.city refers to the city name
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Determines if city equal to the specified object.
     * 2 cities are equal if have same CITY NAME and PROVINCE NAME
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return this.city.equals(city.city) && this.province.equals(city.province);
    }

    /**
     * Returns a hash code value for city based on city name and province name
     * @return
     */
    @Override
    public int hashCode() {
        return this.city.hashCode() * 31 + this.province.hashCode();
    }
}
