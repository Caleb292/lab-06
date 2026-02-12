package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        // The cityList initializes with Edmonton
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in cityList (retrieved by cityLIst.getCities()
        // .get(0)) is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now original city should be at Pos 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList(); // Creates a mock city list
        City edmonton = mockCity();
        City calgary = new City("Calgary", "Alberta");

        // Test: Calgary should not be in list
        assertFalse(cityList.hasCity(calgary));

        // Test: Add Calgary. Calgary should be in list
        cityList.add(calgary);
        assertTrue(cityList.hasCity(calgary));

        // Test: Edmonton should be in list
        assertTrue(cityList.hasCity(edmonton));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList(); // Creates a mock city list
        City edmonton = mockCity();
        City calgary = new City("Calgary", "Alberta");

        // Test: Delete Calgary. Should throw an error.
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(calgary);
        });

        // Test: Delete edmonton. Should succeed.
        cityList.delete(edmonton);
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(edmonton));
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList(); // Creates a mock city list
        City edmonton = mockCity();
        City calgary = new City("Calgary", "Alberta");
        City calgary2 = new City("Calgary", "PEI");

        // Test: Run count cities. Should be 1
        assertEquals(1, cityList.countCities());

        // Test: Add city calgary. Run count. Should be 2
        cityList.add(calgary);
        assertEquals(2, cityList.countCities());

        // Test: Add city calgary again. Run count. Should be 2
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(calgary);
        });
        assertEquals(2, cityList.countCities());

        // Test: Add city calgary2. Run count. Should be 3
        cityList.add(calgary2);
        assertEquals(3, cityList.countCities());

        // Test: Delete edmonton, calgary and calgary2. Run count. Should be 0
        cityList.delete(edmonton);
        cityList.delete(calgary);
        cityList.delete(calgary2);
        assertEquals(0, cityList.countCities());
    }
}
