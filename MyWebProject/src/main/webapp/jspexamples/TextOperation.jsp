<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="obj"  scope="page" class="mybeans.TextBean">
<jsp:setProperty name="obj" property="txt" /><br>
<jsp:setProperty name="obj" property="operation"/><br>
<font color="red" size="6">
Text=<jsp:getProperty name="obj" property="txt"/><br>
Operation=<jsp:getProperty name="obj" property="operation"/><br>
</font>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String txt,oper,res; %>
<font color="green" size="7">
<%
     txt=request.getParameter("txt");
     oper=request.getParameter("operation");
     out.println("Enter text= "+txt);
     out.println("<br>Selected operation ="+oper);
     
     if(oper.equalsIgnoreCase("upper"))
    	 res=obj.upper();
     else if(oper.equalsIgnoreCase("lower"))
    	 res=obj.lower();
     else if(oper.equalsIgnoreCase("reverse"))
    	 res=obj.reverse();
     else
    	 res="Operaiton not selected";
     out.println("<br>Result="+res);

%>
</font>
</body>
</html>
<br>
<a href="TextDemo.html">Do antoher oepration?</a>
</jsp:useBean>