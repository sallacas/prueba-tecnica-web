package com.co.pruebatecnicaweb.runners;

import com.co.pruebatecnicaweb.utils.BeforeSuite;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class RunnerPersonalizado extends Runner {
    private final Class<CucumberWithSerenity> classValue;
    private CucumberWithSerenity cucumberWithSerenity;

    public RunnerPersonalizado(Class<CucumberWithSerenity> classValue) throws Exception {
        this.classValue = classValue;
        this.cucumberWithSerenity = new CucumberWithSerenity(classValue);
    }

    public Description getDescription() {
        return this.cucumberWithSerenity.getDescription();
    }

    private void runAnnotatedMethods() throws Exception {
        if (BeforeSuite.class.isAnnotation()) {
            Method[] methods = this.classValue.getMethods();

            for (Method method : methods) {
                Annotation[] annotations = method.getAnnotations();

                for (Annotation item : annotations) {
                    if (item.annotationType().equals(BeforeSuite.class)) {
                        method.invoke(null);
                        break;
                    }
                }
            }

        }
    }

    public void run(RunNotifier notifier) {
        try {
            this.runAnnotatedMethods();
            this.cucumberWithSerenity = new CucumberWithSerenity(this.classValue);
        } catch (Exception var3) {
            Logger.getLogger("context", String.valueOf(var3));
        }

        this.cucumberWithSerenity.run(notifier);
    }
}

