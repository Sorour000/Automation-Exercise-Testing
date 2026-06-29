import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTests  extends BaseTest {

@Test(description = "Verify POST Login with valid email and password returns 200 - User exists")
  public void verifyLoginWithValidCredentialsReturnsUserExists(){
//  TC 07
  String response = given()
          .formParam("email","abanob.soror2017@gmail.com")
          .formParam("password", "123")
          .when()
          .post("/verifyLogin")
          .then()
          .statusCode(200)
          .extract()
          .asString();
  Assert.assertTrue(response.contains("200"));
  Assert.assertTrue(response.contains("User exists!"));

  }

    @Test(description = "Validate POST Login without email parameter returns 400")
    public void validateLoginWithoutEmailReturnsBadRequest(){
//      TC 08
      String response = given()
              .formParam("password", "123")
              .when()
              .post("/verifyLogin")
              .then()
              .statusCode(200)
              .extract()
              .asString();
      Assert.assertTrue(response.contains("400"));
      Assert.assertTrue(response.contains("Bad request, email or password parameter is missing in POST request"));


  }
    @Test(description = "Validate POST Login with invalid email returns 404 - User not found")
  public void validateLoginWithInvalidEmailReturnsUserNotFound(){
//      TC 09
      String response = given()
              .formParam("email","abanob.soror@gmail.com")
              .formParam("password", "123")
              .when()
              .post("/verifyLogin")
              .then()
              .statusCode(200)
              .extract()
              .asString();
      Assert.assertTrue(response.contains("404"));
      Assert.assertTrue(response.contains("User not found!"));


  }
    @Test(description = "Validate POST Login with invalid password returns 404 - User not found")
  public void validateLoginWithInvalidPasswordReturnsUserNotFound(){

//    TC 10
      String response = given()
              .formParam("email","abanob.soror2017@gmail.com")
              .formParam("password", "12345")
              .when()
              .post("/verifyLogin")
              .then()
              .statusCode(200)
              .extract()
              .asString();
      Assert.assertTrue(response.contains("404"));
      Assert.assertTrue(response.contains("User not found!"));

    }
    @Test(description = "Validate DELETE to Verify Login returns 405 - method not supported")
  public void validateDeleteToVerifyLoginReturnsMethodNotSupported(){
//    TC 11
      String response = given()
              .formParam("email","abanob.soror2017@gmail.com")
              .formParam("password", "123")
              .when()
              .delete("/verifyLogin")
              .then()
              .statusCode(200)
              .extract()
              .asString();
      Assert.assertTrue(response.contains("405"));
      Assert.assertTrue(response.contains("This request method is not supported"));
    }
}
