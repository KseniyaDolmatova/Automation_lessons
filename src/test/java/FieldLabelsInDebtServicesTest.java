import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FieldLabelsInDebtServicesTest extends BaseTest {
    private DebtPage debtPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        debtPage = new DebtPage(driver);
    }

    @Test
    public void testFieldLabelsInDebtServices() {
        debtPage.DebtServicesService();
        debtPage.checkAccountNumber();
        debtPage.checkSumField();
        debtPage.checkEmailField();
    }
}
