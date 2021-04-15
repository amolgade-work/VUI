import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Class usage: List of test cases that test endpoint '/{country}/{state}/{place}' returns expected nearby area details given country, state and city parameters
 *
 * @author amolgade
 * Date created: April 2021
 */

public class GetNearbyPlacesTest extends Setup {

    @BeforeClass
    void beforeClass() {
        setupBaseURL();
    }

    /**
     * Test cases IDs: VUI-API-09
     */
    @Test
    void test_nearby() {

        country = "us";
        postalCode = "90210";

        String path = "nearby" + "/" + country + '/' + postalCode;

        Response response = RestAssured.get(path);

        Assert.assertEquals(response.getStatusCode(), 200);

        response.prettyPrint();
        //print headers
        System.out.println(response.getHeaders());

    }
}
