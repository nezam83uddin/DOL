import commonapi.Base;
import org.testng.Assert;

/**
 * Created by nd0ma3 on 2/17/2016.
 */
public class WPM_Base extends Base {

    public void login(String userId, String password) {
        typeByCss("#USERNAME", userId);
        typeByCss("#PASSWORD", password);
        clickByXpath(".//*[@id='signin']");
        Assert.assertEquals("NYSDOL - Audit/Monetary System", driver.getTitle());
        log.info("Successfully loged in on WPM!");
    }
}
