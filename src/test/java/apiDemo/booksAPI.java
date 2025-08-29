package apiDemo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class booksAPI {
    private static String token;
    private static String orderId;

    
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://simple-books-api.click";
        Response tokenResponse = given()
                .contentType("application/json")
                .body("{ \"clientName\": \"TestUser\", \"clientEmail\": \"testuser" 
                        + System.currentTimeMillis() + "@mail.com\" }") // unique email
                .when()
                .post("/api-clients/")
                .then()
                .statusCode(201)
                .extract()
                .response();

        token = tokenResponse.jsonPath().getString("accessToken");
        System.out.println("Token: " + token);
    }
    
    @Test(priority = 1)
    public void getBooks_shouldReturnList() {
        given()
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
    	
    
    
    @Test(priority = 2)
    public void createOrder_shouldSucceed() {
        Response orderResponse = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body("{ \"bookId\": 1, \"customerName\": \"Test User\" }")
                .when()
                .post("/orders")
                .then()
                .statusCode(201)
                .extract()
                .response();

        orderId = orderResponse.jsonPath().getString("orderId");
        System.out.println("Order ID: " + orderId);
    }
    
    @Test(priority = 3, dependsOnMethods = "createOrder_shouldSucceed")
    public void deleteOrder_shouldSucceed() {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/orders/" + orderId)
                .then()
                .statusCode(204);
    }
    

    
    }

