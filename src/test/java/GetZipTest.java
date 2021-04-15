import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Class usage: List of test cases that test endpoint '/{country}/{state}/{place}' returns expected zip details given country, state and city parameters
 *
 * @author amolgade
 * Date created: April 2021
 */

public class GetZipTest extends Setup {

    @BeforeClass
    void beforeClass() {
        setupBaseURL();
    }

    /**
     * Test cases IDs: VUI-API-05
     */
    @Test
    void test_city() {

        country = "ca";
        String state = "on";
        String city = "toronto";

        String path = country + '/' + state + "/" + city;

        Response response = RestAssured.get(path);

        Assert.assertEquals(response.getStatusCode(), 200);

        response.prettyPrint();

    }
}
