package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPages {
    //locators & Elements
    private SelenideElement
            firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            userEmail = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            hobbySelectionSports = $(byText("Sports"));


    public static CalendarComponent calendar = new CalendarComponent();

    //Actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public RegistrationsPages typeFirstName(String value) {
        $("[id=firstName]").setValue(value);
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationsPages typelastName(String value) {
        $("[id=LastName]").setValue(value);
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationsPages typeUserEmail(String value) {
        $("#userEmail").setValue(value);
        userEmail.setValue(value);
        return this;
    }

    public RegistrationsPages typeGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationsPages typeUserNumber(String value) {
        $("#userNumber").setValue(value);
        userNumber.setValue(value);
        return this;
    }

    public RegistrationsPages selectHobbySports(){
        hobbySelectionSports.click();
        return this;
    }






//    $("[id=firstName]").setValue("Vitoriia");
//    $("[id=lastName]").setValue("Sun");
//    $("#userEmail").setValue("IronLady@gmail.com");
//    $("[for=gender-radio-1]").click();
//    $("[id=userNumber]").setValue("9302764785");
//    $("#dateOfBirthInput").click();
//    $(".react-datepicker__month-select").selectOptionByValue("4");
//    $(".react-datepicker__year-select").selectOptionByValue("1993");
//    $(".react-datepicker__day").click();
//    $(byText("Sports")).scrollTo();
//    $("#subjectsInput").click();
//    $("#subjectsInput").setValue("d");
//    $(byText("Hindi")).click();
//    $("[for=hobbies-checkbox-1]").click();
//    $("#uploadPicture").uploadFile(new File("src/test/java/resources/cv.png"));
//    $("[id=currentAddress]").setValue("Moscow Kremlin");
//    $("#state").click();
//    $(byText("NCR")).click();
//    $("#city").click();
//    $(byText("Noida")).click();
//    $("[id=submit]").click();
//
//
//    validation("Student Name", "Vitoriia");
//    validation("Student Email", "IronLady@gmail.com");
//    validation("Gender", "Male");
//    validation("Mobile", "9302764785");
//    validation("Date of Birth", "April,1993");
//    validation("Subjects", "Hindi");
//    validation("Hobbies", "Sports");
//    validation("Picture", "cv.png");
//    validation("Address", "Moscow Kremlin");
//    validation("State and City", "NCR Noida");

}
