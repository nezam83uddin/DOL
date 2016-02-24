package TWC_Base;

/**
 * Created by nd0ma3 on 2/22/2016.
 */
public class MC_Features_Base extends TWC_Base{

    /**
     * Below are the list of commonly used data
     */
    public String twcUserName = "twcsupervisor1";
    public String twcUserPassword = "abcd1234";
    public String searchData = "test";

    /**
     * Below are the list of commonly used locators
     */
    public String firstJob = ".//*[@id='form:myTable']/tbody/tr[1]/td[2]/a";
    public String firstInFile = ".//*[@id='form:myTable']/tbody/tr[1]/td[4]/a";
    public String firstOutFile = ".//*[@id='form:myTable']/tbody/tr[1]/td[5]/a";

    /**
     * This function will check that User able to login successfully.
     */
    public void logInToTWCWithKWCreds() {
        login(twcUserName, twcUserPassword);
    }

    /**
     * This function will check that User should able to navigate to
     * 'Mass Email' view with Mass Email Job list present.
     */
    public void selectMassEmailFromMenu() {
        clickByXpath(menu);
        clickByXpath(massEmail);
    }

    /**
     * This function will check that user able to enter date range.
     */
    public void enterDateRangeInMessageSection() {
        clearField(dateRangeFrom);
        typeByXpath(dateRangeFrom, getDateOfChoose(-30));
        clearField(dateRangeTo);
        typeByXpathThenEnter(dateRangeTo, getTodaysDate());
        typeByXpathThenEnter(dateRangeTo, "");
    }

    /**
     * This function will check that user able to see list jobs with filter value.
     */
    public void enterValueInSearchTab(){
        typeByXpath(searchField, searchData);
    }

    /**
     * This function will check that user able to see Compose Mass job and able to click to create mass job
     */
    public void clickFirstMassJob(){
        clickByXpath(firstJob);
    }

    /**
     * This function will check that user able to see and select to view the In-File.
     */
    public void clickFirstInFile(){
        clickByXpath(firstInFile);
    }

    /**
     * This function will check that user able to see and select to view the Out-File.
     */
    public void clickFirstOutFile(){
        clickByXpath(firstOutFile);
    }

    /**
     * This function will check that user able to view job list for
     * the date range provided.
     */
    public void clickSearch() {
        //clickByXpath(search);
    }


}
