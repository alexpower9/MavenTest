package com.example.myApp;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MyApiIntegrationTest {

    @Test
    public void testHttpPost() throws IOException {
        // Create an HttpClient instance
        HttpClient httpClient = HttpClients.createDefault();

        // Define the URL you want to send the POST request to
        String url = "http://localhost:8080/api/v1/student"; // Replace with your URL

        // Create an HttpPost request
        HttpPost httpPost = new HttpPost(url);

        // Set the content type of the request (JSON in this case)
        httpPost.setHeader("Content-Type", "application/json");

        // Define the JSON data to be sent in the request body
        String jsonBody = "{\n" +
                "    \"name\": \"Skippy\",\n" +
                "    \"email\": \"skippy@gmail.com\",\n" +
                "    \"dob\": \"1990-01-01\"\n" +
                "}"; // Replace with your JSON data

        // Set the request body
        StringEntity entity = new StringEntity(jsonBody);
        httpPost.setEntity(entity);

        // Execute the request and get the response
        HttpResponse response = httpClient.execute(httpPost);

        // Handle the response as needed
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("HTTP Status Code: " + statusCode);

        // You can read and process the response content here if needed
        // Example: String responseContent = EntityUtils.toString(response.getEntity());
    }
}
