
import org.testng.annotations.Test;

/**
 * Created by nd0ma3 on 2/17/2016.
 */
public class SignInTest extends WPM_Base {

    @Test(priority=1)
    public void signIn(){
        login("pwsuper1", "Test1234");
    }
}
