import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FieldLabelsInCommunicationServicesTest extends BaseTest {
    private CommunicationServicesPage communicationServicesPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        communicationServicesPage = new CommunicationServicesPage(driver);
    }

    @Test
    public void testFieldLabelsInCommunicationServices() {
        communicationServicesPage.selectCommunicationServices();
        communicationServicesPage.checkPhoneField();
        communicationServicesPage.checkSumField();
        communicationServicesPage.checkEmailField();
    }
}
