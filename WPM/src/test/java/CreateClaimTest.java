import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.*;
import java.time.LocalDateTime;
import java.io.BufferedWriter;

/**
 * Created by nd0ma3 on 2/18/2016.
 */
public class CreateClaimTest extends WPM_Base{

    private int numberOfClaim = 5;

    /**
	 * Audit and Monetary System
	 */
    private String welcomeLabel = "html/body/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]";
    private String nYGovHomeLink = "html/body/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/a[1]";
    private String auditMonetaryWageHomeLink = "html/body/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/a[2]";
    private String logOffLink = "html/body/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/a[3]";
    private String homeLink = ".//*[@id='breadcrumb_trail']/a";
    private String submitButton = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[9]/td/input[1]";
    private String cancelButton = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[9]/td/input[2]";

    /**
     * Type of Complaint
     */
    private String complaint_type_ls = ".//*[@id='complaint_type_ls']";
    private String complaint_type_pw = ".//*[@id='complaint_type_pw']";
    private String receivedDateMM = ".//*[@id='receivedDateMM']";
    private String receivedDateDD = ".//*[@id='receivedDateDD']";
    private String receivedDateYYYY = ".//*[@id='receivedDateYYYY']";

    /**
     * Claimant Contact Information
     */
    private String claimantFirstName = ".//*[@id='firstName']";
    private String claimantLastName = ".//*[@id='lastName']";
    private String claimantSsn1 = ".//*[@id='ssn1']";
    private String claimantSsn2 = ".//*[@id='ssn2']";
    private String claimantSsn3 = ".//*[@id='ss3']";
    private String claimantAddress1 = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input[1]";
    private String claimantAddress2 = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input[2]";
    private String claimantAddress3 = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input[3]";
    private String claimantAddressCity = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input[1]";
    private String claimantAddressState = ".//*[@id='state']";
    private String claimantAddressPostalCode = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/input[3]";
    private String claimantAreaCode = ".//*[@id='areaCode']";
    private String claimantExchange = ".//*[@id='exchange']";
    private String claimantNumber = ".//*[@id='number']";
    private String claimantExtension = ".//*[@id='extension']";
    private String claimantAltAreaCode = ".//*[@id='altAreaCode']";
    private String claimantAltExchange = ".//*[@id='altExchange']";
    private String claimantAltNumber = ".//*[@id='altNumber']";
    private String claimantAltExtension = ".//*[@id='altExtension']";
    private String claimantThirdAreaCode = ".//*[@id='thirdAreaCode']";
    private String claimantThirdExchange = ".//*[@id='thirdExchange']";
    private String claimantThirdNumber = ".//*[@id='thirdNumber']";
    private String claimantThirdExtension = ".//*[@id='thirdExtension']";
    private String claimantEmail = ".//*[@id='email']";

    /**
     * Employer Information
     */
    private String employerCompanyName = ".//*[@id='companyName']";
    private String employerFindEmployerButton = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input[2]";
    private String employerClearEmployerButton = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input[3]";
    private String employerBusinessTypeDropDownMenu = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/select";
    private String employerFein1 = ".//*[@id='empFein1']";
    private String employerFein2 = ".//*[@id='empFein2']";
    private String employerFirstName = ".//*[@id='empFirstName']";
    private String employerLastName = ".//*[@id='empLastName']";
    private String employerAddress1 = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[4]/td/table/tbody/tr[6]/td[2]/input[1]";
    private String employerAddress2 = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[4]/td/table/tbody/tr[6]/td[2]/input[2]";
    private String employerAddress3 = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[4]/td/table/tbody/tr[6]/td[2]/input[3]";
    private String employerCity = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[4]/td/table/tbody/tr[7]/td[2]/input[1]";
    private String employerState = ".//*[@id='empState']";
    private String employerPostalCode = ".//*[@id='empZip']";
    private String employerAreaCode = ".//*[@id='empAreaCode']";
    private String employerExchange = ".//*[@id='empExchange']";
    private String employerNumber = ".//*[@id='empNumber']";
    private String employerExtension = ".//*[@id='empExtension']";
    private String employerIndustryCodeDropdownMenu = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[4]/td/table/tbody/tr[9]/td/table/tbody/tr/td[2]/select";

