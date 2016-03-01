package MC_Features;

import TWC_Base.MC_Features_Base;
import org.testng.annotations.Test;
import java.util.*;
import java.io.IOException;

/**
 * Created by nd0ma3 on 2/23/2016.
 */
public class MC_FeaturesTest extends MC_Features_Base{

    @Test(priority = 0)
    public void setUpEnvironment(){
        createExcelFile();
    }

    /**
     * MEM_MSM_1.1_Alt_01
     * This function  will validate alternate flow of date range in job list.
     */
    @Test(priority = 1)
    public void validateAlternateFlowOfDateRange() throws IOException {
        testId = "MEM_MSM_1.1_Alt_01";
        expectedResult = "User able to view job list for the date range provided.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterDateRangeInMessageSection();
        clickSearch();
        clickFirstMassJob();
        // Evaluate and generate reports:
        actual = "Modify Mass E-Mail | Secure Message Center";
        expected = driver.getTitle();
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Alt_02
     * This function will validate the functionality of filters in job search list
     */
    @Test (priority = 2)
    public void validateTheFunctionalityOfFiltersInJobSearchList() throws IOException {
        testId = "MEM_MSM_1.1_Alt_02";
        expectedResult = "User should able to see list of filtered related jobs from Mass email job list";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterValueInSearchTab();
        clickFirstMassJob();
        // Evaluate and generate reports:
        actual = "Modify Mass E-Mail | Secure Message Center";
        expected = driver.getTitle();
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Alt_03
     * This function will validate the functionality of Compose Mass Job.
     */
    @Test(priority = 3)
    public void validateTheFunctionalityOfComposeMassJob() throws IOException {
        testId = "MEM_MSM_1.1_Alt_03";
        expectedResult = "User able to see Compose Mass job and able to click to create mass job";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterValueInSearchTab();
        clickFirstMassJob();
        // Evaluate and generate reports:
        actual = "Modify Mass E-Mail | Secure Message Center";
        expected = driver.getTitle();
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Alt_04
     * This function will validate the functionality of In-file / Out-File.
     */
    @Test(priority = 4)
    public void validateTheFunctionalityOfInFileOutFile() throws IOException {
        testId = "MEM_MSM_1.1_Alt_04";
        expectedResult = "User able to see and select to view the In-File or the Out-File";
       // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterDateRangeInMessageSection();
        clickSearch();
        clickFirstInFile();
        clickFirstOutFile();
        // Evaluate and generate reports:
        actual = "some string"; // this portions of code have to be changed
        expected = "some string";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_01
     * This function will validate the default date range of 'Mass Email Job List.
     */
    @Test(priority = 5)
    public void validateDefaultDateRangeOfMassEmailJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_01";
        expectedResult = "User should able to see default date range as 6 months for mass email job list";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // Evaluate and generate reports:
        actual = getAttributeByXpath(dateRangeFrom);
        expected= getDateOfChoose(new Date(), -180);
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_02
     * This function will validate 'Search on date range' of 'Mass Email Job List'.
     */
    @Test(priority = 6)
    public void validateSearchOnDateRangeOfMMassEmailJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_02";
        expectedResult = "User should able see 'Search on date range' in job list view";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // Evaluate and generate reports:
        actual = "Showing";
        expected = getTextByXpath(showingMessage).substring(0, 7);
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_03
     * This function will validate 'Search on date range' error msg.
     */
    @Test(priority = 7)
    public void validateSearchOnDateRangeErrorMsg() throws IOException {

        testId = "MEM_MSM_1.1_Main_03";
        expectedResult = "Error message displayed with 'The start date cannot be later than the end date'";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        clearField(dateRangeFrom);
        typeByXpath(dateRangeFrom, getTodaysDate());
        clearField(dateRangeTo);
        typeByXpathThenEnter(dateRangeTo, getDateOfChoose(new Date(), -30));
        typeByXpathThenEnter(dateRangeTo, "");
        // Evaluate and generate reports:
        actual = "From Date cannot be later than To Date";
        expected = getTextByXpath(dateErrorMessage);

        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_04
     * This function will validate Search date range updated as '6 months' by default.
     */
    @Test(priority = 8)
    public void validateSearchDateRangeUpdatedAs6MonthsByDefault() throws IOException {
        testId = "MEM_MSM_1.1_Main_04";
        expectedResult = "User should able to see Search date range updated as '6 months' by default";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // Evaluate and generate reports:
        String from  = getAttributeByXpath(dateRangeFrom);
        String to = getAttributeByXpath(dateRangeTo);
        long difference = ((new Date(from).getTime() - new Date(to).getTime())/86399999);
        actual = "" + difference;
        expected = "-182";
        checkTest();
    }
}