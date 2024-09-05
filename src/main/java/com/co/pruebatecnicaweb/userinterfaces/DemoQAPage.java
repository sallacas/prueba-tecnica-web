package com.co.pruebatecnicaweb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoQAPage {

  public static final Target BTN_NEW_USER = Target.the("Button New User")
          .located(By.id("newUser"));
  public static final Target REGISTER_TITLE = Target.the("Title of register page").located(By.cssSelector("div.register-wrapper>h1"));
  public static final Target TXT_FIRST_NAME = Target.the("Textbox First Name").located(By.id("firstname"));
  public static final Target TXT_LAST_NAME = Target.the("Textbox Last Name").located(By.id("lastname"));
  public static final Target TXT_USERNAME = Target.the("Textbox Username").located(By.id("userName"));
  public static final Target TXT_PASSWORD = Target.the("Textbox Password").located(By.id("password"));
  public static final By IFRAME_CAPTCHA = By.xpath("//iframe[@title='reCAPTCHA']");
  public static final Target BTN_CAPTCHA = Target.the("Button for captcha").located(By.cssSelector("span#recaptcha-anchor > div.recaptcha-checkbox-border"));
  public static final Target BTN_REGISTER = Target.the("Button Register").located(By.id("register"));
  public static final Target BTN_LOGIN = Target.the("Button Login").located(By.id("login"));
  public static final Target TXT_ERROR = Target.the("Error message").located(By.id("name"));
}