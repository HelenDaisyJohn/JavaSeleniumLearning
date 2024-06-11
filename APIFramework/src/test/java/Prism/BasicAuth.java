package Prism;

import static io.restassured.RestAssured.given;
import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BasicAuth {
    @Test
    public void testBasicAuth() {
        String baseUri = "https://release-stm-prism-demo-xpressbet.preprod.1stbet.com";
        String endpoint = "/prism/v1/video/videoEncoder";
//        String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjBFODMyMEQ3RjY0OUIzODFFMkJGMjE5MTEzQTkzQTQwIiwidHlwIjoiYXQrand0In0. eyJhbGciOiJSUzI1NiIsImtpZCI6IjBFODMyMEQ3RjY0OUIzODFFMkJGMjE5MTEzQTkzQTQwIiwidHlwIjoiYXQrand0In0.eyJpc3MiOiJodHRwczovL3JlbGVhc2Utc3RtLXByaXNtLWRlbW8teHByZXNzYmV0LnByZXByb2QuMXN0YmV0LmNvbS9wcmlzbS9hdXRoIiwibmJmIjoxNzE2ODA2OTg1LCJpYXQiOjE3MTY4MDY5ODUsImV4cCI6MTcxNjgxNzc4NSwiYXVkIjoiaHR0cHM6Ly9wcmlzbS4xc3QuY29tIiwic2NvcGUiOlsib3BlbmFwaSIsIm9wZW5pZCIsInByb2ZpbGUiLCJwcmlzbSJdLCJhbXIiOlsicHdkIl0sImNsaWVudF9pZCI6Im9yZy8xU1QvYXV0aG9yaXplZENsaWVudHMvMTExMTExMTEtMTExMS0xMTExLTExMTEtMTExMTExMTExMTExIiwic3ViIjoib3JnLzFTVC91c2Vycy8xMTExMTExMS0xMTExLTExMTEtMTExMS0xMTExMTExMTExMTEiLCJhdXRoX3RpbWUiOjE3MTY3OTYwMTksImlkcCI6ImxvY2FsIiwic2lkIjoiMUEwOTYzRTg0RTQ5OERFQjY1RDAxNTUyQTBFNkQ2NjgiLCJqdGkiOiI4QjlEQTU5NTUzQUMxQzk5OERBOEIwMTBBN0MzQTczMiJ9.oPXW5reVur54Lu8OzDDxg7HoPfcYuGH5oGJN0XrYJ70MCbSe_pFwveqdzB7Yjf5jpWJhmxBymICTqYXcElbj4kncuvdr-GMvaiDhE0Z7ccXHr9o_iIQNlMnDBoPTU7j-WksHIs_CJBWGLGpGw_9H0M9Unek69GbByrOeRPHaHZ8NGxP0jxwNT0uGqvmeFjWiIEVZeOMeAOfm9dzozvg0n62VN6zjWaGHhv5SKGGLLHJFyYe3UkoWzO7Z13D2J_Dy6PJgR37pE7oubv8tgkTpG-NR7HU1pznZ4zmFj797tcKs2VRdyrRwFXc1KNlQheQwTp8wj5lIHfiW7YOWM7GISQ.LBk-8A8iUD72SIP9R6DWi_jQESgRjxhIXouzFr-jRpSceWbh3yUdM2RxQaW2tJyU0IjFezwS75u2KJR7PrfyJy04JoHALDd__0oKGfLU1X1B9n1MdeStrxCrgPEl2-lRxNaO8ADx4IXQcZ9Nl0DS7Sea2kicanmKvckU4NSM_gAbMXx67NycNJGhJaI8ZMc18N5z8pNucFqKvafvIj-2sXmPdH6qy9pyTrElXi7VXiwIys0U_ZN5j2umX98e0K9sMrsOaRL3i73vxfKZ1sDTXmmLKWdymz7PG6__KdVbxikRkHyr1CBldghlR2LWd4YHX_nd2s_fhZmqUWTYPOfuEA";
        // Define the request body
        String requestBody = "{\r\n"
            + "  \"parent\": \"org/Test_Org/orgUnits/Unit_01\",\r\n"
            + "  \"audit_info\": {},\r\n"
            + "  \"display_name\": {\r\n"
            + "    \"value\": \"Test Encoder\"\r\n"
            + "  },\r\n"
            + "  \"vendor\": \"VENDOR_LTN\",\r\n"
            + "  \"vendor_encoder_identifier\": \"gstp-fll-e1\",\r\n"
            + "  \"state\": \"STATE_UNSPECIFIED\"\r\n"
            + "}";

        // Send the request and log details
        Response response = given()
            .baseUri(baseUri)
            .contentType(ContentType.JSON)
            .header("accept", "application/json")
//            .header("Authorization", "Bearer " + token)
            .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjBFODMyMEQ3RjY0OUIzODFFMkJGMjE5MTEzQTkzQTQwIiwidHlwIjoiYXQrand0In0.eyJpc3MiOiJodHRwczovL3JlbGVhc2Utc3RtLXByaXNtLWRlbW8teHByZXNzYmV0LnByZXByb2QuMXN0YmV0LmNvbS9wcmlzbS9hdXRoIiwibmJmIjoxNzE2ODA2OTg1LCJpYXQiOjE3MTY4MDY5ODUsImV4cCI6MTcxNjgxNzc4NSwiYXVkIjoiaHR0cHM6Ly9wcmlzbS4xc3QuY29tIiwic2NvcGUiOlsib3BlbmFwaSIsIm9wZW5pZCIsInByb2ZpbGUiLCJwcmlzbSJdLCJhbXIiOlsicHdkIl0sImNsaWVudF9pZCI6Im9yZy8xU1QvYXV0aG9yaXplZENsaWVudHMvMTExMTExMTEtMTExMS0xMTExLTExMTEtMTExMTExMTExMTExIiwic3ViIjoib3JnLzFTVC91c2Vycy8xMTExMTExMS0xMTExLTExMTEtMTExMS0xMTExMTExMTExMTEiLCJhdXRoX3RpbWUiOjE3MTY3OTYwMTksImlkcCI6ImxvY2FsIiwic2lkIjoiMUEwOTYzRTg0RTQ5OERFQjY1RDAxNTUyQTBFNkQ2NjgiLCJqdGkiOiI4QjlEQTU5NTUzQUMxQzk5OERBOEIwMTBBN0MzQTczMiJ9.oPXW5reVur54Lu8OzDDxg7HoPfcYuGH5oGJN0XrYJ70MCbSe_pFwveqdzB7Yjf5jpWJhmxBymICTqYXcElbj4kncuvdr-GMvaiDhE0Z7ccXHr9o_iIQNlMnDBoPTU7j-WksHIs_CJBWGLGpGw_9H0M9Unek69GbByrOeRPHaHZ8NGxP0jxwNT0uGqvmeFjWiIEVZeOMeAOfm9dzozvg0n62VN6zjWaGHhv5SKGGLLHJFyYe3UkoWzO7Z13D2J_Dy6PJgR37pE7oubv8tgkTpG-NR7HU1pznZ4zmFj797tcKs2VRdyrRwFXc1KNlQheQwTp8wj5lIHfiW7YOWM7GISQ")
            .header("Content-Type", "application/json")
            .body("{\r\n  \"parent\": \"org/Test_Org/orgUnits/Unit-01\",\r\n  \"audit_info\": {},\r\n  \"display_name\": {\r\n    \"value\": \"Test Encoder\"\r\n    \r\n  },\r\n  \"vendor\": \"VENDOR_LTN\",\r\n  \"vendor_encoder_identifier\": \"gstiuyrtst1223\",\r\n  \"state\": \"STATE_UNSPECIFIED\"\r\n}")
           
//            .body(requestBody)
            .log().all() // Log request details
            .when()
            .post(endpoint)
            .then()
            .log().all() // Log response details
            .extract().response();

        // Print the response for debugging
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asString());
    }
}
