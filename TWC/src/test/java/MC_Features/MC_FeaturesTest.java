package MC_Features;

import TWC_Base.MC_Features_Base;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Created by nd0ma3 on 2/23/2016.
 */
public class MC_FeaturesTest extends MC_Features_Base{
    /**
     * MEM_MSM_1.1_Alt_01
     * This function  will validate alternate flow of date range in job list.
     */
    @Test(priority = 1)
    public void validateAlternateFlowOfDateRange()  {
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterDateRangeInMessageSection();
        clickSearch();
        clickFirstMassJob();
        Assert.assertEquals("Modify Mass E-Mail | Secure Message Center", driver.getTitle());
        log.info("User successfully able to view job list for the date range provide");
    }

    /**
     * MEM_MSM_1.1_Alt_02
     * This function will validate the functionality of filters in job search list
     */
    @Test (priority = 2)
    public void validateTheFunctionalityOfFiltersInJobSearchList(){
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterValueInSearchTab();
        clickFirstMassJob();
        Assert.assertEquals("Modify Mass E-Mail | Secure Message Center", driver.getTitle());
        log.info("Successfully validated the functionality of filters in job search list.");
    }

    /**
     * MEM_MSM_1.1_Alt_03
     * This function will validate the functionality of Compose Mass Job.
     */
    @Test(priority = 3)
    public void validateTheFunctionalityOfComposeMassJob(){
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterValueInSearchTab();
        clickFirstMassJob();
        Assert.assertEquals("Modify Mass E-Mail | Secure Message Center", driver.getTitle());
        log.info("Successfully validated the functionality of Compose Mass Job.");
    }

    /**
     * MEM_MSM_1.1_Alt_04
     * This function will validate the functionality of In-file / Out-File.
     */
    @Test(priority = 4)
    public void validateTheFunctionalityOfInFileOutFile() {
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterDateRangeInMessageSection();
        clickSearch();
        clickFirstInFile();
        clickFirstOutFile();
        //Assert.assertEquals("Modify Mass E-Mail | Secure Message Center", driver.getTitle());
        log.info("Successfully validated the functionality of In-file / Out-File.");
    }

    /**
     * MEM_MSM_1.1_Alt_04
     * This function will validate the default date range of 'Mass Email Job List
     */
    @Test(priority = 5)
    public void validateDefaultDateRangeOfMassEmailJobList() throws InterruptedException, ParseException {
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        String s = driver.findElement(By.xpath(dateRangeFrom)).getAttribute("value");
        //System.out.println(s);


       // String expectedPattern = "MM/dd/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(s);
        //String userInput = "09/22/2009";
        Date date = formatter.parse(s);
        System.out.println("hi" + s);
       // System.out.println(getDateOfChoose(date, 180));
       // System.out.println("how are you: " + driver.findElement(By.xpath(dateRangeFrom)).getAttribute("value"));

        //Assert.assertEquals("Modify Mass E-Mail | Secure Message Center", driver.getTitle());
        log.info("Successfully validated default date range of 'Mass Email Job List.");
    }

}