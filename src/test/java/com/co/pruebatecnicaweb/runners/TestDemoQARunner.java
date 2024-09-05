package com.co.pruebatecnicaweb.runners;


import com.co.pruebatecnicaweb.utils.BeforeSuite;
import com.co.pruebatecnicaweb.utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = "src/test/resources/features/demoqa.feature",
        glue = "com.co.pruebatecnicaweb.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Caso2"
)
public class TestDemoQARunner {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException
    {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/demoqa.feature");
    }

    @BeforeClass
    public static void setStage() {
        OnStage.setTheStage(new Cast());
    }
}
