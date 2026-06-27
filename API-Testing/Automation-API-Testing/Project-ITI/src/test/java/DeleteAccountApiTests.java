import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class DeleteAccountApiTests {

@Test(description = "Verify DELETE Account with valid credentials returns 200")
   public void verifyDeleteAccountWithValidCredentialsReturnsSuccess(){
//   TC37
   String response = given()
           .baseUri("https://automationexercise.com/api")
           .formParam("email","abanob.soror2015@gmail.com")
           .formParam("password","123")
           .when()
           .delete("/deleteAccount")
           .then()
           .statusCode(200)
           .extract()
           .asString();
   Assert.assertTrue(response.contains("200"));
   Assert.assertTrue(response.contains("Account deleted!"));
}




@Test(description = "Validate DELETE Account with incorrect password returns error")
   public void validateDeleteAccountWithIncorrectPasswordReturnsError(){
//   TC38
   String response = given()
           .baseUri("https://automationexercise.com/api")
           .formParam("email","abanob.soror2017@gmail.com")
           .formParam("password","123456")
           .when()
           .delete("/deleteAccount")
           .then()
           .statusCode(200)
           .extract()
           .asString();
   Assert.assertTrue(response.contains("404"));
   Assert.assertTrue(response.contains("Account not found!"));









}


}
