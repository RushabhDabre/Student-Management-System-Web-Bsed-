<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!  
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
%>

<%
response.setContentType("text/html");
try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RUSHABH","Wadsa@123");  //for oracle,....
		pst = con.prepareStatement("insert into Student values(?,?,?)");
		int roll = Integer.parseInt(request.getParameter("roll"));
		System.out.println("database connected");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		pst.setInt(1,roll);
		pst.setString(2, name);
		pst.setString(3, address);
		int res=pst.executeUpdate();
		if(res >= 1) {
			out.println("record is inserted successfully");
			out.println("<a href= 'http://localhost:8888/MyWebProject/jspexamples/Insert.html'>Insert more?</a>");
			out.println("<a href= 'http://localhost:8888/MyWebProject/jspexamples/Home.html'>Home</a>");
		}
	
	}catch(Exception ae) {
		System.out.println("Error in database Connection!!");
		out.println("error in Insert Page!!");
		ae.printStackTrace();
	}

%>
</body>
</html>