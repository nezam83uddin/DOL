package MC_Features;

import TWC_Base.MC_Features_Base;
import org.testng.annotations.Test;
import java.util.*;
import java.io.IOException;

/**
 * Created by nd0ma3 on 2/23/2016.
 */
public class MC_FeaturesTest extends MC_Features_Base{

    public final boolean activate = false;
    @Test(priority = 0, enabled = activate)
    public void setUpEnvironment(){
        createExcelFile();
    }

    /**
     * MEM_MSM_1.1_Alt_01
     * This function  will validate alternate flow of date range in job list.
     */
    @Test(priority = 1, enabled = activate)
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
    @Test (priority = 2, enabled = activate)
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
    @Test(priority = 3, enabled = activate)
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
    @Test(priority = 4, enabled = activate)
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
    @Test(priority = 5, enabled = activate)
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
    @Test(priority = 6, enabled = activate)
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
    @Test(priority = 7, enabled = activate)
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
    @Test(priority = 8, enabled = activate)
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

    /**
     * MEM_MSM_1.1_Main_05
     * This function will validate jobs list order status group by scheduled date.
     */
    @Test(priority = 9, enabled = activate)
    public void validateJobsListOrderedByScheduledDateInAscendingAlphabeticalOrder() throws IOException, InterruptedException {
        testId = "MEM_MSM_1.1_Main_05";
        expectedResult = "User should able to see the jobs list ordered by Scheduled date in Ascending alphabetical order";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterDateRangeInMessageSection();
        // Evaluate and generate reports:
        String[] dates = {
                getTextByXpath(".//*[@id='form:myTable']/tbody/tr[1]/td[6]/span[2]").substring(0, 10),
                getTextByXpath(".//*[@id='form:myTable']/tbody/tr[2]/td[6]/span[2]").substring(0, 10),
                getTextByXpath(".//*[@id='form:myTable']/tbody/tr[3]/td[6]/span[2]").substring(0, 10),
                getTextByXpath(".//*[@id='form:myTable']/tbody/tr[4]/td[6]/span[2]").substring(0, 10),
                getTextByXpath(".//*[@id='form:myTable']/tbody/tr[5]/td[6]/span[2]").substring(0, 10),
        };
        boolean status = true;
        for(int i=0; i<4; i++) {
            long difference = ((new Date(dates[i]).getTime() - new Date(dates[i]).getTime()) / 86399999);
            if (difference<0) {
                status = false;
                break;
            }
            //System.out.println(status);
        }
        actual = "" + status;
        expected = "true";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_06
     * This function will validate jobs list order status group by jobs with no scheduled date.
     */
    @Test(priority = 10, enabled = activate)
    public void validateJobsListOrderStatusGroupByJobsWithNoScheduledDate() throws IOException {
        testId = "MEM_MSM_1.1_Main_06";
        expectedResult = "User should able to see the jobs list ordered by 'Job Created date' in ascending order";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        enterDateRangeInMessageSection();
        // Evaluate and generate reports:

        actual = " "; // Test script not created yet.
        expected = "";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_07
     * This function will validate Fields in 'Mass Email Job List'.
     */
    @Test(priority = 11, enabled = activate)
    public void validateFieldsInMassEmailJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_07";
        expectedResult = "User should able to see 'Compose New', 'Create Copy' button.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // Evaluate and generate reports:
        boolean present;
        try {
            findByXpath(composeNewButton);
            findByXpath(createCopyButton);
            present = true;
        } catch (Exception e){
            present = false;
        }
        actual = "" + present;
        expected = "true";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_08
     * This function will validate Search field in 'Message Box' section of Mass email view.
     */
    @Test(priority = 12, enabled = activate)
    public void validateSearchFieldInMessageBoxSectionOfMassEmailView() throws IOException {
        testId = "MEM_MSM_1.1_Main_08";
        expectedResult = "User should able to get the search results for the field entered in Mass email view.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        typeByXpath(searchField, searchData);

        // Evaluate and generate reports:
        boolean present = false;
        String text;
        try{
            text = getTextByXpath(firstJobName);
            if(findStringIgnoreCase(text, searchData)) present = true;
        }catch (Exception e) {
            present = false;
        }
        if (present == false){
            try{
                text = getTextByXpath(firstJobDescription);
                if(findStringIgnoreCase(text, searchData)) present = true;
            }catch (Exception e) {
                present = false;
            }
        }
        actual = "" + present;
        expected = "true";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_09
     * This function will validate Completed Status in 'Message Box' section of Mass email view.
     */
    @Test(priority = 13, enabled = activate)
    public void validateCompletedStatusInMessageBoxSectionOfMassEmailView() throws IOException {
        testId = "MEM_MSM_1.1_Main_09";
        expectedResult = "User should able to see 'Mass Job List' with Completed Status.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // Evaluate and generate reports:
        actual = getTextByXpath(firstStatus);
        expected = "Completed";
        System.out.println("this line executed");
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_10
     * This function will validate Scheduled Status in 'Message Box' section of Mass email view.
     */
    @Test(priority = 14, enabled = activate)
    public void validateScheduledStatusInMessageBoxSectionOfMassEmailView() throws IOException {
        testId = "MEM_MSM_1.1_Main_10";
        expectedResult = "User should able to see 'Mass Job List' with 'Scheduled' Status.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = getTextByXpath(firstStatus);
        expected = "Scheduled";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_11
     * This scenario will validate 'In-Progress' Status in 'Message Box' section of Mass email view.
     */
    @Test(priority = 15, enabled = activate)
    public void validateInProgressStatusInMessageBoxSectionOfMassEmailView() throws IOException {
        testId = "MEM_MSM_1.1_Main_11";
        expectedResult = "User should able to see 'Mass Job List' with 'In-Progress' Status.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = getTextByXpath(firstStatus);
        expected = "In-Progress";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_12
     * This function will validate 'Create Copy' button error message in Mass Secure Message job list.
     */
    @Test(priority = 16, enabled = activate)
    public void validateCreateCopyButtonErrorMessageInMassSecureMessageJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_12";
        expectedResult = "User sees the error message \"Please select one message to copy.\"";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_13
     * This function will validate 'date format' in Mass email job list.
     */
    @Test(priority = 17, enabled = activate)
    public void validateDateFormatInMassEmailJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_13";
        expectedResult = "Date should display in format ##/##/####";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_14
     * This function will validate 'Search Icon' in Mass email job list.
     */
    @Test(priority = 18, enabled = activate)
    public void validateSearchIconInMassEmailJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_14";
        expectedResult = "Search should result listing jobs with Date Picker range.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_15
     * This scenario will validate 'Tool Tip' in Mass email job list.
     */
    @Test(priority = 19, enabled = activate)
    public void validateToolTipInMassEmailJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_15";
        expectedResult = "Should display the message \"Maximum Date Range Allowed is 1 Year\".";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_16
     * This function will validate 'Refresh Icon' in Mass email job list.
     */
    @Test(priority = 20, enabled = activate)
    public void validateRefreshIconInMassEmailJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_16";
        expectedResult = "Job list should get refresh and should display if any latest update in jobs.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_17
     * This function will validate 'Search' field in Mass email job list.
     */
    @Test(priority = 21, enabled = activate)
    public void validateSearchFieldInMassEmailJobList() throws IOException {
        testId = "MEM_MSM_1.1_Main_17";
        expectedResult = "Search tab should not allow more than 150 Alpha Numeric.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_18
     * This function will validate 'Job Name' in Mass email job list section.
     */
    @Test(priority = 22, enabled = activate)
    public void validateJobNameInMassEmailJobListSection() throws IOException {
        testId = "MEM_MSM_1.1_Main_18";
        expectedResult = "Navigates user to 'Modify Mass Email'.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_19
     * This function will validate 'Status field' in Mass email job list section.
     */
    @Test(priority = 23, enabled = activate)
    public void validateStatusFieldInMassEmailJobListSection() throws IOException {
        testId = "MEM_MSM_1.1_Main_19";
        expectedResult = "User should able to see different status jobs with 'Completed, Scheduled, In-Progress, etc'.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }

    /**
     * MEM_MSM_1.1_Main_20
     * This function will validate 'Job Description field' in Mass email job list section.
     */
    @Test(priority = 24, enabled = activate)
    public void validateJobDescriptionFieldInMassEmailJobListSection() throws IOException {
        testId = "MEM_MSM_1.1_Main_20";
        expectedResult = "Job Description table column is Read Only field. It should display bold if status not completed.";
        // Test Steps:
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        // more code here... test script not completed...

        // Evaluate and generate reports:
        actual = "";
        expected = " ";
        checkTest();
    }
}