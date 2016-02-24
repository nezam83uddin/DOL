import org.testng.Assert;

/**
 * Created by nd0ma3 on 2/22/2016.
 */
public class StringTest {

    public static void checkCardNumber(String num) {
        Assert.assertTrue(num.charAt(4) == ' ' && num.charAt(9) == ' ' && num.charAt(14) == ' ');
    }

    public static void main(String[] args) {
        checkCardNumber("1234 5678 9012 3456");
    }
}