    /**
     * Complaint Information
     */
    private String complaintSourceOfComplaintDropdownMenu = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[2]/select";
    private String complaintTypeRadioButton1 = ".//*[@id='22221']/table/tbody/tr[2]/td[1]/input";
    private String complaintTypeRadioButton2 = ".//*[@id='22221']/table/tbody/tr[3]/td[1]/input";
    private String complaintDistrictDropdownMenu = ".//*[@id='22223']/select";
    private String complaintBeginDateMM = ".//*[@id='beginDateMM']";
    private String complaintBeginDateDD = ".//*[@id='beginDateDD']";
    private String complaintBeginDateYYYY = ".//*[@id='beginDateYYYY']";
    private String complaintEndDateMM = ".//*[@id='endDateMM']";
    private String complaintEndDateDD = ".//*[@id='endDateDD']";
    private String complaintEndDateYYYY = ".//*[@id='endDateYYYY']";
    private String complaintRate = ".//*[@id='rate']";
    private String complaintPerDropdownMenu = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[5]/td/table/tbody/tr[7]/td[2]/select";
    private String complaintOccupationDropdownMenu = ".//*[@id='22224']/select";
    private String complaintJobTitle = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[5]/td/table/tbody/tr[10]/td[2]/input";
    private String complaintComplain = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[5]/td/table/tbody/tr[11]/td[2]/textarea";
    private String complaintLanguageDropdownMenu = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[5]/td/table/tbody/tr[12]/td[2]/select";

    /**
     * Complaint Specific Information
     */
    private String complaintPwProjectLocation = ".//*[@id='pwProjectLocation']";
    private String complaintCountryDropdownMenu = ".//*[@id='22222']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/select";
    private String complaintPwDOJ = ".//*[@id='pwDOJ']";
    private String complaintPwDOJAddress = ".//*[@id='pwDOJaddress']";
    private String complaintPwPRC = ".//*[@id='pwPRC']";
    private String complaintPwPrimeContractor = ".//*[@id='pwPrimeContractor']";
    private String complaintFindPrimeContractorButton = ".//*[@id='22222']/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/input[2]";
    private String complaintClearPrimeContractorButton = ".//*[@id='22222']/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/input[3]";
    private String complaintBusinessTypeDropdownMenu = ".//*[@id='22222']/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/select";
    private String complaintPwFein1 = ".//*[@id='pwFein1']";
    private String complaintPwFein2 = ".//*[@id='pwFein2']";
    private String complaintPwpwFirstName = ".//*[@id='pwFirstName']";
    private String complaintPwLastName = ".//*[@id='pwLastName']";
    private String complaintPwAddress1 = ".//*[@id='pwAddress1']";
    private String complaintPwAddress2 = ".//*[@id='pwAddress2']";
    private String complaintPwAddress3 = ".//*[@id='pwAddress3']";
    private String complaintPwCity = ".//*[@id='pwCity']";
    private String complaintPwState = ".//*[@id='pwState']";
    private String complaintPwZip = ".//*[@id='pwZip']";
    private String complaintPwAreaCode = ".//*[@id='pwAreaCode']";
    private String complaintPwExchange = ".//*[@id='pwExchange']";
    private String complaintPwNumber = ".//*[@id='pwNumber']";
    private String complaintPwExtension = ".//*[@id='pwExtension']";
    private String complaintJETFClaim  = ".//*[@id='22222']/table/tbody/tr[2]/td/table/tbody/tr[15]/td[2]/input";

    /**
     * Status & Comments
     */
    private String statusSelectDropdownMenu = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[8]/td/table/tbody/tr[2]/td[2]/select";
    private String statusComments = "html/body/table/tbody/tr[4]/td/div[3]/form/table/tbody/tr[8]/td/table/tbody/tr[3]/td[2]/input";

