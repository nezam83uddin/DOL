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
import org.testng.annotations.Test;

import java.io.IOException;
import util.DataReader;
import java.util.Date;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 * Created by nd0ma3 on 2/23/2016.
 */
public class MC_FeaturesTest extends MC_Features_Base{
    /**
     * MEM_MSM_1.1_Alt_01
     * This function  will validate alternate flow of date range in job list.
     */
    //@Test(priority = 1)
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
    //@Test (priority = 2)
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
    //@Test(priority = 3)
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
    //@Test(priority = 4)
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
     * MEM_MSM_1.1_Main_01
     * This function will validate the default date range of 'Mass Email Job List.
     */
    //@Test(priority = 5)
    public void validateDefaultDateRangeOfMassEmailJobList(){
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        String from = getAttributeByXpath(dateRangeFrom);
        String to = getDateOfChoose(new Date(), -182);
        Assert.assertEquals(from, to);
        log.info("Successfully validated default date range of 'Mass Email Job List.");
    }

    /**
     * MEM_MSM_1.1_Main_02
     * This function will validate 'Search on date range' of 'Mass Email Job List'.
     */
    //@Test(priority = 6)
    public void validateSearchOnDateRangeOfMMassEmailJobList(){
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        String message = getTextByXpath(showingMessage);
        Assert.assertEquals( message.substring(0, 7), "Showing");
        log.info("Successfully validated 'Search on date range' of 'Mass Email Job List'");
    }

    /**
     * MEM_MSM_1.1_Main_03
     * This function will validate 'Search on date range' error msg.
     */
   // @Test(priority = 7)
    public void validateSearchOnDateRangeErrorMsg(){
        logInToTWCWithKWCreds();
        selectMassEmailFromMenu();
        clearField(dateRangeFrom);
        typeByXpath(dateRangeFrom,  getTodaysDate());
        clearField(dateRangeTo);
        typeByXpathThenEnter(dateRangeTo, getDateOfChoose(new Date(), -30));
        typeByXpathThenEnter(dateRangeTo, "");
        Assert.assertEquals(getTextByXpath(dateErrorMessage), "From Date cannot be later than To Date");
        log.info("Successfully validated 'Search on date range' error message.");
    }


    DataReader dr = new DataReader();

    String path = "C:\\Users\\nd0ma3\\Desktop\\Selenium\\My Workspace\\DOL\\TWC\\Data\\Report.xls";


    @Test(priority = 8)
    public void testAmazon() throws IOException, InterruptedException, WriteException {
        String[][] itemLocator = dr.fileReader(path);
        for (int i = 1; i<itemLocator.length; i++){
            typeByCssThenEnter(itemLocator[i][0], itemLocator[i][1]);
        }

        //writeInExcel();

        sleepfor(5);
    }


    public void writeInExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employee Data1");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        Set<String> keyset = data.keySet();
        int rownum = 0;
        data.put("1", new Object[]{"ID", "NAME", "LASTNAME", "AGE"});
        data.put("2", new Object[]{1, "Amit", "Shukla", "12"});
        data.put("3", new Object[]{2, "Lokesh", "Gupta", "13"});
        data.put("4", new Object[]{3, "John", "Adwards", "14"});
        data.put("5", new Object[]{4, "Brian", "Schultz", "15"});
        data.put("6", new Object[]{5, "Amit", "Shukla", "12"});
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream("demo.xls", true);
            workbook.write(out);
            out.flush();
            out.close();
            System.out.println("demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}