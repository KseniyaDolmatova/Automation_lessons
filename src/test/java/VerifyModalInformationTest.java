import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyModalInformationTest extends BaseTest {
    private OpenModalWindow openModalWindow;

    @BeforeClass
    @Override public void setUp() {
        super.setUp();
        openModalWindow = new OpenModalWindow(driver);
    }

    @Test
    public void testVerifyModalInformation() {
        openModalWindow.openModalWindow();
    }
}