    @Test
    public void createClaim() throws InterruptedException, IOException {
        File fout = new File("C:\\Users\\ND0MA3\\Desktop\\Selenium\\My Workspace\\DOL\\WPM\\Store\\claims.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        login("pwsuper1", "Test1234");
        clickByXpath("html/body/table/tbody/tr[4]/td/div/a[9]");
        sleepfor(1);

        for (int i = 0; i < numberOfClaim; i++) {

        /**
         * Type of Complaint
         */
        typeByXpath(receivedDateMM, "" + LocalDateTime.now().getMonthValue());
        typeByXpath(receivedDateDD, "" + LocalDateTime.now().getDayOfMonth());
        typeByXpath(receivedDateYYYY, "" + LocalDateTime.now().getYear());

        /**
         * Claimant Contact Information
         */
        typeByXpath(claimantFirstName, "QMC");
        typeByXpath(claimantLastName, "PW_" + increment());
        typeByXpath(claimantSsn1, "999");
        typeByXpath(claimantSsn2, "88");
        typeByXpath(claimantSsn3, "" + steady);
        typeByXpath(claimantAddress1, "12 " + steady + " Street");
        typeByXpath(claimantAddress2, "Apt # 2A");
        typeByXpath(claimantAddress3, "");
        typeByXpath(claimantAddressCity, "Albany");
        typeByXpath(claimantAddressState, "NY");
        typeByXpath(claimantAddressPostalCode, "12240");
        typeByXpath(claimantAreaCode, "518");
        typeByXpath(claimantExchange, "111");
        typeByXpath(claimantNumber, "" + steady);
        typeByXpath(claimantExtension, "");
        typeByXpath(claimantAltAreaCode, "518");
        typeByXpath(claimantAltExchange, "222");
        typeByXpath(claimantAltNumber, "" + steady);
        typeByXpath(claimantAltExtension, "");
        typeByXpath(claimantThirdAreaCode, "518");
        typeByXpath(claimantThirdExchange, "333");
        typeByXpath(claimantThirdNumber, "" + steady);
        typeByXpath(claimantThirdExtension, "432");
        typeByXpath(claimantEmail, "QMC_PW_" + steady + "@gmail.com");

        /**
         * Employer Information
         */
        typeByXpath(employerCompanyName,"Circuit Design Tech");
        selectFromDropdown(employerBusinessTypeDropDownMenu, 1);
        typeByXpath(employerFein1, "98");
        typeByXpath(employerFein2, "765" + steady);
        typeByXpath(employerFirstName, "QMC_Employer");
        typeByXpath(employerLastName, "PW_" + steady + "_Employer");
        typeByXpath(employerAddress1, "123 " + steady + " Street");
        typeByXpath(employerAddress2, "Apt # 2A");
        typeByXpath(employerAddress3, "");
        typeByXpath(employerCity, "Albany");
        typeByXpath(employerState, "NY");
        typeByXpath(employerPostalCode, "12240");
        typeByXpath(employerAreaCode, "518");
        typeByXpath(employerExchange, "111");
        typeByXpath(employerNumber, "" + steady);
        typeByXpath(employerExtension, "");
        selectFromDropdown(employerIndustryCodeDropdownMenu, 1);

        /**
         * Complaint Information
         */
        selectFromDropdown(complaintSourceOfComplaintDropdownMenu, 1);
        //typeByXpath(complaintTypeRadioButton1, "1");
        //typeByXpath(complaintTypeRadioButton2, "1");
        selectFromDropdown(complaintDistrictDropdownMenu, 2);
        typeByXpath(complaintBeginDateMM, "11");
        typeByXpath(complaintBeginDateDD, "22");
        typeByXpath(complaintBeginDateYYYY, "2015");
        typeByXpath(complaintEndDateMM, "" + LocalDateTime.now().getMonthValue());
        typeByXpath(complaintEndDateDD, "" + LocalDateTime.now().getDayOfMonth());
        typeByXpath(complaintEndDateYYYY, "" + LocalDateTime.now().getYear());
        typeByXpath(complaintRate, "35");
        selectFromDropdown(complaintPerDropdownMenu, 5);
        selectFromDropdown(complaintOccupationDropdownMenu, 2);
        //typeByXpath(complaintJobTitle, "");
        typeByXpath(complaintComplain, "Issuing a private right of action letter so that I may pursue my unpaid wages and other damages through a civil lawsuit against my employer");
        selectFromDropdown(complaintLanguageDropdownMenu, 2);

        /**
         * Complaint Specific Information
         */
        typeByXpath(complaintPwProjectLocation, "Building A");
        selectFromDropdown(complaintCountryDropdownMenu, 3);
        typeByXpath(complaintPwDOJ, "Contracting Agency");
        typeByXpath(complaintPwDOJAddress, "Contracting Agency Address");
        typeByXpath(complaintPwPRC, "" + steady);
        typeByXpath(complaintPwPrimeContractor, "");
        //typeByXpath(complaintFindPrimeContractorButton, "1");
        //typeByXpath(complaintClearPrimeContractorButton, "1");
        //typeByXpath(complaintBusinessTypeDropdownMenu, "1");
        typeByXpath(complaintPwFein1, "98");
        typeByXpath(complaintPwFein2, "765" + steady);
        typeByXpath(complaintPwpwFirstName, "QMC_Employer");
        typeByXpath(complaintPwLastName, "PW_" + steady + "_Employer");
        typeByXpath(complaintPwAddress1, "456 " + steady + " Street");
        typeByXpath(complaintPwAddress2, "Apt # 3A");
        typeByXpath(complaintPwAddress3, "");
        typeByXpath(complaintPwCity, "Albany");
        typeByXpath(complaintPwState, "NY");
        typeByXpath(complaintPwZip, "12240");
        typeByXpath(complaintPwAreaCode, "518");
        typeByXpath(complaintPwExchange, "111");
        typeByXpath(complaintPwNumber, "" + steady);
        typeByXpath(complaintPwExtension, "");
        //typeByXpath(complaintJETFClaim, "1");

        /**
         * Status & Comments
         */
        selectFromDropdown(statusSelectDropdownMenu, 5);
        typeByXpath(statusComments, "Comment");
        clickByXpath(submitButton);

        // Record claim number
        String claimNo = driver.findElement(By.xpath("html/body/table/tbody/tr[4]/td/div[3]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
            bw.write(claimNo);
            bw.newLine();
            clickByXpath("html/body/table/tbody/tr[4]/td/div[3]/table/tbody/tr[1]/td[2]/a");
        }
        bw.close();
    }
}