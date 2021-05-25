package ru.netology.Test;

import org.junit.jupiter.api.Test;
import ru.netology.Data.RegistrationDto;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.Data.DataGenerator.generateInvalidUser;
import static ru.netology.Data.DataGenerator.generateValidUser;

public class AuthTest {
    @Test
    void shouldLogin() {
        RegistrationDto validUser = generateValidUser("en");
        open("http://localhost:9999/");
        $("[data-test-id=login] input").setValue(validUser.getLogin());
        $("[data-test-id=password] input").setValue(validUser.getPassword());
        $("button.button").click();
    }

    @Test
    void shouldNotLoginAsBlocked() {
        RegistrationDto invalidUser = generateInvalidUser("en");
        open("http://localhost:9999/");
        $("[data-test-id=login] input").setValue(invalidUser.getLogin());
        $("[data-test-id=password] input").setValue(invalidUser.getPassword());
        $("button.button").click();
        $("[data-test-id=error-notification]").shouldHave(text("Ошибка"));
    }

    @Test
    void shouldNotLoginWithWrongPassword() {
        RegistrationDto validUser = generateValidUser("en");
        RegistrationDto invalidUser = generateInvalidUser("en");
        open("http://localhost:9999/");
        $("[data-test-id=login] input").setValue(validUser.getLogin());
        $("[data-test-id=password] input").setValue(invalidUser.getPassword());
        $("button.button").click();
        $("[data-test-id=error-notification]").shouldHave(text("Ошибка"));
    }

    @Test
    void shouldNotLoginWithWrongLogin() {
        RegistrationDto validUser = generateValidUser("en");
        RegistrationDto invalidUser = generateInvalidUser("en");
        open("http://localhost:9999/");
        $("[data-test-id=login] input").setValue(invalidUser.getLogin());
        $("[data-test-id=password] input").setValue(validUser.getPassword());
        $("button.button").click();
        $("[data-test-id=error-notification]").shouldHave(text("Ошибка"));
    }

}
