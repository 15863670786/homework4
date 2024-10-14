
<%@ page import="cn.com.webxml.QqOnlineWebServiceSoap" %>
<%@ page import="cn.com.webxml.QqOnlineWebService" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>WeatherWs-天气预报系统</title>
</head>
<body>


<form method="get">
    <input type="test" name="qq">
    <input type="submit" value="查询">
</form>

<%
    String qq = request.getParameter("qq");
    String result=null;
    if (qq!=null){
        QqOnlineWebServiceSoap ws = new QqOnlineWebService().getPort(QqOnlineWebServiceSoap.class);

        result = ws.qqCheckOnline(qq);

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
    }
%>
<%=result%>
</body>
</html>