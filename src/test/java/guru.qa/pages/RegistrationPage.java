package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    //locators & Elements

    SelenideElement name = $("#firstName"),
            lastName = $("#lastName"),
            email = $x("//input[@id='userEmail']"),
            checkBoxFemale = $("div.custom-radio > input[value = 'Female']"),
            phone = $("#userNumber"),
            checkBoxHobbies = $("#hobbies-checkbox-3"),
            upLoadPictures = $("input#uploadPicture"),
            address = $("textarea#currentAddress"),
            stateSelect = $("div#state svg"),
            stateName = $(byText("Uttar Pradesh")),
            citySelect = $("div#city svg[class='css-19bqh2r']"),
            cityName = $(byText("Agra")),
            submitButton = $("button#submit"),
            tableAfterRegistration = $("table[class*='table']"),
            submitTitle = $x("//div[contains(text(), 'Thanks for submit')]");

    @Step("Открываем страницу с формой и проверяем, что она открылась")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Вводим Имя")
    public RegistrationPage setInputName(String firstName) {
        name.setValue(firstName);
        return this;
    }

    @Step("Вводим фамилию")
    public RegistrationPage setInputLastName(String surname) {
        lastName.setValue(surname);
        return this;
    }

    @Step("Вводим email")
    public RegistrationPage setInputEmail(String emailAddress) {
        email.setValue(emailAddress);
        return this;
    }

    @Step("Вводим адрес")
    public RegistrationPage setAddressInTextarea(String addressStreet) {
        address.setValue(addressStreet);
        return this;
    }

    @Step("Вводим номер телефона")
    public RegistrationPage setInputPhone(String numberPhone) {
        phone.setValue(numberPhone);
        return this;
    }

    @Step("Заполняем поле Subject")
    public RegistrationPage chooseSubject(String subject) {
        $("div[class*='subjects-auto-complete__value']").click();
        $("input#subjectsInput").setValue(subject);
        $("div#react-select-2-option-0").click();
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage clickCheckBoxFemale() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(checkBoxFemale).click().build().perform();
        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage clickCheckBoxHobbies() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(checkBoxHobbies).click().build().perform();
        return this;
    }

    @Step("Заполняем поле Штат")
    public RegistrationPage chooseState() {
        stateSelect.scrollTo();
        stateSelect.click();
        stateName.click();
        return this;
    }

    @Step("Заполняем поле Город")
    public RegistrationPage chooseCity() {
        citySelect.click();
        cityName.click();
        return this;
    }

    @Step("Нажимаем кнопку \"Отправить\"")
    public RegistrationPage clickButtonSubmit() {
        submitButton.click();
        return this;
    }
//    public RegistrationPage upLoadImageOnPage(String imagePath) {
//        upLoadPictures.uploadFromClasspath(imagePath);
//        return this;
//    }




    //examination
    @Step("Проверяем правильность заполнения")
    public RegistrationPage assertSubmitTitleIsVisible() {
        Assertions.assertTrue(submitTitle.isDisplayed());
        return this;
    }

    public RegistrationPage assertTableAfterRegistrationHave(String value) {
        tableAfterRegistration.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем показывается ли рекламный баннер и закрываем его при наличии")
    public void closeTable() {
        ElementsCollection closeBannerButton = $$("#close-fixedban");
        if (closeBannerButton.size() > 0 && closeBannerButton.get(0).isDisplayed())
            closeBannerButton.get(0).click();
        $("#closeLargeModal").scrollTo().click();
    }

}
