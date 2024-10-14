<%@ page import="example.client.CountTaxServiceLocator" %>
<%@ page import="example.client.CountTax_PortType" %>
<%@ page import="javax.xml.rpc.ServiceException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>马浩然的个人所得税计算程序Web服务</title>
</head>
<body>
<form method="get">
  <input type="text" name="money">
  <input type="submit" value="计算">
</form>
<%
  CountTaxServiceLocator locator = new CountTaxServiceLocator();
  CountTax_PortType service = null;
  String s = null,money=null;
  try {
    service = locator.getCalTax();
    money = request.getParameter("money");
    if (money!=null){
      s = service.calTax(money);
    }
  } catch (ServiceException e) {
    throw new RuntimeException(e);
  }
%>
<p> 您需要交税的金额为：</p>
<%=s%>
</body>
</html>
