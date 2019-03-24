package service;

import org.openqa.selenium.By;

public class LocatorCorrector {
    public static By masterForLocators(String target, String values)
    { values=values.replaceAll("_"," ");
        final String selector=String.format(target,values);
        By  locator = By.xpath(selector);
        return locator;
    }
}
