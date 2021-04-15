import io.restassured.RestAssured;

/**
 * Class usage: Basic setup helper class
 *
 * @author amolgade
 * Date created: April 2021
 */

public class Setup {

    static String country;
    static String postalCode;
    static String city;

    void setupBaseURL() {
        RestAssured.baseURI = "https://api.zippopotam.us/";
    }
}
