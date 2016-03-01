package TWC_Base;

import commonapi.Base;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by nd0ma3 on 2/22/2016.
 */
public class TWC_Base extends Base {

    public String menu = ".//*[@id='ux-side-nav-toggle']";
    public String massEmail = ".//*[@id='ux-side-nav']/ul/li[8]/a";
    public String dateRangeFrom = ".//*[@id='form:selectFromDate']";
    public String dateRangeTo = ".//*[@id='form:selectToDate']";
    public String search = ".//*[@id='form:j_id_jsp_1675652393_11pc5']";
    public String calendar = ".//*[@id='form']/div[1]/div[3]/fieldset/div/label[2]/img";
    public String searchField = ".//*[@id='form:myTable_filter']/label/input";

    /**
     * List of fields for report generations.
     */
    public static int id = 1;
    public String number = "1";
    public String testId;
    public String expectedResult;
    public String executionDate = "" + new Date();
    public String executedBy = "Md Alam";
    public String testEnvironment = "Windowns 7, IE, 9";
    public String testResult;
    public String actual;
    public String expected;

    public void login(String userId, String password){
        clickByXpath(".//*[@id='logincontainer']/table/tbody/tr[4]/td/a");
        switchWindow();
        driver.close();
        switchWindow();
        typeByCss("#USERNAME", userId);
        typeByCss("#PASSWORD", password);
        clickByXpath(".//*[@id='signin']");
        Assert.assertEquals("Message Inbox | Secure Message Center", driver.getTitle());
        log.info("Successfully logged in on TWC!");
    }

    public void createExcelFile() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("MC_Features");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        Set<String> keyset = data.keySet();
        int rownum = 0;
        data.put("1", new Object[]{"TWC - MC Feature"});
        data.put("2", new Object[]{"Number", "Test ID", "Expected Result", "Execution Date & Time", "Executed By", "Test Environment", "Test Result"});

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
            FileOutputStream out = new FileOutputStream(".\\Data\\" + "Report.xls", false);
            workbook.write(out);
            out.flush();
            out.close();
            System.out.println("Report.xls written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeInExcelFile() throws IOException {
        FileInputStream input = new FileInputStream(".\\Data\\" + "Report.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(input);

        HSSFSheet sheet = workbook.getSheetAt(0);
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        Set<String> keyset = data.keySet();
        int rowNum = ++id;
        int testNumber = id-1;
        data.put("2", new Object[]{testNumber, testId, expectedResult, ""+new Date(), executedBy, testEnvironment, testResult});

        for (String key : keyset) {
            Row row = sheet.createRow(rowNum++);
            Object[] objArr = data.get(key);
            int cellNum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellNum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(".\\Data\\" + "Report.xls", false);
            workbook.write(out);
            out.flush();
            out.close();
            System.out.println("Report.xls written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkTest() throws IOException {
        try{
            Assert.assertEquals(actual, expected);
            testResult = "PASSED";
            writeInExcelFile();
        }catch(Throwable e) {
            testResult = "FAILED";
            writeInExcelFile();
            Assert.fail();
        }
    }
}