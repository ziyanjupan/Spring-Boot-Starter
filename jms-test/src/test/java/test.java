import okhttp3.Credentials;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xiaguangyong
 * @ClassName: test
 * @Description: 测试
 * @Date: 2019/10/16 11:17
 * @Version: 1.0
 * @Modify:
 */
public class test {

    public static void main(String[] args) {

        Long current = System.currentTimeMillis();

        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(current);
        res = simpleDateFormat.format(date);


        String code = Credentials.basic("728", "V9cHGvDX4y9yb4A3F3kRLeIlwASRFd4Duc4AZ9ukJpVAPonG4IfU8RmnsGTNMCaM");

        int a=0;
    }
}
