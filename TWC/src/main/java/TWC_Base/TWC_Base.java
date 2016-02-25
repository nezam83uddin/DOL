package TWC_Base;

import commonapi.Base;
import util.DataReader;
import org.testng.Assert;

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

    public void login(String userId, String password){
        clickByXpath(".//*[@id='logincontainer']/table/tbody/tr[4]/td/a");
        switchWindow();
        driver.close();
        switchWindow();
        typeByCss("#USERNAME", userId);
        typeByCss("#PASSWORD", password);
        clickByXpath(".//*[@id='signin']");
        Assert.assertEquals("Message Inbox | Secure Message Center", driver.getTitle());
        log.info("Successfully loged in on TWC!");
    }
}
