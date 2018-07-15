import com.springcomponent.db.DBUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Administrator
 * @Title: DBUtilTest
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/15 001522:34
 */
public class DBUtilTest {
    DBUtil dbUtil;

    @Before
    public void init() {
        dbUtil = new DBUtil();
    }
    @Test
    public void save() {
        System.out.println("xxxx");
        dbUtil.testSave();
    }
}
