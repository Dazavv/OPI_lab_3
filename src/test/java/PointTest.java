import com.example.web_3.CheckResult;
import org.junit.Test;
import static org.junit.Assert.*;
public class PointTest {
    @Test
    public void testSquare(){
        CheckResult checkResult = new CheckResult();
        boolean res1 = checkResult.check(1, 4, 1);
        boolean res2 = checkResult.check(1, 0.5F, 1.5F);
        boolean res3 = checkResult.check(2, 1, 3);
        assertFalse(res1);
        assertTrue(res2);
        assertTrue(res3);
    }

    @Test
    public void testTriangle(){
        CheckResult checkResult = new CheckResult();
        boolean res1 = checkResult.check(-1, -1, 3);
        boolean res2 = checkResult.check(1, -2, 1);
        boolean res3 = checkResult.check(-1, -3, 2.5F);
        assertTrue(res1);
        assertFalse(res2);
        assertFalse(res3);
    }

    @Test
    public void testCircle(){
        CheckResult checkResult = new CheckResult();
        boolean res1 = checkResult.check(-2, 2, 2);
        boolean res2 = checkResult.check(0.5F, 0.5F, 1);
        boolean res3 = checkResult.check(-2, 2000, 2.5F);
        assertFalse(res1);
        assertTrue(res2);
        assertFalse(res3);
    }




}
