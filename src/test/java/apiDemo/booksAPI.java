package apiDemo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class booksAPI {
  

    
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://simple-books-api.click";

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
    	
    }

