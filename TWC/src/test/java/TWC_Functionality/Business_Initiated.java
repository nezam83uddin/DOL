package TWC_Functionality;

import TWC_Base.BMA_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by nd0ma3 on 3/15/2016.
 */
public class Business_Initiated extends BMA_Base {

    public final boolean activate = true;

    @Test(priority = 0, enabled = activate)
    public void setUpEnvironment(){
        createExcelFile();
    }

    /**
     * 01_BMA_Initiate
     * This function  will validate that a ONE BMA employer can initiate a message to a KW.
     */
    @Test(priority = 1, enabled = activate)
    public void validateOneBMAEmployerCanInitiateAMessageToAKW() throws IOException, InterruptedException {
        testId = "01_BMA_Initiate";
        expectedResult = "ONE BMA employer can initiate a message to a KW.";

        // Test Steps:
        logInToTWCWithBMACreds();

        Assert.assertEquals(getTextByXpath(priorityHeader), "!");
        Assert.assertEquals(getTextByXpath(attachmentHeader), ".");
        Assert.assertEquals(getTextByXpath(subjectHeader), "Subject");
        Assert.assertEquals(getTextByXpath(regardingHeader), "Regarding");
        Assert.assertEquals(getTextByXpath(fromHeader), "From");
        Assert.assertEquals(getTextByXpath(dateHeader), "Date");
        System.out.println("printing after assert");
        selectComposeNewFromMenu();

        sleepfor(3);
        clickByXpath(composeSubject1);
        clickByXpath(subjectUIOnlineServices);
        clickByXpath(composeSubject2);
        clickByXpath(subjectNavigationalIssues);

        WebElement frame = driver.findElement(By.xpath("//*[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));
        driver.switchTo().frame(frame);
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys("Hello world");
        driver.switchTo().defaultContent();

        sleepfor(3);
        clickByXpath(composeSend);

        System.out.println();
        sleepfor(10);

        //Evaluate and generate reports:
        actual = "Message Sent Successfully.";
        expected = getTextByXpath(messageSentConfirmationMessage);
        checkTest();
    }
}
