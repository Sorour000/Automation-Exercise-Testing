import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class ProductsApiTests {
    @Test(description = "Verify GET All Products List returns 200 with products data")
    public void verifyGetAllProductsListReturnsProductsData(){
//        TC 01
            given().baseUri("https://automationexercise.com/api")
                    .when()
                    .get("/productsList")
                    .then().statusCode(200).body("products.size()",greaterThan(0));
        }

    @Test(description = "Validate POST to Products List returns 405 - method not supported")
    public void validatePostToProductsListReturnsMethodNotSupported() {
//        TC 02
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .when()
                .post("/productsList")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        Assert.assertTrue(response.contains("405"));
        Assert.assertTrue(response.contains("This request method is not supported."));
    }

    @Test(description = "Verify POST Search Product with valid keyword 'Tshirt' returns results")
    public void verifySearchProductWithValidKeywordReturnsResults(){
//          TC 03
        String response = given()
                .baseUri("https://automationexercise.com/api").formParam("search_product","Tshirt")
                .when()
                .post("/searchProduct")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("200"));
        Assert.assertTrue(response.toLowerCase().contains("tshirt"));
    }


    @Test(description = "Validate POST Search Product without search_product parameter returns 400")
    public void validateSearchProductWithoutSearchProductParameterReturnsBadRequest(){
//          TC 04
        String response = given()
                .baseUri("https://automationexercise.com/api")
                .when()
                .post("/searchProduct")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad request, search_product parameter is missing in POST request"));
    }
}
