package praktikum;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient {

    public ValidatableResponse login(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then();
    }

    public ValidatableResponse delete(User user, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(user)
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then();
    }
}
