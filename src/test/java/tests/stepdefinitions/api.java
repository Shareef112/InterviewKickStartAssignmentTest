package tests.stepdefinitions;

import com.google.gson.JsonObject;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import tests.businessLogics.FindJobsTests;

import java.util.HashMap;
import java.util.Map;

public class api extends FindJobsTests {
    @Then("^user should see the GET API Response$")
    public void user_should_see_the_GET_API_Response() throws Throwable {
        System.out.println(getJobsList()); ;
//        RestAssured.baseURI = "https://demoqa.com/BookStore";
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.request(Method.GET,"/v1/Books");
//        System.out.println(response.getStatusCode());
//        JsonPath jsonPath = response.jsonPath();
//        List<Map<String,String>> books = jsonPath.getList("books");
//        for(Map<String,String > book : books){
//            System.out.println(book.get("title"));
//        }
        //System.out.println(response.prettyPrint());

    }

    @Then("^user should see the GET API JSON Response$")
    public void user_should_see_the_GET_API_JSON_Response() throws Throwable {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/";
        RequestSpecification httpRequest = RestAssured.given();
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("ISBN","9781449325862");
        queryParams.put("author","Richard E. Silverman");
        Response response = httpRequest.queryParams(queryParams).get("/Book");
        JsonPath jsonRespnse = response.jsonPath();
        Assert.assertEquals(jsonRespnse.get("title"),"Git Pocket Guide");
    }

    @Then("^User Should see POST API JSON respnse$")
    public void user_Should_see_POST_API_JSON_respnse() throws Throwable {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("userId", "TQ123");
        requestParams.addProperty("isbn", "9781449325862");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams);
        Response response = httpRequest.post("/BookStoreV1BooksPost");
        System.out.println(response.getStatusCode());


    }

}
