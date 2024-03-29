/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package testCadbase;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import com.github.javafaker.Faker;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.logevents.SelenideLogger;
import static io.qameta.allure.Allure.step;
import io.qameta.allure.selenide.AllureSelenide;


class AppTest {
        Faker faker = new Faker();
	private String firstName = faker.name().firstName();  
	private String lastName = faker.name().lastName(); 
        private String password = "12345"; 
	
	void openSite() {
		open("https://app.cadbase.rs/#/"); 
		$("a.button[href='#/login']").click();	 
	}
	void openRegistrtionForm() { 
		$("a.button[href='#/register']").click();	
		 
	}
	@Test
	public void unsuccessfulPassword() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            step("Открываем главную страницу", () -> { 
		openSite();
                      });
		$("#username").setValue(firstName); 
		$("#password").setValue(""); 
		$(("#submit-button")).click(); 
		$(".media-content").shouldHave(text("Unauthorized")); 
	}
	@Test
	public void unsuccessfulName() {
		openSite();
		$("#username").setValue(""); 
		$("#password").setValue(password); 
		$(("#submit-button")).click(); 
		$(".media-content").shouldHave(text("Unauthorized")); 
	}
}
