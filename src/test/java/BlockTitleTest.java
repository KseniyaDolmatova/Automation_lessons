import org.testng.Assert;
import org.testng.annotations.Test;

public class BlockTitleTest extends BaseTest {

    @Test
    public void testBlockTitle() {
        String title = paymentPage.getBlockTitle();
        Assert.assertEquals(title, "Онлайн пополнение\nбез комиссии", "Название блока неверно.");
    }
}
