package com.rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class test {
    @Test
    public void test3()
    {
        Response res=given() .baseUri("http://localhost:8098/standard-link/request").log().all()
                .header("ersReference","1234")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"customerId\": \"ZDS\",\n" +
                        "    \"operationId\": \"CREATEORDER\",\n" +
                        "    \"additionalFields\": {\n" +
                        "        \"request\": {\n" +
                        "            \"userId\": \"25fe65f2-0ca3-4df0-b6b0-07f46f93f504\",\n" +
                        "            \"simType\": \"HAVESIM\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}")
                .log().all()
                .when().post()
                .then()
                .log().all().assertThat().statusCode(200)
                .extract().response();
        System.out.println("The response is-------"+res.asString());
        JsonPath jsonPath=new JsonPath(res.asString());
        System.out.println("The resultDescription is -------"+jsonPath.getString("resultDescription"));
        System.out.println("The sim type is -------"+jsonPath.getString("additionalFields.response.simType"));
    }
    @Test
    public void test()
    {
        Response res=given() .baseUri("http://localhost:8098/standard-link/request").log().all()
                .header("ersReference","1234")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"customerId\": \"ZDS\",\n" +
                        "    \"operationId\": \"CREATEORDER\",\n" +
                        "    \"additionalFields\": {\n" +
                        "        \"request\": {\n" +
                        "            \"userId\": \"25fe65f2-0ca3-4df0-b6b0-07f46f93f504\",\n" +
                        "            \"simType\": \"HAVESIM\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}")
                .log().all()
                .when().post()
                .then()
                .log().all().assertThat().statusCode(200)
                .extract().response();
        System.out.println("The response is-------"+res.asString());
    }

    @Test
    public void test1()
    {
        given() .baseUri("http://localhost:8098/standard-link/request").log().all()
                .header("ersReference","1234")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"customerId\": \"ZDS\",\n" +
                        "    \"operationId\": \"CREATEORDER\",\n" +
                        "    \"additionalFields\": {\n" +
                        "        \"request\": {\n" +
                        "            \"userId\": \"25fe65f2-0ca3-4df0-b6b0-07f46f93f504\",\n" +
                        "            \"simType\": \"HAVESIM\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}")
                .log().all()
                .when().post()
                .then()
                         .log().all().assertThat().statusCode(200)
                .body("resultDescription", equalTo("Create order : "));

    }
}
