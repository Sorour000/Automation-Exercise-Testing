import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateAccountApiTests {

@Test(description = "Verify PUT Update Account with all valid fields returns 200")
  public void  verifyUpdateAccountWithAllValidFieldsReturnsSuccess(){
//    TC 35
  String response = given()
          .baseUri("https://automationexercise.com/api")
          .formParam("name", "Mina Saber")
          .formParam("email", "abanob.soror2017@gmail.com")
          .formParam("password", "123")
          .formParam("title", "Mr")
          .formParam("birth_date", "1")
          .formParam("birth_month", "1")
          .formParam("birth_year", "2002")
          .formParam("firstname", "Mina")
          .formParam("lastname", "Saber")
          .formParam("company", "ITI")
          .formParam("address1", "street Mohamed Shams")
          .formParam("address2", "Ain Shams 22")
          .formParam("country", "India")
          .formParam("zipcode", "3753450")
          .formParam("state", "Egypt")
          .formParam("city", "Cairo")
          .formParam("mobile_number", "+201270180191")
          .when()
          .put("/updateAccount")
          .then()
          .statusCode(200)
          .extract()
          .asString();
  Assert.assertTrue(response.contains("200"));
  Assert.assertTrue(response.contains("User updated!"));
System.out.println(response);
}


@Test(description = "Validate PUT Update Account without password returns error")
  public void  validateUpdateAccountWithoutPasswordReturnsError(){

//    TC 36
  String response = given()
          .baseUri("https://automationexercise.com/api")
          .formParam("name", "Mina Saber")
          .formParam("email", "abanob.soror2017@gmail.com")
//          .formParam("password", "123")
          .formParam("title", "Mr")
          .formParam("birth_date", "1")
          .formParam("birth_month", "1")
          .formParam("birth_year", "2002")
          .formParam("firstname", "Mina")
          .formParam("lastname", "Saber")
          .formParam("company", "ITI")
          .formParam("address1", "street Mohamed Shams")
          .formParam("address2", "Ain Shams 22")
          .formParam("country", "India")
          .formParam("zipcode", "3753450")
          .formParam("state", "Egypt")
          .formParam("city", "Cairo")
          .formParam("mobile_number", "+201270180191")
          .when()
          .put("/updateAccount")
          .then()
          .statusCode(200)
          .extract()
          .asString();
  Assert.assertTrue(response.contains("400"));
  Assert.assertTrue(response.contains("password parameter is missing"));
  System.out.println(response);

}

}
