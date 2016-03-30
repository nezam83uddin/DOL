package TWC_Base;

/**
 * Created by nd0ma3 on 3/15/2016.
 */
public class BMA_Base extends TWC_Base {

    /**
     * Below are the list of commonly used locators
     */
    //public String userName = ".//*[@id='form:myTable']/tbody/tr[1]/td[2]/a";
    public String userName = ".//*[@id='USERNAME']";
    public String password = ".//*[@id='PASSWORD']";
    public String viewMyMessages = ".//*[@id='wrapper']/table/tbody/tr[2]/td[2]/table[3]/tbody/tr[1]/td[1]/table/tbody/tr[2]/td/ul/li[2]/a";

    public String priorityHeader = ".//*[@id='form:myTable']/thead/tr/th[2]/div";
    public String attachmentHeader = ".//*[@id='form:myTable']/thead/tr/th[3]/div/span[1]";
    public String subjectHeader = ".//*[@id='form:myTable']/thead/tr/th[4]/div";
    public String regardingHeader = ".//*[@id='form:myTable']/thead/tr/th[5]/div";
    public String fromHeader = ".//*[@id='form:myTable']/thead/tr/th[6]/div";
    public String dateHeader = ".//*[@id='form:myTable']/thead/tr/th[7]/div";

    public String composeSubject1 = ".//*[@id='frmTWCExtIndCompose_levelOneCategory_chosen']/a/div/b";
    public String composeSubject2 = ".//*[@id='frmTWCExtIndCompose_levelTwoCategory_chosen']/a/div/b";

    public String subjectUIOnlineServices = ".//*[@id='frmTWCExtIndCompose_levelOneCategory_chosen']/div/ul/li[13]";
    public String subjectNavigationalIssues = ".//*[@id='frmTWCExtIndCompose_levelTwoCategory_chosen']/div/ul/li[2]";

    public String composeBody = ".cke_editable.cke_editable_themed.cke_contents_ltr>p";
    public String composeSend = ".//*[@id='frmTWCExtIndCompose:sendEmail']";

    public String messageSentConfirmationMessage = ".//*[@id='successMsgGroup']/ul/li";

    /**
     * Below are the list of commonly used data
     */
    public String bmaUserName = "bmatwc18";
    public String bmaUserPassword = "test1234";

    /**
     * This function will check that User able to login successfully.
     */
    public void logInToTWCWithBMACreds() throws InterruptedException {
        typeByXpath(userName, bmaUserName);
        typeByXpathThenEnter(password, bmaUserPassword);
        clickByXpath(viewMyMessages);
        switchWindow();
    }

    /**
     * This function will check that User should able to navigate to
     * 'Mass Email' view with Mass Email Job list present.
     */
    public void selectComposeNewFromMenu() {
        clickByXpath(menu);
        clickByXpath(composeNew);
    }
}
