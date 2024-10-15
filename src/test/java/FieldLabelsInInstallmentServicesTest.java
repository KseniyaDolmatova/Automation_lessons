import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FieldLabelsInInstallmentServicesTest extends BaseTest {
    private InstallmentPage installmentPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        installmentPage = new InstallmentPage(driver);
    }

    @Test
    public void testFieldLabelsInInstallmentServices() {
        installmentPage.installmentServicesService();
        installmentPage.checkAccountNumber();
        installmentPage.checkSumField();
        installmentPage.checkEmailField();
    }
}

