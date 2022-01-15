package guru.qa.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest {

   @Test
     void firstTestForm() {
        open ("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Vitoriia");
        $("[id=lastName]").setValue("Sun");
        $("#userEmail").setValue("IronLady@gmail.com");
        $("[for=gender-radio-1]").click();
        $("[id=userNumber]").setValue("9302764785");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__day").click();
        $(byText("Sports")).scrollTo();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("d");
        $(byText("Hindi")).click();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/cv.png"));
        $("[id=currentAddress]").setValue("Moscow Kremlin");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("[id=submit]").click();



        validation("Student Name","Vitoriia");
        validation("Student Email","IronLady@gmail.com");
        validation("Gender","Male");
        validation("Mobile","9302764785");
        validation("Date of Birth","April,1993");
        validation("Subjects","Hindi");
        validation("Hobbies","Sports");
        validation("Picture","cv.png");
        validation("Address","Moscow Kremlin");
        validation("State and City","NCR Noida");

    }

    public void validation(String key, String meaning) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(meaning));
    }
}
