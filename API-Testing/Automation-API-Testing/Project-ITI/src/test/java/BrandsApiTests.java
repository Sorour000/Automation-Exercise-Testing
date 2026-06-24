import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class BrandsApiTests {


@Test(description = "")
   public void verifyGetAllBrandsListReturnsBrandsData(){
//          TC 05
   String response = given()
           .baseUri("https://automationexercise.com/api")
           .when()
           .get("/brandsList")
           .then()
           .statusCode(200)
           .extract()
           .asString();
   Assert.assertTrue(response.contains("200"));
   JsonPath jsonPath = new JsonPath(response);
   Assert.assertNotNull(jsonPath.getList("brands"));
   Assert.assertFalse(jsonPath.getList("brands").isEmpty());
   Assert.assertTrue(response.contains("id"));
   Assert.assertTrue(response.contains("brand"));

}




@Test
   public void validatePutToBrandsListReturnsMethodNotSupported(){
//          TC 06
   String response = given()
           .baseUri("https://automationexercise.com/api")
           .when()
           .put("/brandsList")
           .then()
           .statusCode(200)
           .extract()
           .asString();
   Assert.assertTrue(response.contains("405"));
   Assert.assertTrue(response.contains("This request method is not supported."));
}


}
