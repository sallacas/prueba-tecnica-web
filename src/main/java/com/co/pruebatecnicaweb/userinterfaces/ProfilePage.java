package com.co.pruebatecnicaweb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProfilePage {
    public static final Target BTN_DELETE_ACCOUNT = Target.the("BUTTON DELETE ACCOUNT").located(By.xpath("//button[text()='Delete Account']"));
    public static final Target BTN_OK = Target.the("BUTTON OK").located(By.id("closeSmallModal-ok"));
}

