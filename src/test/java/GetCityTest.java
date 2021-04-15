import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Class usage: List of test cases that test endpoint '/{country}/{postalcode}' returns expected place details given zip code and country
 *
 * @author amolgade
 * Date created: April 2021
 */

public class GetCityTest extends Setup {


    @BeforeClass
    void beforeClass() {
        setupBaseURL();
    }

    /**
     * This data provider returns a 2d list of valid test data objects
     *
     * @return Object[][]{String country , String postalCode, String city, String description}
     * @throws JsonException
     */
    @DataProvider(name = "test-data")
    public Object[][] validTestData() throws JsonException {
        return new Object[][]{
                {"US", "02180", "Stoneham", "USA zip code"},
                {"US", "02128", "Boston", "USA zip code"}
        };
    }

    /**
     * Test cases IDs: VUI-API-01, VUI-API-02
     *
     * @param country
     * @param postalCode
     * @param city
     * @param description
     */

    @Test(dataProvider = "test-data")
    void test(String country, String postalCode, String city, String description) {

        String path = country + '/' + postalCode;

        Response response = RestAssured.get(path);

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertTrue(response.then().extract().path("places").toString().contains(city));

        response.prettyPrint();

    }


}
