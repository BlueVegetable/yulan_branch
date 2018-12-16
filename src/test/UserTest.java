import com.yulan.dao.CustomerInfoDao;
import com.yulan.dao.UserDao;
import com.yulan.pojo.CustomerInfoCard;
import com.yulan.service.CustomerInfoService;
import com.yulan.utils.MapUtils;
import com.yulan.utils.StringUtil;
import com.yulan.utils.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CustomerInfoDao customerInfoDao;
    @Autowired
    private CustomerInfoService customerInfoService;

    private CustomerInfoCard customerInfoCard;

    private MapUtils mapUtils;

    private StringUtil stringUtil;

    @Test
    public void test1() throws Exception{
        System.out.println(TimeUtil.getTime());
        /*Map<String, Object> map = new HashMap<String, Object>();
        map = mapUtils.beanToMap(customerInfoCard);

        for (Map.Entry<String,Object> entry : map.entrySet()) {
            if(entry.getValue() instanceof String){
                String origin = stringUtil.getUtf8(String.valueOf(entry.getValue()));
                entry.setValue(stringUtil.setUtf8(origin));
            }
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }

        System.out.println("23333"+mapUtils.mapToBean(map ,customerInfoCard));*/
        System.out.println(customerInfoService.getCustomerInfo("C15056"));
 //       System.out.println(customerInfoDao.getCustomerInfo( "C15056"));
        //System.out.println(MD5.toMD5("yulan1234"));
 //       System.out.println(customerInfoCard);
    }

}
