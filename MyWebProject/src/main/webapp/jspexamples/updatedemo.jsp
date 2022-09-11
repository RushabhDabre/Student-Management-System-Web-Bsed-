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
%>
<%
response.setContentType("text/html");
try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RUSHABH","Wadsa@123");  //for oracle,....
		pst = con.prepareStatement("update Student set name=?, address=? where roll = ?");
		System.out.println("database connected");
		int roll = Integer.parseInt(request.getParameter("roll"));
		String name=request.getParameter("name");
		String address=request.getParameter("address");

		pst.setString(1, name);
		pst.setString(2, address);
		pst.setInt(3,roll);

		int res=pst.executeUpdate();
		if(res >= 1) {
			out.println(res+"  record is updated successfully");
			out.println("<a href='http://localhost:8888/MyWebProject/jspexamples/Search.html'>search more?</a>");
			out.println("<a href='http://localhost:8888/MyWebProject/jspexamples/Home.html'>Home Page</a>");
		}
	
	}catch(Exception ae) {
		System.out.println("Error in database Connection!!");
		out.println("error in Insert Page!!");
		ae.printStackTrace();
	}

%>
</body>
</html>