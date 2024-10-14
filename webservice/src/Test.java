import cn.com.webxml.QqOnlineWebService;
import cn.com.webxml.QqOnlineWebServiceSoap;

public class Test {



    public static void main(String[] args) {

        QqOnlineWebServiceSoap ws = new QqOnlineWebService().getPort(QqOnlineWebServiceSoap.class);

        String qq = "88888888";

        String result = ws.qqCheckOnline(qq);


        System.out.println(result);


        // String，Y = 在线；N = 离线；E = QQ号码错误；A = 商业用户验证失败；V = 免费用户超过数量

        if ("Y".equalsIgnoreCase(result)) {

            result = "在线";

        } else if ("N".equalsIgnoreCase(result)) {

            result = "离线";

        } else if ("E".equalsIgnoreCase(result)) {

            result = "QQ号码错误";

        } else if ("A".equalsIgnoreCase(result)) {

            result = "商业用户验证失败";

        } else if ("V".equalsIgnoreCase(result)) {

            result = "免费用户超过数量";

        }

        System.out.println(result);

    }



}