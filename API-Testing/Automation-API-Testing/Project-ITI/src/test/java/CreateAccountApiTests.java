import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateAccountApiTests {
    @Test(description = "Verify POST Create Account with all valid mandatory fields returns 201")
    public void verifyCreateAccountWithValidMandatoryFieldsReturnsCreated() {
//    TC 12
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
//                .formParam("email", "abanob.soror2015@gmail.com")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("201"));
        Assert.assertTrue(response.contains("User created!"));
    }

    @Test(description = "Validate POST Create Account without password returns error")
    public void validateCreateAccountWithoutPasswordReturnsError() {
// TC 13
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
//                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, password parameter is missing in POST request."));
    }

    @Test(description = "Validate POST Create Account without firstname returns error")
    public void validateCreateAccountWithoutFirstnameReturnsError() {
// TC 14
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
//                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, firstname parameter is missing in POST request."));
        System.out.println(response);
    }

    @Test(description = "Validate POST Create Account without lastname returns error")
    public void validateCreateAccountWithoutLastnameReturnsError() {
// TC 15
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
//                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, lastname parameter is missing in POST request."));
        System.out.println(response);
    }

    @Test(description = "Validate POST Create Account without mobile number returns error")
    public void validateCreateAccountWithoutMobileNumberReturnsError() {
// TC 16
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
//                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, mobile_number parameter is missing in POST request."));
        System.out.println(response);
    }

    @Test(description = "Validate POST Create Account without city returns error")
    public void validateCreateAccountWithoutCityReturnsError() {
// TC 17
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
//                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, city parameter is missing in POST request."));
        System.out.println(response);
    }


    @Test(description = "Validate POST Create Account without state returns error")
    public void validateCreateAccountWithoutStateReturnsError() {
// TC 18
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
//                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, state parameter is missing in POST request."));
        System.out.println(response);

    }

    @Test(description = "Validate POST Create Account without zipcode returns error")
    public void validateCreateAccountWithoutZipcodeReturnsError() {
        // TC 19
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
//                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, zipcode parameter is missing in POST request."));
        System.out.println(response);
    }

    @Test(description = "Validate POST Create Account without address1 returns error")
    public void validateCreateAccountWithoutAddress1ReturnsError() {
// TC 20
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
//                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, address1 parameter is missing in POST request."));
        System.out.println(response);
    }

    @Test(description = "Verify POST Create Account without date of birth returns 201")
    public void verifyCreateAccountWithoutDateOfBirthReturnsCreated() {
// TC 21
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
//                .formParam("birth_date", "1")
//                .formParam("birth_month", "1")
//                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("201"));
        Assert.assertTrue(response.contains("User created!"));
        System.out.println(response);

    }


    @Test(description = "Verify POST Create Account without address2 returns 201")
    public void verifyCreateAccountWithoutAddress2ReturnsCreated() {
// TC 22
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
//                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("201"));
        Assert.assertTrue(response.contains("User created!"));
        System.out.println(response);

    }



    @Test(description = "Verify POST Create Account without company returns 201")
    public void verifyCreateAccountWithoutCompanyReturnsCreated() {
// TC 23
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
//                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("201"));
        Assert.assertTrue(response.contains("User created!"));
        System.out.println(response);


    }

    @Test(description = "Verify POST Create Account without title returns 201")
    public void verifyCreateAccountWithoutTitleReturnsCreated() {
// TC 24
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
//                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("201"));
        Assert.assertTrue(response.contains("User created!"));
        System.out.println(response);
    }

    @Test(description = "Verify POST Create Account with Arabic characters in firstname")
    public void verifyCreateAccountWithArabicFirstname() {
// TC 25
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "أبانوب")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("201"));
        Assert.assertTrue(response.contains("User created!"));
        System.out.println(response);

    }

    @Test(description = "Verify POST Create Account with Arabic characters in lastname")
    public void verifyCreateAccountWithArabicLastname() {
// TC 26
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "سرور")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("201"));
        Assert.assertTrue(response.contains("User created!"));
        System.out.println(response);


    }

    @Test(description = "Validate POST Create Account with special characters-only firstname returns error")
    public void validateCreateAccountWithSpecialCharactersOnlyFirstnameReturnsError() {
// TC 27
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "@@@")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        System.out.println(response);

    }

    @Test(description = "Validate POST Create Account with special characters-only lastname returns error")
    public void validateCreateAccountWithSpecialCharactersOnlyLastnameReturnsError() {
        // TC 28
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "######")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+201270180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        System.out.println(response);

    }

    @Test(description = "Validate POST Create Account with alphabetic mobile number returns error")
    public void validateCreateAccountWithAlphabeticMobileNumberReturnsError() {
        // TC 29
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+012dfdf70180191")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        System.out.println(response);

    }

    @Test(description = "System should reject special characters in mobile number field")
    public void validateCreateAccountWithSpecialCharactersInMobileNumberReturnsError() {
        // TC 30
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+2012#$@701801911")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        System.out.println(response);


    }
    @Test(description = "Validate POST Create Account with spaces in mobile number returns error")
    public void validateCreateAccountWithSpacesInMobileNumberReturnsError() {
        // TC 33
        String email = "abanob" + System.currentTimeMillis() + "@gmail.com";
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .formParam("name", "Abanob Sorour")
                .formParam("email", email)
                .formParam("password", "123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "2002")
                .formParam("firstname", "Abanob")
                .formParam("lastname", "Sorour")
                .formParam("company", "ITI")
                .formParam("address1", "street Mohamed Shams")
                .formParam("address2", "Ain Shams 22")
                .formParam("country", "India")
                .formParam("zipcode", "3753450")
                .formParam("state", "Egypt")
                .formParam("city", "Cairo")
                .formParam("mobile_number", "+012 701 80 1          9  1")
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        System.out.println(response);


    }
}
