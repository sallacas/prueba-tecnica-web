package com.co.pruebatecnicaweb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NestedFramesPage {
    public static final By TITLE_PAGE = By.xpath("//h1[@class='text-center' and contains(text(),'Nested Frames')]");
    public static final By FRAME_PARENT = By.id("frame1");
    public static Target BODY = Target.the("Body of the page").located(By.xpath("//body"));
    public static final By FRAME_CHILD = By.xpath( "//iframe[@srcdoc='<p>Child Iframe</p>']");
    public static Target BODY_CHILD = Target.the("Body of the page").located(By.xpath("//body//p"));
}
