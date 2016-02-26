package MC_Features;

import TWC_Base.MC_Features_Base;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;

import util.DataReader;

import java.util.*;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

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
        actual = "Modify Mass E-Mail | Secure  Message Center";
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
        expected= getDateOfChoose(new Date(), -182);
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
        typeByXpath(dateRangeFrom,  getTodaysDate());
        clearField(dateRangeTo);
        typeByXpathThenEnter(dateRangeTo, getDateOfChoose(new Date(), -30));
        typeByXpathThenEnter(dateRangeTo, "");
        actual = "From  Date cannot be later than To Date";
        expected = getTextByXpath(dateErrorMessage);
        checkTest();
//        Assert.assertEquals(getTextByXpath(dateErrorMessage), "From Date cannot be later than To Date");
//        log.info("Successfully validated 'Search on date range' error message.");
    }


    DataReader dr = new DataReader();

    String path = "C:\\Users\\nd0ma3\\Desktop\\Selenium\\My Workspace\\DOL\\TWC\\Data\\Report.xls";


    //@Test(priority = 8)
    public void testAmazon() throws IOException, InterruptedException, WriteException {
        String[][] itemLocator = dr.fileReader(path);
        for (int i = 1; i<itemLocator.length; i++){
            typeByCssThenEnter(itemLocator[i][0], itemLocator[i][1]);
        }
//        createExcelFile(); writeInExcelFile();
        sleepfor(5);
    }
}