import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserDetailsApiTests {

  @Test(description = "Verify GET User Detail by valid email returns 200 with user data")
  public void verifyGetUserDetailByValidEmail() {
//    TC 32
    String response = given()
            .baseUri("https://automationexercise.com/api")
            .queryParam("email", "abanob.soror2017@gmail.com")
            .when()
            .get("/getUserDetailByEmail")
            .then()
            .statusCode(200)
            .extract()
            .asString();

    Assert.assertTrue(response.contains("200"));
    Assert.assertTrue(response.contains("abanob.soror2017@gmail.com"));
    System.out.println(response);
  }





    @Test(description = "Validate GET User Detail with non-existing email returns 404")
  public void validateGetUserDetailWithNonExistingEmailReturnsNotFound(){
//    TC 33
      String response = given()
              .baseUri("https://automationexercise.com/api")
              .queryParam("email", "abanob.soror@gmail.com")
              .when()
              .get("/getUserDetailByEmail")
              .then()
              .statusCode(200)
              .extract()
              .asString();

      Assert.assertTrue(response.contains("404"));
      Assert.assertTrue(response.contains("not found"));
      System.out.println(response);
    }




    @Test(description = "Validate GET User Detail without email parameter returns 400")
  public void validateGetUserDetailWithoutEmailReturnsBadRequest(){
//    TC 34
      String response = given()
              .baseUri("https://automationexercise.com/api")
              .when()
              .get("/getUserDetailByEmail")
              .then()
              .statusCode(200)
              .extract()
              .asString();

      Assert.assertTrue(response.contains("400"));
      Assert.assertTrue(response.contains("email parameter is missing"));
      System.out.println(response);





  }
}
