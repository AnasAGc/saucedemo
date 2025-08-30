package stepDefinitions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BooksSteps {

	private static String token;
    private static String orderId;
    private Response response;
    static {
        RestAssured.baseURI = "https://simple-books-api.click";
        Response tokenResponse = given()
                .contentType("application/json")
                .body("{ \"clientName\": \"TestUser\", \"clientEmail\": \"testuser" 
                        + System.currentTimeMillis() + "@mail.com\" }")
                .when()
                .post("/api-clients/")
                .then()
                .statusCode(201)
                .extract()
                .response();

        token = tokenResponse.jsonPath().getString("accessToken");
        System.out.println("Token: " + token);
    }
    @When("I request the list of books")
    public void i_request_the_list_of_books() {
        response = given()
                .when()
                .get("/books");
    }

    @Then("I should receive a list of books")
    public void i_should_receive_a_list_of_books() {
        response.then().statusCode(200)
                .body("size()", greaterThan(0));
    }

    @When("I create a new order")
    public void i_create_a_new_order() {
        response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body("{ \"bookId\": 1, \"customerName\": \"Test User\" }")
                .when()
                .post("/orders");

        orderId = response.jsonPath().getString("orderId");
        System.out.println("Order ID: " + orderId);
    }

    @Then("The order should be created successfully")
    public void the_order_should_be_created_successfully() {
        response.then().statusCode(201);
        assertNotNull(orderId, "Order ID should not be null");
    }

    @When("I delete the order")
    public void i_delete_the_order() {
        response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/orders/" + orderId);
    }

    @Then("The order should be deleted successfully")
    public void the_order_should_be_deleted_successfully() {
        response.then().statusCode(204);
    }
}
    
    

